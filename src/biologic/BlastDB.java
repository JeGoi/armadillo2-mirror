/*
 *  Armadillo Workflow Platform v1.0
 *  A simple pipeline system for phylogenetic analysis
 *  
 *  Copyright (C) 2009-2011  Etienne Lord, Mickael Leclercq
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package biologic;

import configuration.Util;
import java.io.Serializable;

/**
 * This is really a mock for handling in the Armadillo Workflow
 * (in fact, we just save the blastDB filename into the
 *  filename field
 * @author Etienne Lord
 */
public class BlastDB extends Text implements Serializable {

    public BlastDB() {super();}

    public BlastDB(String filename) {
        super(filename);
    }

    public BlastDB(int id) {
        super(id);
    }

    public void setBlastDB(String filename) {
        this.setFilename(filename);
        this.setUnknownType("BlastDB");
        this.setText("BlastDB : "+filename+"\nSelected on: "+Util.returnCurrentDateAndTime());
    }

    public String getBlastDB() {
        return this.getFilename();
    }

    @Override
    public String getBiologicType() {
        return "BlastDB";
    }

    public String getExtendedString() {
        return toString();
    }
}