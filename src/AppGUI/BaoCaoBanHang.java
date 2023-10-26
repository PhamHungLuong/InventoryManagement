/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGUI;

import ClassConstructor.*;
import HandleData.IOfile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.*;
/**
 *
 * @author cccccccccccccccccccc
 */
public class BaoCaoBanHang extends javax.swing.JInternalFrame {


    DefaultTableModel nhapTableModel;
    DefaultTableModel xuatTableModel;
    DefaultTableModel banchayTableModel;
    DefaultTableModel bankemTableModel;

    public BaoCaoBanHang() {
        initComponents();

        this.nhapTableModel = (DefaultTableModel) this.nhapTable.getModel();
        this.xuatTableModel = (DefaultTableModel) this.xuatTable.getModel();
        this.banchayTableModel = (DefaultTableModel) this.banchayTable.getModel();
        this.bankemTableModel = (DefaultTableModel) this.bankemTable.getModel();

    }

    public void showListNhap(String dateTime) {
        ArrayList<HoaDonNhap> listNhap = new ArrayList<>();
        for (int i = 0; i < ImportInvoiceDAO.getInstance().selectAll().size(); i++) {
            if (ImportInvoiceDAO.getInstance().selectAll().get(i).getDate().indexOf(dateTime) != -1) {
                listNhap.add(ImportInvoiceDAO.getInstance().selectAll().get(i));
            }
        }
        ArrayList<CTDS> listCTN = new ArrayList<>();
        for (int i = 0; i < listNhap.size(); i++) {
            for (int j = 0; j < Detail_Imp_inv_DAO.getInstance().selectAll().size(); j++) {
                if (Detail_Imp_inv_DAO.getInstance().selectAll().get(j).getIdHD().compareTo(listNhap.get(i).getID()) == 0) {
                    listCTN.add(Detail_Imp_inv_DAO.getInstance().selectAll().get(j));
                }
            }
        }
        for (int i = 0; i < listCTN.size(); i++) {
            for (int j = i + 1; j < listCTN.size(); j++) {
                if (listCTN.get(i).getIdClothes() == listCTN.get(j).getIdClothes()) {
                    listCTN.get(i).addNumber(listCTN.get(j).getNumberCount());
                    listCTN.remove(listCTN.get(j));
                    j = j - 1;
                }
            }
        }
        this.nhapTableModel.setRowCount(0);
        for (int i = 0; i < listCTN.size(); i++) {
            this.nhapTableModel.addRow(new Object[]{
                listCTN.get(i).getIdClothes(),
                listCTN.get(i).getNameClothes(ClothesDAO.getInstance().selectAll()),
                "",
                listCTN.get(i).getNumberCount(),
            });
        }
        listCTN.clear();
    }

    public void showListXuat(String dateTime) {
        ArrayList<HoaDonXuat> listXuat = new ArrayList<>();
        for (int i = 0; i < ExportInvoiceDAO.getInstance().selectAll().size(); i++) {
            if (ExportInvoiceDAO.getInstance().selectAll().get(i).getDate().indexOf(dateTime) != -1) {
                listXuat.add(ExportInvoiceDAO.getInstance().selectAll().get(i));
            }
        }
        this.setInforBCTK(listXuat);
        ArrayList<CTDS> listCTX = new ArrayList<>();
        for (int i = 0; i < listXuat.size(); i++) {
            for (int j = 0; j < Detail_Exp_inv_DAO.getInstance().selectAll().size(); j++) {
                if (Detail_Exp_inv_DAO.getInstance().selectAll().get(j).getIdHD().compareTo(listXuat.get(i).getID()) == 0) {
                    listCTX.add(Detail_Exp_inv_DAO.getInstance().selectAll().get(j));
                }
            }
        }
        for (int i = 0; i < listCTX.size(); i++) {
            for (int j = i + 1; j < listCTX.size(); j++) {
                if (listCTX.get(j).getIdClothes()== listCTX.get(i).getIdClothes()) {
                    listCTX.get(i).addNumber(listCTX.get(j).getNumberCount());
                    listCTX.remove(listCTX.get(j));
                    j = j - 1;
                }
            }
        }
        this.showBestAndBadSeller(listCTX);
        this.xuatTableModel.setRowCount(0);
        for (int i = 0; i < listCTX.size(); i++) {
            this.xuatTableModel.addRow(new Object[]{
                listCTX.get(i).getIdClothes(),
                listCTX.get(i).getNameClothes(ClothesDAO.getInstance().selectAll()),
                "",
                listCTX.get(i).getNumberCount(),
            });
        }
        listCTX.clear();
    }

    public void showBestAndBadSeller(ArrayList<CTDS> listItems) {
        ArrayList<CTDS> bestSellers = new ArrayList<>();
        ArrayList<CTDS> badSellers = new ArrayList<>();
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getNumberCount() >= 500) {
                bestSellers.add(listItems.get(i));
            } else {
                if (listItems.get(i).getNumberCount() <= 10) {
                    badSellers.add(listItems.get(i));
                }
            }
        }

        this.banchayTableModel.setRowCount(0);
        this.bankemTableModel.setRowCount(0);
        for (int i = 0; i < bestSellers.size(); i++) {
            this.banchayTableModel.addRow(new Object[]{
                bestSellers.get(i).getIdClothes(),
                bestSellers.get(i).getNameClothes(ClothesDAO.getInstance().selectAll()),
                "",
                bestSellers.get(i).getNumberCount(),
            });
        }
        for (int i = 0; i < badSellers.size(); i++) {
            this.bankemTableModel.addRow(new Object[]{
                badSellers.get(i).getIdClothes(),
                badSellers.get(i).getNameClothes(ClothesDAO.getInstance().selectAll()),
                "",
                badSellers.get(i).getNumberCount(),
            });
        }
        bestSellers.clear();
        badSellers.clear();
    }
    public void setInforBCTK(ArrayList<HoaDonXuat> listItems){
                ArrayList<CTDS> listCT = new ArrayList<>();
        for (int i = 0; i < listItems.size(); i++) {
            for (int j = 0; j < Detail_Exp_inv_DAO.getInstance().selectAll().size(); j++) {
                if (Detail_Exp_inv_DAO.getInstance().selectAll().get(j).getIdHD().compareTo(listItems.get(i).getID()) == 0) {
                    listCT.add(Detail_Exp_inv_DAO.getInstance().selectAll().get(j));
                }
            }
        }
        int allMoney=0;
        int allCostMoney=0;
        for(int i=0;i<listCT.size();i++){
            allMoney=allMoney+listCT.get(i).getMoney(ClothesDAO.getInstance().selectAll());
            allCostMoney=allCostMoney+listCT.get(i).getCostMoney(ClothesDAO.getInstance().selectAll());
        }  
        this.costMoneyText.setText(Integer.toString(allCostMoney));
        this.allMoneyText.setText(Integer.toString(allMoney-allCostMoney));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        dateSelectButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        costMoneyText = new javax.swing.JTextField();
        allMoneyText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        nhapTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        xuatTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        banchayTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        bankemTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Báo cáo bán hàng");

        jLabel1.setText("Báo cáo ngày(hoặc tháng):");

        dateText.setText("dd/mm/yy");

        dateSelectButton.setText("Thống kê");
        dateSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateSelectButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("BÁO CÁO CHI TIẾT");

        jLabel4.setText("Thời gian:");

        jLabel5.setText("Tiên gốc:");

        jLabel6.setText("Tiền lãi:");

        costMoneyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costMoneyTextActionPerformed(evt);
            }
        });

        nhapTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên SP", "Size", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(nhapTable);
        if (nhapTable.getColumnModel().getColumnCount() > 0) {
            nhapTable.getColumnModel().getColumn(0).setResizable(false);
            nhapTable.getColumnModel().getColumn(1).setResizable(false);
            nhapTable.getColumnModel().getColumn(2).setResizable(false);
            nhapTable.getColumnModel().getColumn(3).setResizable(false);
        }

        xuatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên SP", "Size", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(xuatTable);
        if (xuatTable.getColumnModel().getColumnCount() > 0) {
            xuatTable.getColumnModel().getColumn(0).setResizable(false);
            xuatTable.getColumnModel().getColumn(1).setResizable(false);
            xuatTable.getColumnModel().getColumn(2).setResizable(false);
            xuatTable.getColumnModel().getColumn(3).setResizable(false);
        }

        banchayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên SP", "Size", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane3.setViewportView(banchayTable);
        if (banchayTable.getColumnModel().getColumnCount() > 0) {
            banchayTable.getColumnModel().getColumn(0).setResizable(false);
            banchayTable.getColumnModel().getColumn(1).setResizable(false);
            banchayTable.getColumnModel().getColumn(2).setResizable(false);
            banchayTable.getColumnModel().getColumn(3).setResizable(false);
        }

        bankemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Sp", "Size", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane4.setViewportView(bankemTable);
        if (bankemTable.getColumnModel().getColumnCount() > 0) {
            bankemTable.getColumnModel().getColumn(0).setResizable(false);
            bankemTable.getColumnModel().getColumn(1).setResizable(false);
            bankemTable.getColumnModel().getColumn(2).setResizable(false);
            bankemTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel7.setText("Danh sách nhập");

        jLabel8.setText("Danh sách xuất");

        jLabel9.setText("Sản phẩm bán chạy");

        jLabel10.setText("Sản phẩm bán kém");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(allMoneyText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(costMoneyText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(dateSelectButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel7)
                .addGap(164, 164, 164)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(141, 141, 141)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(471, 471, 471))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateSelectButton))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(timeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(costMoneyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(allMoneyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void costMoneyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costMoneyTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costMoneyTextActionPerformed

    private void dateSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateSelectButtonActionPerformed
        if (this.dateText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Nhập thời gian theo đinh dạng trong ô trống !");
        } else {
            this.timeText.setText(this.dateText.getText());
            this.showListNhap(this.dateText.getText());
            this.showListXuat(this.dateText.getText());
        }
    }//GEN-LAST:event_dateSelectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField allMoneyText;
    private javax.swing.JTable banchayTable;
    private javax.swing.JTable bankemTable;
    private javax.swing.JTextField costMoneyText;
    private javax.swing.JButton dateSelectButton;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable nhapTable;
    private javax.swing.JTextField timeText;
    private javax.swing.JTable xuatTable;
    // End of variables declaration//GEN-END:variables
}

