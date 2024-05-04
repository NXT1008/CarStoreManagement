
package DAO;

import Models.KhoXe;
import Models.TopCarBestSell;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class KhoXeDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static KhoXeDAO Instance;

    public static KhoXeDAO getInstance() {
        if (Instance == null)
            Instance = new KhoXeDAO();
        return Instance;
    }
    
    public List<KhoXe> danhSachKhoXe(){
        List<KhoXe> list = new ArrayList<>();
        String query = "select XE.maXe, tenXe, soLuongXeCon, soLuongXeDaBan, hinhAnh from XE inner join KHOXE KX on XE.maXe = KX.maXe";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                KhoXe i = new KhoXe(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public int tongSoLuongXe(){
        int cnt = 0;
        String query = "select sum(soLuongXeCon) + sum(soLuongXeDaBan) from KHOXE";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                cnt = rs.getInt(1);
                return cnt;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return cnt;
    }
    
    public List<TopCarBestSell> findTop4BestSellCar(){
        List<TopCarBestSell> list = new ArrayList<>();
        String query = """
                       select top 4 XE.maXe, tenXe, giaBan, hinhAnh, soLuongXeDaBan 
                       from KHOXE KX inner join XE
                       on KX.maXe = XE.maXe
                       order by soLuongXeDaBan desc""";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                TopCarBestSell i = new TopCarBestSell(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public boolean kiemTraXeCon(String maXe){
        int cnt = 0;
        String query = "select soLuongXeCon from KHOXE where maXe = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maXe);
            rs = ps.executeQuery();
            while (rs.next()){
                cnt = rs.getInt(1);
                return cnt != 0;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return false;
    }
}
