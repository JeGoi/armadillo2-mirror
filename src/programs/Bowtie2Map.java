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
    private String[] mappingSorPTab = {"M_PE_I_value","M_PE_X_value","M_PE_dovetail_box","M_PE_ff_button","M_PE_fr_button","M_PE_noContain_box","M_PE_noDiscordant_box","M_PE_noMixed_box","M_PE_noOverlap_box","M_PE_rf_button","M_PE_un_box"};
    private String[] customMapTab   = {"CM_A_L_value","CM_A_N_value","CM_A_dpad_value","CM_A_ete_button","CM_A_ete_text","CM_A_gbar_value","CM_A_i_text","CM_A_ignoreQuals_box","CM_A_local_button","CM_A_local_text","CM_A_nceil_text","CM_A_no1mm_box","CM_A_norc_box","CM_E_D_value","CM_E_R_value","CM_I_3_value","CM_I_5_value","CM_I_c_box","CM_I_f_box","CM_I_phred33_box","CM_I_phred64_box","CM_I_q_box","CM_I_qseq_box","CM_I_quals_box","CM_I_r_box","CM_I_s_value","CM_I_solexa_box","CM_I_u_value","CM_OO_nonDeterminist_box","CM_OO_qcFilter_box","CM_OO_seed_value","CM_O_al_box","CM_O_met_value","CM_O_metfile_box","CM_O_metstderr_box","CM_O_quiet_box","CM_O_un_box","CM_P_mm_box","CM_P_o_text","CM_P_p_value","CM_P_reorder_box","CM_R_a_button","CM_R_k_button","CM_R_k_value","CM_R_noset_button","CM_SAM_noHd_box","CM_SAM_noSq_box","CM_SAM_noUnal_box","CM_SAM_omitSecSeq_box","CM_SAM_rgId_text","CM_SAM_rg_text","CM_S_ma_value","CM_S_mp_value","CM_S_np_value","CM_S_rdg1_value","CM_S_rdg2_value","CM_S_rfg1_value","CM_S_rfg2_value"};
    
    private static final Hashtable<String,String> optionsHash = new Hashtable<String,String>() {{
        put("M_ETE_F_button","--fast");
        put("M_ETE_S_button","--sensitive");
        put("M_ETE_VF_button","--very-fast");
        put("M_ETE_VS_button","--very-sensitive");
        put("M_L_F_button","--fast-local");
        put("M_L_S_button","--sensitive-local");
        put("M_L_VF_button","--very-fast-local");
        put("M_L_VS_button","--very-sensitive-local");
        put("M_default_button","");
        put("M_CM_button","");
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
        if (!properties.isSet("M_IDG_directory_button")) properties.put("M_IDG_workflow_button","true");
        if (!properties.isSet("Options")) properties.put("Options","M_default_button");
        if (!properties.isSet("M_PE_button")) properties.put("M_SE_button","true");
        if (!Fastq2.isEmpty() && properties.isSet("M_SE_button")){
            properties.put("M_PE_button","true");
            properties.remove("M_SE_button");
        }
        
        boolean b1 = properties.isSet("M_IDG_workflow_button");
        boolean b2 = properties.isSet("M_IDG_directory_button");
        boolean b3 = properties.get("IDG_selected_ComboBox").equals("Choose_an_indexed_Genome");
        boolean b4 = properties.get("M_PE_button").equals("true");
        
        if (Fastq1.isEmpty()) {
            setStatus(status_BadRequirements,"No sequence found.");
            return false;
        } else if (Fastq2.isEmpty() && properties.isSet("M_PE_button")) {
            setStatus(status_BadRequirements,"Need Fasts Paired-end.");
            return false;
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
    public void init_createInput() {
        // Not USED
    }
    
    @Override
    public String[] init_createCommandLine() {
        
        // Inputs
        Vector<Integer>Fastq1    = properties.getInputID("FastqFile",PortInputUP);
        Vector<Integer>Fastq2    = properties.getInputID("FastqFile",PortInputDOWN);
        Vector<Integer>GenomeRef = properties.getInputID("GenomeFile",PortInputDOWN2);
        
        fastqFile1 = getFastqPath(Fastq1);
        fastqFile2 = getFastqPath(Fastq2);
        
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
            String genomeChoosed = properties.get("IDG_selected_ComboBox");
            String genomePath    = properties.get("IDG_r_text");
            genomeFile = genomePath+File.separator+genomeChoosed;
        }
        
        // Programme et options
        String preset  = "";
        String opH     = optionsHash.get(properties.get("Options"));
        if (!opH.equals("")) preset = ""+opH+" ";
        
        String options = optionsChoosed(properties.get("Options"));
        
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
        if (t.equals("M_CM_button")) s = findOptions(customMapTab);
        
        // Paired end
        String pe = "";
        if (properties.isSet("M_PE_button")) pe = findOptions(mappingSorPTab);
        
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
    public void post_parseOutput() {
        
        File f   = new File(outfile);
        String s = f.getAbsolutePath();
        s = s.replaceAll(File.separator+"\\."+File.separator,File.separator);
        SamFile sam=new SamFile();
        sam.setSamFile(s);
        sam.setName(s);
        sam.saveToDatabase();
        properties.put("output_samfile_id", sam.getId());

        String txt = getPgrmOutput(this.getOutputText());
        
        Results text=new Results(outfile+"_bowti2_stats.txt");
        text.setText(txt+"\nThe output file is saved here "+s+"\n");
        text.setNote("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie2_Test ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        properties.put("output_results_id",text.getId());
    }
    
        private String getPgrmOutput (String s){
            String t = "";
            String lines[] = s.split("\\r?\\n|\\r");
            
            int start = 0;
            int end   = 0;
            for (int i =0; i<lines.length;i++){
                if (lines[i].contains("Running program")) start = i+1;
                else if (lines[i].contains("Program Exit Value")) end =i;
            }
            for (int i =start; i<end;i++){
                t += lines[i]+"\n";
            }
            return t;
        }
}
