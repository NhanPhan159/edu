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
public class tk_hs {
    private int id_tk;
    private String account;
    private String pass;
    private String ten;
    private String truong;
    private String city;
    private int lop;
    private int landoi;

    public int getId_tk() {
        return id_tk;
    }

    public void setId_tk(int id_tk) {
        this.id_tk = id_tk;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTruong() {
        return truong;
    }

    public void setTruong(String truong) {
        this.truong = truong;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public int getLandoi() {
        return landoi;
    }

    public void setLandoi(int landoi) {
        this.landoi = landoi;
    }

    @Override
    public String toString() {
        return "tk_hs{" + "id_tk=" + id_tk + ", account=" + account + ", pass=" + pass + ", ten=" + ten + ", truong=" + truong + ", city=" + city + ", lop=" + lop + ", landoi=" + landoi + '}';
    }
    
    
}
