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
public class EinvertedFile extends Text implements Serializable {

    public EinvertedFile() {super();}
    public EinvertedFile(int id) {super(id);}
    public EinvertedFile(String filename) {super(filename);}

    public void setEinvertedFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("Einverted");
        this.setText("Einverted : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getEinvertedFile() {
        return this.getFilename();
    }
    
    public static String[] getEinvertedFileExtensionTab() {
        String[] t = {".einverted"};
        return t;
    }
    
    public static String getEinvertedFileExtensionString() {
        String[] ts = getEinvertedFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isEinvertedFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getEinvertedFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    @Override
    public String getExtendedString() {
        return toString();
    }
    @Override
    public String getBiologicType() {
        return "EinvertedFile";
    }

}
