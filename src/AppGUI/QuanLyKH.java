/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGUI;

import ClassConstructor.*;
import DAO.CustomerDAO;
import DAO.ExportInvoiceDAO;
import HandleData.IOfile;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cccccccccccccccccccc
 */
public class QuanLyKH extends javax.swing.JInternalFrame {

    ArrayList<Customer> listCustomer;
    DefaultTableModel cusTableModel;
    int selectPosition = -1;

    /**
     * Creates new form QuanLyKH
     */
    public QuanLyKH() {
        initComponents();
        this.listCustomer = new ArrayList<>();
        this.cusTableModel = (DefaultTableModel) this.customerTable.getModel();

//        this.listCustomer = IOfile.readCustomer();
        this.listCustomer = CustomerDAO.getInstance().selectAll();
        this.showListCustomer();
        this.customerTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectPosition = customerTable.getSelectedRow();
                idText.setText((String) cusTableModel.getValueAt(selectPosition, 0).toString());
                nameText.setText((String) cusTableModel.getValueAt(selectPosition, 1));
                phoneText.setText((String) cusTableModel.getValueAt(selectPosition, 2));
                addressText.setText((String) cusTableModel.getValueAt(selectPosition, 3));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void showListCustomer() {
        this.cusTableModel.setRowCount(0);
        for (int i = 0; i < this.listCustomer.size(); i++) {
            this.cusTableModel.addRow(new Object[]{
                this.listCustomer.get(i).getID(),
                this.listCustomer.get(i).getName(),
                this.listCustomer.get(i).getPhone(),
                this.listCustomer.get(i).getAddress(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        phoneText = new javax.swing.JTextField();
        addressText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        upgradeButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        resetBUuton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle(" Quản lý khách hàng");
        setPreferredSize(new java.awt.Dimension(1096, 731));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên khách hàng", "Liên hệ", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setResizable(false);
            customerTable.getColumnModel().getColumn(1).setResizable(false);
            customerTable.getColumnModel().getColumn(2).setResizable(false);
            customerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Danh sách khánh hàng");

        jLabel2.setText("ID:");

        jLabel3.setText("Khách hàng:");

        jLabel4.setText("Liên hệ:");

        jLabel5.setText("Địa chỉ:");

        addButton.setText("Thêm khách hàng");
        addButton.setToolTipText("");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        upgradeButton.setText("Cập nhật khách hàng");
        upgradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa khách hàng");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm kiếm:");

        searchButton.setText("Tìm");
        searchButton.setToolTipText("");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        resetBUuton.setText("Reset DS");
        resetBUuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBUutonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)
                                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(upgradeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetBUuton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(jLabel6)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(resetBUuton))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upgradeButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (this.idText.getText().length() == 0 || this.nameText.getText().length() == 0 || this.phoneText.getText().length() == 0 || this.addressText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Háy nhập đầy đủ thông tin trong ô trống !");
        } else {
            Customer newCus = new Customer(Integer.parseInt(this.idText.getText()), this.nameText.getText(), this.phoneText.getText(), this.addressText.getText());
            String checked = "Success";
            for (int i = 0; i < this.listCustomer.size(); i++) {
                if (newCus.getID() == this.listCustomer.get(i).getID()) {
                    checked = "Fail";
                    break;
                }
            }
            if (checked.compareTo("Fail") == 0) {
                JOptionPane.showMessageDialog(rootPane, "ID đã tồn tại !");
            } else {
                this.listCustomer.add(newCus);
//                IOfile.writeCustomer(this.listCustomer);
                CustomerDAO.getInstance().Add(newCus);
                this.idText.setText("");
                this.nameText.setText("");
                this.phoneText.setText("");
                this.addressText.setText("");

                this.showListCustomer();
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void upgradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeButtonActionPerformed
        if (this.selectPosition == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn khách hàng muốn cập nhật !");
        } else {
            int index = -1;
            for (int i = 0; i < this.listCustomer.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listCustomer.get(i).getID()) {
                    index = i;
                    break;
                }
            }
//            Customer newCus = new Customer(Integer.parseInt(this.idText.getText()), this.nameText.getText(), this.phoneText.getText(), this.addressText.getText());

            this.listCustomer.get(index).changeInfor(this.nameText.getText(), this.phoneText.getText(), this.addressText.getText());
//            IOfile.writeCustomer(this.listCustomer);
            CustomerDAO.getInstance().Update(this.listCustomer.get(index));
            this.idText.setText("");
            this.nameText.setText("");
            this.phoneText.setText("");
            this.addressText.setText("");
            this.selectPosition = -1;

            this.showListCustomer();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_upgradeButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (this.selectPosition == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn khách ahfng muốn xóa !");
        } else {
            int index = -1;
            for (int i = 0; i < this.listCustomer.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listCustomer.get(i).getID()) {
                    index = i;
                    break;
                }
            }
            String checked = "Success";
            for (int i = 0; i < ExportInvoiceDAO.getInstance().selectAll().size(); i++) {
                if (this.listCustomer.get(index).getID() == ExportInvoiceDAO.getInstance().selectAll().get(i).getCustommerID()) {
                    checked = "Fail";
                    break;
                }
            }
            if (checked.compareTo("Fail") == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa do có hóa đơn chứa khách hàng này !");
            } else {
//                this.listCustomer.remove(index);
//                IOfile.writeCustomer(this.listCustomer);
                CustomerDAO.getInstance().Delete(this.listCustomer.get(index));
                this.listCustomer.remove(index);
                this.idText.setText("");
                this.nameText.setText("");
                this.phoneText.setText("");
                this.addressText.setText("");
                this.selectPosition = -1;

                this.showListCustomer();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (this.searchText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Nhập tên khách hàng !");
        } else {
            ArrayList<Customer> newListCus = new ArrayList<>();
            for (int i = 0; i < this.listCustomer.size(); i++) {
                if (this.listCustomer.get(i).getName().indexOf(this.searchText.getText()) != -1) {
                    newListCus.add(this.listCustomer.get(i));
                }
            }
            this.cusTableModel.setRowCount(0);
            for (int i = 0; i < newListCus.size(); i++) {
                this.cusTableModel.addRow(new Object[]{
                    newListCus.get(i).getID(),
                    newListCus.get(i).getName(),
                    newListCus.get(i).getPhone(),
                    newListCus.get(i).getAddress(),});
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void resetBUutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBUutonActionPerformed
        this.searchText.setText("");
        this.showListCustomer();
    }//GEN-LAST:event_resetBUutonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressText;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField idText;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JButton resetBUuton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JButton upgradeButton;
    // End of variables declaration//GEN-END:variables
}
