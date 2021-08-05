/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import java.util.Date;
/**
 *
 * @author DELL
 */
public class DiemtrungBinh {
    private int idDiem;
    private int nam;
    private float diem1;
    private float diem2;
    private int sb_d;
    private int hs_d;
    

    public int getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(int idDiem) {
        this.idDiem = idDiem;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public int getSb_d() {
        return sb_d;
    }

    public void setSb_d(int sb_d) {
        this.sb_d = sb_d;
    }

    public int getHs_d() {
        return hs_d;
    }

    public void setHs_d(int hs_d) {
        this.hs_d = hs_d;
    }

    @Override
    public String toString() {
        return "DiemtrungBinh{" + "idDiem=" + idDiem + ", nam=" + nam + ", diem1=" + diem1 + ", diem2=" + diem2 + ", sb_d=" + sb_d + ", hs_d=" + hs_d + '}';
    }

    
    
    
}
