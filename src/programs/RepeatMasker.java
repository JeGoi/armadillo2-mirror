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
public class RepeatMasker extends RunProgram {
    // CREATE VARIABLES HERE
    private String input1     ="";
    private String input2     ="";
    private String outputFile ="";
    private static final String outputPath = "."+File.separator+"results"+File.separator+"RepeatMasker";

    private static final String[] AO_So_panel = {
        "AO_So_lib_Box",
        "AO_So_lib_Box_Text"
    };
    private static final String[] AO_Ro_panel = {
        "AO_Ro_gccalc_Box",
        "AO_Ro_frag_Box",
        "AO_Ro_frag_Box_Value",
        "AO_Ro_nocut_Box",
        "AO_Ro_noisy_Box",
        "AO_Ro_nopost_Box"
    };
    private static final String[] AO_Mo_panel = {
        "AO_Mo_nolow_Box",
        "AO_Mo_low_Box",
        "AO_Mo_noint_Box",
        "AO_Mo_int_Box",
        "AO_Mo_norna_Box",
        "AO_Mo_alu_Box",
        "AO_Mo_div_Box",
        "AO_Mo_div_Box_Value"
    };
    private static final String[] oo_panel = {
        "oo_alignments_Box",
        "oo_inv_Box",
        "oo_lcambig_Box",
        "oo_small_Box",
        "oo_xsmall_Box",
        "oo_x_Box",
        "oo_poly_Box",
        "oo_html_Box",
        "oo_source_Box",
        "oo_source_Box_Text",
        "oo_ace_Box",
        "oo_gff_Box",
        "oo_u_Box",
        "oo_xm_Box",
        "oo_no_id_Box",
        "oo_excln_Box"
    };
    private static final String[] AO_Osas_panel = {
        "AO_Osas_parallel_Box",
        "AO_Osas_parallel_Box_Value",
        "AO_Osas_s_Box",
        "AO_Osas_q_Box",
        "AO_Osas_qq_Box"
    };
    private static final String[] AO_Co_panel = {
        "AO_Co_is_clip_Box",
        "AO_Co_no_is_Box"
    };


    public RepeatMasker(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    @Override
    public boolean init_checkRequirements() {
        // TEST INPUT VARIABLES HERE les ports sont PortInputUp, PortInputDOWN, PortInputDOWN2
        // Sample
        Vector<Integer>Fastq1    = properties.getInputID("FastqFile",PortInputDOWN);
        String s1 = Util.getFileName(FastqFile.getFastqPath(Fastq1));

        // In case program is started without edition
        pgrmStartWithoutEdition(Fastq1);

        //INSERT YOUR TEST
        if (!(s1.equals(""))) {
            return false;
        }
        return true;
    }

        // Sub functions for init_checkRequirements
        private void pgrmStartWithoutEdition (Vector<Integer> Fastq2) {
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
        
        if (!Fastq1.isEmpty()) fastqFile1 = FastqFile.getFastqPath(Fastq1);
        
        // Get Name to create ouput
        fastqFile1Name = Util.getFileName(fastqFile1);
        outputFile = outputPath+File.separator+fastqFile1Name+".sam";
        
        // Programme et options
        String options = "";
        options += Util.findOptions(AO_Ro_panel,properties);
        options += Util.findOptions(AO_Mo_panel,properties);
        options += Util.findOptions(oo_panel,properties);
        options += Util.findOptions(AO_Osas_panel,properties);
        options += Util.findOptions(AO_Co_panel,properties);
        
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
        SamFile.saveSamFile(properties,outputFile,"RepeatMasker");
        Results.saveResultsPgrmOutput(properties,this.getPgrmOutput(),"RepeatMasker");
    }
}
