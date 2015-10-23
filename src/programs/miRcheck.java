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
public class miRcheck extends RunProgram{
    
    private String fastaFile1 ="";
    private String outputFile ="";
    private String outputPath ="."+File.separator+"indexed_genomes"+File.separator+"bwa";
    private String optionsChoosed = "";
    
    private String[] indexGenomeTab = {"IDG_r_text","IG_bwtsw_button","IG_is_button","IG_notUsed_button","IG_p_box"};
    
    public miRcheck(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        // File output directory
        if (properties.get("IDG_r_text").equals("") || !properties.isSet("IDG_r_text")) {
            properties.put("IDG_r_text",outputPath);
            if (!Util.CreateDir(outputPath)) {
                setStatus(status_BadRequirements,"Directory can not be created");
                return false;
            }
        }
        
        // Inputs
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        String s1 = Util.getFileName(FastaFile.getFastaPath(Fasta1));
        
        if (Fasta1.isEmpty() || s1.equals("")) {
            setStatus(status_BadRequirements,"No sequence found.");
            return false;
        } 
        return true;
    }
    
    @Override
    public String[] init_createCommandLine() {
        
        // Input FastaFile
        Vector<Integer>Fasta1 = properties.getInputID("FastaFile",PortInputDOWN);
        
        
        fastaFile1 = FastaFile.getFastaPath(Fasta1);
        outputFile = Util.getFileName(fastaFile1);
        
        if (properties.get("IDG_r_text").startsWith(".")) {
            Util.CreateDir(properties.get("IDG_r_text"));
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
            optionsChoosed = Util.findOptions(indexGenomeTab,properties);
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
    
    @Override
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