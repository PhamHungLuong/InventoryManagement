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
public class Arena {
    private int id;
    private String nameArena;
    
    public Arena(){}
    public Arena(int id,String name){
        this.id=id;
        this.nameArena=name;
    }
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.nameArena;
    }
    public void setID(int id){
        this.id=id;
    }
    public void setName(String name){
        this.nameArena=name;
    }
    public void changeInforArena(String newName){
        this.nameArena=newName;
    }
    public int getNumberProduct(ArrayList<Clothes> list){
        int count=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getIdDistrict()==this.id){
                count=count+list.get(i).getSLHienTai();
            }
        }
        return count;
    }
}
