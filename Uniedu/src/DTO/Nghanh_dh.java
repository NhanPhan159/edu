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
public class Nghanh_dh {
    private int idNghanh;
    private int idDh;

    public int getIdNghanh() {
        return idNghanh;
    }

    public void setIdNghanh(int idNghanh) {
        this.idNghanh = idNghanh;
    }

    public int getIdDh() {
        return idDh;
    }

    public void setIdDh(int idDh) {
        this.idDh = idDh;
    }

    @Override
    public String toString() {
        return "Nghanh_dh{" + "idNghanh=" + idNghanh + ", idDh=" + idDh + '}';
    }
    
}
