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
public class DiemMon {
    private String mon;
    private String diemki1;
    private String diemki2;
    private int id;

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getDiemki1() {
        return diemki1;
    }

    public void setDiemki1(String diemki1) {
        this.diemki1 = diemki1;
    }

    public String getDiemki2() {
        return diemki2;
    }

    public void setDiemki2(String diemki2) {
        this.diemki2 = diemki2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DiemMon{" + "mon=" + mon + ", diemki1=" + diemki1 + ", diemki2=" + diemki2 + ", id=" + id + '}';
    }

    
    
}
