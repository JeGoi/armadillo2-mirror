//System.out.println("GenomeRef.isEmpty()");


/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.FastqFile;
import biologic.GenomeFile;
import biologic.Results;
import biologic.SamFile;
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
 * @date Aout 2015
 *
 */
public class Bowtie2Map extends RunProgram {
    
    private String fastqFile1    ="";
    private String fastqFile2    ="";
    private String genomeFile    ="";
    private String outfile       ="";
    
    //private String[] optionsTab  = {"bowtie2IndexGenome_button","bowtie2Inspect_button","bowtie2Mapping_button"};
    private String[] mappingSorPTab = {"BOWTIE2MAP_M_PE_I_value","BOWTIE2MAP_M_PE_X_value","BOWTIE2MAP_M_PE_dovetail_box","BOWTIE2MAP_M_PE_ff_button","BOWTIE2MAP_M_PE_fr_button","BOWTIE2MAP_M_PE_noContain_box","BOWTIE2MAP_M_PE_noDiscordant_box","BOWTIE2MAP_M_PE_noMixed_box","BOWTIE2MAP_M_PE_noOverlap_box","BOWTIE2MAP_M_PE_rf_button","BOWTIE2MAP_M_PE_un_box"};
    private String[] customMapTab   = {"BOWTIE2MAP_CM_A_L_value","BOWTIE2MAP_CM_A_N_value","BOWTIE2MAP_CM_A_dpad_value","BOWTIE2MAP_CM_A_ete_button","BOWTIE2MAP_CM_A_ete_text","BOWTIE2MAP_CM_A_gbar_value","BOWTIE2MAP_CM_A_i_text","BOWTIE2MAP_CM_A_ignoreQuals_box","BOWTIE2MAP_CM_A_local_button","BOWTIE2MAP_CM_A_local_text","BOWTIE2MAP_CM_A_nceil_text","BOWTIE2MAP_CM_A_no1mm_box","BOWTIE2MAP_CM_A_norc_box","BOWTIE2MAP_CM_E_D_value","BOWTIE2MAP_CM_E_R_value","BOWTIE2MAP_CM_I_3_value","BOWTIE2MAP_CM_I_5_value","BOWTIE2MAP_CM_I_c_box","BOWTIE2MAP_CM_I_f_box","BOWTIE2MAP_CM_I_phred33_box","BOWTIE2MAP_CM_I_phred64_box","BOWTIE2MAP_CM_I_q_box","BOWTIE2MAP_CM_I_qseq_box","BOWTIE2MAP_CM_I_quals_box","BOWTIE2MAP_CM_I_r_box","BOWTIE2MAP_CM_I_s_value","BOWTIE2MAP_CM_I_solexa_box","BOWTIE2MAP_CM_I_u_value","BOWTIE2MAP_CM_OO_nonDeterminist_box","BOWTIE2MAP_CM_OO_qcFilter_box","BOWTIE2MAP_CM_OO_seed_value","BOWTIE2MAP_CM_O_al_box","BOWTIE2MAP_CM_O_met_value","BOWTIE2MAP_CM_O_metfile_box","BOWTIE2MAP_CM_O_metstderr_box","BOWTIE2MAP_CM_O_quiet_box","BOWTIE2MAP_CM_O_un_box","BOWTIE2MAP_CM_P_mm_box","BOWTIE2MAP_CM_P_o_text","BOWTIE2MAP_CM_P_p_value","BOWTIE2MAP_CM_P_reorder_box","BOWTIE2MAP_CM_R_a_button","BOWTIE2MAP_CM_R_k_button","BOWTIE2MAP_CM_R_k_value","BOWTIE2MAP_CM_R_noset_button","BOWTIE2MAP_CM_SAM_noHd_box","BOWTIE2MAP_CM_SAM_noSq_box","BOWTIE2MAP_CM_SAM_noUnal_box","BOWTIE2MAP_CM_SAM_omitSecSeq_box","BOWTIE2MAP_CM_SAM_rgId_text","BOWTIE2MAP_CM_SAM_rg_text","BOWTIE2MAP_CM_S_ma_value","BOWTIE2MAP_CM_S_mp_value","BOWTIE2MAP_CM_S_np_value","BOWTIE2MAP_CM_S_rdg1_value","BOWTIE2MAP_CM_S_rdg2_value","BOWTIE2MAP_CM_S_rfg1_value","BOWTIE2MAP_CM_S_rfg2_value"};
    
    private static final Hashtable<String,String> optionsHash = new Hashtable<String,String>() {{
        put("BOWTIE2MAP_M_ETE_F_button","--fast");
        put("BOWTIE2MAP_M_ETE_S_button","--sensitive");
        put("BOWTIE2MAP_M_ETE_VF_button","--very-fast");
        put("BOWTIE2MAP_M_ETE_VS_button","--very-sensitive");
        put("BOWTIE2MAP_M_L_F_button","--fast-local");
        put("BOWTIE2MAP_M_L_S_button","--sensitive-local");
        put("BOWTIE2MAP_M_L_VF_button","--very-fast-local");
        put("BOWTIE2MAP_M_L_VS_button","--very-sensitive-local");
        put("BOWTIE2MAP_M_default_button","");
        put("BOWTIE2MAP_M_CM_button","");
    }};
    
    
    public Bowtie2Map(workflow_properties properties) {
        this.properties=properties;
        execute();
    }
    
    @Override
    public boolean init_checkRequirements() {
        Vector<Integer>Fastq1    = properties.getInputID("FastqFile",PortInputUP);
        Vector<Integer>Fastq2    = properties.getInputID("FastqFile",PortInputDOWN);
        Vector<Integer>GenomeRef = properties.getInputID("GenomeFile",PortInputDOWN2);

        // In case program is started without edition
        if (!properties.isSet("BOWTIE2MAP_M_IDG_directory_button")) properties.put("BOWTIE2MAP_M_IDG_workflow_button","true");
        if (!properties.isSet("BOWTIE2MAP_Options")) properties.put("BOWTIE2MAP_Options","BOWTIE2MAP_M_default_button");
        if (!properties.isSet("BOWTIE2MAP_M_PE_button")) properties.put("BOWTIE2MAP_M_SE_button","true");
        if (!Fastq2.isEmpty() && properties.isSet("BOWTIE2MAP_M_SE_button")){
            properties.put("BOWTIE2MAP_M_PE_button","true");
            properties.remove("BOWTIE2MAP_M_SE_button");
        }
        
        boolean b1 = properties.isSet("BOWTIE2MAP_M_IDG_workflow_button");
        boolean b2 = properties.isSet("BOWTIE2MAP_M_IDG_directory_button");
        boolean b3 = properties.get("BOWTIE2MAP_IDG_selected_ComboBox").equals("Choose_an_indexed_Genome");
        boolean b4 = properties.get("BOWTIE2MAP_M_PE_button").equals("true");
        
        if (Fastq1.isEmpty()) {
            setStatus(status_BadRequirements,"No sequence found.");
            return false;
        } else if (Fastq2.isEmpty() && properties.isSet("BOWTIE2MAP_M_PE_button")) {
            properties.remove("BOWTIE2MAP_M_PE_button");
            properties.put("BOWTIE2MAP_M_SE_button","true");
            setStatus(status_BadRequirements,"The program will work on single end.");
            return true;
        } else if ( GenomeRef.isEmpty() && b1) {
            setStatus(status_BadRequirements,"Need a Genome Reference");
            return false;
        } else if ( b2 && b3) {
            setStatus(status_BadRequirements,"Choose a Genome Reference");
            return false;
        } else if (!Fastq2.isEmpty() && b4) {
            String s1 = getFileName(getFastqPath(Fastq1));
            String s2 = getFileName(getFastqPath(Fastq2));
            int sn = fastqSameName(s1,s2);
            int gn = fastqGoodNumber(s1,s2);
            if (sn==0 && gn==0) {
                
                setStatus(status_BadRequirements,"Fastq paired are not compatible.\n"
                        + "Check your files they need to have the same name and finish by _1 and _2,\n"
                        + "or it's due to Armadillo process, and let it go !");
                return false;
            }
        }
        return true;
        
    
    }
        // Sub functions for init_checkRequirements
        private int fastqSameName (String s1,String s2) {
            int b = 0;
            s1 = s1.replaceAll("_\\d$","");
            s2 = s2.replaceAll("_\\d$","");
            if (s2.equals(s1)) b=1;
            return b;
        }

        private int fastqGoodNumber (String s1,String s2) {
            int b = 0;
            int val1 = Integer.parseInt(s1.replaceAll(".*_(\\d)$","$1"));
            int val2 = Integer.parseInt(s2.replaceAll(".*_(\\d)$","$1"));
            if (val1==1 && val2==2) b=1;
            return b;
        }

    @Override
    public String[] init_createCommandLine() {
        
        // Inputs
        Vector<Integer>Fastq1    = properties.getInputID("FastqFile",PortInputUP);
        Vector<Integer>Fastq2    = properties.getInputID("FastqFile",PortInputDOWN);
        Vector<Integer>GenomeRef = properties.getInputID("GenomeFile",PortInputDOWN2);
        
        fastqFile1 = getFastqPath(Fastq1);
        if (!Fastq2.isEmpty()) fastqFile2 = getFastqPath(Fastq2);
        
        outfile = getFileName(fastqFile1);
        outfile = "."+File.separator+"results"+File.separator+"bowtie2"+File.separator+outfile+".sam";
        
        // Genome File source
        if (!GenomeRef.isEmpty()){
            for (int ids:GenomeRef) {
                GenomeFile gen = new GenomeFile(ids);
                genomeFile = gen.getName();
                genomeFile = genomeFile.replaceAll("\\.\\d.bt2$","");
                genomeFile = genomeFile.replaceAll("\\.rev$","");
            }
        } else {
            String genomeChoosed = properties.get("BOWTIE2MAP_IDG_selected_ComboBox");
            String genomePath    = properties.get("BOWTIE2MAP_IDG_r_text");
            genomeFile = genomePath+File.separator+genomeChoosed;
        }
        
        // Programme et options
        String preset  = "";
        String opH     = optionsHash.get(properties.get("BOWTIE2MAP_Options"));
        if (!opH.equals("")) preset = ""+opH+" ";
        String options = optionsChoosed(properties.get("BOWTIE2MAP_Options"));
        
        String[] com = new String[30];
        for (int i=0; i<com.length;i++) com[i]="";
        
        com[0]="cmd.exe";
        com[1]="/C";
        com[2]=properties.getExecutable();
        com[3]=preset;
        com[4]=options;
        if (!genomeFile.equals("")) com[5]="-x \""+genomeFile+"\"";
        if (!fastqFile1.equals("") && fastqFile2.equals("")) {
            com[6]="\""+fastqFile1+"\"";
        }
        if (!fastqFile1.equals("") && !fastqFile2.equals("")) {
            com[6]="-1 \""+fastqFile1+"\"";
            com[7]="-2 \""+fastqFile2+"\"";
        }
        if (!outfile.equals(""))    com[8]="-S \""+outfile+"\"";
        
        return com;
    }
    
        /*
        * Function to return options choosed
        */
        private String optionsChoosed(String optionsChoosed){
            String t  = optionsChoosed;

            // Custom made options
            String s  = "";
            if (t.equals("BOWTIE2MAP_M_CM_button")) s = findOptions(customMapTab);

            // Paired end
            String pe = "";
            if (properties.isSet("BOWTIE2MAP_M_PE_button")) pe = findOptions(mappingSorPTab);

            s = pe+" "+s;

            return s;
        }
    
        /*
        * Function to find options choosed use the propertie name to create the command
        */
        private String findOptions(String[] tab) {
            String s = "";
            String t = "";
            for ( int i = 0 ; i < tab.length ; i++ ){
                if (properties.isSet(tab[i])) {
                    t = tab[i];
                    t = t.replaceAll("_[a-z]*$","");
                    t = t.replaceAll("([A-Z]*_)*","");
                    t = t.replaceAll("([A-Z])","$1");
                    if (t.length()>1) {
                        t = t.toLowerCase();
                        t = " --"+t;
                    } else {
                        t = " -"+t;
                    }
                    if (tab[i].contains("_value") || tab[i].contains("_text")) {
                        t = t+" "+properties.get(tab[i]);
                    }
                    s = s+" "+t;
                }
            }
            return s;
        }

        private String getFastqPath(Vector<Integer> f){
            String s = "";
            for (int ids:f) {
                FastqFile fas =new FastqFile(ids);
                s = fas.getName();
            }
            return s;
        }

        private String getFileName(String s){
            String name = "";
            int pos1 = s.lastIndexOf("/");
            int pos2 = s.lastIndexOf(".");
            if (pos1 > 0) {
                name = s.substring(pos1+1,pos2);
            }
            return name;
        }

    /*
    * Output Parsing
    */
    @Override
    public void post_parseOutput() {
        File f   = new File(outfile);
        String s = f.getAbsolutePath();
        s = s.replaceAll(File.separator+"\\."+File.separator,File.separator);
        SamFile sam=new SamFile();
        sam.setSamFile(s);
        sam.setName(s);
        sam.saveToDatabase();
        properties.put("output_samfile_id", sam.getId());

        String txt = this.getPgrmOutput(this.getOutputText());
        
        Results text=new Results(outfile+"_bowtie2_stats.txt");
        text.setText(txt+"\nThe output file is saved here "+s+"\n");
        text.setNote("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie2_Test ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        properties.put("output_results_id",text.getId());
    }
    
}
