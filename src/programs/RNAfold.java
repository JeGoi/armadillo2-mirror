/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
* Author : Jérémy Goimard
* Date   : 10 115
*/

package programs;

import biologic.BamFile;
import biologic.FastaFile;
import biologic.FastqFile;
import biologic.GenomeFile;
import biologic.ImageFile;
import biologic.Results;
import biologic.SamFile;
import biologic.SOLIDFile;
import biologic.TextFile;
import configuration.Util;
import java.io.File;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Map;
import java.util.Iterator;
import program.RunProgram;
import static program.RunProgram.PortInputUP;
import static program.RunProgram.df;
import static program.RunProgram.status_error;
import workflows.workflow_properties;


/**
 *
 * @author Jérémy Goimard
 * @date 10 115
 *
 */
public class RNAfold extends RunProgram {
    // CREATE VARIABLES HERE
    private String input1     ="";
    private String input2     ="";
    private String outputFile ="";
    private static final String outputPath = "."+File.separator+"results"+File.separator+"RNAfold";

    private static final String[] AO_MD_panel = {
        "AO_MD_noTetra_Box",
        "AO_MD_dangles_Box",
        "AO_MD_noLP_Box",
        "AO_MD_noGU_Box",
        "AO_MD_noClosingGU_Box",
        "AO_MD_paramFile_Box"
,
        "AO_MD_paramFile_Box_Text"
    };
    private static final String[] AO_GO_panel = {
        "AO_GO_canonicalBPonly_Box",
        "AO_GO_noconv_Box",
        "AO_GO_noPS_Box"
    };
    private static final String[] AO_ASaawsbiitcTMfeaasraciac_panel = {
        "AO_ASaawsbiitcTMfeaasraciac_MEA_Box",
        "AO_ASaawsbiitcTMfeaasraciac_MEA_Box_Value",
        "AO_ASaawsbiitcTMfeaasraciac_circ_Box",
        "AO_ASaawsbiitcTMfeaasraciac_gquad_Box"
    };


    public RNAfold(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    @Override
    public boolean init_checkRequirements() {
        // TEST INPUT VARIABLES HERE les ports sont PortInputUp, PortInputDOWN, PortInputDOWN2
        // Sample
        Vector<Integer>Fastq1    = properties.getInputID("FastqFile",PortInputDOWN);
        String s1 = Util.getFileName(FastqFile.getFastqFilePath(Fastq1));

        // In case program is started without edition
        pgrmStartWithoutEdition(Fastq1);

        //INSERT YOUR TEST
        if (!(s1.equals(""))) {
            return false;
        }
        return true;
    }

        // Sub functions for init_checkRequirements
        private void pgrmStartWithoutEdition (Vector<Integer> v) {
           // In case program is started without edition
           if (!properties.isSet("")) properties.put("","true");
        }

    @Override
    public String[] init_createCommandLine() {
        // Inputs
        // Sample
        Vector<Integer>Fastq1 = properties.getInputID("FastqFile",PortInputDOWN);
        String fastqFile1     = "";
        String fastqFile1Name = "";
        
        if (!Fastq1.isEmpty()) fastqFile1 = FastqFile.getFastqFilePath(Fastq1);
        
        // Get Name to create ouput
        fastqFile1Name = Util.getFileName(fastqFile1);
        outputFile = outputPath+File.separator+fastqFile1Name+".sam";
        
        // Programme et options
        String options = Util.findOptions(AO_GO_panel,properties);
        options = options+Util.findOptions(AO_ASaawsbiitcTMfeaasraciac_panel,properties);
        options = options+Util.findOptions(AO_MD_panel,properties);
        
        // Command line creation
        String[] com = new String[30];
        for (int i=0; i<com.length;i++) com[i]="";
        
        com[0]="cmd.exe"; // Windows 
        com[1]="/C";      // Windows 
        com[2]=properties.getExecutable();
        com[3]=options;
        com[4]=outputFile;
        return com;
    }

    /*
    * Output Parsing
    */

    @Override
    public void post_parseOutput() {
        //SAMPLE OF OUTPUT as SAMFILE
        SamFile.saveSamFile(properties,outputFile,"RNAfold");
        Results.saveResultsPgrmOutput(properties,this.getPgrmOutput(),"RNAfold");
    }
}
