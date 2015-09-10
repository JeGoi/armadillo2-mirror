//System.out.println("update");
//System.out.println(properties.get("CM_A_i_function"));
//System.out.println("remove box");

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package editors;

import configuration.Config;
import editor.EditorInterface;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import program.*;
import workflows.armadillo_workflow;
import workflows.workflow_properties;
import workflows.workflow_properties_dictionnary;

/**
 *
 * @author Jérémy Goimard
 * @date Aout 2015
 * 
 * If a button, box is used with spinner or text field,
 * the choice was made to use the value name because of the updated content function
 * 
 */

public class Bowtie2InspectEditors extends javax.swing.JDialog implements EditorInterface  {
    
    /**
     * Creates new form MaqEditors
     */
    Config config=new Config();
    //ConnectorInfoBox connectorinfobox;
    workflow_properties_dictionnary dict=new workflow_properties_dictionnary();
    String selected="";             // Selected properties
    Frame frame;
    workflow_properties properties;
    armadillo_workflow parent_workflow;
    
    public final String defaultNameString=" Name";
    static final boolean default_map=true;
    
    /////////////////////////////////////////////////////////////////////////
    /// Default Options
    
    public Bowtie2InspectEditors(java.awt.Frame parent, armadillo_workflow parent_workflow) {
        super(parent, false);
        this.parent_workflow=parent_workflow;
        //--Set variables and init
        frame=parent;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Options_Buttons = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        Bowtie2InspectEditor = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        name_jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        I_DO_button = new javax.swing.JRadioButton();
        I_AO_button = new javax.swing.JRadioButton();
        I_Panel = new javax.swing.JPanel();
        I_v_box = new javax.swing.JCheckBox();
        I_s_box = new javax.swing.JCheckBox();
        I_n_box = new javax.swing.JCheckBox();
        I_a_value = new javax.swing.JSpinner();
        I_a_box = new javax.swing.JCheckBox();
        reset_jButton3 = new javax.swing.JButton();
        stop_jButton4 = new javax.swing.JButton();
        run_jButton5 = new javax.swing.JButton();
        ClosejButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Bowtie2InspectEditor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Bowtie2InspectEditorComponentShown(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(521, 521));

        jButton2.setText("Rename");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        name_jTextField1.setText("Bowtie2 Inspect");
        name_jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(name_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Options_Buttons.add(I_DO_button);
        I_DO_button.setText("Default Options");
        I_DO_button.setToolTipText("<html>\nAll sequences are compared <br/>\nto each other\n</html>");
        I_DO_button.setName("I_DO_button"); // NOI18N
        I_DO_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I_DO_buttonActionPerformed(evt);
            }
        });

        Options_Buttons.add(I_AO_button);
        I_AO_button.setText("Advanced Options");
        I_AO_button.setToolTipText("<html>\nAll sequences are compared <br/>\nto each other\n</html>");
        I_AO_button.setName("I_AO_button"); // NOI18N
        I_AO_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I_AO_buttonActionPerformed(evt);
            }
        });

        I_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Inspect Options"));
        I_Panel.setEnabled(false);
        I_Panel.setName("I_Panel"); // NOI18N

        I_v_box.setText("-v/--verbose");
        I_v_box.setName("I_v_box"); // NOI18N
        I_v_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I_v_boxActionPerformed(evt);
            }
        });

        I_s_box.setText("-s/--summary");
        I_s_box.setName("I_s_box"); // NOI18N
        I_s_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I_s_boxActionPerformed(evt);
            }
        });

        I_n_box.setText("-n/--names");
        I_n_box.setName("I_n_box"); // NOI18N
        I_n_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I_n_boxActionPerformed(evt);
            }
        });

        I_a_value.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(60), Integer.valueOf(0), null, Integer.valueOf(1)));
        I_a_value.setToolTipText("");
        I_a_value.setName("I_a_value"); // NOI18N
        I_a_value.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                I_a_spinner_value(evt);
            }
        });

        I_a_box.setText("-a/--across");
        I_a_box.setName("I_a_box"); // NOI18N
        I_a_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I_a_boxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout I_PanelLayout = new javax.swing.GroupLayout(I_Panel);
        I_Panel.setLayout(I_PanelLayout);
        I_PanelLayout.setHorizontalGroup(
            I_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(I_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(I_n_box, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(I_PanelLayout.createSequentialGroup()
                        .addComponent(I_a_box)
                        .addGap(18, 18, 18)
                        .addComponent(I_a_value, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(I_s_box)
                    .addComponent(I_v_box, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        I_PanelLayout.setVerticalGroup(
            I_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(I_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(I_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I_a_box)
                    .addComponent(I_a_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(I_n_box)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(I_s_box)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(I_v_box)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        I_v_box.getAccessibleContext().setAccessibleDescription("Print verbose output (for debugging).");
        I_s_box.getAccessibleContext().setAccessibleDescription("Print a summary that includes information about index settings, as well as the names and lengths of the input sequences. The summary has this format:  Colorspace  <0 or 1> SA-Sample   1 in <sample> FTab-Chars  <chars> Sequence-1  <name>  <len> Sequence-2  <name>  <len> ... Sequence-N  <name>  <len>  Fields are separated by tabs. Colorspace is always set to 0 for Bowtie 2.");
        I_n_box.getAccessibleContext().setAccessibleDescription("Print reference sequence names, one per line, and quit.");

        reset_jButton3.setText("Reset default value");
        reset_jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_jButton3ActionPerformed(evt);
            }
        });

        stop_jButton4.setText("Stop");
        stop_jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_jButton4ActionPerformed(evt);
            }
        });

        run_jButton5.setText("Run");
        run_jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                run_jButton5ActionPerformed(evt);
            }
        });

        ClosejButton6.setText("Close");
        ClosejButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosejButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reset_jButton3)
                        .addGap(60, 60, 60)
                        .addComponent(stop_jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(run_jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClosejButton6))
                    .addComponent(I_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(I_DO_button)
                        .addGap(18, 18, 18)
                        .addComponent(I_AO_button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I_DO_button)
                    .addComponent(I_AO_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(I_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_jButton3)
                    .addComponent(stop_jButton4)
                    .addComponent(run_jButton5)
                    .addComponent(ClosejButton6))
                .addContainerGap())
        );

        Bowtie2InspectEditor.addTab("Bowtie2 Inspect", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addComponent(Bowtie2InspectEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bowtie2InspectEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );

        Bowtie2InspectEditor.getAccessibleContext().setAccessibleName("BwaEditors");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void Bowtie2InspectEditorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Bowtie2InspectEditorComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_Bowtie2InspectEditorComponentShown
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HelpEditor help = new HelpEditor(this.frame, false, properties);
        help.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void ClosejButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosejButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_ClosejButton6ActionPerformed
    
    private void run_jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run_jButton5ActionPerformed
        // TODO add your handling code here:
        if (this.properties.isSet("ClassName")) {
            this.parent_workflow.workflow.updateDependance();
            programs prog=new programs(parent_workflow.workbox.getCurrentWorkflows());
            prog.Run(properties);
        }
    }//GEN-LAST:event_run_jButton5ActionPerformed
    
    private void stop_jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_jButton4ActionPerformed
        // TODO add your handling code here:
        properties.put("Status", Config.status_nothing);
        properties.killThread();
    }//GEN-LAST:event_stop_jButton4ActionPerformed
    
    private void reset_jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_jButton3ActionPerformed
        // TODO add your handling code here:
        properties.load();             //--reload current properties from file
        this.setProperties(properties);//--Update current field
        this.display(properties);
    }//GEN-LAST:event_reset_jButton3ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        properties.put("Name", this.name_jTextField1.getText());
    }//GEN-LAST:event_jButton2ActionPerformed
                                                        
    private void I_v_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I_v_boxActionPerformed
        // TODO add your handling code here:
        if (properties.isSet(I_s_box.getName())) {
            properties.remove(I_s_box.getName());
            I_s_box.setSelected(false);
        } else if (properties.isSet(I_n_box.getName())) {
            properties.remove(I_n_box.getName());
            I_n_box.setSelected(false);
        }
        boxEvent(I_v_box,null);
    }//GEN-LAST:event_I_v_boxActionPerformed
    
    private void I_s_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I_s_boxActionPerformed
        // TODO add your handling code here:
        if (properties.isSet(I_v_box.getName())) {
            properties.remove(I_v_box.getName());
            I_v_box.setSelected(false);
        } else if (properties.isSet(I_n_box.getName())) {
            properties.remove(I_n_box.getName());
            I_n_box.setSelected(false);
        }
        boxEvent(I_s_box,null);
    }//GEN-LAST:event_I_s_boxActionPerformed
    
    private void I_n_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I_n_boxActionPerformed
        // TODO add your handling code here:
        if (properties.isSet(I_v_box.getName())) {
            properties.remove(I_v_box.getName());
            I_v_box.setSelected(false);
        } else if (properties.isSet(I_s_box.getName())) {
            properties.remove(I_s_box.getName());
            I_s_box.setSelected(false);
        }
        boxEvent(I_n_box,null);
    }//GEN-LAST:event_I_n_boxActionPerformed
        
    private void name_jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_jTextField1ActionPerformed
                                                                                                        
    private void I_a_spinner_value(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_I_a_spinner_value
        // TODO add your handling code here:
        spinnerUpdate(I_a_value);
    }//GEN-LAST:event_I_a_spinner_value
        
    private void I_a_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I_a_boxActionPerformed
        // TODO add your handling code here:
        boxEvent(I_a_box,I_a_value);
    }//GEN-LAST:event_I_a_boxActionPerformed
                                                                                                                                                                                                                                                                                    
    private void I_DO_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I_DO_buttonActionPerformed
        // TODO add your handling code here:
        if (!properties.isSet(I_AO_button.getName())) {
            properties.remove(I_AO_button.getName());
        }
        inspectFields(false);
        buttonEvent(I_DO_button);
    }//GEN-LAST:event_I_DO_buttonActionPerformed

    private void I_AO_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I_AO_buttonActionPerformed
        // TODO add your handling code here:
        if (!properties.isSet(I_DO_button.getName())) {
            properties.remove(I_DO_button.getName());
        }
        inspectFields(true);
        buttonEvent(I_AO_button);
    }//GEN-LAST:event_I_AO_buttonActionPerformed
    
    
    /**
     * Save Values
     * /!\ DONT FORGET TO ADD A NAME in the design for all /!\
     * @param Save_Values
     */
    //For Box
    private void boxEvent(javax.swing.JCheckBox b,javax.swing.JSpinner s){
        if (b.isSelected()==true){
            if (s != null) {
                s.setEnabled(true);
                properties.put(s.getName(),s.getValue());
            }
            properties.put(b.getName(),b.isSelected());
        } else {
            if (s != null){
                s.setEnabled(false);
            }
            properties.remove(b.getName());
        }
    }
    //For Button and Spinner
    private void buttonEvent(javax.swing.JRadioButton b){
        if (b.isSelected()==true){
            properties.put(b.getName(),b.isSelected());
        }
    }
    
    
    /**
     * Update Values content
     * /!\ DONT FORGET TO ADD A NAME in the design for all /!\
     * @param Update_Values
     */
    //Spinner update
    private void spinnerUpdate(javax.swing.JSpinner s){
        properties.put(s.getName(),s.getValue());
    }
    
    /**
     * Enable or disable fields of Options
     * @param enabled
     */
    
    private void inspectFields(boolean enabled){
        this.I_Panel.setVisible(enabled);
        this.I_v_box.setEnabled(enabled);
        this.I_s_box.setEnabled(enabled);
        this.I_n_box.setEnabled(enabled);
        this.I_a_box.setEnabled(enabled);
        if (properties.isSet(I_a_box.getName())) this.I_a_value.setEnabled(true);
        else this.I_a_value.setEnabled(false);
    }
    
    
    /**
     * Set Properties
     */
    
    public void setProperties(workflow_properties properties) {
        this.properties=properties;
        setTitle(properties.getName());
        //if (this.properties.isSet("Description")) this.Notice.setText(properties.get("Description"));
        
        // Properties Default Options
        this.defaultPgrmValues(properties);
    }

    public void setProperties(String filename, String path) {
        workflow_properties tmp=new workflow_properties();
        tmp.load(filename, path);
        this.properties=tmp;
        setTitle(properties.getName());
    }
    
    private void defaultPgrmValues(workflow_properties properties) {
        if (!properties.isSet(I_DO_button.getName())) {
            String defaultEditorStatus = properties.get("defaultPgrmValues");
            String[] arrayDefault = defaultEditorStatus.split("<>");
            int z = 0;
            for (int i =0 ; i < arrayDefault.length ; i=i+2){
                z = i;
                this.properties.put(arrayDefault[z],arrayDefault[z+1]);
            }
        }
    }

    /**
     * Update Saved Properties uSP
     */
    
    private void updateSavedProperties(workflow_properties properties) {
        // Inspect properties saved
        if (properties.isSet(I_DO_button.getName())) {
            this.I_DO_button.setSelected(true);
            inspectFields(false);
        }
        if (properties.isSet(I_AO_button.getName())) {
            this.I_AO_button.setSelected(true);
            inspectFields(true);
        }
        
        if (properties.isSet(I_a_value.getName())){
            this.I_a_value.setValue(Integer.parseInt(properties.get(I_a_value.getName())));
        }
        if (properties.isSet(I_a_box.getName())){
            this.I_a_value.setEnabled(true);
            this.I_a_box.setSelected(true);
        }
        if (properties.isSet(I_n_box.getName())){
            this.I_n_box.setSelected(true);
        }
        if (properties.isSet(I_v_box.getName())){
            this.I_v_box.setSelected(true);
        }
        if (properties.isSet(I_s_box.getName())){
            this.I_s_box.setSelected(true);
        }
    }
    
    /**
     * Set the configuration properties for this object
     */
    
    public void display(workflow_properties properties) {
        this.properties=properties;
        initComponents();
        setIconImage(Config.image);
        // Set position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = getSize();
        setLocation((screenSize.width-d.width)/2,
                (screenSize.height-d.height)/2);
        
        this.setProperties(properties);
        
        //Update Saved Properties uSP
        this.updateSavedProperties(properties);

        
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
    
    public void saveImage(String filename) {
        BufferedImage bi;
        try {
            bi = new Robot().createScreenCapture(this.getBounds());
            ImageIO.write(bi, "png", new File(filename));
            this.setVisible(false);
        } catch (Exception ex) {
            Config.log("Unable to save "+filename+" dialog image");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Bowtie2InspectEditor;
    private javax.swing.JButton ClosejButton6;
    private javax.swing.JRadioButton I_AO_button;
    private javax.swing.JRadioButton I_DO_button;
    private javax.swing.JPanel I_Panel;
    private javax.swing.JCheckBox I_a_box;
    private javax.swing.JSpinner I_a_value;
    private javax.swing.JCheckBox I_n_box;
    private javax.swing.JCheckBox I_s_box;
    private javax.swing.JCheckBox I_v_box;
    private javax.swing.ButtonGroup Options_Buttons;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name_jTextField1;
    private javax.swing.JButton reset_jButton3;
    private javax.swing.JButton run_jButton5;
    private javax.swing.JButton stop_jButton4;
    // End of variables declaration//GEN-END:variables
}
