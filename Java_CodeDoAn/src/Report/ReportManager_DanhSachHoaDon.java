
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


public class ReportManager_DanhSachHoaDon {
    private static ReportManager_DanhSachHoaDon instance;
    
    private JasperReport report_DanhSachHoaDon;
;    
    public static ReportManager_DanhSachHoaDon getInstance(){
        if (instance == null){
            instance = new ReportManager_DanhSachHoaDon();
        }
        
        return instance;
    }
    
    private ReportManager_DanhSachHoaDon(){
        
    }
    
    public void compileReport() throws JRException{
        report_DanhSachHoaDon = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Report/report_DanhSachHoaDon.jrxml"));
    }
    
    public void printReportPayment(Parameter_Report_DanhSachHoaDon data) throws JRException{
        Map para = new HashMap();
        para.put("year", data.getYear());
        para.put("tongTien", data.getTongTien());
        para.put("hoTenNhanVien", data.getHoTenNhanVien());
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getListFields()); // Fields 
        JasperPrint print = JasperFillManager.fillReport(report_DanhSachHoaDon, para, dataSource);
        view(print);
    }
    
    private void view(JasperPrint print) throws JRException{
        JasperViewer.viewReport(print, false);
    }
    
}
