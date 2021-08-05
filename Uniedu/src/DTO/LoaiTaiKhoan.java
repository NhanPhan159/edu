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
public class LoaiTaiKhoan {
    private int idLoaiTk;
    private String ten;
    private String pass;
    private String role;

    public int getIdLoaiTk() {
        return idLoaiTk;
    }

    public void setIdLoaiTk(int idLoaiTk) {
        this.idLoaiTk = idLoaiTk;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoaiTaiKhoan{" + "idLoaiTk=" + idLoaiTk + ", ten=" + ten + ", pass=" + pass + ", role=" + role + '}';
    }

   
    
    
}
