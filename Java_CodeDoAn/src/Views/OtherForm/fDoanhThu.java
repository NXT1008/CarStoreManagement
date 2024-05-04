
package Views.OtherForm;

import DAO.HoaDonDAO;
import DAO.KhoXeDAO;
import DAO.PhieuNhapDAO;
import Models.TopCarBestSell;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class fDoanhThu extends javax.swing.JPanel {

    
    public fDoanhThu() {
        initComponents();
        loadData();
    }
    
    public void loadData(){
        
        // Load Doanh thu
        long tongDoanhThu = HoaDonDAO.getInstance().tongDoanhThu();
        long tongChiTieu = PhieuNhapDAO.getInstance().tongChiPhi();
        long loiNhuan = tongDoanhThu - tongChiTieu;
        
        // Format
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormatter = (DecimalFormat) formatter;
        decimalFormatter.applyPattern("#,### VNĐ");
        
        lblTongDoanhThu.setText(String.valueOf(decimalFormatter.format(tongDoanhThu)));
        lblTongChiTieu.setText(String.valueOf(decimalFormatter.format(tongChiTieu)));
        lblLoiNhuan.setText(String.valueOf(decimalFormatter.format(loiNhuan)));
        
        //Load top car best sell
        List<TopCarBestSell> list = KhoXeDAO.getInstance().findTop4BestSellCar();
        card_CarBestSell1.setData(list.get(0));
        card_CarBestSell1.setLblSoLuongXeDaBan(list.get(0).getSoLuongXeDaBan());
        
        card_CarBestSell2.setData(list.get(1));
        card_CarBestSell2.setLblSoLuongXeDaBan(list.get(1).getSoLuongXeDaBan());
        
        card_CarBestSell3.setData(list.get(2));
        card_CarBestSell3.setLblSoLuongXeDaBan(list.get(2).getSoLuongXeDaBan());
        
        card_CarBestSell4.setData(list.get(3));
        card_CarBestSell4.setLblSoLuongXeDaBan(list.get(3).getSoLuongXeDaBan());
        
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.BLACK, 0, getHeight(), Color.WHITE);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
//        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
//        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new Views.Main.component.Panel();
        panelRound1 = new Views.OtherForm.swing.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        pictureBox1 = new Views.OtherForm.swing.PictureBox();
        panelRound3 = new Views.OtherForm.swing.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        lblLoiNhuan = new javax.swing.JLabel();
        pictureBox3 = new Views.OtherForm.swing.PictureBox();
        panelRound4 = new Views.OtherForm.swing.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        lblTongChiTieu = new javax.swing.JLabel();
        pictureBox2 = new Views.OtherForm.swing.PictureBox();
        panelRound2 = new Views.OtherForm.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        card_CarBestSell1 = new Views.OtherForm.component.Card.Card_CarBestSell();
        card_CarBestSell2 = new Views.OtherForm.component.Card.Card_CarBestSell();
        card_CarBestSell3 = new Views.OtherForm.component.Card.Card_CarBestSell();
        card_CarBestSell4 = new Views.OtherForm.component.Card.Card_CarBestSell();
        panelRound5 = new Views.OtherForm.swing.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        fPieChart3 = new Views.OtherForm.component.PieChart.fPieChart();

        setBackground(new java.awt.Color(255, 255, 255));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setColor1(new java.awt.Color(237, 237, 237));
        panel2.setColor2(new java.awt.Color(237, 237, 237));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TỔNG DOANH THU");

        lblTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThu.setText("500000000000");

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/revenue.png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongDoanhThu)))
                .addGap(16, 16, 16))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LỢI NHUẬN");

        lblLoiNhuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLoiNhuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoiNhuan.setText("600000000000");

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/profit.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(lblLoiNhuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(lblLoiNhuan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(30);
        panelRound4.setRoundBottomRight(30);
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TỔNG CHI TIÊU");

        lblTongChiTieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongChiTieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongChiTieu.setText("900000000000");

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/wallet.png"))); // NOI18N

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongChiTieu, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongChiTieu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("TOP XE BÁN CHẠY");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(card_CarBestSell3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card_CarBestSell4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(card_CarBestSell1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card_CarBestSell2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card_CarBestSell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card_CarBestSell2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card_CarBestSell3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card_CarBestSell4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(30);
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CHI PHÍ NHẬP Ô TÔ VỀ CỬA HÀNG");

        fPieChart3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(fPieChart3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fPieChart3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.component.Card.Card_CarBestSell card_CarBestSell1;
    private Views.OtherForm.component.Card.Card_CarBestSell card_CarBestSell2;
    private Views.OtherForm.component.Card.Card_CarBestSell card_CarBestSell3;
    private Views.OtherForm.component.Card.Card_CarBestSell card_CarBestSell4;
    private Views.OtherForm.component.PieChart.fPieChart fPieChart3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblLoiNhuan;
    private javax.swing.JLabel lblTongChiTieu;
    private javax.swing.JLabel lblTongDoanhThu;
    private Views.Main.component.Panel panel2;
    private Views.OtherForm.swing.PanelRound panelRound1;
    private Views.OtherForm.swing.PanelRound panelRound2;
    private Views.OtherForm.swing.PanelRound panelRound3;
    private Views.OtherForm.swing.PanelRound panelRound4;
    private Views.OtherForm.swing.PanelRound panelRound5;
    private Views.OtherForm.swing.PictureBox pictureBox1;
    private Views.OtherForm.swing.PictureBox pictureBox2;
    private Views.OtherForm.swing.PictureBox pictureBox3;
    // End of variables declaration//GEN-END:variables
}
