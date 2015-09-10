/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package biologic;

import configuration.Util;
import java.io.Serializable;

/**
 *
 * @author Brisée-pas-morte
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
    
    @Override
    public String getBiologicType() {
        return "BamFile";
    }
    @Override
    public String getExtendedString() {
        return toString();
    }
}