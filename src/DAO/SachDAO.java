/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.LoaiSach;
import POJO.Sach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdk.jfr.DataAmount;

/**
 *
 * @author Nham Ngo
 */
public class SachDAO extends BanSachDAO<Sach, Integer>{

    String INSERT_SQL = "INSERT INTO Sach(TieuDe, TacGia,NamXuatBan,TheLoai,MoTa) VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Sach SET TieuDe=?, TacGia=?, NamXuatBan=?, TheLoai=?, MoTa=? where S_ID = ?";
    String DELETE_SQL = "DELETE FROM Sach WHERE S_ID =?";
    String SELECT_ALL_SQL = "SELECT * FROM Sach";
    String SELETE_BY_ID_SQL = "SELECT * FROM Sach WHERE S_ID =?";
    @Override
    public void insert(Sach entity) {
        try {
            DataProvider.update(INSERT_SQL, entity.getTieuDe(),entity.getTacGia(),entity.getNamXuatBan(),entity.getTheLoai(),entity.getMoTa());
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Sach entity) {
        try {
            DataProvider.update(UPDATE_SQL, entity.getTieuDe(),entity.getTacGia(),entity.getNamXuatBan(),entity.getTheLoai(),entity.getMoTa(),entity.getS_ID());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            DataProvider.update(DELETE_SQL, id);
        } catch (Exception e) {
        }
    }

    @Override
    public Sach selectById(Integer id) {
        try {
            List<Sach> s=selectBySql(SELETE_BY_ID_SQL, id);
            return s.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Sach> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }
    public LoaiSach getTheLoaiByID(int id)
    {
        try {
            LoaiSachDAO dao=new LoaiSachDAO();
            return dao.selectById(id);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> a=new ArrayList<Sach>();
        try {
            ResultSet rs = DataProvider.query(sql, args);
            while (rs.next()) {
               Sach nd=new Sach();
               nd.setS_ID(rs.getInt("S_ID"));
               nd.setTieuDe(rs.getString("TieuDe"));
               nd.setTacGia(rs.getString("TacGia"));
               nd.setNamXuatBan(rs.getInt("NamXuatBan"));
               nd.setTheLoai(rs.getInt("TheLoai"));
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
