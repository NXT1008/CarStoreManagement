
package DAO;

import Models.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TaiKhoanDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private static TaiKhoanDAO Instance;

    public static TaiKhoanDAO getInstance() {
        if (Instance == null)
            Instance = new TaiKhoanDAO();
        return Instance;
    }
    
    public List<TaiKhoan> danhSachTaiKhoan(){
        List<TaiKhoan> list = new ArrayList<>();
        String query = "select * from TAIKHOAN";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                TaiKhoan i = new TaiKhoan(rs);
                list.add(i);
            }
            
            conn.close();
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public TaiKhoan login(String username, String password){
        TaiKhoan tk;
        String query = "select * from TAIKHOAN where tenDangNhap = ? and matKhau = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()){
                tk = new TaiKhoan(rs);
                return tk;
            }
            conn.close();
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean register(TaiKhoan tk){
        String query = "insert into TAIKHOAN(maNhanVien, tenDangNhap, matKhau, email, verifyCode) values (?,?,?,?,?)";
        String code = generateVerifyCode();
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tk.getMaNhanVien());
            ps.setString(2, tk.getTenDangNhap());
            ps.setString(3, tk.getMatKhau());
            ps.setString(4, tk.getEmail());
            ps.setString(5, code);
            ps.executeUpdate();
            conn.close();
            tk.setVerifyCode(code);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public TaiKhoan findByMaNhanVien(String maNV){
        TaiKhoan tk;
        String query = "select * from TAIKHOAN where maNhanVien = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()){
                tk = new TaiKhoan(rs);
                return tk;
            }
            conn.close();
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean update(TaiKhoan tk){
        String query = "update TAIKHOAN set tenDangNhap = ?, matKhau = ? where maNhanVien = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tk.getTenDangNhap());
            ps.setString(2, tk.getMatKhau());
            ps.setString(3, tk.getMaNhanVien());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean checkVerifyCode(String maNhanVien, String verifyCode){
        boolean verify = false;
        String query = "select * from TAIKHOAN where maNhanVien = ? and verifyCode = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maNhanVien);
            ps.setString(2, verifyCode);
            rs = ps.executeQuery();
            while (rs.next()){
                verify = true;
            }
            conn.close();
        } catch (Exception e) {
        }
        return verify;
    }
    
    public boolean doneVerify(String maNhanVien){
        String query = "update TAIKHOAN set isCheck = 1 where maNhanVien = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    // hàm tạo mã xác nhận ngẫu nhiên
    private String generateVerifyCode(){
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }
    
    // Hàm kiểm tra mã code đã được tạo chưa
    public boolean checkDuplicateCode(String verifyCode){
        boolean verify = false;
        String query = "select * from TAIKHOAN where verifyCode = ?";
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, verifyCode);
            rs = ps.executeQuery();
            while (rs.next()){
                verify = true;
            }
            conn.close();
        } catch (Exception e) {
        }
        return verify;
    }
}
