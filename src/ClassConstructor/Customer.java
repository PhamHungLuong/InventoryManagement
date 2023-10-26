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
public class Customer {
    private int id;
    private String name;
    private String phone;
    private String address;
    
    public Customer(){}
    public Customer(int id,String name,String phone,String address){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }
    
    public int getID(){
        return this.id;
    }
    public String getName(){
       return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getAddress(){
        return this.address;
    }
    
    public void setID(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setAddress(String add){
        this.address=add;
    }
    public void changeInfor(String newName,String newPhone,String newAddress ){
        this.name=newName;
        this.phone= newPhone;
        this.address= newAddress;
    }
}
