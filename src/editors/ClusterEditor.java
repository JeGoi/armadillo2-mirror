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


import editor.DatabaseSQLite3_cellRenderer;
import workflows.workflow_properties;
import configuration.Config;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.File;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import editor.ConnectorInfoBox;
import editor.EditorInterface;
import javax.swing.DefaultComboBoxModel;
import program.*;
import workflows.Workbox;
import workflows.armadillo_workflow;
import workflows.armadillo_workflow.Workflow;
import workflows.workflow_properties_dictionnary;

/**
 * Editor of the object properties in the Main Workflow
 * Note: Only called if object doesnt have a Custum Editor
 * @author JG
 * @since Feb 2016
 */
public class ClusterEditor extends javax.swing.JDialog implements EditorInterface {
    
    ////////////////////////////////////////////////////////////////////////////
    /// VARIABLES
    
    Config config=new Config();
    //ConnectorInfoBox connectorinfobox;
    workflow_properties_dictionnary dict=new workflow_properties_dictionnary();
    String selected="";             // Selected properties
    Frame frame;
    workflow_properties properties=new workflow_properties();
    armadillo_workflow parent_workflow;
    
    
    
    /** Creates new form propertiesJDialog */
    public ClusterEditor(java.awt.Frame parent, armadillo_workflow parent_workflow) {
        super(parent, false);
        this.parent_workflow=parent_workflow;
        frame=parent;
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ClusterName = new javax.swing.JTextField();
        ClusterUserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ClusterGroupName = new javax.swing.JTextField();
        ClusterAccess = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ClusterNames2_list = new javax.swing.JComboBox();
        clusterEnabled = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        ClosejButton = new javax.swing.JButton();
        ClusterInfosUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Properties");

        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("Clusters name");

        jLabel6.setText("Selected cluster");

        ClusterName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ClusterName.setText("clustername");
        ClusterName.setName("ClusterName"); // NOI18N
        ClusterName.setPreferredSize(new java.awt.Dimension(197, 27));
        ClusterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClusterNameActionPerformed(evt);
            }
        });

        ClusterUserName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ClusterUserName.setText("user name");
        ClusterUserName.setName("ClusterUserName"); // NOI18N
        ClusterUserName.setPreferredSize(new java.awt.Dimension(197, 27));
        ClusterUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ClusterUserNameFocusLost(evt);
            }
        });

        jLabel7.setText("User Name");

        jLabel8.setText("Group Name");

        ClusterGroupName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ClusterGroupName.setText("group name");
        ClusterGroupName.setName("ClusterGroupName"); // NOI18N
        ClusterGroupName.setPreferredSize(new java.awt.Dimension(197, 27));
        ClusterGroupName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ClusterGroupNameFocusLost(evt);
            }
        });

        ClusterAccess.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ClusterAccess.setText("username@(groupName)clustername");
        ClusterAccess.setMinimumSize(new java.awt.Dimension(276, 27));
        ClusterAccess.setName("ClusterAccess"); // NOI18N
        ClusterAccess.setPreferredSize(new java.awt.Dimension(276, 27));
        ClusterAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClusterAccessActionPerformed(evt);
            }
        });

        jLabel9.setText("Used");

        ClusterNames2_list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Briaree_nom@briaree.calculquebec.ca", "Colosse_nom@colosse.calculquebec.ca", "Cottos_nom@cottos.calculquebec.ca", "Guillimin_nom@guillimin.hpc.mcgill.ca", "Mp2_nom@<nom du groupe>-mp2.ccs.usherbrooke.ca", "Ms2_nom@<nom du groupe>-ms.ccs.usherbrooke.ca", "Psi_nom@psi.concordia.ca" }));
        ClusterNames2_list.setMinimumSize(new java.awt.Dimension(319, 27));
        ClusterNames2_list.setName("ClusterNames2_list"); // NOI18N
        ClusterNames2_list.setPreferredSize(new java.awt.Dimension(319, 27));
        ClusterNames2_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClusterNames2_listActionPerformed(evt);
            }
        });

        clusterEnabled.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        clusterEnabled.setText("Cluster is enabled");
        clusterEnabled.setEnabled(false);
        clusterEnabled.setName("clusterEnabled"); // NOI18N

        jTextField1.setText("insert@your.email.com");
        jTextField1.setPreferredSize(new java.awt.Dimension(217, 27));

        jLabel1.setText("Email");

        jLabel2.setText("Rap ID");

        jTextField2.setText("insert your RapID");
        jTextField2.setPreferredSize(new java.awt.Dimension(217, 27));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(8, 8, 8)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ClusterGroupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ClusterUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ClusterName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ClusterAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(ClusterNames2_list, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(clusterEnabled)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clusterEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClusterNames2_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClusterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClusterUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClusterGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClusterAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        ClosejButton.setText("<html><b>Close</b></html>");
        ClosejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosejButtonActionPerformed(evt);
            }
        });

        ClusterInfosUpdate.setText("Update Selected Cluster");
        ClusterInfosUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClusterInfosUpdateActionPerformed(evt);
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(ClusterInfosUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClosejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClosejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClusterInfosUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cluster Access Options", jPanel9);

        jButton3.setText("?");
        jButton3.setToolTipText("Help / Informations");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void ClosejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosejButtonActionPerformed
        //-- 1. Did we change the properties? If, yes ask for direction
        //properties.save();
        //-- 2. Close dialog
        this.setVisible(false);
}//GEN-LAST:event_ClosejButtonActionPerformed
    
    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        
}//GEN-LAST:event_jTabbedPane1ComponentShown
                    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        HelpEditor help = new HelpEditor(this.frame, false, properties);
        help.setVisible(true);
}//GEN-LAST:event_jButton3ActionPerformed
        
    private void ClusterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClusterNameActionPerformed
        
    }//GEN-LAST:event_ClusterNameActionPerformed
    
    private void ClusterUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ClusterUserNameFocusLost
        updateName();
        updateValues();
    }//GEN-LAST:event_ClusterUserNameFocusLost
    
    private void ClusterGroupNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ClusterGroupNameFocusLost
        updateGroup();
        updateValues();
    }//GEN-LAST:event_ClusterGroupNameFocusLost
    
    private void ClusterAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClusterAccessActionPerformed
        
    }//GEN-LAST:event_ClusterAccessActionPerformed
    
    private void ClusterInfosUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClusterInfosUpdateActionPerformed
        updateValues();
    }//GEN-LAST:event_ClusterInfosUpdateActionPerformed

    private void ClusterNames2_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClusterNames2_listActionPerformed
        // TODO add your handling code here:
        updateValues();
    }//GEN-LAST:event_ClusterNames2_listActionPerformed
    
    /**
     * General Update
     */
    private void updateValues() {
        ClusterAccess.setEnabled(false);
        ClusterName.setEnabled(false);
        
        int i = this.ClusterNames2_list.getSelectedIndex();
        String s   = (String)this.ClusterNames2_list.getModel().getElementAt(i).toString();
        properties.put("ClusterAllName",s);
        properties.put(ClusterNames2_list.getName(),i);
        if (s.matches("^Mp2.*")||s.matches("^Ms2.*")){
            s = s.replaceAll("\\<nom du groupe\\>","");
            ClusterGroupName.setEnabled(true);
        } else {
            ClusterGroupName.setEnabled(false);
        }
        s = s.replaceAll("^\\w*_nom@","");
        properties.put(ClusterName.getName(),s);
        ClusterName.setText(s);
        ClusterUserName.setEnabled(true);
        updateName();
        updateGroup();
        updateAccess();
        updateEnabled();
    }
    /**
     * Name Update
     */
    private void updateName() {
        String s = ClusterUserName.getText();
        if (s.equals("")||!(properties.isSet(ClusterUserName.getName()))){
            properties.put(ClusterUserName.getName(),"Add a name");
            ClusterUserName.setText("Add a name");
        } else {
            properties.put(ClusterUserName.getName(),s);
            ClusterUserName.setText(s);
        }
    }
    /**
     * Group Update
     */
    private void updateGroup() {
        String s = ClusterGroupName.getText();
        if (s.equals("")||!(properties.isSet(ClusterGroupName.getName()))){
            properties.put(ClusterGroupName.getName(),"Add a group");
            ClusterGroupName.setText("Add a group");
        } else {
            properties.put(ClusterGroupName.getName(),s);
            ClusterGroupName.setText(s);
        }
    }
    /**
     * Access Update
     */
    private void updateAccess() {
        if (properties.isSet("ClusterAllName")) {
            String s       = properties.get("ClusterAllName");
            String group   = "";
            String name    = properties.get(ClusterUserName.getName());
            String cluster = properties.get(ClusterName.getName());
            if (s.matches("^Mp2.*")||s.matches("^Ms2.*"))
                group = properties.get(ClusterGroupName.getName());
            String access  = name+"@"+group+cluster;
            ClusterAccess.setText(access);
            properties.put(ClusterAccess.getName(),access);
            properties.put("Description",access);
        }
    }
    
    /**
     * Access Update
     */
    public void updateEnabled(){
        Workbox workbox = parent_workflow.getWorkbox();
        workflow_properties selection = workbox.getWorkFlowJInternalFrame().getProperties();
        selection.put("ClusterAccessAddress",properties.get("Description"));
        boolean b = workbox.isWorkboxATest();
        if (b) {
            clusterEnabled.setSelected(true);
            properties.put(clusterEnabled.getName(),true);
        } else {
            clusterEnabled.setSelected(false);
            properties.remove(clusterEnabled.getName());
        }
    }
    
    /**
     * Load Saved Values
     */
    public void loadSavedValues(workflow_properties properties) {
        ClusterAccess.setEnabled(false);
        ClusterName.setEnabled(false);
        ClusterUserName.setEnabled(false);
        ClusterGroupName.setEnabled(false);
        if (properties.isSet("ClusterAllName")) {
            String s = properties.get("ClusterAllName");
            if (properties.isSet(ClusterName.getName())){
                String s2 = properties.get(ClusterName.getName());
                ClusterName.setText(s2);
            }
            if (properties.isSet(ClusterUserName.getName())){
                String s2 = properties.get(ClusterUserName.getName());
                ClusterUserName.setText(s2);
                ClusterUserName.setEnabled(true);
            }
            if (properties.isSet(ClusterGroupName.getName())){
                String s2 = properties.get(ClusterGroupName.getName());
                ClusterGroupName.setText(s2);
            }
            if (s.matches("^Mp2.*")||s.matches("^Ms2.*")){
                ClusterGroupName.setEnabled(true);
            }
            if (properties.isSet(ClusterNames2_list.getName())){
                int i = Integer.parseInt(properties.get(ClusterNames2_list.getName()));
                ClusterNames2_list.setSelectedIndex(i);
            }
            if (properties.isSet(ClusterAccess.getName())){
                String s2 = properties.get(ClusterAccess.getName());
                ClusterAccess.setText(s2);
            }
            if (properties.isSet(clusterEnabled.getName())){
                clusterEnabled.setSelected(true);
            } else {
                clusterEnabled.setSelected(false);
            }
        } else {
            ClusterNames2_list.setSelectedIndex(0);
            properties.put(ClusterNames2_list.getName(),0);
            ClusterName.setText("Select a cluster");
            ClusterUserName.setText("Add user name");
            ClusterGroupName.setText("Add group name");
            clusterEnabled.setSelected(false);
        }
        updateEnabled();
    }
    
    /**
     * This set the Properties
     * @param properties
     */
    public void setProperties(workflow_properties properties) {
        this.properties=properties;
        setTitle(properties.getName());
//        if (properties.isSet("Description")) this.ClusterAccess.setText(properties.get("Description"));
        loadSavedValues(properties);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    /// DISPLAY MAIN FUNCTION
    
    public void display(workflow_properties properties) {
        initComponents();
        setProperties(properties);
        // Set position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = getSize();
        setLocation((screenSize.width-d.width)/2,
                (screenSize.height-d.height)/2);
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
    private javax.swing.JTextField ClusterAccess;
    private javax.swing.JTextField ClusterGroupName;
    private javax.swing.JButton ClusterInfosUpdate;
    private javax.swing.JTextField ClusterName;
    private javax.swing.JComboBox ClusterNames2_list;
    private javax.swing.JTextField ClusterUserName;
    private javax.swing.JCheckBox clusterEnabled;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
