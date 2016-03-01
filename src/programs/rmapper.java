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

////////////////////////////////////////////////////////////////////////////////
///
/// Create a Thread to run  Shrimp rmapper
///
/// Etienne Lord 2010

import biologic.Alignment;
import biologic.FastaFile;
import biologic.MultipleSequences;
import biologic.Results;
import biologic.SOLIDFile;
import biologic.Sequence;
import biologic.Text;
import biologic.TextFile;
import biologic.Tree;
import configuration.Util;
import program.RunProgram;
import workflows.workflow_properties;


public class rmapper extends RunProgram {

   
    ////////////////////////////////////////////////////////////////////////////
    /// Input / Output
   
    public rmapper(workflow_properties properties) {
       super(properties);
        execute();
    }

    @Override
    public boolean init_checkRequirements() {
        int fastafile_id=properties.getInputID("FastaFile");
        int SOLIDFile_id=properties.getInputID("SOLIDFile");
        if (fastafile_id==0) {
            setStatus(status_BadRequirements,"No fasta file found.");
            return false;
        }
        if (SOLIDFile_id==0) {
            setStatus(status_BadRequirements,"No SOLID Color reads file found.");
            return false;
        }
        return true;
    }

    @Override
    public void init_createInput() {
        
    }

    
    @Override
    public void post_parseOutput() {
        int fastafile_id=properties.getInputID("FastaFile");
        FastaFile fasta=new FastaFile(fastafile_id);
        TextFile text=new TextFile();
        text.setRunProgram_id(this.getId());
        text.setTextFile(fasta.getFastaFile()+".out");
        text.setName("Shrimp rmapper output ("+Util.returnCurrentDateAndTime()+")");
        text.setNote("Shrimp rmapper output ("+Util.returnCurrentDateAndTime()+")");
        text.saveToDatabase();
        properties.put("output_textfile_id", text.getId());
    }

    @Override
    public String[] init_createCommandLine() {
        int fastafile_id=properties.getInputID("FastaFile");
        int SOLIDFile_id=properties.getInputID("SOLIDFile");
        FastaFile fasta=new FastaFile(fastafile_id);
        SOLIDFile solid=new SOLIDFile(SOLIDFile_id);

          String[] com=new String[20];
          for (int i=0; i<com.length;i++) com[i]="";
          int index=7;
          //---P reads INFILE > OUTFILE
          com[0]="cmd.exe";
           com[1]="/C";
           com[2]=properties.getExecutable();
           com[3]="-P";
           com[4]=solid.getSolidFile();
           com[5]=fasta.getFastaFile();
           com[6]=">"+fasta.getFastaFile()+".out";
           return com;
    }

    

     @Override
    public int hashCode() {
         return Util.returnCount();
     }

     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final muscle other = (muscle) obj;
        return true;
    }

}
