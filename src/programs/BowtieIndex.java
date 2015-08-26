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
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import program.RunProgram;
import static program.RunProgram.PortInputUP;
import static program.RunProgram.df;
import static program.RunProgram.status_error;
import workflows.workflow_properties;


/**
 *
 * @author Jérémy Goimard
 * @date Aout 2015
 *
 */
public class BowtieIndex extends RunProgram{
    
    private String fastaFile1 ="";
    private String outputFile ="";
    
    private String[] indexGenomeTab = {"IG_3_box","IG_a_button","IG_bmaxdivn_box","IG_bmax_box","IG_dcv_box","IG_ntoa_box","IG_nodc_box","IG_o_box","IG_p_box","IG_q_box","IG_r_box","IG_seed_box","IG_t_box","IG_little_box","IG_big_box"};
    
    public BowtieIndex(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        // File output directory
        if (properties.get("IDG_r_text").equals("") || !properties.isSet("IDG_r_text")) {
            String s = "."+File.separator+"indexed_genomes"+File.separator+"bowtie";
            properties.put("IDG_r_text",s);
            File f = new File(s);
            f.canExecute();
            f.canRead();
            f.canWrite();
        
            if (!f.exists()){
                f.mkdir();
            }
        }
        
        // Input
        Vector<Integer>Fasta1    = properties.getInputID("FastaFile",PortInputDOWN);
        String s = getFileName(getFastaPath(Fasta1));
        if (Fasta1.isEmpty()||s.equals("")) {
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
        // Inputs
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        String optionsChoosed = "";
        
        fastaFile1 = getFastaPath(Fasta1);
        outputFile = getFileName(fastaFile1);
        outputFile = properties.get("IDG_r_text")+File.separator+outputFile;
        
        if (properties.get("IG_AO_button").equals("true")){
            optionsChoosed = findOptions(indexGenomeTab);
        }
        
        String[] com = new String[30];
        for (int i=0; i<com.length;i++) com[i]="";
        
        com[0]="cmd.exe";
        com[1]="/C";
        com[2]=properties.getExecutable();
        com[3]=optionsChoosed;
        com[4]=fastaFile1;
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

    
    @Override
    public void post_parseOutput() {
        GenomeFile genome=new GenomeFile();
        genome.setGenomeFile(outputFile);
        genome.setName(outputFile);
        genome.setNote("Bowtie builder. Created on "+Util.returnCurrentDateAndTime());
        genome.saveToDatabase();
        properties.put("output_genomefile_id", genome.getId());
        this.addOutput(genome);
        
        String txt = this.getPgrmOutput();
        Results text=new Results("bowtie_index_stats.txt");
        text.setText(txt+"\n");
        text.setNote("Bowtie_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie_builder ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        properties.put("output_results_id",text.getId());
    }
    
}
