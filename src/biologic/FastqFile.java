/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package biologic;

import configuration.Util;
import java.io.Serializable;
import java.util.Vector;

/**
 * @author JG 2015
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
    public static String[] getFastqExtension() {
        String[] t = {".fastq",".fq"};
        return t;
    }
    
    public static boolean isFastqFile(String s){
        boolean b = false;
        String ext = s.substring(s.lastIndexOf("."),s.length());
        for (String sT:getFastqExtension())
            if (ext.equals(sT))
                b = true;
        return b;
    }
    
    public static String getFastqPath(Vector<Integer> f){
        String s = "";
        for (int ids:f) {
            FastqFile fas =new FastqFile(ids);
            s = fas.getName();
        }
        return s;
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
