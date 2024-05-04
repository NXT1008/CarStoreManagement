
package DAO;

import Models.Xe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class XeDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static XeDAO Instance;

    public static XeDAO getInstance() {
        if (Instance == null)
            Instance = new XeDAO();
        return Instance;
    }
    
    public List<Xe> danhSachXe(){
        List<Xe> list = new ArrayList<>();
        String query = "select * from XE";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Xe i = new Xe(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<String> listMaXe(){
        List<String> list = new ArrayList<>();
        String query = "select maXe from XE";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString("maXe"));
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public Xe findOne(String maXe){
        Xe xe;
        String query = "select * from XE where maXe = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maXe);
            rs = ps.executeQuery();
            while (rs.next()){
                xe = new Xe(rs);
                return xe;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public Xe findTop1(){
        Xe xe;
        String query = "select top 1 * from XE ORDER BY maXe DESC";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                xe = new Xe(rs);
                return xe;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public Xe findTop2(){
        Xe xe;
        String query = """
                       SELECT TOP 1 *
                       FROM (
                           SELECT TOP 2 *
                           FROM XE
                           ORDER BY maXe DESC
                       ) AS SubQuery
                       ORDER BY maXe ASC""";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                xe = new Xe(rs);
                return xe;
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean insert(Xe model){
        String query = "exec Insert_XE ?,?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getTenXe());
            ps.setString(2, model.getMauSac());
            ps.setLong(3, model.getGiaBan());
            ps.setString(4, model.getXuatXu());
            ps.setString(5, model.getHangXe());
            ps.setString(6, model.getPhienBanXe());
            ps.setInt(7, model.getTrongLuong());
            ps.setInt(8, model.getCongSuatDongCo());
            ps.setString(9, model.getLoaiDongCo());
            ps.setInt(10, model.getChieuDai());
            ps.setInt(11, model.getChieuRong());
            ps.setInt(12, model.getChieuCao());
            ps.setBytes(13, model.getHinhAnh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean update(Xe model){
        String query = "exec Update_XE ?,?,?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, model.getMaXe());
            ps.setString(2, model.getTenXe());
            ps.setString(3, model.getMauSac());
            ps.setLong(4, model.getGiaBan());
            ps.setString(5, model.getXuatXu());
            ps.setString(6, model.getHangXe());
            ps.setString(7, model.getPhienBanXe());
            ps.setInt(8, model.getTrongLuong());
            ps.setInt(9, model.getCongSuatDongCo());
            ps.setString(10, model.getLoaiDongCo());
            ps.setInt(11, model.getChieuDai());
            ps.setInt(12, model.getChieuRong());
            ps.setInt(13, model.getChieuCao());
            ps.setBytes(14, model.getHinhAnh());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String ma){
        String query = "exec Delete_XE ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public long getGiaBan(String maXe){
        long tongTien;
        String query = "select giaBan from XE where maXe = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maXe);
            rs = ps.executeQuery();
            while (rs.next()){
                tongTien = rs.getLong(1);
                return tongTien;
            }
            conn.close();
        } catch (Exception e) {
        }
        return 0;
    }
    
}
