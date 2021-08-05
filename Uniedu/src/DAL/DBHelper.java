/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.BangChiSo;
import DTO.DaiHoc;
import DTO.DiemtrungBinh;
import DTO.HocSinh;
import DTO.LoaiTaiKhoan;
import DTO.LuuTru;
import DTO.Mon;
import DTO.Nghanh;
import DTO.Nghanh_dh;
import DTO.tk_hs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class DBHelper 
{
       
    Connection cnn;
    private static DBHelper instance;
    private DBHelper(){
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cnn= DriverManager.getConnection("jdbc:sqlserver://103.95.197.121:9696;databaseName=doan;","DACNPM","khoa19@itf"); 
    }
    catch(Exception e){}
    }
    public static DBHelper Instance(){
        if(instance==null) {
            instance=new DBHelper();
            System.out.println("oke");
        }
        return instance;
    }
    
      
       public ArrayList<LoaiTaiKhoan> GetRecordsLtk() 
        {
           ArrayList<LoaiTaiKhoan> t = new ArrayList<LoaiTaiKhoan>();
           String query = "select * from LoaiTaiKhoan";
           try{
            
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                LoaiTaiKhoan tk = new LoaiTaiKhoan();
                tk.setIdLoaiTk(rs.getInt("idLoaiTaiKhoan"));
                tk.setRole(rs.getString("VaiTro"));
                tk.setTen(rs.getString("ten"));
                tk.setPass(rs.getString("pass"));
                t.add(tk);
            }
           }catch(Exception e){}
           
         return t;  
        }
        public ArrayList<HocSinh> GetRecordsHs() 
        {
           ArrayList<HocSinh> t = new ArrayList<HocSinh>();
           String query = "select * from Student";
           try{
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    //THANHNHAN-DUT\SQLEXPRESS
            while(rs.next()){
                HocSinh hs = new HocSinh();
                hs.setIdHs(rs.getInt("idStudent"));
                hs.setTen(rs.getString("Name"));
                hs.setCity(rs.getString("city"));
                hs.setTruong(rs.getString("truong"));
                hs.setLop(rs.getInt("Lop"));
                hs.setLanDoi(rs.getInt("LanDoi"));
                hs.setIdLoaiTk_hs(rs.getInt("idLoaiTaiKhoan"));
                t.add(hs);
            }
           }catch(Exception e){}
           
         return t;  
        }
       public ArrayList<Mon> GetRecordsMon() 
        {
           ArrayList<Mon> t = new ArrayList<Mon>();
           String query = "select * from Subject";
           try{
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                Mon mon = new Mon();
                mon.setIdMon(rs.getInt("idSubject"));
                mon.setTen(rs.getString("Name"));
                t.add(mon);
            }
           }catch(Exception e){}
           
         return t;  
        } 
       public ArrayList<DiemtrungBinh> GetRecordsDiemtb() 
        {
           ArrayList<DiemtrungBinh> t = new ArrayList<DiemtrungBinh>();
           String query = "select * from DiemTb";
           try{ 
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                DiemtrungBinh dtb=new DiemtrungBinh();
                dtb.setIdDiem(rs.getInt("idDiemTb"));
                dtb.setDiem1(rs.getFloat("DiemK1"));
                dtb.setDiem2(rs.getFloat("DiemK2"));
                dtb.setNam(rs.getInt("nam"));
                dtb.setHs_d(rs.getInt("idStudent"));
                dtb.setSb_d(rs.getInt("idSubject"));
                t.add(dtb);
            }
           }catch(Exception e){}
           
         return t;  
        }
       
        public ArrayList<Nghanh> GetRecordsNghanh() 
        {
           ArrayList<Nghanh> t = new ArrayList<Nghanh>();
           String query = "select * from Nghanh";
           try{
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                Nghanh n=new Nghanh();
                n.setIdNganh(rs.getInt("idDanhSachNghanh"));
                n.setTen(rs.getString("Ten"));
                n.setLogic(rs.getFloat("ChiSoLogic"));
                n.setXahoi(rs.getFloat("ChiSoXahoi"));
                n.setGhinho(rs.getFloat("ChiSoGhiNho"));
                n.setTruyendat(rs.getFloat("ChiSoTruyenDat"));
                t.add(n);
            }
           }catch(Exception e){}
           
         return t;  
        }
        
        public ArrayList<DTO.Admin> GetRecordsAdmin() 
        {
           ArrayList<DTO.Admin> t = new ArrayList<DTO.Admin>();
           String query = "select * from Admin";
           try{ 
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                DTO.Admin ad = new DTO.Admin();
                ad.setIdAdmin(rs.getInt("idAdmin"));
                ad.setIdLoaiTk_admin(rs.getInt("idLoaiTaiKhoan"));
                ad.setTen(rs.getString("Ten"));
                ad.setTuoi(rs.getInt("Age"));
                t.add(ad);
            }
           }catch(Exception e){}
           
         return t;  
        } 
        
        public ArrayList<DaiHoc> GetRecordsDaiHoc() 
        {
           ArrayList<DaiHoc> t = new ArrayList<>();
           String query = "select * from University";
           try{
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                DaiHoc n=new DaiHoc();
                n.setIdTruong(rs.getInt("idUniveristy"));
                n.setCity(rs.getString("city"));
                n.setTen(rs.getString("Name"));
                n.setMota(rs.getString("Mota"));
                n.setSoNghanh(rs.getInt("SoNghanh"));
                n.setDiemsan(rs.getFloat("DiemSan"));
                t.add(n);
            }
           }catch(Exception e){}
           
         return t;  
        }
        
        public ArrayList<Nghanh_dh> GetRecordsNghanhDaiHoc() 
        {
           ArrayList<Nghanh_dh> t = new ArrayList<>();
           String query = "select * from Nghanh_dai_hoc";
           try{
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                Nghanh_dh n=new Nghanh_dh();
                n.setIdDh(rs.getInt("idUniveristy"));
                n.setIdNghanh(rs.getInt("idDanhSachNghanh"));
                t.add(n);
            }
           }catch(Exception e){}
           
         return t;  
        }
        public ArrayList<LuuTru> GetRecordsDaiHocThich() 
        {
           ArrayList<LuuTru> t = new ArrayList<>();
           String query = "select * from Store";
           try{ 
            Statement st= cnn.createStatement();
            
            ResultSet rs=st.executeQuery(query);    
            while(rs.next()){
                LuuTru lt=new LuuTru();
                lt.setIdHs(rs.getInt("idStudent"));
                lt.setIdDh(rs.getInt("idUniveristy"));
                t.add(lt);
            }
           }catch(Exception e){}
           
         return t;  
        }
        
        public void ExcuteUpdate(String query){
          try{ 
              Statement st= cnn.createStatement();
              st.executeUpdate(query);
          }catch(Exception e){}
      }
}
