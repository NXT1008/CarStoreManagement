
package Views.OtherForm.component.Card;

import DAO.FormatMoney;
import Models.Xe;
import Views.OtherForm.swing.PanelRound_Border;
import Views.OtherForm.swing.PictureBox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Card_CarHome2 extends javax.swing.JPanel {
    
    public PictureBox getPicture(){
        return picHinhAnh;
    }
    
    public PanelRound_Border getPanelRound(){
        return panelRound_Border1;
    }
    
    public Card_CarHome2() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        setEnabled(true);
        setFocusable(true);
        
    }
    
    public void setData(Xe xe){
        
        lblTenXe.setText(xe.getTenXe());
        lblHangXe.setText(xe.getHangXe());
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Các mã vẽ khác
    }

    public void addCardClickListener(MouseListener event){
        this.addMouseListener(event);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound_Border1 = new Views.OtherForm.swing.PanelRound_Border();
        lblTenXe = new javax.swing.JLabel();
        picHinhAnh = new Views.OtherForm.swing.PictureBox();
        lblGiaBan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblHangXe = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setOpaque(false);

        panelRound_Border1.setColor(new java.awt.Color(234, 233, 233));
        panelRound_Border1.setColorClick(new java.awt.Color(0, 153, 255));
        panelRound_Border1.setColorOver(new java.awt.Color(153, 204, 255));
        panelRound_Border1.setRoundBottomLeft(30);
        panelRound_Border1.setRoundBottomRight(30);
        panelRound_Border1.setRoundTopLeft(30);
        panelRound_Border1.setRoundTopRight(30);

        lblTenXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenXe.setText("Car Name");

        picHinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // NOI18N

        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGiaBan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaBan.setText("300,000,000");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("VNĐ");

        lblHangXe.setForeground(new java.awt.Color(102, 102, 102));
        lblHangXe.setText("Hãng Xe");

        javax.swing.GroupLayout panelRound_Border1Layout = new javax.swing.GroupLayout(panelRound_Border1);
        panelRound_Border1.setLayout(panelRound_Border1Layout);
        panelRound_Border1Layout.setHorizontalGroup(
            panelRound_Border1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound_Border1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound_Border1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addGroup(panelRound_Border1Layout.createSequentialGroup()
                        .addComponent(lblGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(panelRound_Border1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblHangXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        panelRound_Border1Layout.setVerticalGroup(
            panelRound_Border1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound_Border1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenXe)
                .addGap(3, 3, 3)
                .addComponent(lblHangXe)
                .addGap(4, 4, 4)
                .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelRound_Border1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaBan)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound_Border1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound_Border1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblHangXe;
    private javax.swing.JLabel lblTenXe;
    private Views.OtherForm.swing.PanelRound_Border panelRound_Border1;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    // End of variables declaration//GEN-END:variables
}


