/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.Genome;
import biologic.Results;
import biologic.Text;
import configuration.Util;
import java.io.File;
import java.util.Vector;
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
public class Bowtie2Inspect extends RunProgram{
    
    private String genomeFile ="";
    private String outputFile ="";
    
    private String[] inspectTab = {"I_a_box","I_n_box","I_s_box","I_v_box"};
    
    public Bowtie2Inspect(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        Vector<Integer>Genome    = properties.getInputID("Genome",PortInputDOWN);
        
        if (Genome.isEmpty()) {
            setStatus(status_BadRequirements,"No Genome found.");
            return false;
        }
        return true;
    }
    
    public String[] init_createCommandLine() {
        
        // Inputs
        Vector<Integer>GenomeRef = properties.getInputID("Genome",PortInputDOWN);
        String optionsChoosed    = "";
        
        for (int ids:GenomeRef) {
            Genome gen =new Genome(ids);
            genomeFile = gen.getName();
            genomeFile = genomeFile.replaceAll("\\.\\d.bt2$","");
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
    
    public void post_parseOutput() {
        
        Text output=new Text();
        output.loadFromFile("outfile");
        output.setName("Bowtie inspect ("+Util.returnCurrentDateAndTime()+")");
        output.setNote("Created on "+Util.returnCurrentDateAndTime());
        output.saveToDatabase();
        properties.put("output_alignment_id", output.getId());
        this.addOutput(output);
        
        Text lk=new Text(output+"_bowti2_lk.txt");
        
        Results text=new Results(output+"_bowti2_stats.txt");
        text.setText(text.getText()+"\n"+lk.getText());
        text.setNote("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        addOutput(text);
        properties.put("output_results_id",text.getId());
    }
    
    
}
