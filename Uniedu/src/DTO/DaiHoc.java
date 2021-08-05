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
public class DaiHoc {
    private int idTruong;
    private String ten;
    private String city;
    private String mota;
    private int soNghanh;
    private float diemsan;

    public int getIdTruong() {
        return idTruong;
    }

    public void setIdTruong(int idTruong) {
        this.idTruong = idTruong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoNghanh() {
        return soNghanh;
    }

    public void setSoNghanh(int soNghanh) {
        this.soNghanh = soNghanh;
    }

    public float getDiemsan() {
        return diemsan;
    }

    public void setDiemsan(float diemsan) {
        this.diemsan = diemsan;
    }

    @Override
    public String toString() {
        return "DaiHoc{" + "idTruong=" + idTruong + ", ten=" + ten + ", city=" + city + ", mota=" + mota + ", soNghanh=" + soNghanh + ", diemsan=" + diemsan + '}';
    }
    
}
