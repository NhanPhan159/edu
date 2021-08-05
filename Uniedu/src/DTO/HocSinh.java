/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class HocSinh {
    private int idHs;
    private String ten;
    private int lop;
    private String city ;
    private String truong;
    private int idLoaiTk_hs;
    private int LanDoi;
    
    public int getIdHs() {
        return idHs;
    }

    public void setIdHs(int idHs) {
        this.idHs = idHs;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTruong() {
        return truong;
    }

    public void setTruong(String truong) {
        this.truong = truong;
    }

    public int getIdLoaiTk_hs() {
        return idLoaiTk_hs;
    }

    public void setIdLoaiTk_hs(int idLoaiTk_hs) {
        this.idLoaiTk_hs = idLoaiTk_hs;
    }

    public int getLanDoi() {
        return LanDoi;
    }

    public void setLanDoi(int LanDoi) {
        this.LanDoi = LanDoi;
    }

    @Override
    public String toString() {
        return "HocSinh{" + "idHs=" + idHs + ", ten=" + ten + ", lop=" + lop + ", city=" + city + ", truong=" + truong + ", idLoaiTk_hs=" + idLoaiTk_hs + ", LanDoi=" + LanDoi + '}';
    }
    
    
}
