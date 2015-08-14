/*
 *  Armadillo Workflow Platform v2.0
 *  A simple pipeline system for phylogenetic analysis
 *  
 *  Copyright (C) 2009-2012  Etienne Lord, Mickael Leclercq
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
import program.programs;
import workflows.armadillo_workflow;
import workflows.workflow_properties_dictionnary;

/**
 * Editor of the object properties in the Main Workflow
 * Note: Only called if object doesnt have a Custum Editor
 * @author Etienne Lord
 * @since July 2009
 */
public class ranger_dtlEditor extends javax.swing.JDialog implements EditorInterface {

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

    /** Creates new form propertiesJDialog */
    public ranger_dtlEditor(java.awt.Frame parent, armadillo_workflow parent_workflow) {
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NamejTextField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        duplication_cost_TextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        mode_ComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        transfer_cost_TextField1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lost_cost_TextField2 = new javax.swing.JTextField();
        transfer_cost_mode_ComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        threshold_TextField = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        ClosejButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

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

        NamejTextField.setText(" ");

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
                .addComponent(NamejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
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

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        duplication_cost_TextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        duplication_cost_TextField.setText("2");
        duplication_cost_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                duplication_cost_TextFieldFocusLost(evt);
            }
        });

        jLabel30.setText("Duplication cost");

        mode_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Undated species (branch lengths will be ignored)", "Dated species " }));
        mode_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mode_ComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Mode");

        transfer_cost_TextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        transfer_cost_TextField1.setText("3");
        transfer_cost_TextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                transfer_cost_TextField1FocusLost(evt);
            }
        });

        jLabel31.setText("Transfer cost");

        jLabel32.setText("Loss cost");

        lost_cost_TextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lost_cost_TextField2.setText("1");
        lost_cost_TextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lost_cost_TextField2FocusLost(evt);
            }
        });

        transfer_cost_mode_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - Fixed transfer cost [default]", "1 - Simple threshold based variable transfer cost", "2 - General threshold based variable transfer cost" }));
        transfer_cost_mode_ComboBox.setEnabled(false);
        transfer_cost_mode_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfer_cost_mode_ComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Type of transfer cost to use");

        threshold_TextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        threshold_TextField.setText("1");
        threshold_TextField.setEnabled(false);
        threshold_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                threshold_TextFieldFocusLost(evt);
            }
        });

        jLabel33.setText("Threshold value");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(28, 28, 28)
                                .addComponent(threshold_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(duplication_cost_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lost_cost_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(transfer_cost_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(transfer_cost_mode_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mode_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(169, 169, 169)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(mode_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(duplication_cost_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(transfer_cost_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(lost_cost_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transfer_cost_mode_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(threshold_TextField)
                            .addComponent(jLabel33))
                        .addGap(30, 30, 30))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap())
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

        jButton6.setText("Reset default values");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, 0, 322, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(10, 10, 10)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClosejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClosejButton)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Ranger-dtl", jPanel9);

        jButton3.setText("?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClosejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosejButtonActionPerformed
        //-- 2. Close dialog
        this.setVisible(false);
}//GEN-LAST:event_ClosejButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      HelpEditor help = new HelpEditor(this.frame, false, properties);
        help.setVisible(true);
}//GEN-LAST:event_jButton3ActionPerformed

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown

}//GEN-LAST:event_jTabbedPane1ComponentShown

    private void mode_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mode_ComboBoxActionPerformed

        int index=this.mode_ComboBox.getSelectedIndex();
        properties.put("mode", index);
        if (this.mode_ComboBox.getSelectedIndex()==0) {
            this.transfer_cost_mode_ComboBox.setEnabled(false);
            this.transfer_cost_TextField1.setEnabled(false);
        } else {
            this.transfer_cost_mode_ComboBox.setEnabled(true); 
            if (this.transfer_cost_mode_ComboBox.getSelectedIndex()>0) {
                this.transfer_cost_TextField1.setEnabled(true);
            } else {
                this.transfer_cost_TextField1.setEnabled(false);
            }
        }
//        Linz = 0, hybrid = 1, exhaustive = 2, incorrect conjecture = 3
//- Conjectured uses the minimal solvable common cluster conjecture from
//  SPRIT: Identifying horizontal gene transfer in rooted phylogenetic trees.
//- Hybrid uses the minimal common cluster reduction which might be 
//  significantly quicker in some cases but does not guarantee finding the 
//  minimum rSPR distance. 
//- Exhaustive means that the whole tree is used when searching for the min rSPR.
//  This will take a long time and does not as far as we can tell produce solutions
//  better than conjectured mode
        
}//GEN-LAST:event_mode_ComboBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        properties.put("Name", this.NamejTextField.getText());
        parent_workflow.updateCurrentWorkflow(properties);
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        properties.load();             //--reload current properties from file
        this.setProperties(properties);//--Update current field
}//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        properties.put("Status", Config.status_nothing);
        properties.killThread();
}//GEN-LAST:event_jButton8ActionPerformed

    private void duplication_cost_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_duplication_cost_TextFieldFocusLost
       properties.put("duplication_cost", this.duplication_cost_TextField.getText());
    }//GEN-LAST:event_duplication_cost_TextFieldFocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if(properties.isSet("ClassName")) {
           this.parent_workflow.workflow.updateDependance();
           programs prog=new programs(parent_workflow.workbox.getCurrentWorkflows());
           prog.Run(properties);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void transfer_cost_TextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_transfer_cost_TextField1FocusLost
        properties.put("transfer_cost", this.transfer_cost_TextField1.getText());
    }//GEN-LAST:event_transfer_cost_TextField1FocusLost

    private void lost_cost_TextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lost_cost_TextField2FocusLost
        properties.put("lost_cost", this.lost_cost_TextField2.getText());
    }//GEN-LAST:event_lost_cost_TextField2FocusLost

    private void transfer_cost_mode_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfer_cost_mode_ComboBoxActionPerformed
       if (this.transfer_cost_mode_ComboBox.getSelectedIndex()!=0) {
           this.threshold_TextField.setEnabled(true);
       } else {
           this.threshold_TextField.setEnabled(false);           
       }
       properties.put("transfer_cost_mode", this.transfer_cost_mode_ComboBox.getSelectedIndex());
    }//GEN-LAST:event_transfer_cost_mode_ComboBoxActionPerformed

    private void threshold_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_threshold_TextFieldFocusLost
        properties.put("threshold", this.threshold_TextField.getText());
    }//GEN-LAST:event_threshold_TextFieldFocusLost

   
    /**
     * This set the Properties
     * @param properties
     */
    public void setProperties(workflow_properties properties) {
        this.properties=properties;
        setTitle(properties.getName());
       
        this.NamejTextField.setText(properties.getName());

        if (properties.isSet("mode")) {
           this.mode_ComboBox.setSelectedIndex(properties.getInt("mode"));
           if (properties.getInt("mode")==1) {
               this.transfer_cost_mode_ComboBox.setEnabled(true);
           } else {
               this.transfer_cost_mode_ComboBox.setEnabled(false);
           }
        } 
        
        if (properties.isSet("transfer_cost")) {
            this.transfer_cost_TextField1.setText(properties.get("transfer_cost"));
        } 
        if (properties.isSet("duplication_cost")) {
            this.duplication_cost_TextField.setText(properties.get("transfer_cost"));
        } 
        if (properties.isSet("lost_cost")) {
            this.lost_cost_TextField2.setText(properties.get("lost_cost"));
        }        
        if (properties.isSet("threshold")) {
            this.threshold_TextField.setText(properties.get("threshold"));
        } 
         if (properties.isSet("transfer_cost_mode")) {
           this.transfer_cost_mode_ComboBox.setSelectedIndex(properties.getInt("transfer_cost_mode"));
           if (properties.getInt("transfer_cost_mode")==0) {
               this.threshold_TextField.setEnabled(false);
           } else {
               this.threshold_TextField.setEnabled(true);
           }
        } 
        
        
//        if (properties.isSet("time_constraint")) {
//            if (properties.get("time_constraint").equals("weak")) {
//                this.time1_jCheckBox.setSelected(true);
//            } else {
//                this.time2_jCheckBox.setSelected(true);                                
//            }
//        } else this.time0_jCheckBox.setSelected(true);
     
    }


    ///////////////////////////////////////////////////////////////////////////
    /// DISPLAY MAIN FUNCTION

    public void display(workflow_properties properties) {
        initComponents();
        setIconImage(Config.image);
        this.setProperties(properties);
        // if (properties.isSet("Description")) this.Notice.setText(properties.get("Description"));
        // Set position 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = getSize();
        setLocation((screenSize.width-d.width)/2,
					(screenSize.height-d.height)/2);
        this.setProperties(properties);
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
    private javax.swing.JButton ClosejButton;
    private javax.swing.JTextField NamejTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField duplication_cost_TextField;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lost_cost_TextField2;
    private javax.swing.JComboBox mode_ComboBox;
    private javax.swing.JTextField threshold_TextField;
    private javax.swing.JTextField transfer_cost_TextField1;
    private javax.swing.JComboBox transfer_cost_mode_ComboBox;
    // End of variables declaration//GEN-END:variables



}