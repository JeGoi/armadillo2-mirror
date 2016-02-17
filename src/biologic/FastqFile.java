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

public class FastqFile extends Text implements Serializable{
    
    public FastqFile()                  {super();}
    public FastqFile(int id)            {super(id);}
    public FastqFile(String filename)   {super(filename);}
    
    public void setFastqFile(String filename) {
        this.setFilename(filename);
        this.setUnknownType("FastqFile");
        //--Note: we have a properties in the Fastq file
        this.setText("Fastq : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }
    public String getFastqFile(){
        return this.getFilename();
    }
    public static String[] getFastqFileExtension() {
        String[] t = {".fastq",".fq"};
        return t;
    }
    
    public static String getFastqFileExtensionString() {
        String[] ts = getFastqFileExtension();
        String   t  = ts[0];
        if (ts.length>1) t = String.join("<>",ts);
        return t;
    }    
    public static boolean isFastqFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getFastqFileExtension())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getFastqFilePath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            FastqFile fas =new FastqFile(ids);
            s = fas.getName();
        }
        return s;
    }
    
    public static int sameFastqFileName (String s1,String s2) {
        int b = 0;
        s1 = s1.replaceAll("_\\d$","");
        s2 = s2.replaceAll("_\\d$","");
        if (s2.equals(s1)) b=1;
        return b;
    }

    public static int goodFastqFileNumber (String s1,String s2) {
        int b = 0;
        int val1 = Integer.parseInt(s1.replaceAll(".*_(\\d)$","$1"));
        int val2 = Integer.parseInt(s2.replaceAll(".*_(\\d)$","$1"));
        if (val1==1 && val2==2) b=1;
        return b;
    }

    
    public static void saveFastqFile (workflow_properties properties, String s, String pgrmName) {
        s = Util.relativeToAbsoluteFilePath(s);
        FastqFile f=new FastqFile();
        f.setFastqFile(s);
        f.setNote(pgrmName+"_stats ("+Util.returnCurrentDateAndTime()+")");
        f.setName(pgrmName+" ("+Util.returnCurrentDateAndTime()+")");
        boolean b = f.saveToDatabase();
        if (b) properties.put("output_fastqfile_id", f.getId());
        else System.out.println("WARNING : fastq file not saved");
    }
    
    @Override
    public String getBiologicType() {
        return "FastqFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
}
