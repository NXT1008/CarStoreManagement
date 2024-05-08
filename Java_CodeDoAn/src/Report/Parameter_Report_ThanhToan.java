
package Report;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class Parameter_Report_ThanhToan {
    private String tenNhanVien;
    private String tenKhachHang;
    private String tongTien;
    private InputStream qrcode;
    private Date ngayLap;
    private String giaOTo;
    private String tongCacLoaiPhi;
    private String thueVAT;
    List<Fields_Report_ThanhToan> listFields;

    public Parameter_Report_ThanhToan() {
    }

    public Parameter_Report_ThanhToan(String tenNhanVien, String tenKhachHang, String tongTien, InputStream qrcode, Date ngayLap, String giaOTo, String tongCacLoaiPhi, String thueVAT, List<Fields_Report_ThanhToan> listFields) {
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.tongTien = tongTien;
        this.qrcode = qrcode;
        this.ngayLap = ngayLap;
        this.giaOTo = giaOTo;
        this.tongCacLoaiPhi = tongCacLoaiPhi;
        this.thueVAT = thueVAT;
        this.listFields = listFields;
    }

    

    public List<Fields_Report_ThanhToan> getListFields() {
        return listFields;
    }

    public void setListFields(List<Fields_Report_ThanhToan> listFields) {
        this.listFields = listFields;
    }

    

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public InputStream getQrcode() {
        return qrcode;
    }

    public void setQrcode(InputStream qrcode) {
        this.qrcode = qrcode;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTongCacLoaiPhi() {
        return tongCacLoaiPhi;
    }

    public void setTongCacLoaiPhi(String tongCacLoaiPhi) {
        this.tongCacLoaiPhi = tongCacLoaiPhi;
    }

    public String getGiaOTo() {
        return giaOTo;
    }

    public void setGiaOTo(String giaOTo) {
        this.giaOTo = giaOTo;
    }
    
    public String getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(String thueVAT) {
        this.thueVAT = thueVAT;
    }
    
    
}
