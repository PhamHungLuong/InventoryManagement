/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGUI;

import DAO.EmployeeDAO;
import HandleData.IOfile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cccccccccccccccccccc
 */
public class LoginFrame extends javax.swing.JFrame {

    MainFrame viewQL;
    MainFrame2 viewNV;

    Boolean loginState;
    public LoginFrame() {
        initComponents();

        this.loginState = true;
        this.userNameText.setText("hihi");
        this.passText.setText("123");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneViewWork = new javax.swing.JDesktopPane();
        LoginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameText = new javax.swing.JTextField();
        passText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APP QUẢN LÝ KHO HÀNG");

        jDesktopPaneViewWork.setPreferredSize(new java.awt.Dimension(1408, 895));

        javax.swing.GroupLayout jDesktopPaneViewWorkLayout = new javax.swing.GroupLayout(jDesktopPaneViewWork);
        jDesktopPaneViewWork.setLayout(jDesktopPaneViewWorkLayout);
        jDesktopPaneViewWorkLayout.setHorizontalGroup(
            jDesktopPaneViewWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1404, Short.MAX_VALUE)
        );
        jDesktopPaneViewWorkLayout.setVerticalGroup(
            jDesktopPaneViewWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );

        LoginButton.setText("Đăng nhập");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Tài khoản:");

        jLabel2.setText("Mật khẩu:");

        jLabel5.setText("ĐĂNG NHẬP");

        jLabel6.setText("MÀN HÌNH LÀM VIỆC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameText)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginButton)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addComponent(passText))
                .addGap(12, 12, 12)
                .addComponent(jDesktopPaneViewWork, javax.swing.GroupLayout.PREFERRED_SIZE, 1404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(688, 688, 688))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(userNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LoginButton))
                    .addComponent(jDesktopPaneViewWork, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed

        if (this.loginState == true) {
            if (this.userNameText.getText().length() == 0 || this.passText.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Nhập đày đủ thông tin tài khoản !");
            } else {
                boolean checkState=false;
                for (int i = 0; i < EmployeeDAO.getInstance().selectAll().size(); i++) {
                    if (this.userNameText.getText().compareTo(EmployeeDAO.getInstance().selectAll().get(i).getUser()) == 0 && this.passText.getText().compareTo(EmployeeDAO.getInstance().selectAll().get(i).getPass()) == 0) {
                        if (EmployeeDAO.getInstance().selectAll().get(i).getPosition().compareTo("Quản lý") == 0) {
                            this.viewQL= new MainFrame(EmployeeDAO.getInstance().selectAll().get(i));
                            this.jDesktopPaneViewWork.add(this.viewQL);
                            this.viewQL.setVisible(true);
                        } else {
                            this.viewNV=new MainFrame2(EmployeeDAO.getInstance().selectAll().get(i));
                            this.jDesktopPaneViewWork.add(this.viewNV);
                            this.viewNV.setVisible(true);
                        }
                        checkState=true;
                        this.jLabel5.setText("XIN CHÀO!");
                        this.jLabel1.setText("Nhân viên:");
                        this.jLabel2.setText("Chức vụ:");
                        this.userNameText.setText(EmployeeDAO.getInstance().selectAll().get(i).getHoTen());
                        this.passText.setText(EmployeeDAO.getInstance().selectAll().get(i).getPosition());
                        this.LoginButton.setText("Đăng xuất");
                        this.loginState = false;
                        JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công!");
                    }
                }
                if(checkState==false){
                    JOptionPane.showMessageDialog(rootPane,"Sai tài khoản hoặc mật khẩu !");
                }
            }
        } else {
            if (this.passText.getText().compareTo("Quản lý") == 0) {
                this.viewQL.setVisible(false);
            } else {
                this.viewNV.setVisible(false);
            }
            this.jLabel5.setText("ĐĂNG NHẬP");
            this.jLabel1.setText("Tài khoản:");
            this.jLabel2.setText("Mật khẩu:");
            this.userNameText.setText("");
            this.passText.setText("");
            this.LoginButton.setText("Đăng nhập");
            this.loginState = true;
            JOptionPane.showMessageDialog(rootPane, "Đăng xuất thành công!");
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JDesktopPane jDesktopPaneViewWork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField passText;
    private javax.swing.JTextField userNameText;
    // End of variables declaration//GEN-END:variables
}

