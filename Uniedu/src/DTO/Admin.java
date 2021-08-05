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
public class Admin {
    private int idAdmin;
    private int idLoaiTk_admin;
    private int tuoi;
    private String ten;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdLoaiTk_admin() {
        return idLoaiTk_admin;
    }

    public void setIdLoaiTk_admin(int idLoaiTk_admin) {
        this.idLoaiTk_admin = idLoaiTk_admin;
    }


    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "Admin{" + "idAdmin=" + idAdmin + ", idLoaiTk_admin=" + idLoaiTk_admin + ", tuoi=" + tuoi + ", ten=" + ten + '}';
    }
    
}
