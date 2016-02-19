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
public class BananaFile extends Text implements Serializable {

    public BananaFile() {super();}
    public BananaFile(int id) {super(id);}
    public BananaFile(String filename) {super(filename);}

    public void setBananaFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Banana");
        this.setText("Banana : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getBananaFile() {
        return this.getFilename();
    }
    
    public static String[] getBananaFileExtensionTab() {
        String[] t = {".profile"};
        return t;
    }
    
    public static String getBananaFileExtensionString() {
        String[] ts = getBananaFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isBananaFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getBananaFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getBananaFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            BananaFile fas =new BananaFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static void saveBananaFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        BananaFile f=new BananaFile();
        f.setBananaFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b){
            p.put("output_bananafile_id", f.getId());
            p.put("output_bananafile_fileName", f.getBananaFile());
        }
        else System.out.println("WARNING : Banana file not saved");
    }

    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "BananaFile";
    }

}
