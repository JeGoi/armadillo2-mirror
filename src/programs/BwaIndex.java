/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.FastaFile;
import biologic.GenomeFile;
import biologic.Results;
import biologic.Text;
import configuration.Util;
import java.util.Vector;
import program.RunProgram;
import static program.RunProgram.PortInputUP;
import static program.RunProgram.df;
import static program.RunProgram.status_error;
import workflows.workflow_properties;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
/**
 *
 * @author Jérémy Goimard
 * @date Aout 2015
 *
 */
public class BwaIndex extends RunProgram{
    
    private String fastaFile1 ="";
    private String outputFile ="";
    
    private String[] indexGenomeTab = {"IDG_r_text","IG_bwtsw_button","IG_is_button","IG_notUsed_button","IG_p_button"};
    
    public BwaIndex(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        // Inputs
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        String s1 = getFileName(getFastaPath(Fasta1));
        
        if (Fasta1.isEmpty() || s1.equals("")) {
            setStatus(status_BadRequirements,"No sequence found.");
            return false;
        } 
        
        // File output directory
        if (properties.get("IDG_r_text").equals("") || !properties.isSet("IDG_r_text")) {
            String s = "."+File.separator+"indexed_genomes"+File.separator+"bwa";
            properties.put("IDG_r_text",s);
            File f = new File(s);
            if (!f.exists()){
                f.mkdir();
                f.canExecute();
                f.canRead();
                f.canWrite();
            }
        }

        return true;
    }
    
    @Override
    public String[] init_createCommandLine() {
        
        // Input FastaFile
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        String optionsChoosed = "";
        
        fastaFile1 = getFastaPath(Fasta1);
        outputFile = getFileName(fastaFile1);
        
        if (properties.get("IDG_r_text").startsWith(".")) {
            File outfile = new File(properties.get("IDG_r_text"));
            String abs = outfile.getAbsolutePath();
            abs = abs.replaceAll(File.separator+"\\."+File.separator,File.separator);
            outputFile = abs+File.separator+outputFile+".fasta";
        } else outputFile = properties.get("IDG_r_text")+File.separator+outputFile+".fasta";
        
        if (!outputFile.equals(fastaFile1)) {
            try {
                    Util.copy(fastaFile1,outputFile);
                } catch (final IOException e) {
                    // À voir comment intégrer dans Armadillo
                    throw new RuntimeException("Failed to copy the file", e);
                }
        }
        
        if (properties.get("IG_AO_button").equals("true")){
            optionsChoosed = findOptions(indexGenomeTab);
        }
        
        String[] com = new String[30];
        for (int i=0; i<com.length;i++) com[i]="";
        
        com[0]="cmd.exe";
        com[1]="/C";
        com[2]=properties.getExecutable();
        com[3]=" index";
        com[4]=optionsChoosed;
        com[5]=outputFile;
        return com;
    }
    
        private String findOptions(String[] tab) {
            String s = ""; // Final string
            String t = ""; // Box type or option
            String v = ""; // Box value if set
            for ( int i = 0 ; i < tab.length ; i++ ){
                if (properties.isSet(tab[i]) &&
                    properties.get(tab[i]).equals("true")
                    ) {
                    t = tab[i];
                    t = t.replaceAll("_[a-z]*$","");
                    t = t.replaceAll("([A-Z]*_)*","");
                    t = t.replaceAll("([A-Z])","$1");
                    t = t.toLowerCase();
                    if (t.length()>1) {
                        t = " --"+t;
                    } else {
                        t = " -"+t;
                    }

                    v = tab[i];
                    v = v.replaceAll("_[a-z]*$","_value");
                    if (properties.isSet(v)){
                        t += " "+properties.get(v);
                    }
                    s += t;
                }
            }
            return s;
        }
    
        private String getFastaPath(Vector<Integer> f){
            String s = "";
            for (int ids:f) {
                FastaFile fas =new FastaFile(ids);
                s = fas.getName();
            }
            return s;
        }

        private String getFileName(String s){
            String name = "";
            int pos1 = s.lastIndexOf(File.separator);
            int pos2 = s.lastIndexOf(".");
            if (pos1 > 0 && pos2>pos1) name = s.substring(pos1+1,pos2);
            else return s;
            return name;
        }
    
        
    public void post_parseOutput() {
        
        GenomeFile genome=new GenomeFile();
        genome.setGenomeFile(outputFile);
        genome.setName(outputFile);
        genome.setNote("Bwa Indexer. Created on "+Util.returnCurrentDateAndTime());
        genome.saveToDatabase();
        properties.put("output_genomefile_id", genome.getId());
        this.addOutput(genome);
        
        String txt = this.getPgrmOutput();
        Results text=new Results("bwa_index_stats.txt");
        text.setText(txt+"\n");
        text.setNote("Bwa_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bwa_indexer ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        properties.put("output_results_id",text.getId());
    }
    
    
}
