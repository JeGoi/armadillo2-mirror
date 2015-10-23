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
import java.io.Serializable;
import java.util.Vector;
import workflows.workflow_properties;

/**
 *
 * @author Etienne Lord
 */
public class FastaFile extends Text implements Serializable {

    public FastaFile() {super();}
    public FastaFile(int id) {super(id);}
    public FastaFile(String filename) {super(filename);}

    public void setFastaFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Fasta");
        this.setText("Fasta : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getFastaFile() {
        return this.getFilename();
    }
    
    public static String[] getFastaExtensionTab() {
        String[] t = {".fasta",".fa",".fna",".csfasta",".csfa"};
        return t;
    }
    
    public static String getFastaExtensionString() {
        String t = ".fasta<>.fa<>.fna<>.csfasta<>.csfa";
        return t;
    }
    
    public static boolean isFastaFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getFastaExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getFastaPath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            FastaFile fas =new FastaFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static int saveFastaFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        FastaFile f=new FastaFile();
        f.setFastaFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        f.saveToDatabase();
        return f.getId();
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
