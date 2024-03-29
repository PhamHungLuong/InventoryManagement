/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppGUI;

import ClassConstructor.*;
import DAO.ClothesDAO;
import DAO.Detail_Imp_inv_DAO;
import DAO.EmployeeDAO;
import DAO.ImportInvoiceDAO;
import DAO.SupplierDAO;
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
public class QuanLyHDN extends javax.swing.JInternalFrame {

    ArrayList<Clothes> listClothes;
    ArrayList<HoaDonNhap> listHDN;
    ArrayList<CTDS> listCTDS;
    ArrayList<CTDS> listCTClone;
    DefaultTableModel hdnTableModel;
    DefaultTableModel cthdnTableModel;
    int selectPosition = -1;

    NhanVien user;

    public QuanLyHDN(NhanVien user) {
        initComponents();

        this.listClothes = new ArrayList<>();
        this.listHDN = new ArrayList<>();
        this.listCTDS = new ArrayList<>();
        this.listCTClone = new ArrayList<>();

//        this.listHDN = IOfile.readHDN();
        this.listHDN = ImportInvoiceDAO.getInstance().selectAll();
//        this.listCTDS = IOfile.readCTDS();

        this.listCTDS = Detail_Imp_inv_DAO.getInstance().selectAll();
//        this.listClothes = IOfile.readClothes();
        this.listClothes = ClothesDAO.getInstance().selectAll();

        this.hdnTableModel = (DefaultTableModel) this.hdnTable.getModel();
        this.cthdnTableModel = (DefaultTableModel) this.ctdsHDNTable.getModel();

        this.user = user;
        this.showListHDN();

        this.hdnTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectPosition = hdnTable.getSelectedRow();

                idHDNText.setText((String) hdnTableModel.getValueAt(selectPosition, 0));
                dateHDNText.setText((String) hdnTableModel.getValueAt(selectPosition, 1));
                nccText.setText((String) hdnTableModel.getValueAt(selectPosition, 2));
                staffHDNText.setText((String) hdnTableModel.getValueAt(selectPosition, 3));
                ArrayList<CTDS> listClone = new ArrayList<>();
                for (int i = 0; i < Detail_Imp_inv_DAO.getInstance().selectAll().size(); i++) {
                    if (idHDNText.getText().compareTo(Detail_Imp_inv_DAO.getInstance().selectAll().get(i).getIdHD()) == 0) {
                        listClone.add(Detail_Imp_inv_DAO.getInstance().selectAll().get(i));
                    }
                }
                showCTHDN(listClone);
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

    public void showListHDN() {
        this.hdnTableModel.setRowCount(0);
        for (int i = 0; i < ImportInvoiceDAO.getInstance().selectAll().size(); i++) {
            this.hdnTableModel.addRow(new Object[]{
                ImportInvoiceDAO.getInstance().selectAll().get(i).getID(),
                ImportInvoiceDAO.getInstance().selectAll().get(i).getDate(),
                ImportInvoiceDAO.getInstance().selectAll().get(i).getNameNCC(SupplierDAO.getInstance().selectAll()),
                ImportInvoiceDAO.getInstance().selectAll().get(i).getNameEmp(EmployeeDAO.getInstance().selectAll()),
                ImportInvoiceDAO.getInstance().selectAll().get(i).getAllMoney(ClothesDAO.getInstance().selectAll(), Detail_Imp_inv_DAO.getInstance().selectAll())
            });
        }
    }

    public void showCTHDN(ArrayList<CTDS> list) {
        this.cthdnTableModel.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            this.cthdnTableModel.addRow(new Object[]{
                list.get(i).getIdClothes(),
                list.get(i).getNameClothes(ClothesDAO.getInstance().selectAll()),
                list.get(i).getNumberCount(),
                list.get(i).getMoney(ClothesDAO.getInstance().selectAll()),});
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hdnTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idHDNText = new javax.swing.JTextField();
        dateHDNText = new javax.swing.JTextField();
        nccText = new javax.swing.JTextField();
        staffHDNText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nameProHDNText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        numberHDNText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ctdsHDNTable = new javax.swing.JTable();
        moreProHDNButton = new javax.swing.JButton();
        addHDNButton = new javax.swing.JButton();
        resetHDNButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        searchHDNText = new javax.swing.JTextField();
        searchHDNButton = new javax.swing.JButton();
        resetListHDNButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Quản lý hóa đơn nhập");
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1096, 731));

        jLabel1.setText("Danh sách hóa đơn nhập");

        hdnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ngày", "Nhà cung cấp", "Nhân viên nhập phiếu", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hdnTable);
        if (hdnTable.getColumnModel().getColumnCount() > 0) {
            hdnTable.getColumnModel().getColumn(0).setResizable(false);
            hdnTable.getColumnModel().getColumn(1).setResizable(false);
            hdnTable.getColumnModel().getColumn(2).setResizable(false);
            hdnTable.getColumnModel().getColumn(3).setResizable(false);
            hdnTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setText("ID:");

        jLabel3.setText("Ngày:");

        jLabel4.setText("Nhà cung cấp:");

        jLabel5.setText("Nhân viên tạo:");

        idHDNText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idHDNTextActionPerformed(evt);
            }
        });

        dateHDNText.setText("dd/mm/yy");

        staffHDNText.setEditable(false);

        jLabel6.setText("Tên SP:");

        nameProHDNText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameProHDNTextActionPerformed(evt);
            }
        });

        jLabel7.setText("Số lượng:");

        ctdsHDNTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(ctdsHDNTable);
        if (ctdsHDNTable.getColumnModel().getColumnCount() > 0) {
            ctdsHDNTable.getColumnModel().getColumn(0).setResizable(false);
            ctdsHDNTable.getColumnModel().getColumn(1).setResizable(false);
            ctdsHDNTable.getColumnModel().getColumn(2).setResizable(false);
            ctdsHDNTable.getColumnModel().getColumn(3).setResizable(false);
        }

        moreProHDNButton.setText("Tiếp");
        moreProHDNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreProHDNButtonActionPerformed(evt);
            }
        });

        addHDNButton.setText("Thêm hóa đơn");
        addHDNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHDNButtonActionPerformed(evt);
            }
        });

        resetHDNButton.setText("Reset form");
        resetHDNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHDNButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Tìm kiếm theo ngày:");

        searchHDNButton.setText("Tìm");
        searchHDNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHDNButtonActionPerformed(evt);
            }
        });

        resetListHDNButton.setText("Làm mới danh sách");
        resetListHDNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetListHDNButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameProHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numberHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(moreProHDNButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(staffHDNText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                        .addComponent(nccText, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(279, 279, 279)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchHDNButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(resetListHDNButton))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(addHDNButton)
                .addGap(36, 36, 36)
                .addComponent(resetHDNButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(searchHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchHDNButton)
                            .addComponent(resetListHDNButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nccText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(staffHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nameProHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(numberHDNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moreProHDNButton))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addHDNButton)
                    .addComponent(resetHDNButton))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idHDNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idHDNTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idHDNTextActionPerformed

    private void nameProHDNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameProHDNTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameProHDNTextActionPerformed

    private void addHDNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHDNButtonActionPerformed
        if (this.idHDNText.getText().length() == 0 || this.dateHDNText.getText().length() == 0 || this.nccText.getText().length() == 0 || this.listCTClone.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Nhập đầy đủ thông tin hóa đơn vào ô trống !");
        } else {
            int idNCC = 0;
            for (int i = 0; i < SupplierDAO.getInstance().selectAll().size(); i++) {
                if (this.nccText.getText().compareTo(SupplierDAO.getInstance().selectAll().get(i).getName()) == 0) {
                    idNCC = SupplierDAO.getInstance().selectAll().get(i).getID();
                }
            }
            HoaDonNhap newHDN = new HoaDonNhap(this.idHDNText.getText(), this.dateHDNText.getText(), idNCC, this.user.getID());
            String checkedHD = "";
            for (int i = 0; i < this.listHDN.size(); i++) {
                if (newHDN.getID().compareTo(this.listHDN.get(i).getID()) == 0) {
                    checkedHD = "Failure";
                    break;
                }
            }
            if (checkedHD.compareTo("Failure") != 0 && newHDN.getNCCID() != 0) {
                this.listHDN.add(newHDN);
//                IOfile.writeHDN(this.listHDN);
                ImportInvoiceDAO.getInstance().Add(newHDN);

                for (int i = 0; i < this.listCTClone.size(); i++) {
                    Detail_Imp_inv_DAO.getInstance().Add(this.listCTClone.get(i));
                }

                this.idHDNText.setText("");
                this.dateHDNText.setText("");
                this.nccText.setText("");
                this.staffHDNText.setText("");
                this.numberHDNText.setText("");
                this.nameProHDNText.setText("");
                this.listCTClone.clear();
                this.showListHDN();

                ArrayList<CTDS> cthd = new ArrayList<>();
                for (int i = 0; i < Detail_Imp_inv_DAO.getInstance().selectAll().size(); i++) {
                    if (newHDN.getID().compareTo(Detail_Imp_inv_DAO.getInstance().selectAll().get(i).getIdHD()) == 0) {
                        cthd.add(Detail_Imp_inv_DAO.getInstance().selectAll().get(i));
                    }
                }
                for (int i = 0; i < this.listClothes.size(); i++) {
                    for (int j = 0; j < cthd.size(); j++) {
                        if (this.listClothes.get(i).getId() == cthd.get(j).getIdClothes()) {
                           this.listClothes.get(i).upNumber(cthd.get(j).getNumberCount());
                            ClothesDAO.getInstance().Update(this.listClothes.get(i));
                        }
                    }

                }
//                IOfile.writeClothes(this.listClothes);
                JOptionPane.showMessageDialog(rootPane, "Thêm hóa đơn nhập thành công !");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ID đã tồn tại hoặc nhà cung cấp không tồn tại !");
            }
        }
    }//GEN-LAST:event_addHDNButtonActionPerformed

    private void moreProHDNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreProHDNButtonActionPerformed
        if (this.nameProHDNText.getText().length() == 0 || this.numberHDNText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập số tên sản phẩm và số lượng !");
        } else {
            int idClothes = 0;
            for (int i = 0; i < ClothesDAO.getInstance().selectAll().size(); i++) {
                if (this.nameProHDNText.getText().replaceAll(" ", "").compareTo(ClothesDAO.getInstance().selectAll().get(i).getTenSP().replaceAll(" ", "")) == 0) {
                    idClothes = ClothesDAO.getInstance().selectAll().get(i).getId();
                }
            }
            if (idClothes == 0) {
                JOptionPane.showMessageDialog(rootPane, "Sản phẩm hoặc số lượng không phù hợp !");
            } else {
                this.listCTClone.add(new CTDS(this.idHDNText.getText(), idClothes, Integer.parseInt(this.numberHDNText.getText())));
                this.showCTHDN(this.listCTClone);

                this.numberHDNText.setText("");
                this.nameProHDNText.setText("");
                JOptionPane.showMessageDialog(rootPane, "Thêm vào danh sách thành công !");
            }
        }
    }//GEN-LAST:event_moreProHDNButtonActionPerformed

    private void resetHDNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHDNButtonActionPerformed
        this.idHDNText.setText("");
        this.dateHDNText.setText("");
        this.nccText.setText("");
        this.staffHDNText.setText("");
        this.numberHDNText.setText("");
        this.nameProHDNText.setText("");
        this.listCTClone.clear();
        this.selectPosition = -1;
        this.showCTHDN(this.listCTClone);
    }//GEN-LAST:event_resetHDNButtonActionPerformed

    private void searchHDNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHDNButtonActionPerformed
        if (this.searchHDNText.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Nhập ngày của hóa đơn muốn tìm !");
        } else {
            ArrayList<HoaDonNhap> newListHDN = new ArrayList<>();
            for (int i = 0; i < this.listHDN.size(); i++) {
                if (this.listHDN.get(i).getDate().indexOf(this.searchHDNText.getText()) != -1) {
                    newListHDN.add(this.listHDN.get(i));
                }
            }
            this.hdnTableModel.setRowCount(0);
            for (int i = 0; i < newListHDN.size(); i++) {
                this.hdnTableModel.addRow(new Object[]{
                    newListHDN.get(i).getID(),
                    newListHDN.get(i).getDate(),
                    newListHDN.get(i).getNameNCC(SupplierDAO.getInstance().selectAll()),
                    newListHDN.get(i).getNameEmp(EmployeeDAO.getInstance().selectAll()),
                    newListHDN.get(i).getAllMoney(listClothes, listCTDS)
                });
            }
        }
    }//GEN-LAST:event_searchHDNButtonActionPerformed

    private void resetListHDNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetListHDNButtonActionPerformed
        this.searchHDNText.setText("");
        this.listClothes = ClothesDAO.getInstance().selectAll();
        this.showListHDN();
    }//GEN-LAST:event_resetListHDNButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHDNButton;
    private javax.swing.JTable ctdsHDNTable;
    private javax.swing.JTextField dateHDNText;
    private javax.swing.JTable hdnTable;
    private javax.swing.JTextField idHDNText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton moreProHDNButton;
    private javax.swing.JTextField nameProHDNText;
    private javax.swing.JTextField nccText;
    private javax.swing.JTextField numberHDNText;
    private javax.swing.JButton resetHDNButton;
    private javax.swing.JButton resetListHDNButton;
    private javax.swing.JButton searchHDNButton;
    private javax.swing.JTextField searchHDNText;
    private javax.swing.JTextField staffHDNText;
    // End of variables declaration//GEN-END:variables
}
