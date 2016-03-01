/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
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

public class SwissprotFile extends Text implements Serializable{
    
    public SwissprotFile()                 {super();}
    public SwissprotFile(int id)           {super(id);}
    public SwissprotFile(String filename)  {super(filename);}

    public void setSwissprotFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("SwissprotFile");
        this.setText("SwissprotFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getSwissprotFile(){
        return this.getFilename();
    }
    
    @Override
    public String getBiologicType() {
        return "SwissprotFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
    public static String[] getSwissprotFileExtensionTab() {
        String[] t = {".swissprot",".swiss",".sw"};
        return t;
    }
    
    public static String getSwissprotFileExtensionString() {
        String[] ts = getSwissprotFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isSwissprotFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getSwissprotFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    

}
