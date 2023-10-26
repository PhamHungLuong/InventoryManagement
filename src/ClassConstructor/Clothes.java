/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassConstructor;

import DAO.GroupClothesDAO;
import HandleData.*;
import java.util.ArrayList;

/**
 *
 * @author cccccccccccccccccccc
 */
public class Clothes {

    private int id;
    private String tenSp;
    private String size;
    private String mau;
    private int giaBan;
    private int giaGoc;
    private int slHienTai;
    private int idDistrict;
    private int idNhom;

    public Clothes() {
    }

    public Clothes(int id, String tenSp, String size, String mau, int giaBan, int giaGoc, int slHT, int district, int idNhom) {
        this.id = id;
        this.tenSp = tenSp;
        this.size = size;
        this.mau = mau;
        this.giaBan = giaBan;
        this.giaGoc = giaGoc;
        this.slHienTai = slHT;
        this.idDistrict = district;
        this.idNhom = idNhom;
    }

    public Clothes(int id, String tenSp, String size, String mau, int giaBan, int giaGoc, int district, int idNhom) {
        this.id = id;
        this.tenSp = tenSp;
        this.size = size;
        this.mau = mau;
        this.giaBan = giaBan;
        this.giaGoc = giaGoc;
        this.idDistrict = district;
        this.idNhom = idNhom;
    }

    public int getId() {
        return this.id;
    }

    public String getTenSP() {
        return this.tenSp;
    }

    public String getSize() {
        return this.size;
    }

    public String getMau() {
        return this.mau;
    }

    public int getGiaBan() {
        return this.giaBan;
    }

    public int getSLHienTai() {
        return this.slHienTai;
    }

    public int getIdDistrict() {
        return this.idDistrict;
    }

    public int getGiaGoc() {
        return this.giaGoc;
    }

    public int getIdNhom() {
        return this.idNhom;
    }

    public String getNameGroup(ArrayList<GroupClothes> list) {
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == this.getIdNhom()) {
                name = list.get(i).getName();
            }
        }
        return name;
    }

    public String getNameDistrict(ArrayList<Arena> list) {
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            if (this.idDistrict == list.get(i).getID()) {
                name = list.get(i).getName();
            }
        }
        return name;
    }

    public void upNumber(int number) {
        this.slHienTai = this.slHienTai + number;
    }

    public void downNumber(int number) {
        this.slHienTai = this.slHienTai - number;
    }

    public void changeInforOfProduct(String newName, String newSize, String newColor, int newPrice, int newOldPrice, int newDistrict, String newGroup) {
        this.tenSp = newName;
        this.size = newSize;
        this.mau = newColor;
        this.giaBan = newPrice;
        this.giaGoc = newOldPrice;
        this.idDistrict = newDistrict;
        int newIdNhom = 0;
        for (int i = 0; i < GroupClothesDAO.getInstance().selectAll().size(); i++) {
            if (newGroup.compareTo(GroupClothesDAO.getInstance().selectAll().get(i).getName()) == 0) {
                this.idNhom = GroupClothesDAO.getInstance().selectAll().get(i).getID();
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenSp(String tsp) {
        this.tenSp = tsp;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMau(String cl) {
        this.mau = cl;
    }

    public void setGiaBan(int gb) {
        this.giaBan = gb;
    }

    public void setSLHienTai(int slht) {
        this.slHienTai = slht;
    }

    public void setArea(int id) {
        this.idDistrict = id;
    }

    public void setGiaGoc(int gg) {
        this.giaGoc = gg;
    }

    public void setIdNhom(int idNhom) {
        this.idNhom = idNhom;
    }

}
