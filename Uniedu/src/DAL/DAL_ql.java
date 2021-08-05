/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DaiHoc;
import DTO.DiemtrungBinh;
import DTO.HocSinh;
import DTO.LoaiTaiKhoan;
import DTO.LuuTru;
import DTO.Mon;
import DTO.Nghanh;
import DTO.Nghanh_dh;
import DTO.tk_hs;
import GUI.Admin;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAL_ql {
    private static DAL_ql instance;
    private DAL_ql(){
    
    }
    public static DAL_ql Instance(){
        if(instance==null) {
            instance=new DAL_ql();
            System.out.println("oke");
        }
        return instance;
    }
    //phan dang nhap
    
    public HocSinh getHs_tk(int id){
        
        for(HocSinh i : DBHelper.Instance().GetRecordsHs()){
            if(i.getIdLoaiTk_hs()==id) return i;
        }
        return new HocSinh();
    }
    public HocSinh GetHsTheoId(int id){
        for(HocSinh i : DBHelper.Instance().GetRecordsHs()){
            if(i.getIdHs()==id) return i;
        }
        return new HocSinh();
    }
    public DTO.Admin getAdmin(int id){
        for(DTO.Admin i: DBHelper.Instance().GetRecordsAdmin())
            if(i.getIdLoaiTk_admin()==id) return i;
        return new DTO.Admin();
    }
    public LoaiTaiKhoan getTk(String name,String pass){
        LoaiTaiKhoan ltk= new LoaiTaiKhoan();
        for(LoaiTaiKhoan i:DBHelper.Instance().GetRecordsLtk())
            if(i.getTen().equals(name)&&i.getPass().equals(pass)) ltk=i;
        return ltk;
    }
    
    //phan cap nhat diem
    

    public ArrayList<DiemtrungBinh> getDiembyNam(int nam,int id){
        ArrayList<DiemtrungBinh> dtb=new ArrayList<>();
        for(DiemtrungBinh i : DBHelper.Instance().GetRecordsDiemtb()){
            if(i.getNam()==nam&&i.getHs_d()==id) dtb.add(i);
        }
        return dtb;
    }
    public Mon getMon(String s){
        Mon m=new Mon();
        int n=0;
        for(Mon i : DBHelper.Instance().GetRecordsMon()){
            if(i.getTen().equals(s)) m=i;
        }
        return m;
    }
    public void AddDiem(DiemtrungBinh dtb){
        String query;
        query="INSERT into DiemTb (DiemK1,DiemK2,idSubject,idStudent,nam)"+"values("+dtb.getDiem1()+","+dtb.getDiem2()+","+dtb.getSb_d()+","+dtb.getHs_d()+","+dtb.getNam()+");";
        DBHelper.Instance().ExcuteUpdate(query);
    }

    public void EditDiem(DiemtrungBinh dtb){
        String query ="Update DiemTb set DiemK1="+dtb.getDiem1()+", DiemK2="+dtb.getDiem2()+" where idDiemTb = "+dtb.getIdDiem();
        DBHelper.Instance().ExcuteUpdate(query);
    }
    //phan du doan
    
    
    //phan ho so
    
    public void Ediths(String Ten,String city,String truong,int id){
        String query="Update Student set Name='"+Ten+"', city ='"+city+"', truong='"+truong+"' where idStudent = "+Integer.toString(id);
        DBHelper.Instance().ExcuteUpdate(query);
    }
    
    
    //phan dang ki
    
    public void addTk(LoaiTaiKhoan t){
        String query="INSERT into LoaiTaiKhoan(VaiTro,ten,pass)"+"values('"+t.getRole()+"','"+t.getTen()+"','"+t.getPass()+"');";
        DBHelper.Instance().ExcuteUpdate(query);    
    }
    public void addhs(HocSinh hs){
        String query="INSERT into Student(Name,Lop,city,truong,idLoaiTaiKhoan)"+"values('"+hs.getTen()+"',"+hs.getLop()+",'"+hs.getCity()+"','"+hs.getTruong()+"',"+hs.getIdLoaiTk_hs()+");";
        DBHelper.Instance().ExcuteUpdate(query);
    }
    public void addAdmin(DTO.Admin ad){
        String query="INSERT into Admin(Ten,Age,idLoaiTaiKhoan)"+"values('"+ad.getTen()+"',"+ad.getTuoi()+","+ad.getIdLoaiTk_admin()+");";
        DBHelper.Instance().ExcuteUpdate(query);
    }
    
    //phan chuc nang admin
    
      // phan hoc sinh
    public ArrayList<tk_hs> getTk_hs(){
        ArrayList<LoaiTaiKhoan> ltk=DBHelper.Instance().GetRecordsLtk();
        ArrayList<HocSinh> hs=DBHelper.Instance().GetRecordsHs();
        ArrayList<tk_hs> tk=new ArrayList<tk_hs>();
        for(LoaiTaiKhoan i:ltk)
            for(HocSinh j: hs){
                if(i.getIdLoaiTk()==j.getIdLoaiTk_hs()) {
                   tk_hs a= new tk_hs();
                   a.setId_tk(i.getIdLoaiTk());
                   a.setAccount(i.getTen());
                   a.setPass(i.getPass());
                   a.setTen(j.getTen());
                   a.setCity(j.getCity());
                   a.setTruong(j.getTruong());
                   a.setLop(j.getLop());
                   a.setLandoi(j.getLanDoi());
                   tk.add(a);
                }
            }
        return tk;
    }
    public void XoaTk(LoaiTaiKhoan ltk){
        String query="Delete from LoaiTaiKhoan where idLoaiTaiKhoan="+ltk.getIdLoaiTk();
        DBHelper.Instance().ExcuteUpdate(query);
    }
       
      //phan truong
    public String GetNghanh(int id){
        String s=" ";
        for(Nghanh i:DBHelper.Instance().GetRecordsNghanh())
            if(i.getIdNganh()==id) return i.getTen();
        return s;
    }
//    
//    public int GetIdNghanh(String s){
//        int n=0;
//        for(Nghanh i:DBHelper.Instance().GetRecordsNghanh())
//            if(i.getTen().equals(s)) n=i.getIdNganh();
//        return n;
//    }
    
    public ArrayList<String> GetAllNghanh(DaiHoc dh){
        ArrayList<String> s= new ArrayList<>();
        for(Nghanh_dh i:DBHelper.Instance().GetRecordsNghanhDaiHoc()){
            if(i.getIdDh()==dh.getIdTruong()) s.add(GetNghanh(i.getIdNghanh()));
        }
        return s;
    }
    
    public void AddTruong(DaiHoc dh){
         String query="INSERT into University(Name,city,SoNghanh,DiemSan,Mota)"+"values('"+dh.getTen()+"','"+dh.getCity()+"',"+dh.getSoNghanh()+","+dh.getDiemsan()+",'"+dh.getMota()+"');";
         DBHelper.Instance().ExcuteUpdate(query);
    }
    
    public void EditDaihoc(DaiHoc dh){
        String query ="Update University set Mota='"+dh.getMota()+"', DiemSan="+dh.getDiemsan()+" where idUniveristy = "+dh.getIdTruong();
        DBHelper.Instance().ExcuteUpdate(query);
    }
    
    public void AddNghanh_dh(Nghanh_dh dh){
        String query="INSERT into Nghanh_dai_hoc(idDanhSachNghanh,idUniveristy)"+"values("+dh.getIdNghanh()+","+dh.getIdDh()+");";
         DBHelper.Instance().ExcuteUpdate(query);
    }
    
    // phan luu tru hoc sinh
    public void Addtruongyeuthich(LuuTru lt){
        String query="INSERT into Store(idStudent,idUniveristy)"+"values("+lt.getIdHs()+","+lt.getIdDh()+");";
        DBHelper.Instance().ExcuteUpdate(query);
    }
    public DaiHoc GetDaiHocTheoId(int id){
        DaiHoc dh=new DaiHoc();
        for(DaiHoc i:DBHelper.Instance().GetRecordsDaiHoc())
            if(i.getIdTruong()==id) dh=i;
        return dh;
    }
    public void XoaTruongThich(LuuTru lt){
        String query="Delete from Store where idStudent="+lt.getIdHs()+" and idUniveristy= "+lt.getIdDh();
        DBHelper.Instance().ExcuteUpdate(query);
    }
}
