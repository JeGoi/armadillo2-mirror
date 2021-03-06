package program;

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




import configuration.Config;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import workflows.workflow_properties;

/**
 * RenameComboBox for propertiesName
 * Note: return the propertiesName, it will be empty if cancelled
 *
 * @author Etienne Lord
 * @since July 2009
 */
public class UseAlternativeExecutableJDialog extends javax.swing.JDialog {

    ////////////////////////////////////////////////////////////////////////////
    /// Variables
   
    public String AlternativeExecutableName="";        //New properties filename
    Config config=new Config();             //Configuration file
    Frame frame;                            //parent frame
    private workflow_properties properties=null;
    
    ////////////////////////////////////////////////////////////////////////////
    /// Constructor
   
    public UseAlternativeExecutableJDialog(java.awt.Frame parent, workflow_properties properties) {
        super(parent, true);
        this.properties=properties;
        
        this.frame=parent;
        initComponents();
        setIconImage(Config.image);    
        this.setTitle("Use Alternative Executable");
        MessageErreur("Note: This program will use the alternative executable...","");
        if (properties.isSet("Alternative")) {
            this.executable_jTextField.setText(properties.getExecutable());
        }
        
        Message("","");
        // Set position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = getSize();
        setLocation((screenSize.width-d.width)/2,
					(screenSize.height-d.height)/2);
        setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CanceljButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        executable_jTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CanceljButton = new javax.swing.JButton();
        RenamejButton = new javax.swing.JButton();
        jStatusMessage = new javax.swing.JLabel();
        LocateWindowsjButton = new javax.swing.JButton();
        OS_jComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        DefaultjButton = new javax.swing.JButton();

        CanceljButton1.setText("Cancel");
        CanceljButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanceljButton1ActionPerformed(evt);
            }
        });

        setTitle("Rename properties");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        executable_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                executable_jTextFieldKeyPressed(evt);
            }
        });

        jLabel1.setText("<html>Alternative executable (Note: This is valid only for this workflow instance)</html>");

        CanceljButton.setText("Cancel");
        CanceljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanceljButtonActionPerformed(evt);
            }
        });

        RenamejButton.setText("<html><b>Use Alternative</b/</html>");
        RenamejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenamejButtonActionPerformed(evt);
            }
        });

        jStatusMessage.setForeground(new java.awt.Color(51, 51, 255));
        jStatusMessage.setText("Info");

        LocateWindowsjButton.setText("Locate");
        LocateWindowsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocateWindowsjButtonActionPerformed(evt);
            }
        });

        OS_jComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Windows", "MacOSX", "Linux" }));
        OS_jComboBox.setToolTipText("Choose the Operating System (OS) . This will change how the application is executed on the command-line.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("OS");

        DefaultjButton.setText("Revert to default");
        DefaultjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(290, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jStatusMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(DefaultjButton))
                            .addComponent(executable_jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocateWindowsjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CanceljButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RenamejButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OS_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(executable_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OS_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(LocateWindowsjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStatusMessage)
                    .addComponent(DefaultjButton)
                    .addComponent(RenamejButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CanceljButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CanceljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanceljButtonActionPerformed
      
        this.setVisible(false);
    }//GEN-LAST:event_CanceljButtonActionPerformed

    private void RenamejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenamejButtonActionPerformed
        setAlternativeExecutableProperties();
}//GEN-LAST:event_RenamejButtonActionPerformed

    private void executable_jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_executable_jTextFieldKeyPressed
       
    }//GEN-LAST:event_executable_jTextFieldKeyPressed

    private void LocateWindowsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocateWindowsjButtonActionPerformed
        JFileChooser jf=new JFileChooser("executable"+File.separator);
        //jf.addChoosableFileFilter(new ProgramsFilter());
        jf.setAcceptAllFileFilterUsed(false);
        jf.setName("Locate program Executable ...");
        int result=jf.showOpenDialog(this);
        if (result==JFileChooser.APPROVE_OPTION) {            
            String path=jf.getSelectedFile().getAbsolutePath();                    
            properties.setExecutable(path);
            this.executable_jTextField.setText(path);            
        }
}//GEN-LAST:event_LocateWindowsjButtonActionPerformed

    private void CanceljButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanceljButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CanceljButton1ActionPerformed

    private void DefaultjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultjButtonActionPerformed
        properties.remove("UseAlternative");                        
    }//GEN-LAST:event_DefaultjButtonActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /// Rename

    private void setAlternativeExecutableProperties() {
        AlternativeExecutableName=executable_jTextField.getText();
        File file=new File(AlternativeExecutableName);
        System.out.println(file.getName());
//        if (file.exists()) {
//            MessageErreur("Warning, alternative executable was not found!","");
//            System.out.println(AlternativeExecutableName);
//            return;
//        }
        properties.setAlternative(AlternativeExecutableName);
        properties.put("UseAlternative", true); 
        properties.put("AlternativeExecutableOS", this.OS_jComboBox);       
        //--End dialog
         this.setVisible(false);
    }

    ///////////////////////////////////////////////////////////////////////////
    /// MESSAGE FONCTION

    /**
     * Affiche un message dans la status bar
     * La provenance peut être mise dans un tooltip
     * @param text Le texte
     * @param tooltip Le tooltip texte
     */
    void Message(String text, String tooltip) {
        this.jStatusMessage.setEnabled(true);
        this.jStatusMessage.setForeground(new java.awt.Color(0, 51, 153));
        this.jStatusMessage.setBackground(Color.WHITE);
        this.jStatusMessage.setToolTipText(tooltip);
        this.jStatusMessage.setText(text);
    }

    /**
     * Affiche un message d'erreur en rouge dans la status bar
     * La provenance peut être mise dans un tooltip
     * @param text Le texte
     * @param tooltip Le tooltip texte
     */
    void MessageErreur(String text, String tooltip) {
        this.jStatusMessage.setEnabled(true);
        this.jStatusMessage.setForeground(Color.RED);
        this.jStatusMessage.setBackground(Color.WHITE);
        this.jStatusMessage.setToolTipText(tooltip);
        this.jStatusMessage.setText(text);
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CanceljButton;
    private javax.swing.JButton CanceljButton1;
    private javax.swing.JButton DefaultjButton;
    private javax.swing.JButton LocateWindowsjButton;
    private javax.swing.JComboBox OS_jComboBox;
    private javax.swing.JButton RenamejButton;
    private javax.swing.JTextField executable_jTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jStatusMessage;
    // End of variables declaration//GEN-END:variables

}
