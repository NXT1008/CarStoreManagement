
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


public class ReportManager_DanhSachPhieuNhap {
    private static ReportManager_DanhSachPhieuNhap instance;
    
    private JasperReport report_DanhSachPhieuNhap;
;    
    public static ReportManager_DanhSachPhieuNhap getInstance(){
        if (instance == null){
            instance = new ReportManager_DanhSachPhieuNhap();
        }
        
        return instance;
    }
    
    private ReportManager_DanhSachPhieuNhap(){
        
    }
    
    public void compileReport() throws JRException{
        report_DanhSachPhieuNhap = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Report/report_DanhSachPhieuNhap.jrxml"));
    }
    
    public void printReportPayment(Parameter_Report_DanhSachPhieuNhap data) throws JRException{
        Map para = new HashMap();
        para.put("year", data.getYear());
        para.put("tongTien", data.getTongTien());
        para.put("hoTenNhanVien", data.getHoTenNhanVien());
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getListFields()); // Fields 
        JasperPrint print = JasperFillManager.fillReport(report_DanhSachPhieuNhap, para, dataSource);
        view(print);
    }
    
    private void view(JasperPrint print) throws JRException{
        JasperViewer.viewReport(print, false);
    }
    
//    public static void main(String[] args) {
//        try {
//            ReportManager_DanhSachPhieuNhap.getInstance().compileReport();
//        } catch (Exception e) {
//        }
//    }
    
}
