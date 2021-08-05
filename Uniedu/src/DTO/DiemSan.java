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
public class DiemSan {
    private int idDiemsan;
    private float diem;
    private Date nam;
    private int id_dh_ds;

    public int getIdDiemsan() {
        return idDiemsan;
    }

    public void setIdDiemsan(int idDiemsan) {
        this.idDiemsan = idDiemsan;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public Date getNam() {
        return nam;
    }

    public void setNam(Date nam) {
        this.nam = nam;
    }

    public int getId_dh_ds() {
        return id_dh_ds;
    }

    public void setId_dh_ds(int id_dh_ds) {
        this.id_dh_ds = id_dh_ds;
    }
    
}
