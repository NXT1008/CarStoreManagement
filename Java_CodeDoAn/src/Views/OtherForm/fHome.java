package Views.OtherForm;

import Models.NhanVien;
import Models.Xe;
import Services.NhanVienService;
import Services.XeService;
import Views.Login.LoginForm.fLogin;
import Views.Main.swing.ScrollBar;
import Views.OtherForm.component.Card.Card_CarHome;
import Views.OtherForm.component.Card.Card_CarHome1;
import Views.OtherForm.component.Card.Card_CarHome2;
import Views.OtherForm.swing.WrapLayout;
import groovyjarjarantlr.debug.MessageAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import raven.alerts.MessageAlerts;



public class fHome extends javax.swing.JPanel{

    public fHome() {
        initComponents();
        loadAll();

    }

    public void loadAll() {
        loadData();
        loadHome();
        NhanVien nv = NhanVienService.getInstance().findOne(fLogin.getTk().getMaNhanVien());
        lblTenNhanVien.setText(nv.getHoTenNhanVien());
        searchText.setText("");
    }

    // Load New Car
    private void loadData() {
        Xe xe1 = XeService.getInstance().findTop1();
        cardTop1.setData(xe1);

        Xe xe2 = XeService.getInstance().findTop2();
        cardTop2.setData(xe2);
        
        cardTop1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (listener != null) {
                    listener.onCardClicked(xe1); // Thông báo rằng một card đã được click
                }
            }
        });
        
        cardTop2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (listener != null) {
                    listener.onCardClicked(xe2); // Thông báo rằng một card đã được click
                }
            }
        });

    }
    
    public Card_CarHome getCardTop1(){
        return cardTop1;
    }
    
    public Card_CarHome1 getCardTop2(){
        return cardTop2;
    }

    // Load All Car
    public void loadHome(){
        panelHome.removeAll();
        panelHome.setLayout(new WrapLayout(WrapLayout.LEADING, 20, 20));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        List<Xe> list = XeService.getInstance().danhSachXe();
        for (Xe o : list) {
            Card_CarHome2 card = new Card_CarHome2();
            card.setData(o);
            
            panelHome.add(card);
            
            card.getPanelRound().addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(listener != null) {
                        listener.onCardClicked(o); // Thông báo rằng một card đã được click
                    }
                }
            });
            
            panelHome.revalidate();
            panelHome.repaint();
        }
    }

    private CardClickListener listener;

    public void setCardClickListener(CardClickListener listener) {
        this.listener = listener;
    }
    
    public interface CardClickListener {
        void onCardClicked(Xe xe);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        panelRound1 = new Views.OtherForm.swing.PanelRound();
        searchText = new Views.Main.swing.SearchText();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pictureBox1 = new Views.OtherForm.swing.PictureBox();
        cardTop1 = new Views.OtherForm.component.Card.Card_CarHome();
        cardTop2 = new Views.OtherForm.component.Card.Card_CarHome1();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelHome = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pictureBox2 = new Views.OtherForm.swing.PictureBox();

        setBackground(new java.awt.Color(247, 246, 249));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Good Morning,");

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTenNhanVien.setText("Nguyễn Xuân Thể");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Main/icon/search.png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Mẫu OTo Mới Ra Mắt");

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Icon/icons8-fire-25.png"))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        panelHome.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelHome);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Lựa chọn khác");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(cardTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(cardTop2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardTop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTenNhanVien)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardTop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // Lấy từ khóa tìm kiếm từ searchText1
        String keyword = searchText.getText().trim();

        // Load lại danh sách xe dựa trên từ khóa tìm kiếm
        List<Xe> list = XeService.getInstance().timKiemXe(keyword);
        
        // Nếu danh sách xe rỗng
        if (list.isEmpty()){
            MessageAlerts.getInstance().showMessage("Xin lỗi", "Không tìm thấy mẫu xe này", 
                    MessageAlerts.MessageType.ERROR);
        }

        else{
             // Xóa các card hiện có trong panelHome
            panelHome.removeAll();
        
            // Hiển thị danh sách xe lên panelHome
            for (Xe o : list) {
                Card_CarHome2 card = new Card_CarHome2();
                card.setData(o);

                panelHome.add(card);

                card.getPanelRound().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (listener != null) {
                            listener.onCardClicked(o); // Thông báo rằng một card đã được click
                        }
                    }
                });
            }

            // Yêu cầu panelHome vẽ lại giao diện
            panelHome.revalidate();
            panelHome.repaint();
        }
    }//GEN-LAST:event_searchTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.component.Card.Card_CarHome cardTop1;
    private Views.OtherForm.component.Card.Card_CarHome1 cardTop2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JPanel panelHome;
    private Views.OtherForm.swing.PanelRound panelRound1;
    private Views.OtherForm.swing.PictureBox pictureBox1;
    private Views.OtherForm.swing.PictureBox pictureBox2;
    private Views.Main.swing.SearchText searchText;
    // End of variables declaration//GEN-END:variables
}
