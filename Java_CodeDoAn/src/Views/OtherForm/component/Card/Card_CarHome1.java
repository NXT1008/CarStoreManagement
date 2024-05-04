
package Views.OtherForm.component.Card;

import DAO.FormatMoney;
import Models.Xe;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Card_CarHome1 extends javax.swing.JPanel {

  
    public Card_CarHome1() {
        initComponents();
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }

    public void setData(Xe xe){
        lblTenXe.setText(xe.getTenXe());
        lblXuatXu.setText(xe.getXuatXu());
        lblTrongLuong.setText(String.valueOf(xe.getTrongLuong()));
        lblHangXe.setText(xe.getHangXe());
        lblCongSuatDongCo.setText(String.valueOf(xe.getCongSuatDongCo()));
        lblLoaiDongCo.setText(xe.getLoaiDongCo());
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
        panelRound2 = new Views.OtherForm.swing.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        lblXuatXu = new javax.swing.JLabel();
        panelRound3 = new Views.OtherForm.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        lblHangXe = new javax.swing.JLabel();
        panelRound4 = new Views.OtherForm.swing.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        lblTrongLuong = new javax.swing.JLabel();
        panelRound5 = new Views.OtherForm.swing.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        lblCongSuatDongCo = new javax.swing.JLabel();
        lblTenXe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblGiaBan = new javax.swing.JLabel();
        panelRound6 = new Views.OtherForm.swing.PanelRound();
        jLabel11 = new javax.swing.JLabel();
        lblLoaiDongCo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setOpaque(false);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        picHinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // NOI18N

        panelRound2.setBackground(new java.awt.Color(252, 225, 205));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Xuất Xứ");

        lblXuatXu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblXuatXu.setForeground(new java.awt.Color(24, 23, 25));
        lblXuatXu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXuatXu.setText("Nhật Bản");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(lblXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblXuatXu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(238, 239, 180));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hãng Xe");

        lblHangXe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHangXe.setForeground(new java.awt.Color(24, 23, 25));
        lblHangXe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHangXe.setText("Toyota");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHangXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHangXe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound4.setBackground(new java.awt.Color(230, 235, 252));
        panelRound4.setRoundBottomLeft(30);
        panelRound4.setRoundBottomRight(30);
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Trọng Lượng");

        lblTrongLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrongLuong.setForeground(new java.awt.Color(24, 23, 25));
        lblTrongLuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrongLuong.setText("1530");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrongLuong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound5.setBackground(new java.awt.Color(247, 237, 255));
        panelRound5.setRoundBottomLeft(30);
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Công Suất");

        lblCongSuatDongCo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCongSuatDongCo.setForeground(new java.awt.Color(24, 23, 25));
        lblCongSuatDongCo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCongSuatDongCo.setText("250 ");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCongSuatDongCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCongSuatDongCo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTenXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenXe.setText("Car Name");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Giá: ");

        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGiaBan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaBan.setText("500,000,000");

        panelRound6.setBackground(new java.awt.Color(187, 234, 192));
        panelRound6.setRoundBottomLeft(30);
        panelRound6.setRoundBottomRight(30);
        panelRound6.setRoundTopLeft(30);
        panelRound6.setRoundTopRight(30);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Loại Động Cơ");

        lblLoaiDongCo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLoaiDongCo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoaiDongCo.setText("Diesel Bi-Turbo");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLoaiDongCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLoaiDongCo)
                .addContainerGap())
        );

        jLabel7.setText("VNĐ");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(lblTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(lblTenXe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblCongSuatDongCo;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblHangXe;
    private javax.swing.JLabel lblLoaiDongCo;
    private javax.swing.JLabel lblTenXe;
    private javax.swing.JLabel lblTrongLuong;
    private javax.swing.JLabel lblXuatXu;
    private Views.OtherForm.swing.PanelRound panelRound1;
    private Views.OtherForm.swing.PanelRound panelRound2;
    private Views.OtherForm.swing.PanelRound panelRound3;
    private Views.OtherForm.swing.PanelRound panelRound4;
    private Views.OtherForm.swing.PanelRound panelRound5;
    private Views.OtherForm.swing.PanelRound panelRound6;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    // End of variables declaration//GEN-END:variables
}
