//System.out.println("t est "+t);
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.FastaFile;
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
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        
        if (Fasta1.isEmpty()) {
            setStatus(status_BadRequirements,"No sequence found.");
            return false;
        }
        return true;
    }
    
    //@Override
    //public void init_createInput() {
    //}
    
    @Override
    public String[] init_createCommandLine() {
        // File output directory
        if (properties.get("IDG_r_text").equals("") || !properties.isSet("IDG_r_text")) {
            String s = "."+File.separator+"indexed_genomes"+File.separator+"bowtie2";
            properties.put("IDG_r_text",s);
            File f = new File(s);
            f.canExecute();
            f.canRead();
            f.canWrite();
        
            if (!f.exists()){
                f.mkdir();
            }
        }
        
        // Input FastaFile
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        String optionsChoosed = "";
        
        for (int ids:Fasta1) {
            FastaFile fas =new FastaFile(ids);
            if (outputFile.equals("")){
                outputFile = fas.getName();
                int pos1 = outputFile.lastIndexOf("/");
                if (pos1 > 0) {
                    outputFile = outputFile.substring(pos1+1,fas.getName().length());
                }

                outputFile = properties.get("IDG_r_text")+File.separator+outputFile;
            }
            
            if (!fas.getName().equals(outputFile)){
                File infile  = new File(fas.getName());
                File outfile = new File(outputFile);
                if (outfile.exists()) outfile.delete();
                
                try {
                    copyFile(infile,outfile);
                } catch (final IOException e) {
                    // À voir comment intégrer dans Armadillo
                    throw new RuntimeException("Failed to copy the file", e);
                }
            }
            
        }
        
        if (properties.get("IG_AO_button").equals("true")){
            optionsChoosed = findOptions(indexGenomeTab);
            System.out.println("optionsChoosed est "+optionsChoosed);
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
    
    private static void copyFile(File source, File dest) throws IOException {
	Files.copy(source.toPath(), dest.toPath());
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
    
    public void post_parseOutput() {
        FastaFile genome=new FastaFile();
        genome.loadFromFile(outputFile);
        genome.setName("Bwa index ("+Util.returnCurrentDateAndTime()+")");
        genome.setNote("Created on "+Util.returnCurrentDateAndTime());
        genome.saveToDatabase();
        properties.put("Bwa", genome.getId());
        this.addOutput(genome);
        
        Text lk=new Text(outputFile+"_bowti2_lk.txt");
        
        Results text=new Results(outputFile+"_bowti2_stats.txt");
        text.setText(text.getText()+"\n"+lk.getText());
        text.setNote("Bwa_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bwa_stats ("+Util.returnCurrentDateAndTime()+")");
        
        text.saveToDatabase();
        addOutput(text);
        properties.put("output_results_id",text.getId());
    }
    
    
}
