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

public class GcgFile extends Text implements Serializable{
    
    public GcgFile()                 {super();}
    public GcgFile(int id)           {super(id);}
    public GcgFile(String filename)  {super(filename);}

    public void setGcgFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("GcgFile");
        this.setText("GcgFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getGcgFile(){
        return this.getFilename();
    }
    
    public static String getGcgFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            GcgFile gen =new GcgFile(ids);
            s = gen.getName();
        }
        return s;
    }
    
    @Override
    public String getBiologicType() {
        return "GcgFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
    public static String[] getGcgFileExtensionTab() {
        String[] t = {".gcg",".gcg8"};
        return t;
    }
    
    public static String getGcgFileExtensionString() {
        String[] ts = getGcgFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isGcgFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getGcgFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static void saveGcgFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        GcgFile g = new GcgFile();
        g.setGcgFile(s);
        g.setName(s);
        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
        boolean b = g.saveToDatabase();
        if (b){
            p.put("output_gcgfile_id", g.getId());
            p.put("output_gcgfile_fileName", s);
        }
        else System.out.println("GcgFile not saved");
    }

}
