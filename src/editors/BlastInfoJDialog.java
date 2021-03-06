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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BlastInfoJDialog.java
 *
 * Created on 2010-05-01, 13:00:09
 */

package editors;

import configuration.Config;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Toolkit;

/**
 *
 * @author Lorde
 */
public class BlastInfoJDialog extends javax.swing.JDialog {

    /** Creates new form BlastInfoJDialog */
    public BlastInfoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setIconImage(Config.image);
           // Set position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d = getSize();
        setLocation((screenSize.width-d.width)/2,
					(screenSize.height-d.height)/2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Blast Info");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("--Word Size--\nChoices for amino acid sequences:\n2\n3 (Default)\n\nChoices for nucleotide sequences:\n7\n11 (Default)\n15\n\nChoices when using megablast:\n11\n12\n16\n20\n24\n28 (default)\n32\n48\n64\n\n--Outfmt-\n alignment view options:\n   0 = pairwise,\n   1 = query-anchored showing identities,\n   2 = query-anchored no identities,\n   3 = flat query-anchored, show identities,\n   4 = flat query-anchored, no identities,\n   5 = XML Blast output,\n   6 = tabular,\n   7 = tabular with comment lines,\n   8 = Text ASN.1,\n   9 = Binary ASN.1\n  10 = Comma-separated values\n\n Options 6, 7, and 10 can be additionally configured to produce\n a custom format specified by space delimited format specifiers.\n The supported format specifiers are:\n          qseqid means Query Seq-id\n             qgi means Query GI\n            qacc means Query accesion\n          sseqid means Subject Seq-id\n       sallseqid means All subject Seq-id(s), separated by a ';'\n             sgi means Subject GI\n          sallgi means All subject GIs\n            sacc means Subject accession\n         sallacc means All subject accessions\n          qstart means Start of alignment in query\n            qend means End of alignment in query\n          sstart means Start of alignment in subject\n            send means End of alignment in subject\n            qseq means Aligned part of query sequence\n            sseq means Aligned part of subject sequence\n          evalue means Expect value\n        bitscore means Bit score\n           score means Raw score\n          length means Alignment length\n          pident means Percentage of identical matches\n          nident means Number of identical matches\n        mismatch means Number of mismatches\n        positive means Number of positive-scoring matches\n         gapopen means Number of gap openings\n            gaps means Total number of gaps\n            ppos means Percentage of positive-scoring matches\n          frames means Query and subject frames separated by a '/'\n          qframe means Query frame\n          sframe means Subject frame\n When not provided, the default value is:\n 'qseqid sseqid pident length mismatch gapopen qstart qend sstart send\n evalue bitscore', which is equivalent to the keyword 'std'\n Default = `0'");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BlastInfoJDialog dialog = new BlastInfoJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
