/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.gui;

import crypto.ecceg.logic.ECCEG;
import crypto.ecceg.logic.EllipticalCurve;
import crypto.ecceg.utils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Michael
 */
public class MainFrame extends javax.swing.JFrame {

    private String filePath;
    private String keyPath;
    private ArrayList<ECCEG.CipherPair> resultCipher;
    private ArrayList<ECCEG.CipherPair> cipherData;
    private ArrayList<BigInteger> decipherResult;
    private ECCEG elgamal;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        OpenFileButton = new javax.swing.JButton();
        OpenKeyButton = new javax.swing.JButton();
        EncryptButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TimeTakenLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PlaintextText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CiphertextText = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        FileSizeLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FileNameLabel = new javax.swing.JLabel();
        KeyFileLabel = new javax.swing.JLabel();
        SaveCiphertextButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        OpenFileButton1 = new javax.swing.JButton();
        OpenKeyButton1 = new javax.swing.JButton();
        DecryptButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TimeTakenLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CiphertextTextTab2 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PlaintextTextTab2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        FileSizeLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        FileNameLabel1 = new javax.swing.JLabel();
        KeyFileLabel1 = new javax.swing.JLabel();
        SavePlaintextButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        GenerateKey = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ECCEG");
        setResizable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("13512046 - 13512079");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        OpenFileButton.setText("Open File");
        OpenFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileButtonActionPerformed(evt);
            }
        });

        OpenKeyButton.setText("Open Key");
        OpenKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenKeyButtonActionPerformed(evt);
            }
        });

        EncryptButton.setText("Encrypt");
        EncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Plaintext");

        jLabel2.setText("Time Taken to Encrypt :");

        TimeTakenLabel.setText("-");

        PlaintextText.setEditable(false);
        PlaintextText.setColumns(20);
        PlaintextText.setRows(5);
        jScrollPane1.setViewportView(PlaintextText);

        jLabel3.setText("Ciphertext");

        CiphertextText.setEditable(false);
        CiphertextText.setColumns(20);
        CiphertextText.setRows(5);
        jScrollPane2.setViewportView(CiphertextText);

        jLabel4.setText("Filesize after Encrypt :");

        FileSizeLabel.setText("-");

        jLabel6.setText("File Name :");

        jLabel7.setText("Key File    :");

        FileNameLabel.setText("-");

        KeyFileLabel.setText("-");

        SaveCiphertextButton.setText("Save Ciphertext");
        SaveCiphertextButton.setEnabled(false);
        SaveCiphertextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveCiphertextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(OpenFileButton)
                                .addGap(18, 18, 18)
                                .addComponent(OpenKeyButton))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                        .addComponent(EncryptButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KeyFileLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FileNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TimeTakenLabel)
                            .addComponent(FileSizeLabel))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SaveCiphertextButton)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {EncryptButton, OpenFileButton, OpenKeyButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenFileButton)
                    .addComponent(OpenKeyButton)
                    .addComponent(EncryptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TimeTakenLabel)
                    .addComponent(jLabel6)
                    .addComponent(FileNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FileSizeLabel)
                    .addComponent(jLabel7)
                    .addComponent(KeyFileLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaveCiphertextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Encrypt", jPanel1);

        OpenFileButton1.setText("Open File");
        OpenFileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileButton1ActionPerformed(evt);
            }
        });

        OpenKeyButton1.setText("Open Key");
        OpenKeyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenKeyButton1ActionPerformed(evt);
            }
        });

        DecryptButton.setText("Decrypt");
        DecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Ciphertext");

        jLabel9.setText("Time Taken to Decrypt :");

        TimeTakenLabel1.setText("-");

        CiphertextTextTab2.setEditable(false);
        CiphertextTextTab2.setColumns(20);
        CiphertextTextTab2.setRows(5);
        jScrollPane3.setViewportView(CiphertextTextTab2);

        jLabel10.setText("Plaintext");

        PlaintextTextTab2.setEditable(false);
        PlaintextTextTab2.setColumns(20);
        PlaintextTextTab2.setRows(5);
        jScrollPane4.setViewportView(PlaintextTextTab2);

        jLabel11.setText("Filesize after Decrypt :");

        FileSizeLabel1.setText("-");

        jLabel12.setText("File Name :");

        jLabel13.setText("Key File    :");

        FileNameLabel1.setText("-");

        KeyFileLabel1.setText("-");

        SavePlaintextButton.setText("Save Plaintext");
        SavePlaintextButton.setEnabled(false);
        SavePlaintextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePlaintextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(OpenFileButton1)
                                .addGap(18, 18, 18)
                                .addComponent(OpenKeyButton1))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DecryptButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KeyFileLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FileNameLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TimeTakenLabel1)
                            .addComponent(FileSizeLabel1))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SavePlaintextButton)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenFileButton1)
                    .addComponent(OpenKeyButton1)
                    .addComponent(DecryptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TimeTakenLabel1)
                    .addComponent(jLabel12)
                    .addComponent(FileNameLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(FileSizeLabel1)
                    .addComponent(jLabel13)
                    .addComponent(KeyFileLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SavePlaintextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Decrypt", jPanel4);

        GenerateKey.setText("Generate Key");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GenerateKey)
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GenerateKey)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Generate Keys", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Encrypt");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileButtonActionPerformed

        final JFileChooser fc = new JFileChooser();
        try {
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                filePath = fc.getSelectedFile().getPath();
                
                FileNameLabel.setText(fc.getSelectedFile().getName());
                
                //Show plaintext box
                String filetype = Files.probeContentType(fc.getSelectedFile().toPath());
                if(filetype == null) {
                    filetype = "Undefined";
                }
                if(filetype.contains("text")) {
                    String plaintext = IOUtils.getStringData(filePath);
                    PlaintextText.setText(plaintext);
                } else {
                    PlaintextText.setText("Not showing non text file");
                }
                
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in loading File\nMessage:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OpenFileButtonActionPerformed

    private void OpenKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenKeyButtonActionPerformed
        // TODO add your handling code here:
        final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Key File (*.pub, *.pri)", "pub", "pri"));
        
        //try {
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                keyPath = fc.getSelectedFile().getPath();
                
                KeyFileLabel.setText(keyPath);
                
            }
        /*} catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in loading Key\nMessage:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_OpenKeyButtonActionPerformed

    private void OpenFileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileButton1ActionPerformed
        final JFileChooser fc = new JFileChooser();
        try {
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                filePath = fc.getSelectedFile().getPath();
                
                FileNameLabel1.setText(fc.getSelectedFile().getName());
                
                cipherData = IOUtils.readCipherFile(filePath);
                CiphertextTextTab2.setText(IOUtils.formattedOutput(cipherData));

            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error in loading File\nMessage:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
    }//GEN-LAST:event_OpenFileButton1ActionPerformed

    private void OpenKeyButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenKeyButton1ActionPerformed
        // Clone of OpenKeyButtonActionPerformed
        OpenKeyButtonActionPerformed(evt);
        KeyFileLabel.setText("-");
        KeyFileLabel1.setText(keyPath);
    }//GEN-LAST:event_OpenKeyButton1ActionPerformed

    private void EncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButtonActionPerformed
        // TODO add your handling code here:
        try {
        ArrayList<BigInteger> data = IOUtils.getDataArray(filePath);
        elgamal=new ECCEG(EllipticalCurve.P192.Prime);
        resultCipher = elgamal.encrypt(data);
        CiphertextText.setText(IOUtils.formattedOutput(resultCipher));
        SaveCiphertextButton.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EncryptButtonActionPerformed

    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed
        // TODO add your handling code here:
        try {
        //ECCEG elgamal=new ECCEG(EllipticalCurve.P192.Prime);
        decipherResult = elgamal.decrypt(cipherData);
        
        IOUtils.writeDataFromList("temp.txt", decipherResult);
        PlaintextTextTab2.setText(IOUtils.getStringData("temp.txt"));
        File file = new File("temp.txt");
        file.delete();
        
        SavePlaintextButton.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DecryptButtonActionPerformed

    private void SaveCiphertextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveCiphertextButtonActionPerformed
        final JFileChooser fc = new JFileChooser();
        try {
            // TODO add your handling code here:
             if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                String fileLocation = fc.getSelectedFile().getPath();
                //get data
                IOUtils.writeCipherFile(fileLocation, resultCipher);
                String filesize;
                    filesize = Long.toString(IOUtils.getFilesize(fileLocation)) + " bytes";
                    FileSizeLabel.setText(filesize);
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in saving File\nMessage:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveCiphertextButtonActionPerformed

    private void SavePlaintextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePlaintextButtonActionPerformed
        final JFileChooser fc = new JFileChooser();
        try {
            // TODO add your handling code here:
             if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                String fileLocation = fc.getSelectedFile().getPath();
                //get data
                IOUtils.writeDataFromList(fileLocation, decipherResult);
                String filesize;
                    filesize = Long.toString(IOUtils.getFilesize(fileLocation)) + " bytes";
                    FileSizeLabel1.setText(filesize);
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in saving File\nMessage:" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SavePlaintextButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CiphertextText;
    private javax.swing.JTextArea CiphertextTextTab2;
    private javax.swing.JButton DecryptButton;
    private javax.swing.JButton EncryptButton;
    private javax.swing.JLabel FileNameLabel;
    private javax.swing.JLabel FileNameLabel1;
    private javax.swing.JLabel FileSizeLabel;
    private javax.swing.JLabel FileSizeLabel1;
    private javax.swing.JButton GenerateKey;
    private javax.swing.JLabel KeyFileLabel;
    private javax.swing.JLabel KeyFileLabel1;
    private javax.swing.JButton OpenFileButton;
    private javax.swing.JButton OpenFileButton1;
    private javax.swing.JButton OpenKeyButton;
    private javax.swing.JButton OpenKeyButton1;
    private javax.swing.JTextArea PlaintextText;
    private javax.swing.JTextArea PlaintextTextTab2;
    private javax.swing.JButton SaveCiphertextButton;
    private javax.swing.JButton SavePlaintextButton;
    private javax.swing.JLabel TimeTakenLabel;
    private javax.swing.JLabel TimeTakenLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
