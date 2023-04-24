/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.LoaiSach;
import POJO.NguoiDung;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nham Ngo
 */
public class LoaiSachDAO extends BanSachDAO<LoaiSach, Integer> {

    String INSERT_SQL = "INSERT INTO LoaiSach(Ten, MoTa) VALUES(?,?)";
    String UPDATE_SQL = "UPDATE LoaiSach SET Ten=?, MoTa=? where LS_ID = ?";
    String DELETE_SQL = "DELETE FROM LoaiSach WHERE LS_ID =?";
    String SELECT_ALL_SQL = "SELECT * FROM LoaiSach";
    String SELETE_BY_ID_SQL = "SELECT * FROM LoaiSach WHERE LS_ID =?";
    @Override
    public void insert(LoaiSach entity) {
        try {
            DataProvider.update(INSERT_SQL,entity.getTen(),entity.getMoTa());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LoaiSach entity) {
       try {
            DataProvider.update(UPDATE_SQL, entity.getTen(),entity.getMoTa(),entity.getLS_ID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
         try {
            DataProvider.update(DELETE_SQL,id);
        } catch (Exception e) {
        }
    }
    @Override
    public LoaiSach selectById(Integer id) {
        List<LoaiSach> lnd=selectBySql(SELETE_BY_ID_SQL,id);
        if(lnd==null)
            return null;
        return lnd.get(0);
    }

    @Override
    public List<LoaiSach> selectAll() {
      return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<LoaiSach> selectBySql(String sql, Object... args) {
       List<LoaiSach> a=new ArrayList<LoaiSach>();
        try {
            ResultSet rs = DataProvider.query(sql, args);
            while (rs.next()) {
               LoaiSach nd=new LoaiSach();
               nd.setLS_ID(rs.getInt("LS_ID"));
               nd.setTen(rs.getString("Ten"));
               nd.setMoTa(rs.getString("MoTa"));
               a.add(nd);
            }
            rs.getStatement().getConnection().close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    
}
