//System.out.println("GenomeRef.isEmpty()");


/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package programs;

import biologic.Alignment;
import biologic.FastaFile;
import biologic.Genome;
import biologic.Results;
import biologic.Sequence;
import biologic.Text;
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
public class Bowtie2Map extends RunProgram{
    
    private String fastaFile1    ="";
    private String fastaFile2    ="";
    private String genomeFile    ="";
    private String outfile       ="outfile";
    
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
        Vector<Integer>Fasta1    = properties.getInputID("FastaFile",PortInputUP);
        Vector<Integer>Fasta2    = properties.getInputID("FastaFile",PortInputDOWN);
        Vector<Integer>GenomeRef = properties.getInputID("Genome",PortInputDOWN2);
        boolean b                = properties.isSet("M_IDG_workflow_button");
        
        if (Fasta1.isEmpty()) {
            setStatus(status_BadRequirements,"No sequence found.");
            return false;
        } else if (Fasta2.isEmpty() && properties.isSet("M_PE_button")) {
            setStatus(status_BadRequirements,"Need Fasts Paired-end.");
            return false;
        } else if (GenomeRef.isEmpty() || b) {
            setStatus(status_BadRequirements,"Need a Genome Reference");
            return false;
        }
        return true;
        
    
    }

    @Override
    public void init_createInput() {
        // Not USED
    }
    
    @Override
    public String[] init_createCommandLine() {
        
        // In case program is started without edition
        if (!properties.isSet("Options")) properties.put("Options","M_default_button");
        
        // Inputs
        Vector<Integer>Fasta1    = properties.getInputID("FastaFile",PortInputUP);
        Vector<Integer>Fasta2    = properties.getInputID("FastaFile",PortInputDOWN);
        Vector<Integer>GenomeRef = properties.getInputID("Genome",PortInputDOWN2);
        
        if (!Fasta2.isEmpty()){
            properties.put("M_PE_button","true");
            properties.remove("M_SE_button");
        }

        for (int ids:Fasta1) {
            FastaFile fas =new FastaFile(ids);
            if (fastaFile1.equals("")) {
                fastaFile1 = fas.getName();
                int pos1 = fastaFile1.lastIndexOf("/");
                int pos2 = fastaFile1.lastIndexOf(".");
                if (pos1 > 0) {
                    outfile = fastaFile1.substring(pos1+1,pos2);
                }
                outfile = "./results/bowtie2/"+outfile+".sam";
            } else {
                // Usefull when several files will be available
                fastaFile1 = fastaFile1+","+fas.getName()+"";
            }
        }
        
        for (int ids:Fasta2) {
            FastaFile fas =new FastaFile(ids);
            if (fastaFile2.equals("")){
                fastaFile2 = fas.getName();
            } else {
                // Usefull when several files will be available
                fastaFile2 = fastaFile2+","+fas.getName()+"";
            }
        }
        
        if (!GenomeRef.isEmpty()){
            for (int ids:GenomeRef) {
                Genome gen = new Genome(ids);
                genomeFile = gen.getName();
                genomeFile = genomeFile.replaceAll("\\.\\d.bt2$","");
                genomeFile = genomeFile.replaceAll("\\.rev$","");
            }
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
        if (!fastaFile1.equals("")) com[6]="\""+fastaFile1+"\"";
        if (!fastaFile2.equals("")) com[7]="\""+fastaFile2+"\"";
        if (!outfile.equals(""))    com[8]="-S \""+outfile+"\"";
        
        return com;
    }
    
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
    
    private String findOptions(String[] tab) {
        String s = "";
        String t = "";
        for ( int i = 0 ; i < tab.length ; i++ ){
            if (properties.isSet(tab[i])) {
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
                //System.out.println("t est "+t);
                if (tab[i].contains("_value") || tab[i].contains("_text")) {
                    //System.out.println("t2 est "+t);
                    t = t+" "+properties.get(tab[i]);
                    //System.out.println("tab[i] est "+tab[i]);
                }
                s = s+" "+t;
            }
        }
        return s;
    }
    
    public void post_parseOutput() {
        
        SamFile sam=new SamFile();
        File sam2 = new File(outfile);
        String s = sam2.getAbsolutePath();
        
//        System.out.println(s);
        sam.setSamFile(s);
        sam.setName(s);
        sam.saveToDatabase();
        properties.put("SamFile", sam.getId());
        addOutput(sam);
        
//        System.out.println(getOutput().isEmpty());
//        System.out.println(getOutput().get(0));
//        System.out.println(getOutput().size());

//        FastaFile sam=new FastaFile();
//        sam.setFastaFile(outfile+".fasta");
//        sam.setName(outfile);
//        sam.saveToDatabase();
//        addOutput(sam);
        
        properties.put("outfile_sam_id", sam.getId());
        
        //Text lk=new Text(fastaFile1+"_bowti2_lk.txt");
        
        Results text=new Results(fastaFile1+"_bowti2_stats.txt");
        //text.setText(text.getText()+"\n"+lk.getText());
        text.setText(text.getText()+"\n");
        text.setNote("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.setName("Bowtie2_stats ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        addOutput(text);
        properties.put("output_results_id",text.getId());
    }
    
    
}
