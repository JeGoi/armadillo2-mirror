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

package editors;


import workflows.workflow_properties;
import configuration.Config;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import editor.EditorInterface;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import program.*;
import workflows.armadillo_workflow;
import workflows.workflow_properties_dictionnary;

/**
 *
 * @author Etienne Lord
 * @since July 2009
 */
public class MuscleEditor extends javax.swing.JDialog implements EditorInterface {

    ////////////////////////////////////////////////////////////////////////////
    /// VARIABLES

    Config config=new Config();
    //ConnectorInfoBox connectorinfobox;
    workflow_properties_dictionnary dict=new workflow_properties_dictionnary();
    String selected="";             // Selected properties
    Frame frame;
    workflow_properties properties;
    armadillo_workflow parent_workflow;
   
    ////////////////////////////////////////////////////////////////////////////
    /// CONSTANT

    public final String defaultNameString=" Name";

    /////////////////////////////////////////////////////////////////////////
    /// Default Options
    

    /** Creates new form propertiesJDialog */
    public MuscleEditor(java.awt.Frame parent, armadillo_workflow parent_workflow) {
        super(parent, false);
        this.parent_workflow=parent_workflow;
        //--Set variables and init
        frame=parent;
        //connectorinfobox=new ConnectorInfoBox(parent); //--Used to display Connector info
        //--Initialize component
       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NamejTextField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        DiagjCheckBox = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        MaxiterjComboBox = new javax.swing.JComboBox();
        MaxHourjComboBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        MaxMbjComboBox = new javax.swing.JComboBox();
        DefaultSettingjComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ClosejButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jButton1.setText("jButton1");

        setTitle("Properties");
        setResizable(false);

        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Name");

        jButton4.setText("Rename");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NamejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(NamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setText("Maximum number of iterations (maxiters) :");
        jLabel11.setToolTipText("");

        DiagjCheckBox.setText(" Find diagonals (faster for similar sequences)");
        DiagjCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagjCheckBoxActionPerformed(evt);
            }
        });

        jLabel12.setText("Maximum hours to iterate (h):");
        jLabel12.setToolTipText("");

        MaxiterjComboBox.setEditable(true);
        MaxiterjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        MaxiterjComboBox.setSelectedIndex(1);
        MaxiterjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxiterjComboBoxActionPerformed(evt);
            }
        });

        MaxHourjComboBox.setEditable(true);
        MaxHourjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default (no limit)", "1", "2", "4", "8", "12" }));
        MaxHourjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxHourjComboBoxActionPerformed(evt);
            }
        });

        jLabel13.setText("Max memory (Mb):");
        jLabel13.setToolTipText("");

        MaxMbjComboBox.setEditable(true);
        MaxMbjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default (80% RAM)", "256", "512", "1024" }));
        MaxMbjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxMbjComboBoxActionPerformed(evt);
            }
        });

        DefaultSettingjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "Without refinement (very fast, avg accuracy similar to T-Coffee)", "Fastest possible (amino acids)", "Fastest possible (nucleotides)", "Large number of sequences/huge sequences", "Custom" }));
        DefaultSettingjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultSettingjComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Fast setting");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                    .addComponent(DiagjCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MaxiterjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MaxHourjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MaxMbjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DefaultSettingjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DefaultSettingjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(MaxiterjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaxHourjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(MaxMbjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DiagjCheckBox))
        );

        ClosejButton.setText("<html><b>Close</b></html>");
        ClosejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosejButtonActionPerformed(evt);
            }
        });

        jButton5.setText("Run");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("Stop");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("Reset default values");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClosejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, 0, 495, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClosejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Muscle", jPanel9);

        jButton6.setText("?");
        jButton6.setToolTipText("Help / Informations");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(477, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClosejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosejButtonActionPerformed
       
        this.setVisible(false);
}//GEN-LAST:event_ClosejButtonActionPerformed

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
      
}//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       properties.put("Name", this.NamejTextField.getText());
       parent_workflow.updateCurrentWorkflow(properties);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if(properties.isSet("ClassName")) {
           this.parent_workflow.workflow.updateDependance();
           programs prog=new programs(parent_workflow.workbox.getCurrentWorkflows());
           prog.Run(properties);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        properties.put("Status", Config.status_nothing);
        properties.killThread();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       HelpEditor help = new HelpEditor(this.frame, false, properties);
        help.setVisible(true);
}//GEN-LAST:event_jButton6ActionPerformed

    private void DiagjCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagjCheckBoxActionPerformed
        properties.put("diag1", this.DiagjCheckBox.isSelected());
    }//GEN-LAST:event_DiagjCheckBoxActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        properties.load();             //--reload current properties from file
        this.setProperties(properties);//--Update current field
}//GEN-LAST:event_jButton7ActionPerformed

    private void DefaultSettingjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultSettingjComboBoxActionPerformed
        int index=this.DefaultSettingjComboBox.getSelectedIndex();
        //--Remove ambigious properties
        properties.remove("distance1");
        properties.remove("sv");
        properties.put("custom", true);
        switch(index) {
            case 0: properties.remove("custom");
                    properties.remove("maxiters");
                    break;
            case 1:
                    properties.put("maxiters", 2);
                    break;
            case 2: 
                    //--muscle -in seqs.fa -out seqs.afa -maxiters 1 -diags1 -sv -distance1 kbit20_3
                    properties.put("maxiters", 1);
                    properties.put("diag1",true);
                    properties.put("sv", true);
                    properties.put("distance1", "kbit20_3");

                    break;
            case 4: 
                    //--muscle -in seqs.fa -out seqs.afa -maxiters 1 -diags1
                    properties.put("maxiters", 1);
                    properties.put("diag1",true);

                    break;
            case 5: 
                    //muscle -in seqs.fa -out seqs.afa -maxiters 1 -diags1 -sv
                    properties.put("maxiters", 1);
                    properties.put("diag1",true);
                    properties.put("sv", true);
                    break;                       
        }
         this.DiagjCheckBox.setSelected(properties.getBoolean(("diags1")));

        if (properties.isSet("maxiters")) {
            this.MaxiterjComboBox.setSelectedItem(properties.get("maxiters"));
        }

        if (properties.isSet("maxhours")) {
            this.MaxHourjComboBox.setSelectedItem(properties.get("maxhours"));
        }

        if (properties.isSet("maxmb")) {
            this.MaxMbjComboBox.setSelectedItem(properties.get("maxmb"));
        }
        this.MaxHourjComboBox.setEnabled(properties.getBoolean("custom"));
        this.MaxMbjComboBox.setEnabled(properties.getBoolean("custom"));
        this.MaxiterjComboBox.setEnabled(properties.getBoolean("custom"));
        this.DiagjCheckBox.setEnabled(properties.getBoolean("custom"));
    }//GEN-LAST:event_DefaultSettingjComboBoxActionPerformed

    private void MaxiterjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxiterjComboBoxActionPerformed
        properties.put("maxiters",(String)MaxiterjComboBox.getSelectedItem());
    }//GEN-LAST:event_MaxiterjComboBoxActionPerformed

    private void MaxHourjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxHourjComboBoxActionPerformed
        properties.put("maxhours",(String)MaxHourjComboBox.getSelectedItem());
    }//GEN-LAST:event_MaxHourjComboBoxActionPerformed

    private void MaxMbjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxMbjComboBoxActionPerformed
       properties.put("maxmb",(String)MaxMbjComboBox.getSelectedItem());
    }//GEN-LAST:event_MaxMbjComboBoxActionPerformed

    
   
    /**
     * This set the Properties
     * @param properties
     */
    public void setProperties(workflow_properties properties) {
        this.properties=properties;
        this.NamejTextField.setText(properties.getName());
        //if (properties.isSet("Description")) this.Notice.setText(properties.get("Description"));
        setTitle(properties.getName());
      
        this.DiagjCheckBox.setSelected(properties.getBoolean(("diags1")));
        
        if (properties.isSet("maxiters")) {
            this.MaxiterjComboBox.setSelectedItem(properties.get("maxiters"));
        }
        
        if (properties.isSet("maxhours")) {
            this.MaxHourjComboBox.setSelectedItem(properties.get("maxhours"));
        }

        if (properties.isSet("maxmb")) {
            this.MaxMbjComboBox.setSelectedItem(properties.get("maxmb"));
        }
        
        this.MaxHourjComboBox.setEnabled(properties.getBoolean("custom"));
        this.MaxMbjComboBox.setEnabled(properties.getBoolean("custom"));
        this.MaxiterjComboBox.setEnabled(properties.getBoolean("custom"));
        this.DiagjCheckBox.setEnabled(properties.getBoolean("custom"));
    }
      

    

    ///////////////////////////////////////////////////////////////////////////
    /// DISPLAY MAIN FUNCTION

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
    private javax.swing.JButton ClosejButton;
    private javax.swing.JComboBox DefaultSettingjComboBox;
    private javax.swing.JCheckBox DiagjCheckBox;
    private javax.swing.JComboBox MaxHourjComboBox;
    private javax.swing.JComboBox MaxMbjComboBox;
    private javax.swing.JComboBox MaxiterjComboBox;
    private javax.swing.JTextField NamejTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables



}