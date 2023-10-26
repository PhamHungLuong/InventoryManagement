/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassConstructor;

import java.util.ArrayList;

/**
 *
 * @author cccccccccccccccccccc
 */
public class CTDS {

    private String idHD;
    private int idClothes;
    private int soluong;
    
    public CTDS(){};
    public CTDS(String idHD, int id, int soluong) {
        this.idHD = idHD;
        this.idClothes = id;
        this.soluong = soluong;
    }

    public String getIdHD() {
        return this.idHD;
    }

    public int getIdClothes() {
        return this.idClothes;
    }

    public int getNumberCount() {
        return this.soluong;
    }

    public void addNumber(int number) {
        this.soluong = this.soluong + number;
    }

    public int getMoney(ArrayList<Clothes> listClothes) {
        int money = 0;
        for (int i = 0; i < listClothes.size(); i++) {
            if (this.idClothes == listClothes.get(i).getId()) {
                if (this.soluong >= 100) {
                    money = money + this.soluong * listClothes.get(i).getGiaBan() - 5 * this.soluong * listClothes.get(i).getGiaBan() / 100;
                } else {
                    money = money + this.soluong * listClothes.get(i).getGiaBan();
                }
            }
        }
        return money;
    }

    public int getCostMoney(ArrayList<Clothes> listClothes) {
        int money = 0;
        for (int i = 0; i < listClothes.size(); i++) {
            if (this.idClothes == listClothes.get(i).getId()) {
                money = money + this.soluong * listClothes.get(i).getGiaGoc();
            }
        }
        return money;
    }

    public String getNameClothes(ArrayList<Clothes> listClothes) {
        String nameClothes = "";
        for (int i = 0; i < listClothes.size(); i++) {
            if (this.idClothes == listClothes.get(i).getId()) {
                nameClothes = listClothes.get(i).getTenSP();
                break;
            }
        }
        return nameClothes;
    }
    public void setIdHD(String x){
        this.idHD=x;
    }
    public void setIdClothes(int x){
        this.idClothes=x;
    }
    public void setSoluong(int x){
        this.soluong=x;
    }
}
