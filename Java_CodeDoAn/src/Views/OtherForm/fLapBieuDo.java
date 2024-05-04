
package Views.OtherForm;

import DAO.HoaDonDAO;
import DAO.PhieuNhapDAO;
import Models.HoaDon;
import Models.NhanVien;
import Models.PhieuNhap;
import Report.Fields_Report_DanhSachHoaDon;
import Report.Fields_Report_DanhSachPhieuNhap;
import Report.Parameter_Report_DanhSachHoaDon;
import Report.Parameter_Report_DanhSachPhieuNhap;
import Report.ReportManager_DanhSachHoaDon;
import Report.ReportManager_DanhSachPhieuNhap;
import Services.NhanVienService;
import Views.Login.LoginForm.fLogin;
import Views.OtherForm.component.Chart.CurveChart;
import Views.OtherForm.component.Chart.CurveChartPHIEUNHAP;
import Views.OtherForm.component.Chart_LineChart.LineChart_Main;
import Views.OtherForm.component.ColumnChart.ColumnChart_Main;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

public class fLapBieuDo extends javax.swing.JPanel {

    
    String year = "";
    String loaiBieuDo = "";
    private CurveChart fChartHoaDon;
    private CurveChartPHIEUNHAP fChartPhieuNhap;
    private ColumnChart_Main fChartSoSanh;
    private LineChart_Main fChartSoSanh_Line;
    public fLapBieuDo() {
        initComponents();
        
        loadYear();
        loadLoaiBieuDo();
    }

    private void loadYear(){
        String[] data = new String[]{"2021", "2022", "2023", "2024"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(data);
        cbbYear.setModel(model);
    }
    
    private void loadLoaiBieuDo(){
        String[] data = new String[]{"Thống Kê Thu", "Thống Kê Chi", "So Sánh"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(data);
        cbbLoaiBieuDo.setModel(model);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyChart = new javax.swing.JPanel();
        headerChart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbYear = new Views.OtherForm.component.Combobox.Combobox();
        cbbLoaiBieuDo = new Views.OtherForm.component.Combobox.Combobox();
        btnVeBieuDo = new Views.OtherForm.swing.MyButton();
        btnInBaoCao = new Views.OtherForm.swing.MyButton();

        bodyChart.setBackground(new java.awt.Color(17, 38, 47));
        bodyChart.setLayout(new java.awt.BorderLayout());

        headerChart.setBackground(new java.awt.Color(17, 38, 47));

        jLabel1.setBackground(new java.awt.Color(17, 38, 47));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIỂU ĐỒ THỐNG KÊ");

        cbbYear.setBackground(new java.awt.Color(17, 38, 47));
        cbbYear.setForeground(new java.awt.Color(255, 255, 255));
        cbbYear.setLabeText("Năm");
        cbbYear.setLightWeightPopupEnabled(false);
        cbbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbYearActionPerformed(evt);
            }
        });

        cbbLoaiBieuDo.setBackground(new java.awt.Color(17, 38, 47));
        cbbLoaiBieuDo.setForeground(new java.awt.Color(255, 255, 255));
        cbbLoaiBieuDo.setLabeText("Thống Kê");
        cbbLoaiBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiBieuDoActionPerformed(evt);
            }
        });

        btnVeBieuDo.setText("Vẽ Biểu Đồ");
        btnVeBieuDo.setBorderColor(new java.awt.Color(89, 89, 255));
        btnVeBieuDo.setRadius(20);
        btnVeBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeBieuDoActionPerformed(evt);
            }
        });

        btnInBaoCao.setText("In Báo Cáo");
        btnInBaoCao.setBorderColor(new java.awt.Color(0, 156, 0));
        btnInBaoCao.setRadius(20);
        btnInBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerChartLayout = new javax.swing.GroupLayout(headerChart);
        headerChart.setLayout(headerChartLayout);
        headerChartLayout.setHorizontalGroup(
            headerChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerChartLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbbLoaiBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnVeBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        headerChartLayout.setVerticalGroup(
            headerChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerChartLayout.createSequentialGroup()
                .addGroup(headerChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerChartLayout.createSequentialGroup()
                        .addGroup(headerChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLoaiBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(headerChartLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(headerChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerChartLayout.createSequentialGroup()
                                .addComponent(btnVeBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnInBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bodyChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bodyChart, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbYearActionPerformed
        year = cbbYear.getSelectedItem().toString();
        
        //fChartHoaDon f = new fChartHoaDon();
//        CurveChart f = new CurveChart(year);
//        setForm(f);
    }//GEN-LAST:event_cbbYearActionPerformed

    private void cbbLoaiBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiBieuDoActionPerformed
        loaiBieuDo = cbbLoaiBieuDo.getSelectedItem().toString();
    }//GEN-LAST:event_cbbLoaiBieuDoActionPerformed

    private void btnVeBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeBieuDoActionPerformed
        switch (loaiBieuDo) {
            case "Thống Kê Thu" -> {
                fChartHoaDon = new CurveChart(year);
                setForm(fChartHoaDon);
            }
            case "Thống Kê Chi" -> {
                fChartPhieuNhap = new CurveChartPHIEUNHAP(year);
                setForm(fChartPhieuNhap);
            }
            case "So Sánh" -> {
                fChartSoSanh = new ColumnChart_Main(year);
                setForm(fChartSoSanh);
            }
//            case "So Sánh - Biểu đồ đường" -> {
//                fChartSoSanh_Line = new LineChart_Main(year);
//                setForm(fChartSoSanh_Line);
//            }
            default -> {
            }
        }
    }//GEN-LAST:event_btnVeBieuDoActionPerformed

    private void btnInBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBaoCaoActionPerformed
        // Format
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormatter1 = (DecimalFormat) formatter.clone();
        decimalFormatter1.applyPattern("#,### VNĐ");
        
        DecimalFormat decimalFormatter = (DecimalFormat) formatter.clone();
        decimalFormatter.applyPattern("#,###");
        
        switch (loaiBieuDo) {
            case "Thống Kê Thu" -> {
                List<HoaDon> listHoaDon = HoaDonDAO.getInstance().danhSachHoaDonTheoNam(year);
                String y = year;
                long money = HoaDonDAO.getInstance().tongTienTheoNam(year);
                String tongTien = decimalFormatter1.format(money);
                // Find Employee
                NhanVien nv = NhanVienService.getInstance().findOne(fLogin.getTk().getMaNhanVien());
                String hoTenNhanVien = nv.getHoTenNhanVien();
                
                // Fields Report
                List<Fields_Report_DanhSachHoaDon> fields = new ArrayList<>();
                for (HoaDon o : listHoaDon){
                    fields.add(new Fields_Report_DanhSachHoaDon(
                    o.getMaHoaDon(), String.valueOf(o.getNgayLapHoaDon()), o.getMaKhachHang(), o.getMaNhanVienThucHien(), o.getMaXe(), decimalFormatter.format(o.getTongTien())));
                }
                
                //Parameter
                Parameter_Report_DanhSachHoaDon dataPrint = new Parameter_Report_DanhSachHoaDon();
                dataPrint.setHoTenNhanVien(hoTenNhanVien);
                dataPrint.setYear(y);
                dataPrint.setTongTien(tongTien);
                dataPrint.setListFields(fields);
                
                try {
                    ReportManager_DanhSachHoaDon.getInstance().compileReport();
                    ReportManager_DanhSachHoaDon.getInstance().printReportPayment(dataPrint);
                } catch (Exception e) {
                }
            }
            case "Thống Kê Chi" -> {
                String y = year;
                List<PhieuNhap> listPhieuNhap = PhieuNhapDAO.getInstance().danhSachPhieuNhapTheoNam(y);
                long money = PhieuNhapDAO.getInstance().tongChiPhiTheoNam(y);
                String tongTien = decimalFormatter1.format(money);
                
                // Find Employee
                NhanVien nv = NhanVienService.getInstance().findOne(fLogin.getTk().getMaNhanVien());
                String hoTenNhanVien = nv.getHoTenNhanVien();
                
                //Field Report
                List<Fields_Report_DanhSachPhieuNhap> fields = new ArrayList<>();
                for (PhieuNhap o : listPhieuNhap){
                    long thanhTien = o.getGiaNhap() * o.getSoLuong();
                    fields.add(new Fields_Report_DanhSachPhieuNhap(
                    o.getMaPhieuNhap(), String.valueOf(o.getNgayNhap()), o.getMaNhaCungCap(), 
                            o.getMaXe(), decimalFormatter.format(o.getGiaNhap()), String.valueOf(o.getSoLuong()), decimalFormatter.format(thanhTien) 
                    ));
                }
                
                //Parameter
                Parameter_Report_DanhSachPhieuNhap dataPrint = new Parameter_Report_DanhSachPhieuNhap();
                dataPrint.setHoTenNhanVien(hoTenNhanVien);
                dataPrint.setYear(y);
                dataPrint.setTongTien(tongTien);
                dataPrint.setListFields(fields);
                
                try {
                    ReportManager_DanhSachPhieuNhap.getInstance().compileReport();
                    ReportManager_DanhSachPhieuNhap.getInstance().printReportPayment(dataPrint);
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnInBaoCaoActionPerformed

    private void setForm(JComponent com) {
        bodyChart.removeAll();
        bodyChart.add(com);
        bodyChart.repaint();
        bodyChart.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyChart;
    private Views.OtherForm.swing.MyButton btnInBaoCao;
    private Views.OtherForm.swing.MyButton btnVeBieuDo;
    private Views.OtherForm.component.Combobox.Combobox cbbLoaiBieuDo;
    private Views.OtherForm.component.Combobox.Combobox cbbYear;
    private javax.swing.JPanel headerChart;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
