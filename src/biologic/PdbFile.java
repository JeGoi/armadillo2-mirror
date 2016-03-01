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
    
//    public static void savePdbFile (workflow_properties p, String s, String pgrmName) {
//        s = Util.relativeToAbsoluteFilePath(s);
//        PdbFile g = new PdbFile();
//        g.setPdbFile(s);
//        g.setName(s);
//        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
//        boolean b = g.saveToDatabase();
//        if (b){
//            p.put("output_pdbfile_id", g.getId());
//            p.put("output_pdbfile_fileName", s);
//        }
//        else System.out.println("PdbFile not saved");
//    }

}
