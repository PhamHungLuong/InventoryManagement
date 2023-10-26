/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassConstructor;

import DAO.EmployeeDAO;
import HandleData.IOfile;
import java.util.ArrayList;

/**
 *
 * @author cccccccccccccccccccc
 */
public class HoaDonNhap {

    private String id;
    private String date;
    private int IDnhaCungCap;
    private String nhanVien;

    public HoaDonNhap() {
    }

    ;
    public HoaDonNhap(String id, String date, int ncc, String nhanVien) {
        this.id = id;
        this.date = date;
        this.IDnhaCungCap = ncc;
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

    public int getNCCID() {
        return this.IDnhaCungCap;
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

    public void setNhaCungCap(int nhaCungCap) {
        this.IDnhaCungCap = nhaCungCap;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getNameNCC(ArrayList<NhaCungCap> list) {
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            if (this.IDnhaCungCap == list.get(i).getID()) {
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
