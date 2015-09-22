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
 *
 * @author Brisée-pas-morte
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
    
    public static String getGenomePath(Vector<Integer> f){
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
    

}
