/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassConstructor;

/**
 *
 * @author cccccccccccccccccccc
 */
public class NhanVien {

    private String id;
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private String ngaySinh;
    private String user;
    private String password;
    private String position;
    private String active;
    
    public NhanVien(){};
    public NhanVien(String id, String name, String sex,String que,String birth,String user,String pass,String position,String active) {
        this.id = id;
        this.hoTen = name;
        this.gioiTinh = sex;
        this.queQuan=que;
        this.ngaySinh=birth;
        this.user=user;
        this.password=pass;
        this.position=position;
        this.active=active;
    }

    public String getID() {
        return this.id;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }
    public String getQue(){
        return this.queQuan;
    }
    public String getBirthDay(){
        return this.ngaySinh;
    }
    public String getUser(){
        return this.user;
    }
    public String getPass(){
        return this.password;
    }
    public String getPosition(){
        return this.position;
    }
    public String getActive(){
        return this.active;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setGioiTinh(String gt) {
        this.gioiTinh = gt;
    }
    public  void setQue(String que){
        this.queQuan=que;
    }
    public void setBirth(String birth){
        this.ngaySinh=birth;        
    }
    public void setActive(String act){
        this.active=act;
    }
    public void setUser(String user){
        this.user=user;
    }
    public void setPass(String pass){
        this.password=pass;
    }
    public void setPos(String pos){
        this.position=pos;
    }
    public void changeInforStaff(String newName, String newSex , String newHome,String newBirth,String newUser,String newPass,String newPos) {
        this.hoTen = newName;
        this.gioiTinh = newSex;
        this.queQuan=newHome;
        this.ngaySinh=newBirth;
        this.user=newUser;
        this.password=newPass;
        this.position=newPos;
    }
}
