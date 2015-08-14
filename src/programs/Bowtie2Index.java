//System.out.println("t est "+t);
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.FastaFile;
import biologic.Genome;
import biologic.Results;
import biologic.Text;
import configuration.Util;
import java.io.File;
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
public class Bowtie2Index extends RunProgram{
    
    private String fastaFile1 ="";
    private String outputFile ="";
    
    private String[] indexGenomeTab = {"IG_3_box","IG_a_button","IG_bmaxdivn_box","IG_bmax_box","IG_dcv_box","IG_largeIndex_box","IG_nodc_box","IG_o_box","IG_p_box","IG_q_box","IG_r_box","IG_seed_box","IG_t_box"}; // ,"IG_cutoff_box" No set yet. It's in options help webpage but doesn't work in the program
    
    public Bowtie2Index(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        Vector<Integer>Fasta1    = properties.getInputID("FastaFile",PortInputDOWN);
        
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
        
        // Inputs
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        String optionsChoosed = "";
        
        for (int ids:Fasta1) {
            FastaFile fas =new FastaFile(ids);
            if (fastaFile1.equals("")){
                fastaFile1 = fas.getName();
                int pos1 = fastaFile1.lastIndexOf("/");
                int pos2 = fastaFile1.lastIndexOf(".");
                if (pos1 > 0) {
                    outputFile = fastaFile1.substring(pos1+1,pos2);
                }
                outputFile = properties.get("IDG_r_text")+File.separator+outputFile;
            }
            else fastaFile1 = fastaFile1+","+fas.getName();
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
    
    public void post_parseOutput() {
        Genome genome=new Genome();
        genome.loadFromFile(outputFile);
        genome.setName("Bowtie builder ("+Util.returnCurrentDateAndTime()+")");
        genome.setNote("Created on "+Util.returnCurrentDateAndTime());
        genome.saveToDatabase();
        properties.put("Bowtie", genome.getId());
        this.addOutput(genome);
        
        Text lk=new Text(outputFile+"_bowti2_lk.txt");
        
        Results text=new Results(outputFile+"_bowti2_stats.txt");
        text.setText(text.getText()+"\n"+lk.getText());
        text.setNote("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        
        text.saveToDatabase();
        addOutput(text);
        properties.put("output_results_id",text.getId());
    }
    
    
}
