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

public class NbrfFile extends Text implements Serializable {

    public NbrfFile() {super();}
    public NbrfFile(int id) {super(id);}
    public NbrfFile(String filename) {super(filename);}

    public void setNbrfFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Nbrf");
        this.setText("Nbrf : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getNbrfFile() {
        return this.getFilename();
    }
    
    public static String[] getNbrfFileExtensionTab() {
        String[] t = {".nbrf"};
        return t;
    }
    
    public static String getNbrfFileExtensionString() {
        String[] ts = getNbrfFileExtensionTab();
        String t = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isNbrfFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getNbrfFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getNbrfFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            NbrfFile fas =new NbrfFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static int saveNbrfFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        NbrfFile f=new NbrfFile();
        f.setNbrfFile(s);
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
        return "NbrfFile";
    }

}
