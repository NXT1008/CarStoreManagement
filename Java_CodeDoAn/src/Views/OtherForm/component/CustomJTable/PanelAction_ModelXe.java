
package Views.OtherForm.component.CustomJTable;

import Models.Xe;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class PanelAction_ModelXe extends javax.swing.JPanel {

    public PanelAction_ModelXe() {
        initComponents();
    }
    
    public void setData(Xe xe){
        lblTenXe.setText(xe.getTenXe());
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

        panelRound1 = new Views.OtherForm.swing.PanelRound();
        lblTenXe = new javax.swing.JLabel();
        picHinhAnh = new Views.OtherForm.swing.PictureBox();

        setBackground(new java.awt.Color(204, 204, 204));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        lblTenXe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenXe.setText("Tên Xe");

        picHinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(picHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(picHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTenXe;
    private Views.OtherForm.swing.PanelRound panelRound1;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    // End of variables declaration//GEN-END:variables
}
