/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.GenomeFile;
import biologic.Results;
import biologic.Text;
import biologic.TextFile;
import configuration.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import program.RunProgram;
import static program.RunProgram.PortInputDOWN;
import static program.RunProgram.PortInputUP;
import static program.RunProgram.df;
import static program.RunProgram.status_BadRequirements;
import static program.RunProgram.status_error;
import workflows.workflow_properties;


/**
 *
 * @author Jérémy Goimard
 * @date Aout 2015
 *
 */
public class Bowtie2Inspect extends RunProgram {
    
    private String genomeFile ="";
    
    private String[] inspectTab = {"I_a_box","I_n_box","I_s_box","I_v_box"};
    
    public Bowtie2Inspect(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        int GenomeRef = properties.getInputID("GenomeFile");
        if (GenomeRef==0) {
            setStatus(status_BadRequirements,"No Genome found.");
            return false;
        }
        // TO BE COMPLETELY IDIOT PROOF NEED TO TEST EXISTENCE OF BOWTIE2's FILES
        return true;
    }
    
    @Override
    public String[] init_createCommandLine() {
        
        // Inputs
        Vector<Integer> GenomeRef = properties.getInputID("GenomeFile",PortInputDOWN);
        String optionsChoosed    = "";
        
        genomeFile = getGenomePath(GenomeRef);
        if (genomeFile.matches("\\.\\d.bt2l?$")) {
            genomeFile = getFileName(genomeFile);
            genomeFile = genomeFile.replaceAll("\\.\\d.bt2l?$","");
            genomeFile = genomeFile.replaceAll("\\.rev$","");
        }
        
        // Programme et options
        if (properties.get("I_AO_button").equals("true")) {
            optionsChoosed = findOptions(inspectTab);
        }
        
        String[] com = new String[30];
        for (int i=0; i<com.length;i++) com[i]="";
        
        com[0]="cmd.exe";
        com[1]="/C";
        com[2]=properties.getExecutable();
        com[3]=optionsChoosed;
        com[4]=genomeFile;
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
        
        private String getGenomePath(Vector<Integer> f){
            String s = "";
            for (int ids:f) {
                GenomeFile gen =new GenomeFile(ids);
                s = gen.getName();
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
        
    /*
    * Output Parsing
    */
    @Override
    public void post_parseOutput() {
        String txt = this.getPgrmOutput();
        Results text=new Results("bowtie2_inspect_stats.txt");
        text.setText(txt+"\n");
        text.setNote("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie2_Inspect ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        properties.put("output_results_id",text.getId());
    }
}
