/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author Nham Ngo
 */
public abstract class BanSachDAO<Entities,Interger> {
    
    abstract public void insert(Entities entity);

    abstract public void update(Entities entity);

    abstract public void delete(Interger id);

    abstract public Entities selectById(Interger id);

    abstract public List<Entities> selectAll();

    abstract protected List<Entities> selectBySql(String sql, Object... args);
}
