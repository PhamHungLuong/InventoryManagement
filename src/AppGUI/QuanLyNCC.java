/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGUI;

import java.util.ArrayList;
import ClassConstructor.*;
import DAO.ImportInvoiceDAO;
import DAO.SupplierDAO;
import HandleData.IOfile;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cccccccccccccccccccc
 */
public class QuanLyNCC extends javax.swing.JInternalFrame {

    ArrayList<NhaCungCap> listNCC;
    DefaultTableModel NCCTableModel;
    int selectPosition = -1;

    public QuanLyNCC() {
        initComponents();
        this.listNCC = new ArrayList<>();
        this.NCCTableModel = (DefaultTableModel) this.NCCTable.getModel();

//        this.listNCC = IOfile.readNCC();
        this.listNCC = SupplierDAO.getInstance().selectAll();
        this.showListNCC();

        this.NCCTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectPosition = NCCTable.getSelectedRow();
                idText.setText((String) NCCTableModel.getValueAt(selectPosition, 0).toString());
                nameText.setText((String) NCCTableModel.getValueAt(selectPosition, 1));
                phoneText.setText((String) NCCTableModel.getValueAt(selectPosition, 2));
                addressText.setText((String) NCCTableModel.getValueAt(selectPosition, 3));
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

    public void showListNCC() {
        this.NCCTableModel.setRowCount(0);
        for (int i = 0; i < this.listNCC.size(); i++) {
            this.NCCTableModel.addRow(new Object[]{
                this.listNCC.get(i).getID(),
                this.listNCC.get(i).getName(),
                this.listNCC.get(i).getPhone(),
                this.listNCC.get(i).getAddress(),});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        NCCTable = new javax.swing.JTable();
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
        resetButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Quản lý nhà cung cấp");
        setPreferredSize(new java.awt.Dimension(1096, 731));

        NCCTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên nhà cung cấp", "Liên hệ", "Địa chỉ"
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
        jScrollPane1.setViewportView(NCCTable);
        if (NCCTable.getColumnModel().getColumnCount() > 0) {
            NCCTable.getColumnModel().getColumn(0).setResizable(false);
            NCCTable.getColumnModel().getColumn(1).setResizable(false);
            NCCTable.getColumnModel().getColumn(2).setResizable(false);
            NCCTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Danh sách nhà cung cấp");

        jLabel2.setText("ID:");

        jLabel3.setText("Nhà cung cấp:");

        jLabel4.setText("Liên hệ:");

        jLabel5.setText("Địa chỉ:");

        addButton.setText("Thêm NCC");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        upgradeButton.setText("Cập nhật NCC");
        upgradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa NCC");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm kiếm :");

        searchButton.setText("Tìm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset DS");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(150, 150, 150))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(113, 113, 113))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addressText, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(nameText, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idText, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneText))
                                .addGap(89, 89, 89)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(upgradeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(jLabel6)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(resetButton))
                .addGap(18, 18, 18)
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
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (this.idText.getText().length() == 0 || this.nameText.getText().length() == 0 || this.phoneText.getText().length() == 0 || this.addressText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin trong ô trống !");
        } else {
            NhaCungCap newNCC = new NhaCungCap(Integer.parseInt(this.idText.getText()), this.nameText.getText(), this.phoneText.getText(), this.addressText.getText());
            String checked = "";
            for (int i = 0; i < this.listNCC.size(); i++) {
                if (newNCC.getID() == this.listNCC.get(i).getID()) {
                    checked = "Fail";
                    break;
                }
            }
            if (checked.compareTo("Fail") == 0) {
                JOptionPane.showMessageDialog(rootPane, "ID đã tồn tại!");
            } else {
                this.listNCC.add(newNCC);
//                IOfile.writeNCC(this.listNCC);
                SupplierDAO.getInstance().Add(newNCC);

                this.idText.setText("");
                this.nameText.setText("");
                this.phoneText.setText("");
                this.addressText.setText("");

                this.showListNCC();
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");

            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void upgradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeButtonActionPerformed
        if (this.selectPosition == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn nhà cung cấp muốn cập nhật !");
        } else {
            int index = -1;
            for (int i = 0; i < this.listNCC.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listNCC.get(i).getID()) {
                    index = i;
                    break;
                }
            }
//            NhaCungCap newNCC = new NhaCungCap(Integer.parseInt(this.idText.getText()), this.nameText.getText(), this.phoneText.getText(), this.addressText.getText());
            this.listNCC.get(index).changeInfor(this.nameText.getText(), this.phoneText.getText(), this.addressText.getText());
//            IOfile.writeNCC(this.listNCC);
            SupplierDAO.getInstance().Update(this.listNCC.get(index));
            this.idText.setText("");
            this.nameText.setText("");
            this.phoneText.setText("");
            this.addressText.setText("");
            this.selectPosition = -1;

            this.showListNCC();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_upgradeButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (this.selectPosition == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn nhà cung cấp muốn xóa !");
        } else {
            int index = -1;
            for (int i = 0; i < this.listNCC.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listNCC.get(i).getID()) {
                    index = i;
                    break;
                }
            }
            String checked = "";
            for (int i = 0; i < ImportInvoiceDAO.getInstance().selectAll().size(); i++) {
                if (this.listNCC.get(index).getID() == ImportInvoiceDAO.getInstance().selectAll().get(i).getNCCID()) {
                    checked = "Fail";
                    break;
                }
            }
            if (checked.compareTo("Fail") == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa do nhà cung cấp này tồn tại trong hóa đơn!");
            } else {
//                this.listNCC.remove(index);
//                IOfile.writeNCC(this.listNCC);
                SupplierDAO.getInstance().Delete(this.listNCC.get(index));
                this.listNCC.remove(index);
                this.idText.setText("");
                this.nameText.setText("");
                this.phoneText.setText("");
                this.addressText.setText("");
                this.selectPosition = -1;

                this.showListNCC();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (this.searchText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Nhập tên nhà cung cấp !");
        } else {
            ArrayList<NhaCungCap> newListNCC = new ArrayList<>();
            for (int i = 0; i < this.listNCC.size(); i++) {
                if (this.listNCC.get(i).getName().indexOf(this.searchText.getText()) != -1) {
                    newListNCC.add(this.listNCC.get(i));
                }
            }
            this.NCCTableModel.setRowCount(0);
            for (int i = 0; i < newListNCC.size(); i++) {
                this.NCCTableModel.addRow(new Object[]{
                    newListNCC.get(i).getID(),
                    newListNCC.get(i).getName(),
                    newListNCC.get(i).getPhone(),
                    newListNCC.get(i).getAddress(),});
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        this.searchText.setText("");
        this.showListNCC();
    }//GEN-LAST:event_resetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable NCCTable;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JButton upgradeButton;
    // End of variables declaration//GEN-END:variables
}
