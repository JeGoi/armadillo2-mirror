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
public class BamFile extends Text implements Serializable{
    
    public BamFile()                  {super();}
    public BamFile(int id)            {super(id);}
    public BamFile(String filename)   {super(filename);}
    
    public void setBamFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("BamFile");
        //--Note: we have a properties in the Fastq file
        this.setText("BamFile : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    
    public String getBamFile(){
        return this.getFilename();
    }
    
    public static String getBamFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            BamFile b =new BamFile(ids);
            s = b.getName();
        }
        return s;
    }
    
    public static void saveBamFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        BamFile f=new BamFile();
        f.setBamFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b) properties.put("output_bamfile_id", f.getId());
        else System.out.println("WARNING : BAM file not saved");
    }

    
    @Override
    public String getBiologicType() {
        return "BamFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
}
