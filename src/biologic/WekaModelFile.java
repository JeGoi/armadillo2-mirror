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
public class WekaModelFile extends Text implements Serializable {

    public WekaModelFile() {super();}
    public WekaModelFile(int id) {super(id);}
    public WekaModelFile(String filename) {super(filename);}

    public void setWekaModelFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("WekaModelFile");
        this.setText("WekaModelFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getWekaModelFile() {
        return this.getFilename();
    }
    
    public static String[] getWekaModelFileExtensionTab() {
        String[] t = {".model",".modelOutput"};
        return t;
    }
    
    public static String getWekaModelFileExtensionString() {
        String[] ts = getWekaModelFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isWekaModelFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getWekaModelFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getWekaModelFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            WekaModelFile fas =new WekaModelFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static void saveWekaModelFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        WekaModelFile f=new WekaModelFile();
        f.setWekaModelFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b) properties.put("output_wekamodelfile_id", f.getId());
        else System.out.println("WekaModel file not saved");
    }

    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "WekaModelFile";
    }

}
