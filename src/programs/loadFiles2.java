/*
*  Armadillo Workflow Platform v1.0
*  A simple pipeline system for phylogenetic analysis
*
*  Copyright (C) 2009-2011  Etienne Lord, Mickael Leclercq
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*
*  You should have received a copy of the GNU General Public License
*  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package programs;


import biologic.FastaFile;
import biologic.FastqFile;
import biologic.GenomeFile;
import biologic.Results;
import biologic.SOLIDFile;
import biologic.Text;
import biologic.TextFile;
import configuration.Util;
import program.RunProgram;
import workflows.workflow_properties;

/**
 * Subprogram to load some files into Armadillo
 * @author Etienne Lord
 * @since Mars 2010
 */
public class loadFiles2 extends RunProgram {
    
    
    /**
     * Main contructor
     */
    public loadFiles2(workflow_properties properties) {
        super(properties);
        execute();
    }
    
    /**
     * Verify some of the requirement
     * @return
     */
    @Override
    public boolean init_checkRequirements() {
        int TextID=properties.getInputID("Text");
        int type=properties.getInt("type");
        if (properties.isSet("LAF_Repeat_button") &&
                !properties.isSet("inputname")    &&
                TextID==0) {
            setStatus(status_BadRequirements,"No filename specified.");
            return false;
        } else if (properties.isSet("LAF2_AFIOS_Button") && type!=6 ) {
            setStatus(status_BadRequirements,"Only available for Bowtie2, Bowtie\n"
                    + "Need also >>>> FastqFiles <<<< Only");
            return false;
        } else if (!properties.isSet("LAF_Repeat_button") &&
                !properties.isSet("LAF2_AFIOS_Button")) {
            setStatus(status_BadRequirements,"Need to choose a file and type of send files");
            return false;
        }
        
        return true;
    }
    
    
    @Override
    public void init_createInput() {
        
    }
    
    
    @Override
    public String[] init_createCommandLine() {
        String[] com=new String[11];
        for (int i=0; i<com.length;i++) com[i]="";
        return com;
    }
    
    
    
    @Override
    public boolean do_run() throws Exception {
        return true;
    }
    
    
    @Override
    public void post_parseOutput() {
        
        int TextID=properties.getInputID("Text");
        if (TextID!=0) {
            Text text=new Text(TextID);
            text.Output("outfile");
            properties.put("inputname","outfile");
        }
        
        int type=properties.getInt("type");
        
        //System.out.println(properties.getPropertiesToString());
        
        if (properties.isSet("LAF2_AFIOS_Button") && type==6 ) {
            FastqFile fastqFile=new FastqFile();
            fastqFile.setFastqFile(properties.get("inputAllNames"));
            fastqFile.setName(properties.get("inputAllNames"));
            fastqFile.saveToDatabase();
            properties.put("output_fastqfile_id", fastqFile.getId());
        }
        else if (properties.isSet("LAF_Repeat_button")) {
            switch(type) {
                case 0: TextFile txt=new TextFile();
                    txt.setFile(properties.get("inputname"));
                    txt.setName(Util.getFileNameAndExt(properties.get("inputname")));
                    txt.saveToDatabase();
                    properties.put("output_textfile_id", txt.getId());
                    break;
                case 1: SOLIDFile solid=new SOLIDFile();
                    solid.setSolidFile(properties.get("inputname"));
                    solid.setName(Util.getFileNameAndExt(properties.get("inputname")));
                    solid.saveToDatabase();
                    properties.put("output_solidfile_id", solid.getId());
                    break;
                case 2: FastaFile fasta=new FastaFile();
                    fasta.setFastaFile(properties.get("inputname"));
                    fasta.setName(Util.getFileNameAndExt(properties.get("inputname")));
                    fasta.saveToDatabase();
                    properties.put("output_fastafile_id", fasta.getId());
                    break;
                case 3: Results results=new Results(properties.get("inputname"));
                    results.setName(properties.get("inputname"));
                    results.saveToDatabase();
                    properties.put("output_results_id", results.getId());
                    break;
                case 4: Text text=new Text(properties.get("inputname"));
                    text.setName(properties.get("inputname"));
                    text.saveToDatabase();
                    properties.put("output_text_id", text.getId());
                    break;
                    // JG 2015
                case 5: GenomeFile genomeFile=new GenomeFile();
                    genomeFile.setGenomeFile(properties.get("inputname"));
                    genomeFile.setName(Util.getFileNameAndExt(properties.get("inputname")));
                    genomeFile.saveToDatabase();
                    properties.put("output_genomefile_id", genomeFile.getId());
                    break;
                    // JG 2015
                case 6: FastqFile fastqFile=new FastqFile();
                    fastqFile.setFastqFile(properties.get("inputname"));
                    fastqFile.setName(Util.getFileNameAndExt(properties.get("inputname")));
                    fastqFile.saveToDatabase();
                    properties.put("output_fastqfile_id", fastqFile.getId());
                    break;
            }
        } else System.out.println("else");
    }
    
}
