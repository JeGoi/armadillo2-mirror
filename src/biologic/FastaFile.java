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

package biologic;

import configuration.Util;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
import workflows.workflow_properties;

/**
 *
 * @author Etienne Lord
 * @author JG 2016
 * 
 */
public class FastaFile extends Text implements Serializable {

    public FastaFile() {super();}
    public FastaFile(int id) {super(id);}
    public FastaFile(String filename) {super(filename);}

    public void setFastaFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("FastaFile");
        this.setText("FastaFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getFastaFile() {
        return this.getFilename();
    }
    
    public static String[] getFastaFileExtensionTab() {
        String[] t = {".fasta",".fa",".fna",".csfasta",".csfa",".gifasta"};
        return t;
    }
    
    public static String getFastaFileExtensionString() {
        String[] ts = getFastaFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isFastaFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getFastaFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getFastaFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            FastaFile fas =new FastaFile(ids);
            s = fas.getFastaFile();
        }
        return s;
    }
    
    public static void saveFastaFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        FastaFile f=new FastaFile();
        f.setFastaFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(Util.getFileNameAndExt(s)+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b){
            p.put("output_fastafile_id", f.getId());
            p.put("output_fastafile_fileName", s);
        }
        else System.out.println("WARNING : fasta file not saved");
    }

    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "FastaFile";
    }

}
