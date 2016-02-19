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
public class ArffFile extends Text implements Serializable {

    public ArffFile() {super();}
    public ArffFile(int id) {super(id);}
    public ArffFile(String filename) {super(filename);}

    public void setArffFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Arff");
        this.setText("Arff : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getArffFile() {
        return this.getFilename();
    }
    
    public static String[] getArffFileExtensionTab() {
        String[] t = {".profile"};
        return t;
    }
    
    public static String getArffFileExtensionString() {
        String[] ts = getArffFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isArffFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getArffFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getArffFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            ArffFile fas =new ArffFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static void saveArffFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        ArffFile f=new ArffFile();
        f.setArffFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b){
            p.put("output_arfffile_id", f.getId());
            p.put("output_arfffile_fileName", s);
        }
        else System.out.println("WARNING : Arff file not saved");
    }

    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "ArffFile";
    }

}
