/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_ql;
import DAL.DBHelper;
import DTO.BangChiSo;
import DTO.DaiHoc;
import DTO.DiemMon;
import DTO.DiemtrungBinh;
import DTO.HocSinh;
import DTO.LoaiTaiKhoan;
import DTO.LuuTru;
import DTO.Mon;
import DTO.Nghanh;
import DTO.Nghanh_dh;
import DTO.tk_hs;
import java.util.ArrayList;
import java.math.*;
import java.time.Year;

/**
 *
 * @author DELL
 */
public class BLL_ql {
    private static BLL_ql instance;
    private BLL_ql(){
    
    }
    public static BLL_ql Instance(){
        if(instance==null) {
            instance=new BLL_ql();
           
        }
        return instance;
    }
    //phan dang nhap
    public String getrole(String name,String pass){
        String s="sai";
        LoaiTaiKhoan ltk=DAL_ql.Instance().getTk(name, pass);
        
        if(ltk.getIdLoaiTk()!=0)
            return ltk.getRole();
        else return s;
    }
    public HocSinh geths(String name,String pass){
       LoaiTaiKhoan ltk=DAL_ql.Instance().getTk(name, pass);
       return DAL_ql.Instance().getHs_tk(ltk.getIdLoaiTk());
    }
    public int getId(String name,String pass){
        LoaiTaiKhoan ltk=DAL_ql.Instance().getTk(name, pass);
        return ltk.getIdLoaiTk();
    }
    public DTO.Admin getadmin(String name,String pass){
        LoaiTaiKhoan ltk=DAL_ql.Instance().getTk(name, pass);
        return DAL_ql.Instance().getAdmin(ltk.getIdLoaiTk());
    }
    public int GetLanDoi(int id){
        return DAL_ql.Instance().GetHsTheoId(id).getLanDoi();
    }
     // phan ho so
    public int getLop(int id){
        
       return DAL_ql.Instance().GetHsTheoId(id).getLop();
    }    
    public void Ediths(String Ten,String city,String truong,int id){
        DAL_ql.Instance().Ediths(Ten, city, truong, id);
    }
    
    // phan diem
    public ArrayList<DiemMon> getDiemMon(int nam,int id){
        
        ArrayList<DiemtrungBinh> dtb=DAL_ql.Instance().getDiembyNam(nam,id);
        ArrayList<Mon> mon=DBHelper.Instance().GetRecordsMon();
        ArrayList<DiemMon> dm= new ArrayList<>();
        for(Mon i : mon){
            for(DiemtrungBinh j : dtb){
                if(i.getIdMon()==j.getSb_d()){
                    DiemMon d=new DiemMon();
                    d.setMon(i.getTen());
                    d.setDiemki1( String.valueOf(j.getDiem1()));
                    d.setDiemki2(String.valueOf(j.getDiem2()));
                    d.setId(j.getIdDiem());
                    dm.add(d);
                }
                
            }
        }
        return dm;
    }
    
    public ArrayList<DiemMon> getdm(int nam,int id){
        ArrayList<DiemMon> dm= BLL_ql.Instance().getDiemMon(nam, id);
        ArrayList<Mon> m=DBHelper.Instance().GetRecordsMon();
        
        for(Mon i : m){
            int flat=1;
            for(DiemMon j : dm){
                if(i.getTen().equals(j.getMon())) flat=0;
            }
            if(flat==1) {
                DiemMon a=new DiemMon();
                a.setMon(i.getTen());
                a.setDiemki1(" ");
                a.setDiemki2(" ");
                a.setId(0);
                dm.add(a);
            }
        }
        return dm;
    }
    
    public int getidMon(String s){
       return DAL_ql.Instance().getMon(s).getIdMon();
    }
    
    
    
    public void Add(DiemtrungBinh d){

        if(d.getIdDiem()==0) DAL_ql.Instance().AddDiem(d);
        else {DAL_ql.Instance().EditDiem(d);}
        
    }
    
    // thuat toan du doan
    
    public float dtb(String d1,String d2){
        float diem1=Float.parseFloat(d1);
        float diem2=Float.parseFloat(d2);
        return (diem1+diem2*2)/3;
                
    }
    
    public float logic(ArrayList<DiemMon> d){
        float toan=0;
        float hoa=0;
        float ly=0;
        for(DiemMon i : d)
            if(i.getMon().equals("toan")) toan=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("ly")) ly=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("hoa")) hoa=dtb(i.getDiemki1(),i.getDiemki2());
        float logic=(toan*2+ly+hoa)/4;
        return logic;
    }
    public float xahoi(ArrayList<DiemMon> d){
        float van=0;
        float dia=0;
        float su=0;
        float cd=0;
        for(DiemMon i : d)
            if(i.getMon().equals("van")) van=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("dia")) dia=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("su")) su=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("GDCD")) cd=dtb(i.getDiemki1(),i.getDiemki2());
        float xahoi=(van*2+cd+dia+su)/5;
        return xahoi;
    }
    public float ghinho(ArrayList<DiemMon> d){
        float van=0;
        float dia=0;
        float su=0;
        float cd=0;
        float sinh=0;
        float ta=0;
        for(DiemMon i : d)
            if(i.getMon().equals("van")) van=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("dia")) dia=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("su")) su=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("gdcd")) cd=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("sinh")) sinh=dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("anh")) ta=dtb(i.getDiemki1(),i.getDiemki2());
        float ghinho=(van+ta+sinh+cd+dia+su)/6;
        return ghinho;
    }
    public float truyendat(ArrayList<DiemMon> d){
        float toan=0;
        float van=0;
        
        for(DiemMon i : d)
            if(i.getMon().equals("toan")) toan=BLL_ql.Instance().dtb(i.getDiemki1(),i.getDiemki2());
        for(DiemMon i : d)
            if(i.getMon().equals("van")) van=BLL_ql.Instance().dtb(i.getDiemki1(),i.getDiemki2());
        float truyendat=(toan+van)/2;
        return truyendat;
    }
    public BangChiSo nam1(ArrayList<DiemMon> d){
        BangChiSo bcs=new BangChiSo();
        bcs.setLogic(5*logic(d)/10);
        bcs.setXahoi(5*xahoi(d)/10);
        bcs.setTruyendat(5*truyendat(d)/10);
        bcs.setGhinho(5*ghinho(d)/10);
        return bcs;
                
    }
    public BangChiSo nam2(ArrayList<DiemMon> d1,ArrayList<DiemMon> d2){
        BangChiSo bcs=new BangChiSo();
        float lo=(logic(d1)+logic(d2)*2)/3;
        float xa=(xahoi(d1)+xahoi(d2)*2)/3;
        float tr=(truyendat(d1)+truyendat(d2)*2)/3;
        float gh=(ghinho(d1)+ghinho(d2)*2)/3;
        bcs.setLogic(5*lo/10);
        bcs.setXahoi(5*xa/10);
        bcs.setTruyendat(5*tr/10);
        bcs.setGhinho(5*gh/10);
        return bcs;
                
    }
    public BangChiSo nam3(ArrayList<DiemMon> d1,ArrayList<DiemMon> d2,ArrayList<DiemMon> d3){
        BangChiSo bcs=new BangChiSo();
        float lo=(logic(d1)+logic(d2)*2+logic(d3)*3)/6;
        float xa=(xahoi(d1)+xahoi(d2)*2+xahoi(d3)*3)/6;
        float tr=(truyendat(d1)+truyendat(d2)*2+truyendat(d3)*3)/6;
        float gh=(ghinho(d1)+ghinho(d2)*2+ghinho(d3)*3)/6;
        bcs.setLogic(5*lo/10);
        bcs.setXahoi(5*xa/10);
        bcs.setTruyendat(5*tr/10);
        bcs.setGhinho(5*gh/10);
        return bcs;
                
    }
    
    public float kc(BangChiSo bs,Nghanh n){
        
        double kc=Math.sqrt(Math.pow(bs.getLogic()-n.getLogic(),2)+Math.pow(bs.getXahoi()-n.getXahoi(), 2)+Math.pow(bs.getGhinho()-n.getGhinho(),2)+Math.pow(bs.getTruyendat()-n.getTruyendat(),2));
        return (float)kc;
        
    }
    
    public ArrayList<Nghanh> DoanNghanh(BangChiSo bs){
        ArrayList<Nghanh> n= DBHelper.Instance().GetRecordsNghanh();
        ArrayList<Nghanh> nra=new ArrayList<>();
        Nghanh truongdoi=new Nghanh();
        truongdoi.setLogic((float)2.5);truongdoi.setXahoi((float)2.5);truongdoi.setGhinho((float)2.5);truongdoi.setTruyendat((float)2.5);
        
        if(kc(bs,truongdoi)>1.15&&bs.getLogic()>truongdoi.getLogic()&&bs.getGhinho()>truongdoi.getGhinho()&&bs.getTruyendat()>truongdoi.getTruyendat()&&bs.getXahoi()>truongdoi.getXahoi()){

        

//        for(Nghanh i : n)
//            if(i.getLogic()<=bs.getLogic()&&i.getXahoi()<=bs.getXahoi()&&i.getGhinho()<=bs.getGhinho()&&i.getTruyendat()<=bs.getTruyendat())
//                nra.add(i);
//            
//        for(int i=0;i<nra.size();i++)  { n.remove(nra.get(i));}
//
//        
//        int tieuchuan=3;
//        if(nra.size()>=3) return nra;
//        else{
            for(int i=0;i<n.size();i++)
                for(int j=i;j<n.size();j++)
                {
                    if(kc(bs,n.get(i))>kc(bs,n.get(j))){
                        Nghanh x= n.get(i);
                        n.set(i, n.get(j));
                        n.set(j,x); 
                   }
                }
            int tieuchuan=3;   //-nra.size();
            for(int i=1;i<=tieuchuan;i++) 
                nra.add(n.get(i-1));
            return nra;
        }
      //  }
        else {nra.add(truongdoi);return nra;}
       
    }
    
    public boolean isfill(ArrayList<DiemMon> dtb){
        if(dtb.size()==9){
            for(DiemMon i : dtb)
                if(i.getDiemki1().equals("-1.0")||i.getDiemki2().equals("-1.0")) return false;
            return true;
            
        }
        else return false;
    }
    
    public ArrayList<Nghanh> DuDoan(int id){
      int lop=getLop(id);
      int year=Year.now().getValue();
      int namgiam=year+10-lop;
      int namtang=year+12-lop;
      ArrayList<Nghanh> ng=new ArrayList<>();
      BangChiSo bs=new BangChiSo();
      int n=0;
      for(int i=namgiam;i<=namtang;i++)
          if(isfill(getDiemMon(i, id))==true) n++;
      
      switch(n){
              case 0:  break;
              case 1: {bs=nam1(getdm(namgiam,id));return DoanNghanh(bs);}
              case 2: {bs=nam2(getdm(namgiam, id),getdm(namgiam+1, id)); return DoanNghanh(bs);}
              case 3: {bs=nam3(getdm(namgiam, id),getdm(namgiam+1, id),getdm(namgiam+2, id));return DoanNghanh(bs);}
              
    }
        
      return ng;
    }
    
    
    //phan dang ki
    public void addTk(LoaiTaiKhoan ltk){
        DAL_ql.Instance().addTk(ltk);
    }
    public void addHs(HocSinh hs){
        DAL_ql.Instance().addhs(hs);
    }
    public void addAdmin(DTO.Admin ad){
        DAL_ql.Instance().addAdmin(ad);
    }
    
    //phan chuc nang admin hoc sinh
    public void XoaTk(LoaiTaiKhoan ltk){
        DAL_ql.Instance().XoaTk(ltk);
    }
    public ArrayList<tk_hs> getTk_Hs(){
        return DAL_ql.Instance().getTk_hs();
    }
    //phan truong admin
    public ArrayList<DaiHoc> GetAllDaiHoc(){
        return DBHelper.Instance().GetRecordsDaiHoc();
    }
    public String GetChiTiet(DaiHoc dh){
        String s="Mo ta : "+dh.getMota()+"\n"+"Các nghành đào tạo : "+"\n";
        for(String i:DAL_ql.Instance().GetAllNghanh(dh))
            s=s+i+"\n";
        return s;
    }
    public void Addtruong(DaiHoc dh){
        if(dh.getIdTruong()==0)
          DAL_ql.Instance().AddTruong(dh);
        else DAL_ql.Instance().EditDaihoc(dh);
    }
    public ArrayList<Nghanh> GetallNghanh(){
        return DBHelper.Instance().GetRecordsNghanh();
    }
    public int GetidNghanh(String s){
        int n=0;
        for(Nghanh i:DBHelper.Instance().GetRecordsNghanh())
            if(i.getTen().equals(s)) n=i.getIdNganh();
        return n;
    }
    public void AddNghanh(Nghanh_dh ndh){
        DAL_ql.Instance().AddNghanh_dh(ndh);
    }
    
    // phan truong hocsinh
    
    public boolean isnghanh(String s,DTO.DaiHoc dh){
        return DAL_ql.Instance().GetAllNghanh(dh).contains(s);
    }
    
    public ArrayList<DTO.DaiHoc> GetDaihoctheotieuchi(String nghanh,String city,float diemsan){
        ArrayList<DTO.DaiHoc> dh=GetAllDaiHoc();
        ArrayList<DaiHoc> dh1=new ArrayList<>();
        if(nghanh.equals("all")==false){
            for(DaiHoc i: dh)
                   if(isnghanh(nghanh, i)) dh1.add(i);}
        else dh1=dh;
        
        ArrayList<DaiHoc> dh2=new ArrayList<>();
        if(city.isEmpty()) dh2=dh1;
        else 
            for(DaiHoc i:dh1)
                if(i.getCity().equals(city)) dh2.add(i);
        ArrayList<DaiHoc> dh3=new ArrayList<>();
        if(diemsan==0) dh3=dh2;
        else
            for(DaiHoc i:dh2)
                if(i.getDiemsan()<=diemsan) dh3.add(i);
        return dh3;
    }
    
    public ArrayList<DTO.DaiHoc> GetDaiHocTheoTen(String s){
        ArrayList<DTO.DaiHoc> dh=GetAllDaiHoc();
        ArrayList<DaiHoc> dhout=new ArrayList<>();
        for(DTO.DaiHoc i: dh)
            if(i.getTen().contains(s)) dhout.add(i);
        
        return dhout;
    }
    
    // phan luu tru hoc sinh
    public ArrayList<DTO.DaiHoc> GetDaiHocThich(int id){
        ArrayList<DTO.DaiHoc> dh=new ArrayList<>();
        for(LuuTru i : DBHelper.Instance().GetRecordsDaiHocThich() ){
            if(i.getIdHs()==id) dh.add(DAL_ql.Instance().GetDaiHocTheoId(i.getIdDh()));
        }
        return dh;
    }
    public void AddTruongThich(LuuTru lt){
        DAL_ql.Instance().Addtruongyeuthich(lt);
    }
    public boolean IsExist(int iddh,int idhs){
        for(LuuTru i : DBHelper.Instance().GetRecordsDaiHocThich())
            if(i.getIdDh()==iddh&&i.getIdHs()==idhs) return true;
        return false;
    }
    public void XoaTruoungThich(LuuTru lt){
        DAL_ql.Instance().XoaTruongThich(lt);
    }
    public DaiHoc GetDaiHocTheoId(int id){
        for(DaiHoc i : GetAllDaiHoc())
            if(i.getIdTruong()==id) return i;
        return new DaiHoc();
    }
    // phan du doan 

    public ArrayList<DaiHoc> LietKeDaiHoc(String s){
        int id=GetidNghanh(s);
        ArrayList<DaiHoc> dh=new ArrayList<>();
        ArrayList<Nghanh_dh> ndh=DBHelper.Instance().GetRecordsNghanhDaiHoc();
        for(Nghanh_dh i:ndh){
            if(i.getIdNghanh()==id) dh.add(DAL_ql.Instance().GetDaiHocTheoId(i.getIdDh()));
            if(dh.size()==3) break;
        }
        return dh;
    }
    public String GhiChiTiet(String s){
        ArrayList<DaiHoc> dh=LietKeDaiHoc(s);
        String out="Dai hoc de xuat : "+"\n";
        for(DaiHoc i:dh)
            out=out+"+ "+i.getTen()+"\n";
        return out;
    }
}