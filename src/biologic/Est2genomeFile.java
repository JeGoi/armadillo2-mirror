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
 * @author JG 2016
 * 
 */
public class Est2genomeFile extends Text implements Serializable {

    public Est2genomeFile() {super();}
    public Est2genomeFile(int id) {super(id);}
    public Est2genomeFile(String filename) {super(filename);}

    public void setEst2genomeFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Est2genome");
        this.setText("Est2genome : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getEst2genomeFile() {
        return this.getFilename();
    }
    
    public static String[] getEst2genomeFileExtensionTab() {
        String[] t = {".est2genome"};
        return t;
    }
    
    public static String getEst2genomeFileExtensionString() {
        String[] ts = getEst2genomeFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isEst2genomeFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getEst2genomeFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getEst2genomeFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            Est2genomeFile fas =new Est2genomeFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static void saveEst2genomeFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        Est2genomeFile f=new Est2genomeFile();
        f.setEst2genomeFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b) {
            p.put("output_est2genomefile_id", f.getId());
            p.put("output_est2genomefile_fileName", s);
        }
        else System.out.println("WARNING : est2genome file not saved");
    }

    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "Est2genomeFile";
    }

}
