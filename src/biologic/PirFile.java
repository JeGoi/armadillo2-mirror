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

public class PirFile extends Text implements Serializable{
    
    public PirFile()                 {super();}
    public PirFile(int id)           {super(id);}
    public PirFile(String filename)  {super(filename);}

    public void setPirFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("PirFile");
        this.setText("PirFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getPirFile(){
        return this.getFilename();
    }
    
    public static String getPirFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            PirFile gen =new PirFile(ids);
            s = gen.getName();
        }
        return s;
    }
    
    @Override
    public String getBiologicType() {
        return "PirFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
    public static String[] getPirFileExtensionTab() {
        String[] t = {".pir"};
        return t;
    }
    
    public static String getPirFileExtensionString() {
        String[] ts = getPirFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isPirFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getPirFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static void savePirFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        PirFile g = new PirFile();
        g.setPirFile(s);
        g.setName(s);
        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
        boolean b = g.saveToDatabase();
        if (b){
            p.put("output_pirfile_id", g.getId());
            p.put("output_pirfile_fileName", s);
        }
        else System.out.println("PirFile not saved");
    }

}
