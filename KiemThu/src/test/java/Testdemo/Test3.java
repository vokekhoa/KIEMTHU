/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testdemo;

import KhachHang.KhachHang;
import KhachHang.KhachHangService;
import com.khoa.kiemthu.HoaDon;
import com.khoa.kiemthu.HoaDonService;
import com.khoa.kiemthu.JDBC;
import com.khoa.kiemthu.ThongBao;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ACER
 */
public class Test3 {
    
            private static Connection Connect;
    @BeforeAll 
    public static void BeforeAll() throws SQLException{
    Connect= JDBC.ConnectDb();
    }
    @AfterAll
    public static void AfterAll() throws SQLException{
        if (Connect != null)
            Connect.close();
    }
        @Test
        public  double tinhTienBTN(String idkh) throws SQLException{
        double thanhtien = 0;

        HoaDonService a = new HoaDonService();
        ArrayList<HoaDon> b= (ArrayList<HoaDon>) a.napHoaDon(idkh);
        for(int i=0;i<b.size();i++){
                
                thanhtien+= Double.parseDouble(b.get(i).getGiahh())*Double.parseDouble(b.get(i).getSoluonghh());
        }
            return thanhtien;
        }
        @Test
        public void testTinhTien() throws SQLException{
            System.out.println("==========================");
            
            System.out.println("Tong tien la:"+tinhTienBTN("Đã tính"));
            System.out.println("Tien thoi la:"+(200000-tinhTienBTN("Đã tính")));
            System.out.println("Tien tong khi co vip là:"+(tinhTienBTN("Đã tính")-tinhTienBTN("Đã tính")*8/100));
             System.out.println("==========================");
        }
        @Test
         public void xuatHD() throws IOException, SQLException{
        String id = "Đã tính";
        String nhanvien = "Test";
        String vip = "VIP";
        FileWriter hoadon = new FileWriter("HoaDonTest"+id+".txt");
        HoaDonService nap = new HoaDonService();
        ArrayList<HoaDon> h = (ArrayList<HoaDon>) nap.napHoaDon(id);
        hoadon.write("371 Nguyen Kiem, Go Vap, Ho Chi Minh\n");
        hoadon.write("=====================================\n");
        hoadon.write("==============Hoa Don================\n");
        hoadon.write("Nhan vien : "+ nhanvien +"\n");
        hoadon.write("\n");
        hoadon.write("=====================================\n");
        hoadon.write("Ten   Soluong   Khuyen mai    Gia \n");
        for(int i =0; i<h.size();i++)
         {
             hoadon.write(h.get(i).getNamehh()+"      ");
             hoadon.write(h.get(i).getSoluonghh()+"       ");
             hoadon.write(h.get(i).getXuatxu()+"         ");
             hoadon.write(h.get(i).getGiahh()+"      \n");
             hoadon.write("=====================================\n");
         }
        if(vip.matches("VIP"))
            hoadon.write("      \n");
        else
            hoadon.write("VIP -8% Tong tien     \n");
        hoadon.write("=====================================\n");
        double tt = tinhTienBTN("Đã tính");
        String khachdua = "Test";
        String thoilai = "Test";
        String tienvip = "Test";
        hoadon.write("\n");
        hoadon.write("\n");
        hoadon.write("Tien khach dua: "+ khachdua+" Dong"+"\n");
        hoadon.write("Thanh tien: "+tt+" Dong"+"\n");
        hoadon.write("Tien thoi lai: "+ thoilai+" Dong"+"\n");
        hoadon.write("\n");
        hoadon.write("          CAM ON QUY KHACH DA MUA HANG       \n");
        hoadon.close();
            System.out.println("=======================");
            System.out.println("In hoa don xong");
    }   @Test
         public void traCuu() throws SQLException{
         
         
        String sol = "Khoa";
        KhachHangService d = new KhachHangService();
        ArrayList<KhachHang> c = new ArrayList<>();
        c = (ArrayList<KhachHang>) d.search(sol);
        
            for (int i = 0; i < c.size(); i++) {
               
                    if(sol.equals(c.get(i).getTenkh()))                   
                
                     
                    
                    
                        System.out.println("Khach hang nay là VIP");
        
                          
                    else
                    
                        
                        System.out.println("Khach hang nay không là VIP");
                    

        
   
        
            }
    }
 
}
