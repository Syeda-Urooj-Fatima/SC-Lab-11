/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Syeda Urooj Fatima
 */
public class carInfo extends javax.swing.JFrame {
    private static SessionFactory factory; 
    private String user = "";
    private String option = "";
    private String id = "";
    private String filename="";
    private boolean img_update = false;
    /**
     * Creates new form carInfo
     */
    public carInfo() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }
    }
    
    public carInfo(String user, String option){
        this();
        this.user = user;
        this.option=option;
        lblUser.setText("User : "+user);
        lblTitle.setText("Add Car Record");
        btnSave.setText(option+" Record");
    }
    
    public carInfo(String user, String option, String id){
        this();
        this.user = user;
        this.option=option;
        this.id = id;
        lblUser.setText("User : "+user);
        lblTitle.setText("Update Car Record");
        btnSave.setText(option+" Record");
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            //String hql = "FROM carrental.Cars AS C WHERE C.registrationNo = :car_id";
            Cars car = (Cars)session.get(Cars.class, id); 
            txtReg.setText(car.getRegistrationNo());
            txtReg.setEditable(false);
            txtMake.setText(car.getMake());
            txtModel.setText(car.getModel());
            txtRent.setText(Integer.toString(car.getRentRate()));

            byte[] img = car.getImage(); 
            if(img==null)
            {
                lblCar.setText("No Image");
            }
            else
            {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblCar.getWidth(), lblCar.getHeight(), Image.SCALE_DEFAULT));
                lblCar.setIcon(imageIcon);
            }
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
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
        lblCompany = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblReg = new javax.swing.JLabel();
        lblMake = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblRent = new javax.swing.JLabel();
        txtReg = new javax.swing.JTextField();
        txtMake = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        txtRent = new javax.swing.JTextField();
        btnCarPic = new javax.swing.JButton();
        lblCar = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 172, 224));

        lblCompany.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        lblCompany.setForeground(java.awt.Color.white);
        lblCompany.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompany.setText("CarGo");

        lblUser.setBackground(java.awt.Color.white);
        lblUser.setFont(new java.awt.Font("Monotype Corsiva", 1, 15)); // NOI18N
        lblUser.setForeground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblReg.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblReg.setText("Registration number :");

        lblMake.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblMake.setText("Make :");

        lblModel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblModel.setText("Model :");

        lblRent.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblRent.setText("Rent rate: ");

        txtReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegActionPerformed(evt);
            }
        });

        btnCarPic.setText("Upload Car Image");
        btnCarPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarPicActionPerformed(evt);
            }
        });

        lblCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/Save-icon.png"))); // NOI18N
        btnSave.setText("Save Record");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(52, 172, 224));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrental/images/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCarPic)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMake)
                            .addComponent(lblReg, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblModel)
                            .addComponent(lblRent))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtReg)
                            .addComponent(txtMake)
                            .addComponent(txtModel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(lblCar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(10, 10, 10)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReg)
                            .addComponent(txtReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMake)
                            .addComponent(txtMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModel)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRent)
                            .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnCarPic)
                .addGap(57, 57, 57)
                .addComponent(btnSave)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarPicActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            filename =f.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblCar.getWidth(), lblCar.getHeight(), Image.SCALE_DEFAULT));
            lblCar.setIcon(imageIcon);
            img_update=true;
        } 
        
    }//GEN-LAST:event_btnCarPicActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int p;
        if(option.equals("Add"))
        {
            p = JOptionPane.showConfirmDialog(null, "Would you like to add the new record?","Save Record",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
                Session session = factory.openSession();
                Transaction tx = null;

                try {
                    File image = new File(filename);
                    FileInputStream fis = new FileInputStream (image);
                    ByteArrayOutputStream bos= new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];

                    for(int readNum; (readNum=fis.read(buf))!=-1; ){
                        bos.write(buf,0,readNum);
                    }

                    Cars cim = new Cars();
                    cim.setRegistrationNo(txtReg.getText());
                    cim.setMake(txtMake.getText());
                    cim.setModel(txtModel.getText());
                    cim.setRentRate(Integer.valueOf(txtRent.getText()));
                    cim.setAvailability("Available");
                    cim.setImage(bos.toByteArray());
                    tx = session.beginTransaction();
                    session.save(cim); 
                    tx.commit();
                    JOptionPane.showMessageDialog(null,"Record has been added successfully");

                }

                catch (HibernateException e) {
                    if (tx!=null) tx.rollback();
                    e.printStackTrace(); 
                } 

                catch(Exception e){
                    System.out.println("Exception: "+e.getMessage());
                }
                finally {
                   session.close(); 
                }
                
            }
        }
        
        else
        {
            p = JOptionPane.showConfirmDialog(null, "Would you like to update the record?","Update Record",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
                Session session = factory.openSession();
                Transaction tx = null;

                try {
                    tx = session.beginTransaction();
                    Cars car = (Cars)session.get(Cars.class, id);

                    if(img_update == true)
                    {
                        File image = new File(filename);
                        FileInputStream fis = new FileInputStream (image);
                        ByteArrayOutputStream bos= new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];

                        for(int readNum; (readNum=fis.read(buf))!=-1; ){
                            bos.write(buf,0,readNum);
                        }

                        car.setImage(bos.toByteArray());
                    }
                    
                    car.setMake(txtMake.getText());
                    car.setModel(txtModel.getText());
                    car.setRentRate(Integer.valueOf(txtRent.getText()));
                    
                    session.save(car);

                    tx.commit();
                    JOptionPane.showMessageDialog(null,"Record has been updated successfully");

                } catch (HibernateException e) {
                    if (tx!=null) tx.rollback();
                    e.printStackTrace();
                } 
                
                catch(Exception e){
                    System.out.println("Exception: "+e.getMessage());
                }
                finally {
                    session.close();
                }
            }
        }
        
        carsDisplay cD = new carsDisplay();
        cD.setVisible(true);
        cD.pack();
        cD.setLocationRelativeTo(null);
        cD.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        carsDisplay cD = new carsDisplay(user);
        cD.setVisible(true);
        cD.pack();
        cD.setLocationRelativeTo(null);
        cD.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(carInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCarPic;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCar;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblReg;
    private javax.swing.JLabel lblRent;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtMake;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtReg;
    private javax.swing.JTextField txtRent;
    // End of variables declaration//GEN-END:variables
}
