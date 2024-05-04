
package Report;


public class Fields_Report_DanhSachPhieuNhap {
    private String maPhieuNhap;
    private String ngayNhap;
    private String maNhaCungCap;
    private String maXe;
    private String giaNhap;
    private String soLuong;
    private String thanhTien;

    public Fields_Report_DanhSachPhieuNhap(String maPhieuNhap, String ngayNhap, String maNhaCungCap, String maXe, String giaNhap, String soLuong, String thanhTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.maNhaCungCap = maNhaCungCap;
        this.maXe = maXe;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public Fields_Report_DanhSachPhieuNhap() {
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
