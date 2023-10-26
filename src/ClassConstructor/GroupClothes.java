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
public class GroupClothes {
    private int id;
    private String nameGroup;
    
    public GroupClothes(){};
    public GroupClothes(int id,String name){
        this.id=id;
        this.nameGroup=name;
    }
    
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.nameGroup;
    }
    public void changePropeties(String newName){
        this.nameGroup= newName;
    }
    public void setID(int id){
        this.id=id;
    }
    public void setNameGroup(String name){
        this.nameGroup=name;
    }
}
