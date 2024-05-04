
package Report;


public class Fields_Report_ThanhToan {
    private String tenXe;
    private String xuatXu;
    private String hangXe;
    private long gia;

    public Fields_Report_ThanhToan() {
    }

    public Fields_Report_ThanhToan(String tenXe, String xuatXu, String hangXe, long gia) {
        this.tenXe = tenXe;
        this.xuatXu = xuatXu;
        this.hangXe = hangXe;
        this.gia = gia;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
    
}
