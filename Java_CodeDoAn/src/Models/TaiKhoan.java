
package Models;
import java.sql.*;

public class TaiKhoan {
    private String maNhanVien; // dùng để đăng ký
    private String tenDangNhap;
    private String matKhau;
    private boolean isAdmin;
    private String email;
    private String verifyCode;
    private boolean isCheck;

    public TaiKhoan(String maNhanVien, String tenDangNhap, String matKhau, boolean isAdmin, String email) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
        this.isAdmin = isAdmin;
        this.email = email;
    }

    
    
    public TaiKhoan(String maNhanVien, String tenDangNhap, String matKhau, boolean isAdmin, String email, String verifyCode, boolean isCheck) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
        this.isAdmin = isAdmin;
        this.email = email;
        this.verifyCode = verifyCode;
        this.isCheck = isCheck;
    }
    
    public TaiKhoan(ResultSet resultSet) throws SQLException {
        tenDangNhap = resultSet.getString("tenDangNhap");
        matKhau = resultSet.getString("matKhau");
        maNhanVien = resultSet.getString("maNhanVien");
        isAdmin = resultSet.getBoolean("isAdmin");
        email = resultSet.getString("email");
        verifyCode = resultSet.getString("verifyCode");
        isCheck = resultSet.getBoolean("isCheck");
    }
    
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isIsCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "maNhanVien=" + maNhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", isAdmin=" + isAdmin + ", email=" + email + ", verifyCode=" + verifyCode + ", isCheck=" + isCheck + '}';
    }

    
    
}
