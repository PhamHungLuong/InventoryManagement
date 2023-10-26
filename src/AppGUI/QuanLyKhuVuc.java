/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGUI;

import java.util.ArrayList;
import ClassConstructor.*;
import DAO.AreaDAO;
import DAO.ClothesDAO;
import HandleData.IOfile;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cccccccccccccccccccc
 */
public class QuanLyKhuVuc extends javax.swing.JInternalFrame {

    ArrayList<Arena> listArena;
    DefaultTableModel arenaTableModel;
    int selectPosition = -1;

    public QuanLyKhuVuc() {
        initComponents();
        this.listArena = new ArrayList<>();
        this.arenaTableModel = (DefaultTableModel) this.arenaTable.getModel();

//        this.listArena = IOfile.readArena();
        this.listArena = AreaDAO.getInstance().selectAll();
        this.showListArena();
        this.arenaTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectPosition = arenaTable.getSelectedRow();
                idText.setText((String) arenaTableModel.getValueAt(selectPosition, 0).toString());
                nameText.setText((String) arenaTableModel.getValueAt(selectPosition, 1));
                numberText.setText((String) arenaTableModel.getValueAt(selectPosition, 2).toString());
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

    public void showListArena() {
        this.arenaTableModel.setRowCount(0);
        for (int i = 0; i < this.listArena.size(); i++) {
            this.arenaTableModel.addRow(new Object[]{
                this.listArena.get(i).getID(),
                this.listArena.get(i).getName(),
                this.listArena.get(i).getNumberProduct(ClothesDAO.getInstance().selectAll()),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arenaTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        numberText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        upgradeButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        seacrhText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Quản lý khu vực kho hàng");
        setPreferredSize(new java.awt.Dimension(1096, 731));

        arenaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên khu", "Số lượng quần áo hiện tại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(arenaTable);
        if (arenaTable.getColumnModel().getColumnCount() > 0) {
            arenaTable.getColumnModel().getColumn(0).setResizable(false);
            arenaTable.getColumnModel().getColumn(1).setResizable(false);
            arenaTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Danh sách khu vực");

        jLabel2.setText("ID:");

        jLabel3.setText("Tên khu vực:");

        jLabel4.setText("Số lượng SP hiện tại:");

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        upgradeButton.setText("Cập nhật thông tin");
        upgradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa khu vực");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Tìm kiếm:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(upgradeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(138, 138, 138)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seacrhText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(seacrhText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton)
                        .addComponent(resetButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(upgradeButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(deleteButton))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (this.idText.getText().length() == 0 || this.nameText.getText().length() == 0 || Integer.parseInt(this.numberText.getText()) != 0) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin vào ô trông!");
        } else {
            Arena newArena = new Arena(Integer.parseInt(this.idText.getText()), this.nameText.getText());
            String checked = "Success";
            for (int i = 0; i < this.listArena.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listArena.get(i).getID()) {
                    checked = "Fail";
                }
            }
            if (checked.compareTo("Fail") != 0) {
                this.listArena.add(newArena);
//                IOfile.writeArena(this.listArena);
                AreaDAO.getInstance().Add(newArena);
                this.idText.setText("");
                this.nameText.setText("");
                this.numberText.setText("");

                this.showListArena();
                JOptionPane.showMessageDialog(rootPane, "Thêm khu vực mới thành công !");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ID đã tồn tại !");
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void upgradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeButtonActionPerformed
        if (this.selectPosition == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn khu vực muốn cập nhật!");
        } else {
            int index = -1;
            for (int i = 0; i < this.listArena.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listArena.get(i).getID()) {
                    index = i;
                    break;
                }
            }
//            Arena newArena = new Arena(Integer.parseInt(this.idText.getText()), this.nameText.getText());
            this.listArena.get(index).changeInforArena(this.nameText.getText());
//            IOfile.writeArena(this.listArena);
            AreaDAO.getInstance().Update(this.listArena.get(index));
            this.idText.setText("");
            this.nameText.setText("");
            this.numberText.setText("");
            this.selectPosition = -1;

            this.showListArena();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật khu vực mới thành công !");
        }
    }//GEN-LAST:event_upgradeButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (this.selectPosition == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn khu vực muốn xóa!");
        } else {
            int index = -1;
            for (int i = 0; i < this.listArena.size(); i++) {
                if (Integer.parseInt(this.idText.getText()) == this.listArena.get(i).getID()) {
                    index = i;
                    break;
                }
            }
            String checked = "";
            for (int i = 0; i < ClothesDAO.getInstance().selectAll().size(); i++) {
                if (this.listArena.get(index).getID() == ClothesDAO.getInstance().selectAll().get(i).getIdDistrict()) {
                    checked = "Fail";
                    break;
                }
            }
            if (checked.compareTo("Fail") == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa do trong khu vực có chứa đò !");
            } else {
//                Arena newArena = new Arena(Integer.parseInt(this.idText.getText()), this.nameText.getText());
//                this.listArena.remove(index);
//                IOfile.writeArena(this.listArena);
                AreaDAO.getInstance().Delete(this.listArena.get(index));
                this.listArena.remove(index);
                this.idText.setText("");
                this.nameText.setText("");
                this.numberText.setText("");
                this.selectPosition = -1;

                this.showListArena();
                JOptionPane.showMessageDialog(rootPane, "Xóa khu vực mới thành công !");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (this.seacrhText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Nhập tên khu vực muốn tìm kiếm !");
        } else {
            ArrayList<Arena> listArenaClone = new ArrayList<>();
            for (int i = 0; i < this.listArena.size(); i++) {
                if (this.listArena.get(i).getName().indexOf(this.seacrhText.getText()) != -1) {
                    listArenaClone.add(this.listArena.get(i));
                }
            }
            this.arenaTableModel.setRowCount(0);
            for (int i = 0; i < listArenaClone.size(); i++) {
                this.arenaTableModel.addRow(new Object[]{
                    listArenaClone.get(i).getID(),
                    listArenaClone.get(i).getName(),
                    listArenaClone.get(i).getNumberProduct(IOfile.readClothes()),});
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        this.seacrhText.setText("");
        this.showListArena();
    }//GEN-LAST:event_resetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable arenaTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField numberText;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField seacrhText;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton upgradeButton;
    // End of variables declaration//GEN-END:variables
}
