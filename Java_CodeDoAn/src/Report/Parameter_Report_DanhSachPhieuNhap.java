
package Report;

import java.util.List;

public class Parameter_Report_DanhSachPhieuNhap {
    private String hoTenNhanVien;
   private String year;
   private String tongTien;
   private List<Fields_Report_DanhSachPhieuNhap> listFields;

    public Parameter_Report_DanhSachPhieuNhap(String hoTenNhanVien, String year, String tongTien, List<Fields_Report_DanhSachPhieuNhap> listFields) {
        this.hoTenNhanVien = hoTenNhanVien;
        this.year = year;
        this.tongTien = tongTien;
        this.listFields = listFields;
    }

    public Parameter_Report_DanhSachPhieuNhap() {
    }

    public String getHoTenNhanVien() {
        return hoTenNhanVien;
    }

    public void setHoTenNhanVien(String hoTenNhanVien) {
        this.hoTenNhanVien = hoTenNhanVien;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public List<Fields_Report_DanhSachPhieuNhap> getListFields() {
        return listFields;
    }

    public void setListFields(List<Fields_Report_DanhSachPhieuNhap> listFields) {
        this.listFields = listFields;
    }
   
   
}
