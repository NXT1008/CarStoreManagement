package Report;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager_HoaDon {
    private static ReportManager_HoaDon instance;
    
    private JasperReport report_HoaDon;
;    
    public static ReportManager_HoaDon getInstance(){
        if (instance == null){
            instance = new ReportManager_HoaDon();
        }
        
        return instance;
    }
    
    private ReportManager_HoaDon(){
        
    }
    
    public void compileReport() throws JRException{
        report_HoaDon = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Report/report_HoaDon.jrxml"));
    }
    
    public void printReportPayment(Parameter_Report_HoaDon data) throws JRException{
        Map para = new HashMap();
        para.put("maHoaDon", data.getMaHoaDon());
        para.put("ngayLapHoaDon", data.getNgayLapHoaDon());
        para.put("nhanVienThucHien", data.getTenNhanVienThucHien());
        para.put("hoTenKhachHang", data.getHoTenKhachHang());
        para.put("diaChiKhachHang", data.getDiaChiKH());
        para.put("soDienThoaiKhachHang", data.getSoDienThoaiKH());
        para.put("CCCDKhachHang", data.getCCCDKhachHang());
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getListFields()); // Fields 
        JasperPrint print = JasperFillManager.fillReport(report_HoaDon, para, dataSource);
        view(print);
    }
    
    private void view(JasperPrint print) throws JRException{
        JasperViewer.viewReport(print, false);
    }
    
//    public static void main(String[] args) {
//        try {
//            ReportManager_HoaDon.getInstance().compileReport();
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
//    }
}
