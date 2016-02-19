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

public class GenomeFile extends Text implements Serializable{
    
    public GenomeFile()                 {super();}
    public GenomeFile(int id)           {super(id);}
    public GenomeFile(String filename)  {super(filename);}

    public void setGenomeFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("GenomeFile");
        this.setText("GenomeFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getGenomeFile(){
        return this.getFilename();
    }
    
    public static String getGenomeFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            GenomeFile gen =new GenomeFile(ids);
            s = gen.getName();
        }
        return s;
    }
    
    @Override
    public String getBiologicType() {
        return "GenomeFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
    
    public static void saveGenomeFile (workflow_properties p, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        GenomeFile g = new GenomeFile();
        g.setGenomeFile(s);
        g.setName(s);
        g.setNote(pgrmName+". Created on "+Util.returnCurrentDateAndTime());
        boolean b = g.saveToDatabase();
        if (b) {
            p.put("output_genomefile_id", g.getId());
            p.put("output_genomefile_fileName", s);
        }
        else System.out.println("genome not saved");
    }

}
