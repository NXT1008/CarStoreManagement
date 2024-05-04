
package Views.OtherForm.component.Card;

import Models.KhoXe;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Card_KhoXe extends javax.swing.JPanel {

    public Card_KhoXe() {
        initComponents();
        
    }

    public void setData(KhoXe xe){
        lblItemID.setText(xe.getMaXe());
        lblName.setText(xe.getTenXe());
        if (xe.getHinhAnh() != null){
            try {
                // Chuyển đổi mảng byte thành Image
                ByteArrayInputStream bis = new ByteArrayInputStream(xe.getHinhAnh());
                Image image = ImageIO.read(bis);
                if (image == null) {
                    picHinhAnh.setImage(new ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // Xóa bỏ hình ảnh hiện tại nếu có
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
        
        lblSoLuongXeCon.setText("Số lượng xe còn: " + xe.getSoLuongXeCon());
        lblSoLuongXeDaBan.setText("Số lượng xe bán: " + xe.getSoLuongXeDaBan());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound22 = new Views.OtherForm.swing.PanelRound_Border();
        lblName = new javax.swing.JLabel();
        picHinhAnh = new Views.OtherForm.swing.PictureBox();
        lblSoLuongXeCon = new javax.swing.JLabel();
        lblSoLuongXeDaBan = new javax.swing.JLabel();
        lblItemID = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelRound22.setBackground(new java.awt.Color(255, 255, 255));
        panelRound22.setBorderColor(new java.awt.Color(51, 102, 255));
        panelRound22.setColor(java.awt.Color.white);
        panelRound22.setColorClick(new java.awt.Color(0, 153, 255));
        panelRound22.setColorOver(new java.awt.Color(153, 204, 255));
        panelRound22.setRoundBottomLeft(40);
        panelRound22.setRoundBottomRight(40);
        panelRound22.setRoundTopLeft(40);
        panelRound22.setRoundTopRight(40);

        lblName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(153, 51, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Item Name");

        picHinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/10.png"))); // NOI18N

        lblSoLuongXeCon.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSoLuongXeCon.setForeground(new java.awt.Color(51, 51, 51));
        lblSoLuongXeCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuongXeCon.setText("Số lượng xe còn: ");

        lblSoLuongXeDaBan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSoLuongXeDaBan.setForeground(new java.awt.Color(51, 51, 51));
        lblSoLuongXeDaBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuongXeDaBan.setText("Số lượng xe bán: ");

        lblItemID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblItemID.setForeground(new java.awt.Color(0, 0, 255));
        lblItemID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItemID.setText("ItemID");

        javax.swing.GroupLayout panelRound22Layout = new javax.swing.GroupLayout(panelRound22);
        panelRound22.setLayout(panelRound22Layout);
        panelRound22Layout.setHorizontalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblItemID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSoLuongXeCon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
            .addComponent(lblSoLuongXeDaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound22Layout.setVerticalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound22Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(lblItemID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoLuongXeCon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoLuongXeDaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSoLuongXeCon;
    private javax.swing.JLabel lblSoLuongXeDaBan;
    private Views.OtherForm.swing.PanelRound_Border panelRound22;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    // End of variables declaration//GEN-END:variables
}
