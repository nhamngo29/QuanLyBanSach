/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DataProvider;
import POJO.NguoiDung;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nham Ngo
 */
public class NguoiDungDAO extends BanSachDAO<NguoiDung, Integer>{
    String INSERT_SQL = "INSERT INTO NguoiDung(TenDangNhap, MatKhau, HoTen, Email, DiaChi, NgaySinh, GioiTinh)VALUES(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NguoiDung SET TenDangNhap=?, MatKhau=?, HoTen=?, Email=?, DiaChi=?, NgaySinh=?, GioiTinh =? where ND_ID = ?";
    String DELETE_SQL = "DELETE FROM NguoiDung WHERE ND_ID =?";
    String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    String SELETE_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MaNV =?";
    String SP_LOGIN="{CALL SP_Login(?,?)}";

    public NguoiDung Login(String UserName,String Password)
    {
        List<NguoiDung> lnd=selectBySql(SP_LOGIN, UserName,Password);
        if(lnd.size()==0)
        {
            
            return null;
        }
        return lnd.get(0);
    }
    @Override
    public void insert(NguoiDung entity) {
        try {
            DataProvider.update(INSERT_SQL,entity.getTenDangNhap(),entity.getMatKhau(), entity.getHoTen(),entity.getEmail(),entity.getDiaChi(),entity.getNgaySinh(),entity.getGioiTinh());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(NguoiDung entity) {
        try {
            DataProvider.update(UPDATE_SQL, entity.getTenDangNhap(),entity.getMatKhau(), entity.getHoTen(),entity.getEmail(),entity.getDiaChi(),entity.getNgaySinh(),entity.getGioiTinh(),entity.getND_ID());
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
    public NguoiDung selectById(Integer id) {
        List<NguoiDung> lnd=selectBySql(SELETE_BY_ID_SQL,id);
        if(lnd==null)
            return null;
        return lnd.get(0);
    }

    @Override
    public List<NguoiDung> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    protected List<NguoiDung> selectBySql(String sql, Object... args) {
       List<NguoiDung> a=new ArrayList<NguoiDung>();
        try {
            ResultSet rs = DataProvider.query(sql, args);
            while (rs.next()) {
               NguoiDung nd=new NguoiDung();
               nd.setND_ID(rs.getInt("ND_ID"));
               nd.setTenDangNhap(rs.getString("TenDangNhap"));
               nd.setMatKhau(rs.getString("MatKhau"));
               nd.setHoTen(rs.getString("HoTen"));
               nd.setEmail(rs.getString("Email"));
               nd.setDiaChi(rs.getString("DiaChi"));
               nd.setNgaySinh(String.valueOf(rs.getDate("NgaySinh")));
               nd.setGioiTinh(rs.getString("GioiTinh"));
               a.add(nd);
               System.out.println(nd.getHoTen());
            }
            rs.getStatement().getConnection().close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    

   
    
    
}
