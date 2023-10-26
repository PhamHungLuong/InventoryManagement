/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author QUÂN BÙI
 */
public interface DAOInterface<Obj> {
    public boolean Add(Obj o);
    public boolean Delete(Obj o);
    public boolean Update(Obj o);
    public ArrayList<Obj> selectAll();
    public ArrayList<Obj> selectByCondition(String condition);
}
