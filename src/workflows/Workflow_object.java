
package workflows;

import configuration.Util;
import processing.core.PApplet;
import static processing.core.PApplet.dist;
import static processing.core.PApplet.expand;
import static processing.core.PApplet.str;
import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.CORNER;
import static processing.core.PConstants.HALF_PI;
import static processing.core.PConstants.QUADS;
import static processing.core.PConstants.TWO_PI;
import processing.core.PImage;
import program.RunProgram;
import processing.core.PApplet;
import java.applet.Applet;

/**
 *
 * @author Etienne Lord
 */
public class Workflow_object extends java.awt.Polygon {
    


    /**
     * This will create the specified variable on the workflow or update it.
     * @param name
     * @param value
     * @param visible
     * @return
     */
    public workflow_properties setVariable(String name, String value, boolean visible) {
        workflow_properties tmp=null;
        //1. Find possible variable
        
        //2. No variable found in the workflow, add one...
        tmp.setName("Undefined Variable");
        tmp.put("colorMode","GREEN");
        tmp.put("defaultColor","GREEN");
        tmp.put("Output"+"Text", "True");
        tmp.put("outputType", "Text");
        tmp.put("InputAll","Connector0");
        tmp.put("Connector1Output", "True");
        //tmp.put("Connector0Conditional", "True");
        tmp.put("ObjectType", "Variable");
        //tmp.put("output_"+"variable"+"_id", id);
        tmp.put("EditorClassName","editors.VariableEditor");
        
        return tmp;
    }
    
    /**
     * This will create the specified variable on the workflow or update it.
     * @param name
     * @param value
     * @param visible
     * @return
     */
    public workflow_properties setVariable2(String name, String value, boolean visible) {
        workflow_properties tmp=null;
        //1. Find possible variable
        
        //2. No variable found in the workflow, add one...
        tmp.setName("Undefined Variable");
        tmp.put("colorMode","GREEN");
        tmp.put("defaultColor","GREEN");
        tmp.put("Output"+"Text", "True");
        tmp.put("outputType", "Text");
        tmp.put("InputAll","Connector0");
        tmp.put("Connector1Output", "True");
        //tmp.put("Connector0Conditional", "True");
        tmp.put("ObjectType", "Variable");
        //tmp.put("output_"+"variable"+"_id", id);
        tmp.put("EditorClassName","editors.VariableEditor");
        
        return tmp;
    }
    
}//End workflow_object

