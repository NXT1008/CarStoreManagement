
package Report;

import java.io.InputStream;
import java.util.List;


public class Parameter_Report_ThanhToan {
    private String tenNhanVien;
    private String tenKhachHang;
    private String tongTien;
    private InputStream qrcode;
    List<Fields_Report_ThanhToan> listFields;

    public Parameter_Report_ThanhToan() {
    }

    public Parameter_Report_ThanhToan(String tenNhanVien, String tenKhachHang, String tongTien, InputStream qrcode, List<Fields_Report_ThanhToan> listFields) {
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.tongTien = tongTien;
        this.qrcode = qrcode;
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
    
    
}
