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
 * @author JG 2016
 */
public class DatFile extends Text implements Serializable {

    public DatFile() {super();}
    public DatFile(int id) {super(id);}
    public DatFile(String filename) {super(filename);}

    public void setDatFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Dat");
        this.setText("Dat : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getDatFile() {
        return this.getFilename();
    }
    
    public static String[] getDatFileExtensionTab() {
        String[] t = {".txt",".dat"};
        return t;
    }
    
    public static String getDatFileExtensionString() {
        String[] ts = getDatFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isDatFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getDatFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getDatFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            DatFile fas =new DatFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static void saveDatFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        DatFile f=new DatFile();
        f.setDatFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b) {
            p.put("output_datfile_id", f.getId());
            p.put("output_datfile_fileName", s);
        }
        else System.out.println("WARNING : Dat file not saved");
    }

    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "DatFile";
    }

}
