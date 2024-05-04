
package Report;


public class Fields_Report_DanhSachHoaDon {
    private String maHoaDon;
    private String ngayLapHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private String maXe;
    private String giaBan;

    public Fields_Report_DanhSachHoaDon() {
    }

    public Fields_Report_DanhSachHoaDon(String maHoaDon, String ngayLapHoaDon, String maKhachHang, String maNhanVien, String maXe, String giaBan) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maXe = maXe;
        this.giaBan = giaBan;
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

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
