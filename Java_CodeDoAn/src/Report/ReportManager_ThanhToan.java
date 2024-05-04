package Report;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager_ThanhToan {
    private static ReportManager_ThanhToan instance;
    
    private JasperReport report_ThanhToan;
;    
    public static ReportManager_ThanhToan getInstance(){
        if (instance == null){
            instance = new ReportManager_ThanhToan();
        }
        
        return instance;
    }
    
    private ReportManager_ThanhToan(){
        
    }
    
    public void compileReport() throws JRException{
        report_ThanhToan = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Report/report_ThanhToan.jrxml"));
    }
    
    public void printReportPayment(Parameter_Report_ThanhToan data) throws JRException{
        Map para = new HashMap();
        para.put("nhanVien", data.getTenNhanVien());
        para.put("khachHang", data.getTenKhachHang());
        para.put("tongTien", data.getTongTien());
        para.put("qrcode", data.getQrcode());
        
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getListFields()); // Fields 
        JasperPrint print = JasperFillManager.fillReport(report_ThanhToan, para, dataSource);
        view(print);
    }
    
    private void view(JasperPrint print) throws JRException{
        JasperViewer.viewReport(print, false);
    }
    
    
    // Method generate QRCODE
    public InputStream generateQrcode() throws WriterException, IOException{
        NumberFormat nf = new DecimalFormat("000000000");
        Random rd = new Random();
        String invoice = nf.format(rd.nextLong(999999999) + 1);
        
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);
        
        // Size: 120x120
        BitMatrix bitMatrix = new MultiFormatWriter().encode(invoice, BarcodeFormat.QR_CODE, 120, 120);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
    
//    public static void main(String[] args) {
//        try {
//            ReportManager_ThanhToan.getInstance().compileReport();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
