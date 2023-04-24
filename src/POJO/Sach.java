/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Nham Ngo
 */
public class Sach {
    int S_ID;
    String TieuDe;
    String TacGia;
    int NamXuatBan;
    int TheLoai;
    String MoTa;

    public Sach(int S_ID, String TieuDe, String TacGia, int NamXuatBan, int TheLoai, String MoTa) {
        this.S_ID = S_ID;
        this.TieuDe = TieuDe;
        this.TacGia = TacGia;
        this.NamXuatBan = NamXuatBan;
        this.TheLoai = TheLoai;
        this.MoTa = MoTa;
    }

    public Sach(String TieuDe, String TacGia, int NamXuatBan, int TheLoai, String MoTa) {
        this.TieuDe = TieuDe;
        this.TacGia = TacGia;
        this.NamXuatBan = NamXuatBan;
        this.TheLoai = TheLoai;
        this.MoTa = MoTa;
    }
    
    public Sach() {
    }

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int S_ID) {
        this.S_ID = S_ID;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String TieuDe) {
        this.TieuDe = TieuDe;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }

    public int getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(int TheLoai) {
        this.TheLoai = TheLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}
