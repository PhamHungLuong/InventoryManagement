/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassConstructor;

import HandleData.IOfile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cccccccccccccccccccc
 */
public class HoaDonXuat {

    private String id;
    private String date;
    private int customerID;
    private String nhanVien;

    public HoaDonXuat() {
    }

    ;
    public HoaDonXuat(String id, String date, int customer, String nhanVien) {
        this.id = id;
        this.date = date;
        this.customerID = customer;
        this.nhanVien = nhanVien;
    }

    public int getAllMoney(ArrayList<Clothes> listClothes, ArrayList<CTDS> listItems) {
        int allMoney = 0;
        for (int i = 0; i < listItems.size(); i++) {
            if (this.id.compareTo(listItems.get(i).getIdHD()) == 0) {
                allMoney = allMoney + listItems.get(i).getMoney(listClothes);
            }
        }
        return allMoney;
    }

    public String getID() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public int getCustommerID() {
        return this.customerID;
    }

    public String getStaff() {
        return this.nhanVien;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCustomer(int customer) {
        this.customerID = customer;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }
    public String getNameCus(ArrayList<Customer> list) {
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            if (this.customerID == list.get(i).getID()) {
                name = list.get(i).getName();
            }
        }
        return name;
    }
        public String getNameEmp(ArrayList<NhanVien> list) {
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            if (this.nhanVien.compareTo(list.get(i).getID()) == 0) {
                name = list.get(i).getHoTen();
            }
        }
        return name;
    }
}
