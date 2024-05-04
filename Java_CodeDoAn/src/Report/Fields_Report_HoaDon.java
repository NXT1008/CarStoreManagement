package Report;


public class Fields_Report_HoaDon {
    private String tenXe;
    private String hangXe;
    private String xuatXu;
    private long giaBan;

    public Fields_Report_HoaDon(String tenXe, String hangXe, String xuatXu, long giaBan) {
        this.tenXe = tenXe;
        this.hangXe = hangXe;
        this.xuatXu = xuatXu;
        this.giaBan = giaBan;
    }

    public Fields_Report_HoaDon() {
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
