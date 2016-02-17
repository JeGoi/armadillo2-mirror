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

public class PdbFile extends Text implements Serializable{
    
    public PdbFile()                 {super();}
    public PdbFile(int id)           {super(id);}
    public PdbFile(String filename)  {super(filename);}

    public void setPdbFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("PdbFile");
        this.setText("PdbFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getPdbFile(){
        return this.getFilename();
    }
    
    public static String getPdbFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            PdbFile gen =new PdbFile(ids);
            s = gen.getName();
        }
        return s;
    }
    
    @Override
    public String getBiologicType() {
        return "PdbFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
    public static String[] getPdbFileExtensionTab() {
        String[] t = {".pdb",".pdbseq",".pdbnuc",".pdbnucseq"};
        return t;
    }
    
    public static String getPdbFileExtensionString() {
        String[] ts = getPdbFileExtensionTab();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }
    
    public static boolean isPdbFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getPdbFileExtensionTab())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static void savePdbFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        PdbFile g = new PdbFile();
        g.setPdbFile(s);
        g.setName(s);
        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
        boolean b = g.saveToDatabase();
        if (b) properties.put("output_gcgfile_id", g.getId());
        else System.out.println("PdbFile not saved");
    }

}
