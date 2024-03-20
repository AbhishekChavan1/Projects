/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abhishek Chavan
 * @Date   10-March-2024
 */
public class Brands extends javax.swing.JFrame {

    /**
     * Creates new form Brands
     */
    classes.Brand brand=new classes.Brand();
    ArrayList<classes.Brand> brand_list=brand.brandslist();
    private int index;
    public Brands() {
        initComponents();
        this.setLocationRelativeTo(null);
        datatablewithbrands();
    }

    public void displayImage(int width,int height,String image_path,JLabel label){
        //get set resize images
        ImageIcon imgico=new ImageIcon(image_path);        
        Image image=imgico.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);        
        label.setIcon(new ImageIcon(image));
    }

    public void displaywithImage(int width,int height,ImageIcon flogos,JLabel label){
        try {            
            Image img = flogos.getImage(); 
            Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            flogos = new ImageIcon(resizedImg);            
            label.setIcon(flogos);                
            label.setSize(width, height);        
        } catch (Exception ex) {
            Logger.getLogger(Brands.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
   
    public String selectImage(){
        JFileChooser filechooser=new JFileChooser();
        filechooser.setDialogTitle("Select Picture");
        filechooser.setCurrentDirectory(new File("C:\\images"));
        FileNameExtensionFilter filter=new FileNameExtensionFilter("image",".png",".jpg");
        filechooser.addChoosableFileFilter(filter);
        
        int state=filechooser.showSaveDialog(null);
        String path="";        
        if(state == JFileChooser.APPROVE_OPTION){
            path=filechooser.getSelectedFile().getAbsolutePath();
        }        
        return path;
    }
    
    public void datatablewithbrands(){
        ArrayList<classes.Brand> brand_list=brand.brandslist();
        String[] columnName={"ID","Name"};
        Object[][] rows=new Object[brand_list.size()][columnName.length];
        
        for(int i=0;i<brand_list.size();i++){
            rows[i][0]=brand_list.get(i).getId();
            rows[i][1]=brand_list.get(i).getName();            
        }
        DefaultTableModel model=new DefaultTableModel(rows,columnName);
        jTable1.setModel(model);        
    }     
    
    public void displaybrand(){
        ArrayList<classes.Brand> brand_list=brand.brandslist();
        if (index >= 0 && index < brand_list.size()) {             
            classes.Brand selectbrand=brand_list.get(index);
            jspin.setValue(selectbrand.getId());
            jname.setText(selectbrand.getName());
            displaywithImage(jlogo.getWidth(),jlogo.getHeight(),selectbrand.getLogo(),jlogo);
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Index");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jspin = new javax.swing.JSpinner();
        jname = new javax.swing.JTextField();
        jlogo = new javax.swing.JLabel();
        jBrowse = new javax.swing.JButton();
        jButtonedit = new javax.swing.JButton();
        jButtonremove = new javax.swing.JButton();
        jButtonadd = new javax.swing.JButton();
        jButtonfirst = new javax.swing.JButton();
        jButtonback = new javax.swing.JButton();
        jButtonlast = new javax.swing.JButton();
        jButtonnext = new javax.swing.JButton();
        jLabelimagepath = new javax.swing.JLabel();
        jrefresh = new javax.swing.JButton();
        jclear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Brands");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Id ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Logo");

        jspin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlogo.setBackground(new java.awt.Color(102, 255, 102));
        jlogo.setForeground(new java.awt.Color(204, 255, 204));
        jlogo.setOpaque(true);

        jBrowse.setBackground(new java.awt.Color(204, 204, 204));
        jBrowse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jBrowse.setText("Browse");
        jBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseActionPerformed(evt);
            }
        });

        jButtonedit.setBackground(new java.awt.Color(204, 204, 255));
        jButtonedit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonedit.setText("Edit");
        jButtonedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneditActionPerformed(evt);
            }
        });

        jButtonremove.setBackground(new java.awt.Color(255, 102, 255));
        jButtonremove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonremove.setText("Remove");
        jButtonremove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonremoveActionPerformed(evt);
            }
        });

        jButtonadd.setBackground(new java.awt.Color(102, 255, 255));
        jButtonadd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonadd.setText("Add");
        jButtonadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddActionPerformed(evt);
            }
        });

        jButtonfirst.setBackground(new java.awt.Color(255, 51, 102));
        jButtonfirst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonfirst.setText("<<");
        jButtonfirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonfirstActionPerformed(evt);
            }
        });

        jButtonback.setBackground(new java.awt.Color(255, 153, 102));
        jButtonback.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonback.setText("<");
        jButtonback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbackActionPerformed(evt);
            }
        });

        jButtonlast.setBackground(new java.awt.Color(153, 255, 102));
        jButtonlast.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonlast.setText(">>");
        jButtonlast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlastActionPerformed(evt);
            }
        });

        jButtonnext.setBackground(new java.awt.Color(255, 255, 102));
        jButtonnext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonnext.setText(">");
        jButtonnext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonnextActionPerformed(evt);
            }
        });

        jLabelimagepath.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelimagepath.setText("###");

        jrefresh.setBackground(new java.awt.Color(255, 255, 0));
        jrefresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jrefresh.setText("Refresh");
        jrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrefreshActionPerformed(evt);
            }
        });

        jclear.setBackground(new java.awt.Color(51, 51, 255));
        jclear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jclear.setForeground(new java.awt.Color(255, 255, 255));
        jclear.setText("Clear");
        jclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jclear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jspin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jname, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jlogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabelimagepath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonremove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonedit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonfirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonnext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonlast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jspin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelimagepath, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBrowse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jclear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButtonadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonedit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonremove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonback, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonnext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonlast, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbackActionPerformed
        // TODO add your handling code here:
        index--;
        if(index<0){ index=0;}
        displaybrand();
    }//GEN-LAST:event_jButtonbackActionPerformed

    private void jButtonaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddActionPerformed
        // TODO add your brand;        
        try {
            String name=jname.getText();
            int id=(Integer) jspin.getValue();
            File flogo=new File(jLabelimagepath.getText());
            classes.Brand brandcls =new classes.Brand();
            brandcls.addBrand(id, name, flogo);            
        } catch (Exception ex) {
            Logger.getLogger(Brands.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonaddActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButtonlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlastActionPerformed
        // TODO add your handling code here:        
        index=brand_list.size()-1;
        displaybrand();
    }//GEN-LAST:event_jButtonlastActionPerformed

    private void jBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseActionPerformed
        // TODO add your handling code here:
        String imagePath= selectImage();
        displayImage(jlogo.getWidth(),jlogo.getHeight(),imagePath,jlogo);
        jLabelimagepath.setText(imagePath);
    }//GEN-LAST:event_jBrowseActionPerformed

    private void jButtoneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneditActionPerformed
        // TODO edit;
        try {
            String name=jname.getText();
            int id=(Integer) jspin.getValue();
            File flogo=new File(jLabelimagepath.getText());            
            classes.Brand brandcls =new classes.Brand();
            brandcls.editBrand(id, name, flogo);            
        } catch (Exception ex) {
            Logger.getLogger(Brands.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtoneditActionPerformed

    private void jButtonremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonremoveActionPerformed
        // TODO remove your brand;
        try {            
            int id=(Integer) jspin.getValue();  
            int confirm=JOptionPane.showConfirmDialog(null, "Are you Sure? Want to delete","Confirm",JOptionPane.YES_NO_OPTION);
            if(confirm==JOptionPane.YES_OPTION){
                classes.Brand brandcls =new classes.Brand();
                brandcls.removeBrand(id);   
            }                     
        } catch (Exception ex) {
            Logger.getLogger(Brands.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonremoveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index=jTable1.getSelectedRow();
        int id=Integer.parseInt(jTable1.getValueAt(index,0).toString());
        classes.Brand brd=brand.getBrandById(id);
        jspin.setValue(brd.getId());
        jname.setText(brd.getName());
        displaywithImage(jlogo.getWidth(),jlogo.getHeight(),brd.getLogo(),jlogo);        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrefreshActionPerformed
        // TODO add your handling code here:
        datatablewithbrands();        
    }//GEN-LAST:event_jrefreshActionPerformed

    private void jclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jclearActionPerformed
        // TODO add your handling code here:
        jspin.setValue(0);
        jname.setText("");
        jlogo.setIcon(null);
        jLabelimagepath.setText("");
    }//GEN-LAST:event_jclearActionPerformed

    private void jButtonnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonnextActionPerformed
        // TODO add your handling code here:
        index++;
        if(index>brand_list.size()-1){ index=brand_list.size()-1;}
        displaybrand();
    }//GEN-LAST:event_jButtonnextActionPerformed

    private void jButtonfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonfirstActionPerformed
        // TODO add your handling code here:
        index=0;
        displaybrand();
    }//GEN-LAST:event_jButtonfirstActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Brands().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBrowse;
    private javax.swing.JButton jButtonadd;
    private javax.swing.JButton jButtonback;
    private javax.swing.JButton jButtonedit;
    private javax.swing.JButton jButtonfirst;
    private javax.swing.JButton jButtonlast;
    private javax.swing.JButton jButtonnext;
    private javax.swing.JButton jButtonremove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelimagepath;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jclear;
    private javax.swing.JLabel jlogo;
    private javax.swing.JTextField jname;
    private javax.swing.JButton jrefresh;
    private javax.swing.JSpinner jspin;
    // End of variables declaration//GEN-END:variables
}