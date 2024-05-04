package Report;

import java.util.List;

public class Parameter_Report_HoaDon {
    private String maHoaDon;
    private String ngayLapHoaDon;
    private String tenNhanVienThucHien;
    private String hoTenKhachHang;
    private String diaChiKH;
    private String soDienThoaiKH;
    private String CCCDKhachHang;
    private List<Fields_Report_HoaDon> listFields;

    public Parameter_Report_HoaDon() {
    }

    public Parameter_Report_HoaDon(String maHoaDon, String ngayLapHoaDon, String tenNhanVienThucHien, String hoTenKhachHang, String diaChiKH, String soDienThoaiKH, String CCCDKhachHang, List<Fields_Report_HoaDon> listFields) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tenNhanVienThucHien = tenNhanVienThucHien;
        this.hoTenKhachHang = hoTenKhachHang;
        this.diaChiKH = diaChiKH;
        this.soDienThoaiKH = soDienThoaiKH;
        this.CCCDKhachHang = CCCDKhachHang;
        this.listFields = listFields;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(String ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public String getTenNhanVienThucHien() {
        return tenNhanVienThucHien;
    }

    public void setTenNhanVienThucHien(String tenNhanVienThucHien) {
        this.tenNhanVienThucHien = tenNhanVienThucHien;
    }

    public String getHoTenKhachHang() {
        return hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(String soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public String getCCCDKhachHang() {
        return CCCDKhachHang;
    }

    public void setCCCDKhachHang(String CCCDKhachHang) {
        this.CCCDKhachHang = CCCDKhachHang;
    }

    public List<Fields_Report_HoaDon> getListFields() {
        return listFields;
    }

    public void setListFields(List<Fields_Report_HoaDon> listFields) {
        this.listFields = listFields;
    }
    
    
}
