
package Views.OtherForm.component.Card;

import DAO.FormatMoney;
import Models.TopCarBestSell;
import Models.Xe;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card_CarBestSell extends javax.swing.JPanel {
    
    public JLabel getLblSoLuongXeDaBan(){
        return lblSoLuongXeDaBan;
    }
    
    public void setLblSoLuongXeDaBan(int soLuong){
        lblSoLuongXeDaBan.setText(String.valueOf(soLuong));
    }
  
    public Card_CarBestSell() {
        initComponents();
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }

    
    
    public void setData(TopCarBestSell xe){
        lblTenXe.setText(xe.getTenXe());
        lblGiaBan.setText(FormatMoney.formatMoney(xe.getGiaBan()));
        if (xe.getHinhAnh() != null){
            try {
                // Chuyển đổi mảng byte thành Image
                ByteArrayInputStream bis = new ByteArrayInputStream(xe.getHinhAnh());
                Image image = ImageIO.read(bis);
                if (image == null) {
                    picHinhAnh.setImage(new ImageIcon(getClass().getResource("/Views/OtherForm/Image/5.png"))); // Xóa bỏ hình ảnh hiện tại nếu có
                    picHinhAnh.setBackground(Color.WHITE);
                    picHinhAnh.repaint();
                    picHinhAnh.setBackground(Color.WHITE);
                } else {
                    // Chuyển đổi Image thành ImageIcon
                    ImageIcon icon = new ImageIcon(image);

                    // Đặt ImageIcon vào JLabel để hiển thị hình ảnh
                    picHinhAnh.setImage(icon);
                    picHinhAnh.setBackground(Color.WHITE);
                    picHinhAnh.repaint();
                    picHinhAnh.setBackground(Color.WHITE);
                }
            } catch (IOException ex) {
            }
        }
        else{
            picHinhAnh.setImage(new ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // Xóa bỏ hình ảnh hiện tại nếu có
            picHinhAnh.setBackground(Color.WHITE);
            picHinhAnh.repaint();
            picHinhAnh.setBackground(Color.WHITE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        panelRound1 = new Views.OtherForm.swing.PanelRound();
        picHinhAnh = new Views.OtherForm.swing.PictureBox();
        lblTenXe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblGiaBan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblSoLuongXeDaBan = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setOpaque(false);

        panelRound1.setBackground(new java.awt.Color(243, 214, 193));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        picHinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // NOI18N

        lblTenXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenXe.setText("Car Name");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Giá: ");

        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGiaBan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaBan.setText("500,000,000");

        jLabel7.setText("VNĐ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Số lượng xe đã bán:");

        jLabel8.setText("chiếc");

        lblSoLuongXeDaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongXeDaBan.setText("300");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7))
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblSoLuongXeDaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoLuongXeDaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblSoLuongXeDaBan;
    private javax.swing.JLabel lblTenXe;
    private Views.OtherForm.swing.PanelRound panelRound1;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    // End of variables declaration//GEN-END:variables
}
