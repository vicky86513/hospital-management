/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.gui;

import hospital.Dao.DoctorsDao;
import hospital.Dao.EmpDao;
import hospital.Dao.UserDao;
import hospital.pojo.Doctorspojo;
import hospital.pojo.Emppojo;
import hospital.pojo.UserDetailspojo;
import hospital.pojo.Userpojo;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shweta
 */
public class AddDoctorFrame extends javax.swing.JFrame {
     HashMap<String,String> doctors;
    public AddDoctorFrame()  {
        initComponents();
        this.setLocationRelativeTo(null);
           setTitle("Hospital: Register Doctor Screen");
        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Shweta\\Desktop\\pics\\hms.png");
        setIconImage(icon);
        loadDoctorList();
        reset();
        
    }
       public boolean validateInput(){
        char[] pwd=Pwd.getPassword();
        char[] rpwd=RePwd.getPassword();
        return !(txtUserId.getText().isEmpty()||pwd.length==0||rpwd.length==0||txtDoctorId.getText().isEmpty()||txtQulification.getText().isEmpty()||txtSpecilization.getText().isEmpty());
    }
    public boolean passwordMatch(String a,String b){
    return a.equals(b);
}
    public void reset(){
        txtUserId.setText("");
        Pwd.setText("");
        RePwd.setText("");
        txtQulification.setText("");
        txtSpecilization.setText("");
        try{
               txtDoctorId.setText(DoctorsDao.getNewDoctorId());
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"SQLException! "+ex,"Error",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
       
    }
     private void loadDoctorList(){
       try{ 
         doctors=EmpDao.getNonRegisteredDoctors();
           if(doctors.size()==0){
              JOptionPane.showMessageDialog(null,"No unregistered doctor present!");
               btnRegister.setEnabled(false);
               return;
           }
           else
           btnRegister.setEnabled(true);
           Collection<String> values=doctors.values();
           Set<String> keys=doctors.keySet();
           Iterator<String> itr=keys.iterator();
           Iterator<String> it=values.iterator();
          jcbUsername.removeAllItems();
          jcbEmpId.removeAllItems();
           while(it.hasNext()){
           jcbUsername.addItem(it.next());
           jcbEmpId.addItem(itr.next());
       }
       }
       catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"SQLException! "+ex,"Error",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
    
       }
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcEmpName = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        txtQulification = new javax.swing.JTextField();
        Pwd = new javax.swing.JPasswordField();
        RePwd = new javax.swing.JPasswordField();
        txtDoctorId = new javax.swing.JTextField();
        txtSpecilization = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jcbEmpId = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jcbUsername = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcEmpName.setBackground(new java.awt.Color(0, 102, 102));
        jcEmpName.setForeground(new java.awt.Color(255, 255, 255));

        jDesktopPane1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Add Doctor");

        btnLogout.setBackground(new java.awt.Color(0, 102, 102));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(btnLogout)
                .addGap(42, 42, 42))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(42, 42, 42))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnLogout, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Retype Password");

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Doctor id");

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Qualification");

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Specilization");

        txtUserId.setBackground(new java.awt.Color(0, 153, 153));
        txtUserId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdActionPerformed(evt);
            }
        });

        txtQulification.setBackground(new java.awt.Color(0, 153, 153));
        txtQulification.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Pwd.setBackground(new java.awt.Color(0, 153, 153));
        Pwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdActionPerformed(evt);
            }
        });

        RePwd.setBackground(new java.awt.Color(0, 153, 153));
        RePwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtDoctorId.setBackground(new java.awt.Color(0, 153, 153));
        txtDoctorId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSpecilization.setBackground(new java.awt.Color(0, 153, 153));
        txtSpecilization.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnRegister.setBackground(new java.awt.Color(0, 102, 102));
        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Employee id");

        jcbEmpId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbEmpId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEmpIdItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("EmpName");

        jcbUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbUsername.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbUsernameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jcEmpNameLayout = new javax.swing.GroupLayout(jcEmpName);
        jcEmpName.setLayout(jcEmpNameLayout);
        jcEmpNameLayout.setHorizontalGroup(
            jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcEmpNameLayout.createSequentialGroup()
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcEmpNameLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcEmpNameLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnRegister)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jcEmpNameLayout.createSequentialGroup()
                                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jcEmpNameLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUserId, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addComponent(Pwd)
                        .addComponent(RePwd)
                        .addComponent(txtDoctorId)
                        .addComponent(txtQulification)
                        .addComponent(txtSpecilization)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jcEmpNameLayout.setVerticalGroup(
            jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcEmpNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcEmpNameLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcEmpNameLayout.createSequentialGroup()
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RePwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(65, 65, 65)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(62, 62, 62)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQulification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSpecilization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jcEmpNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserIdActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
   
            if(validateInput()==false){
           JOptionPane.showMessageDialog(null,"please fill all the details!","Error",JOptionPane.ERROR_MESSAGE);
           return;
        }
        try{
            char[] pwd=Pwd.getPassword();
            String pwsd=String.valueOf(pwd);
            char[] rpwd=RePwd.getPassword();
            String rpwsd=String.valueOf(rpwd);
            if(!passwordMatch(pwsd,rpwsd)){
                 JOptionPane.showMessageDialog(null,"Password does not match!","Error",JOptionPane.ERROR_MESSAGE);
           return;
            }
            UserDetailspojo p=new UserDetailspojo();
            p.setEmpid(EmpDao.getEmpId(jcbUsername.getSelectedItem().toString()));
            p.setUserName(jcbUsername.getSelectedItem().toString());
            p.setUserid(txtUserId.getText());
            p.setPassword(rpwsd);
            p.setUserType("DOCTOR");
            boolean result=UserDao.addUser(p);
            if(!result){
                JOptionPane.showMessageDialog(null,"Could not add user to the database!","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            else{
                Doctorspojo d=new Doctorspojo();
                d.setDoctorid(txtDoctorId.getText());
                d.setQulification(txtQulification.getText());
                d.setSpecilist(txtSpecilization.getText());
                d.setUserid(txtUserId.getText());
                boolean r=DoctorsDao.addDoctor(d);
                if(!r){
                    JOptionPane.showMessageDialog(null,"Could not add doctor to the database!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                JOptionPane.showMessageDialog(null,"Doctor Registered successfully");
                reset();
                loadDoctorList();
               }
            
            }
             
           
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"SQLException! "+ex,"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jcbEmpIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEmpIdItemStateChanged
       try{
        String name=EmpDao.getEmpId((String)jcbEmpId.getSelectedItem());
        jcbUsername.setSelectedItem(name);
       }
       catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"SQLException! "+ex,"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
       
        
// TODO add your handling code here:
    }//GEN-LAST:event_jcbEmpIdItemStateChanged

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ManageDoctor mr=new ManageDoctor();
        mr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void PwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PwdActionPerformed

    private void jcbUsernameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbUsernameItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbUsernameItemStateChanged

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
            java.util.logging.Logger.getLogger(AddDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddDoctorFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AddDoctorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Pwd;
    private javax.swing.JPasswordField RePwd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegister;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jcEmpName;
    private javax.swing.JComboBox jcbEmpId;
    private javax.swing.JComboBox jcbUsername;
    private javax.swing.JTextField txtDoctorId;
    private javax.swing.JTextField txtQulification;
    private javax.swing.JTextField txtSpecilization;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
