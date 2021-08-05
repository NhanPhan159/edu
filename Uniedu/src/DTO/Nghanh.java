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
public class Nghanh {
 private int   idNganh;
 private String ten;
 private float logic;
 private float xahoi;
 private float ghinho;
 private float truyendat;

    public int getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(int idNganh) {
        this.idNganh = idNganh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getLogic() {
        return logic;
    }

    public void setLogic(float logic) {
        this.logic = logic;
    }

    public float getXahoi() {
        return xahoi;
    }

    public void setXahoi(float xahoi) {
        this.xahoi = xahoi;
    }

    public float getGhinho() {
        return ghinho;
    }

    public void setGhinho(float ghinho) {
        this.ghinho = ghinho;
    }

    public float getTruyendat() {
        return truyendat;
    }

    public void setTruyendat(float truyendat) {
        this.truyendat = truyendat;
    }

    @Override
    public String toString() {
        return "Nghanh{" + "idNganh=" + idNganh + ", ten=" + ten + ", logic=" + logic + ", xahoi=" + xahoi + ", ghinho=" + ghinho + ", truyendat=" + truyendat + '}';
    }

   
 
}
