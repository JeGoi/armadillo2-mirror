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
    
    public static String getSwissprotFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            SwissprotFile gen =new SwissprotFile(ids);
            s = gen.getName();
        }
        return s;
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
    
    public static void saveSwissprotFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        SwissprotFile g = new SwissprotFile();
        g.setSwissprotFile(s);
        g.setName(s);
        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
        boolean b = g.saveToDatabase();
        if (b){
            p.put("output_swissprotfile_id", g.getId());
            p.put("output_swissprotfile_fileName", s);
        }
        else System.out.println("SwissproteFile not saved");
    }

}
