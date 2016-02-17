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

public class EmblFile extends Text implements Serializable{
    
    public EmblFile()                 {super();}
    public EmblFile(int id)           {super(id);}
    public EmblFile(String filename)  {super(filename);}

    public void setEmblFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("EmblFile");
        this.setText("EmblFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getEmblFile(){
        return this.getFilename();
    }
    
    public static String getEmblFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            EmblFile gen =new EmblFile(ids);
            s = gen.getName();
        }
        return s;
    }
    
    @Override
    public String getBiologicType() {
        return "EmblFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
    public static String[] getEmblFileExtensionTab() {
        String[] t = {".embl",".em"};
        return t;
    }
    
    public static String getEmblFileExtensionString() {
        String[] ts = getEmblFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isEmblFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getEmblFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static void saveEmblFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        EmblFile g = new EmblFile();
        g.setEmblFile(s);
        g.setName(s);
        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
        boolean b = g.saveToDatabase();
        if (b) properties.put("output_emblfile_id", g.getId());
        else System.out.println("EmbleFile not saved");
    }

}
