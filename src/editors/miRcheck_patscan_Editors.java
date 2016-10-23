/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package editors;

import configuration.Config;
import editor.EditorInterface;
import configuration.Util;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import program.*;
import workflows.armadillo_workflow;
import workflows.workflow_properties;
import workflows.workflow_properties_dictionnary;

/**
 *
 * @author Jérémy Goimard
 * 
 */
public class miRcheck_patscan_Editors extends javax.swing.JDialog implements EditorInterface  {
    
    /**
     * Creates new form miRchekEditors
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
    
    public miRcheck_patscan_Editors(java.awt.Frame parent, armadillo_workflow parent_workflow) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        miRcheck = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        name_jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Options_panel = new javax.swing.JTabbedPane();
        Patscan_panel = new javax.swing.JPanel();
        P_mismatches_value = new javax.swing.JSpinner();
        P_deletions_value = new javax.swing.JSpinner();
        P_insertions_value = new javax.swing.JSpinner();
        P_mismatches_box = new javax.swing.JCheckBox();
        P_deletions_box = new javax.swing.JCheckBox();
        P_insertions_box = new javax.swing.JCheckBox();
        reset_jButton3 = new javax.swing.JButton();
        stop_jButton4 = new javax.swing.JButton();
        run_jButton5 = new javax.swing.JButton();
        ClosejButton6 = new javax.swing.JButton();
        default_options_jbutton = new javax.swing.JRadioButton();
        advanced_options_jbutton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        miRcheck.setPreferredSize(new java.awt.Dimension(405, 604));
        miRcheck.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                miRcheckComponentShown(evt);
            }
        });

        jButton2.setText("Rename");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        name_jTextField1.setText("miRcheck");

        jLabel1.setText("Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(name_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(name_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setPreferredSize(new java.awt.Dimension(381, 474));

        Options_panel.setPreferredSize(new java.awt.Dimension(341, 413));

        P_mismatches_value.setModel(new javax.swing.SpinnerNumberModel(-1, -1, null, 1));
        P_mismatches_value.setName("P_mismatches_value"); // NOI18N
        P_mismatches_value.setPreferredSize(new java.awt.Dimension(118, 28));
        P_mismatches_value.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                P_mismatches_valueStateChanged(evt);
            }
        });

        P_deletions_value.setModel(new javax.swing.SpinnerNumberModel(-1, -1, null, 1));
        P_deletions_value.setName("P_deletions_value"); // NOI18N
        P_deletions_value.setPreferredSize(new java.awt.Dimension(118, 28));
        P_deletions_value.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                P_deletions_valueStateChanged(evt);
            }
        });

        P_insertions_value.setModel(new javax.swing.SpinnerNumberModel(-1, -1, null, 1));
        P_insertions_value.setName("P_insertions_value"); // NOI18N
        P_insertions_value.setPreferredSize(new java.awt.Dimension(118, 28));
        P_insertions_value.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                P_insertions_valueStateChanged(evt);
            }
        });

        P_mismatches_box.setText("mismatches");
        P_mismatches_box.setName("P_mismatches_box"); // NOI18N

        P_deletions_box.setText("deletions");
        P_deletions_box.setName("P_deletions_box"); // NOI18N
        P_deletions_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_deletions_boxActionPerformed(evt);
            }
        });

        P_insertions_box.setText("insertions");
        P_insertions_box.setName("P_insertions_box"); // NOI18N
        P_insertions_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_insertions_boxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Patscan_panelLayout = new javax.swing.GroupLayout(Patscan_panel);
        Patscan_panel.setLayout(Patscan_panelLayout);
        Patscan_panelLayout.setHorizontalGroup(
            Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Patscan_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P_mismatches_box)
                    .addComponent(P_deletions_box)
                    .addComponent(P_insertions_box))
                .addGap(18, 18, 18)
                .addGroup(Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P_insertions_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_deletions_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_mismatches_value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        Patscan_panelLayout.setVerticalGroup(
            Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Patscan_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P_mismatches_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_mismatches_box))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P_deletions_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_deletions_box))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Patscan_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P_insertions_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_insertions_box))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Options_panel.addTab("advanced options", Patscan_panel);

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

        default_options_jbutton.setText("default options");
        default_options_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                default_options_jbuttonActionPerformed(evt);
            }
        });

        advanced_options_jbutton.setText("advanced options");
        advanced_options_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advanced_options_jbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(default_options_jbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(advanced_options_jbutton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(reset_jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stop_jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(run_jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClosejButton6))
                    .addComponent(Options_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(default_options_jbutton)
                    .addComponent(advanced_options_jbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Options_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_jButton3)
                    .addComponent(stop_jButton4)
                    .addComponent(run_jButton5)
                    .addComponent(ClosejButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        miRcheck.addTab("miRcheck", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addComponent(miRcheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(miRcheck, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void miRcheckComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_miRcheckComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_miRcheckComponentShown

    private void ClosejButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosejButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_ClosejButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HelpEditor help = new HelpEditor(this.frame, false, properties);
        help.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reset_jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_jButton3ActionPerformed
        // TODO add your handling code here:
        properties.load();             //--reload current properties from file
        this.setProperties(properties);//--Update current field
    }//GEN-LAST:event_reset_jButton3ActionPerformed

    private void stop_jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_jButton4ActionPerformed
        // TODO add your handling code here:
        properties.put("Status", Config.status_nothing);
        properties.killThread();
    }//GEN-LAST:event_stop_jButton4ActionPerformed

    private void run_jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run_jButton5ActionPerformed
        // TODO add your handling code here:
        if(properties.isSet("ClassName")) {
            this.parent_workflow.workflow.updateDependance();
            programs prog=new programs(parent_workflow.workbox.getCurrentWorkflows());
            prog.Run(properties);
        }
    }//GEN-LAST:event_run_jButton5ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        properties.put("Name", this.name_jTextField1.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void P_mismatches_valueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_P_mismatches_valueStateChanged
        // TODO add your handling code here:
        Util.boxEventSpinner(properties,P_mismatches_box,P_mismatches_value);
    }//GEN-LAST:event_P_mismatches_valueStateChanged

    private void P_deletions_valueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_P_deletions_valueStateChanged
        // TODO add your handling code here:
        Util.boxEventSpinner(properties,P_deletions_box,P_deletions_value);
    }//GEN-LAST:event_P_deletions_valueStateChanged

    private void P_insertions_valueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_P_insertions_valueStateChanged
        // TODO add your handling code here:
        Util.boxEventSpinner(properties,P_insertions_box,P_insertions_value);
    }//GEN-LAST:event_P_insertions_valueStateChanged

    private void P_insertions_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_insertions_boxActionPerformed
        // TODO add your handling code here:
        Util.boxEventSpinner(properties,P_insertions_box,P_insertions_value);
    }//GEN-LAST:event_P_insertions_boxActionPerformed
 
    private void P_deletions_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_deletions_boxActionPerformed
        // TODO add your handling code here:
        Util.boxEventSpinner(properties,P_deletions_box,P_deletions_value);
    }//GEN-LAST:event_P_deletions_boxActionPerformed

    private void advanced_options_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advanced_options_jbuttonActionPerformed
        // TODO add your handling code here:
        Util.buttonEventSpinner(properties,advanced_options_jbutton,null);
        if (properties.isSet(default_options_jbutton.getName())) {
            properties.remove(default_options_jbutton.getName());
        }
        menuFields(properties);
    }//GEN-LAST:event_advanced_options_jbuttonActionPerformed

    private void default_options_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_default_options_jbuttonActionPerformed
        // TODO add your handling code here:
        Util.buttonEventSpinner(properties,default_options_jbutton,null);
        if (properties.isSet(advanced_options_jbutton.getName())) {
            properties.remove(advanced_options_jbutton.getName());
        }
        menuFields(properties);
    }//GEN-LAST:event_default_options_jbuttonActionPerformed
    
    /**
    ***************************************************************************
    * Set Properties
    ***************************************************************************
    */
    public void setProperties(workflow_properties properties) {
        this.properties=properties;
        setTitle(properties.getName());
        //if (properties.isSet("Description")) this.Notice.setText(properties.get("Description"));
        
        // Properties Default Options
        this.defaultPgrmValues(properties);
    }
    
    public void setProperties(String filename, String path) {
        workflow_properties tmp=new workflow_properties();
        tmp.load(filename, path);
        this.properties=tmp;
        setTitle(properties.getName());
    }
    
    /*******************************************************************
    * Update Saved Properties => usp_functions
    *******************************************************************/
    
    private void updateSavedProperties(workflow_properties properties) {
        usp_valueANDtext (properties);
        usp_boxANDbutton (properties);
    }
    
    private void usp_valueANDtext (workflow_properties properties) {
        if (this.properties.isSet(P_deletions_value.getName())){
            this.P_deletions_value.setValue(Integer.parseInt(this.properties.get(P_deletions_value.getName())));
            this.P_deletions_value.setVisible(false);
        }
        if (this.properties.isSet(P_insertions_value.getName())){
            this.P_insertions_value.setValue(Integer.parseInt(this.properties.get(P_insertions_value.getName())));
            this.P_insertions_value.setVisible(false);
        }
        if (this.properties.isSet(P_mismatches_value.getName())){
            this.P_mismatches_value.setValue(Integer.parseInt(this.properties.get(P_mismatches_value.getName())));
            this.P_mismatches_value.setVisible(false);
        }
    }
    
    private void usp_boxANDbutton (workflow_properties properties) {
        if (this.properties.isSet(P_deletions_box.getName())){
            this.P_deletions_box.setSelected(true);
            this.P_deletions_value.setEnabled(true);
        }
        if (this.properties.isSet(P_insertions_box.getName())){
            this.P_insertions_box.setSelected(true);
            this.P_insertions_value.setEnabled(true);
        }
        if (this.properties.isSet(P_mismatches_box.getName())){
            this.P_mismatches_box.setSelected(true);
            this.P_mismatches_value.setEnabled(true);
        }
        
    }
    
    /*******************************************************************
     * Set Menu fields
     ******************************************************************/
    
    private void menuFields(workflow_properties properties) {
        if (properties.isSet(default_options_jbutton.getName())) {
            enabled_Advanced_Options (false);
        }
        else if (properties.isSet(advanced_options_jbutton.getName())) {
            enabled_Advanced_Options (true);
        }
    }

    /*******************************************************************
    * Enabled Function
    *******************************************************************/
    
    private void enabled_Advanced_Options (boolean e) {
        
        this.P_deletions_box.setEnabled(e);
        if (properties.isSet(P_deletions_box.getName()) && e==true) {
            this.P_deletions_value.setEnabled(true);
        } else {
            properties.remove(P_deletions_box.getName());
            this.P_deletions_value.setEnabled(false);
        }

        this.P_insertions_box.setEnabled(e);
        if (properties.isSet(P_insertions_box.getName()) && e==true) {
            this.P_insertions_value.setEnabled(true);
        } else {
            properties.remove(P_insertions_box.getName());
            this.P_insertions_value.setEnabled(false);
        }
        
        this.P_mismatches_box.setEnabled(e);
        if (properties.isSet(P_mismatches_box.getName()) && e==true) {
            this.P_mismatches_value.setEnabled(true);
        } else {
            properties.remove(P_mismatches_box.getName());
            this.P_mismatches_value.setEnabled(false);
        }

    }
    
    /*******************************************************************
     * Set With default program values present in properties file
     ******************************************************************/
    private void defaultPgrmValues(workflow_properties properties) {
        boolean b = true;
        if (!(properties.isSet(default_options_jbutton.getName()))
        && !(properties.isSet(advanced_options_jbutton.getName()))
        ) {
            Util.buttonEventSpinner(properties,default_options_jbutton,null);
            default_options_jbutton.setSelected(true);
            b = false;
        }
        
        Util.getDefaultPgrmValues(properties,b);
    }
    
    /**
     * Set the configuration properties for this object
     */
    
    
    
    @Override
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
        this.updateSavedProperties(properties);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
    
    @Override
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
    private javax.swing.JButton ClosejButton6;
    private javax.swing.JTabbedPane Options_panel;
    private javax.swing.JCheckBox P_deletions_box;
    private javax.swing.JSpinner P_deletions_value;
    private javax.swing.JCheckBox P_insertions_box;
    private javax.swing.JSpinner P_insertions_value;
    private javax.swing.JCheckBox P_mismatches_box;
    private javax.swing.JSpinner P_mismatches_value;
    private javax.swing.JPanel Patscan_panel;
    private javax.swing.JRadioButton advanced_options_jbutton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton default_options_jbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane miRcheck;
    private javax.swing.JTextField name_jTextField1;
    private javax.swing.JButton reset_jButton3;
    private javax.swing.JButton run_jButton5;
    private javax.swing.JButton stop_jButton4;
    // End of variables declaration//GEN-END:variables
}
