/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testdemo;

import com.khoa.kiemthu.HangHoa;
import com.khoa.kiemthu.HoaDonService;
import com.khoa.kiemthu.JDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;
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
public class Test2 {
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
    public void addHangVaoHoaDon() throws SQLException{
            
        HangHoa han = new HangHoa(UUID.randomUUID().toString(), "Lươn", "10000", "Biển", "-2000","1" );
                        String idhh = han.getId_hh();
                        String namehh = han.getTenhang();
                        String giahh = han.getGiahang();
                        String xuatxu = han.getXuatxu();
                        String soluong = han.getSoluong();
                        String mota = han.getMota();
                        String idkh="Test";
                        
                        String tennv = "Test";
                        double updateGia=0;
                        if(mota!=null)
                            updateGia = Double.valueOf(giahh) + Double.valueOf(mota);
                        
                        String loaikh = "VIP";
                    
                        
                           
                        double luong = 1.2;
                        HoaDonService.themHangHoaHD(UUID.randomUUID().toString(),tennv , idhh, namehh,  luong,String.valueOf(updateGia), 0,loaikh, mota,idkh);
                        System.err.println("==================++===============");
                        System.err.println("THêm hàng vào hóa đơn thành công");
                        System.err.println("==================++===============");
                      
    }
    

    

        

}
