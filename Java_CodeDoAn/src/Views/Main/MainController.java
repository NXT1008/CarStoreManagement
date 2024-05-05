package Views.Main;

import DAO.KhoXeDAO;
import Models.TaiKhoan;
import Models.Xe;
import Views.Login.LoginForm.fLogin;
import Views.OtherForm.fChiNhanh;
import Views.OtherForm.fChiTietXe;
import Views.OtherForm.fDichVuBaoDuong;
import Views.OtherForm.fDoanhThu;
import Views.OtherForm.fHoaDon;
import Views.OtherForm.fHome;
import Views.OtherForm.fHome.CardClickListener;
import Views.OtherForm.fKhachHang;
import Views.OtherForm.fKho;
import Views.OtherForm.fLapBieuDo;
import Views.OtherForm.fNhaCungCap;
import Views.OtherForm.fNhanVien;
import Views.OtherForm.fOTo;
import Views.OtherForm.fPhieuBaoDuong;
import Views.OtherForm.fPhieuNhap;
import Views.OtherForm.fProfile;
import Views.OtherForm.fThanhToan;
import Views.OtherForm.fThongKe;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import raven.alerts.MessageAlerts;
import raven.popup.GlassPanePopup;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import raven.toast.Notifications;

public class MainController extends javax.swing.JFrame {

    private fNhanVien fNhanVien;
    private fOTo fOTo;
    private fKhachHang fKhachhang;
    private fChiNhanh fChiNhanh;
    private fHoaDon fHoaDon;
    private fDichVuBaoDuong fDichVuBaoDuong;
    private fNhaCungCap fNhaCungCap;
    private fPhieuNhap fPhieuNhap;
    private fKho fKho;
    private fPhieuBaoDuong fPhieuBaoDuong;
    private fThongKe fThongKe;
    private fDoanhThu fDoanhThu;
    private fLapBieuDo fBieuDo;
    private fHome fHome;
    private fProfile fProfile;
    private fChiTietXe fChiTietXe;
    private fThanhToan fThanhToan;

    private Xe car;

    public MainController() {
//        // Thiết lập kích thước cửa sổ mặc định
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setPreferredSize(screenSize);
//        
//        // Mở rộng cửa sổ ra toàn bộ màn hình
//        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        // Install to custom message
        GlassPanePopup.install(this);

        TaiKhoan tk = fLogin.getTk();

        fNhanVien = new fNhanVien();
        fOTo = new fOTo();
        fKhachhang = new fKhachHang();
        fChiNhanh = new fChiNhanh();
        fHoaDon = new fHoaDon();
        fDichVuBaoDuong = new fDichVuBaoDuong();
        fNhaCungCap = new fNhaCungCap();
        fPhieuNhap = new fPhieuNhap();
        fKho = new fKho();
        fPhieuBaoDuong = new fPhieuBaoDuong();
        fThongKe = new fThongKe();
        //fchart = new fChartHoaDon();
        fDoanhThu = new fDoanhThu();
        fBieuDo = new fLapBieuDo();

        fHome = new fHome();

        fProfile = new fProfile(tk.getMaNhanVien());
        fChiTietXe = new fChiTietXe();
        fThanhToan = new fThanhToan();

        initComponents();
        init();

        setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(MainController.this);

        // Load home
        setForm(fHome);

        // Event để mở Menu
        menu.addEventMenu((int index) -> {
            System.out.println(String.valueOf(index));
            //System.out.println(tk.getTenDangNhap());
            //Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, (long) 200, "Message");
            refreshData();
            switch (index) {
                case 0 -> {
                    setForm(fHome);
                }
                case 1 -> {
                    if (tk.isIsAdmin()){
                        setForm(fNhanVien);
                    }
                    else{
                        MessageAlerts.getInstance().showMessage("Cảnh báo!!!", 
                                "Chức năng này chỉ dành cho quản lý!", MessageAlerts.MessageType.ERROR);
                    }
                }
                case 2 ->
                    setForm(fOTo);
                case 3 -> // Khách Hàng
                    setForm(fKhachhang);
                case 4 -> {
                    if (tk.isIsAdmin()){
                        setForm(fChiNhanh);
                    }
                    else{
                        MessageAlerts.getInstance().showMessage("Cảnh báo!!!", 
                                "Chức năng này chỉ dành cho quản lý!", MessageAlerts.MessageType.ERROR);
                    }
                }
                case 5 ->
                    setForm(fNhaCungCap);
                case 6 ->
                    setForm(fHoaDon);
                case 7 ->
                    setForm(fPhieuNhap);
                case 8 ->
                    setForm(fKho);
                case 9 ->
                    setForm(fDichVuBaoDuong);
                case 10 ->
                    setForm(fPhieuBaoDuong);
                case 11 ->
                    setForm(fDoanhThu);
                case 12 ->
                    setForm(fThongKe);
                case 13 ->
                    setForm(fBieuDo);
                case 14 -> {
                    MessageAlerts.getInstance().showMessage("Cảnh báo", "Bạn có thật sự muốn thoát?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                        @Override
                        public void action(PopupController pc, int i) {
                            if (i == MessageAlerts.YES_OPTION) {
                                setVisible(false);
                                new fLogin().setVisible(true);
                            }
                        }
                    });
                }
                default -> {

                }
            }
        });

        // Event to open profile
        JMenuItem menuItemProfile = header.getMenuItemProfile();
        menuItemProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setForm(fProfile);
            }
        });

        // Card Click in home => move to fChiTietXe
        fHome.setCardClickListener(new CardClickListener() {
            @Override
            public void onCardClicked(Xe xe) {
                if (!KhoXeDAO.getInstance().kiemTraXeCon(xe.getMaXe())) {
                    MessageAlerts.getInstance().showMessage("Xin thông báo!!!", "Mẫu xe này hiện tại đã hết. \n "
                            + "Chúng tôi sẽ nhập mẫu xe này về trong thời gian sớm nhất. "
                            + "Xin cảm ơn!", MessageAlerts.MessageType.ERROR);
                    return;
                }

                setForm(fChiTietXe);
                car = xe;
                //System.out.println(xe.getTenXe());
                fChiTietXe.setData(xe);
                fChiTietXe.getBtnQuayLai().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setForm(fHome);
                    }
                });
                fChiTietXe.getBtnMuaXe().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setForm(fThanhToan);
                        fThanhToan.setData(car);
                    }

                });
            }
        });

        //fThanhToan move back
        fThanhToan.getBtnQuayLai().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setForm(fChiTietXe);
            }
        });

        header.initData();

    }

    private void refreshData() {
        // Load lại dữ liệu cho các form khi cần
        fNhanVien.loadData(); // Load dữ liệu cho form Nhân viên
        fOTo.loadData(); // Load dữ liệu cho form Ô tô
        fKhachhang.loadData(); // Load dữ liệu cho form Khách hàng
        fChiNhanh.loadData(); // Load dữ liệu cho form Chi nhánh
        fNhaCungCap.loadData(); // Load dữ liệu cho form Nhà cung cấp
        fHoaDon.loadData(); // Load dữ liệu cho form Hóa đơn
        fPhieuNhap.loadData(); // Load dữ liệu cho form Phiếu nhập
        fDichVuBaoDuong.loadData(); // Load dữ liệu cho form Dịch vụ bảo dưỡng
        fPhieuBaoDuong.loadData(); // Load dữ liệu cho form Phiếu bảo dưỡng
        fThongKe.LoadDataToCard();// Load dữ liệu cho form Thống kê
        fDoanhThu.loadData(); // Load dữ liệu cho form Doanh thu
//        fBieuDo.loadData(); // Load dữ liệu cho form Biểu đồ
        fHome.loadAll(); // Load dữ liệu cho form Trang chủ (nếu cần)
        fProfile.initAll();// Cập nhật thông tin profile
        fKho.loadData();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));  //  Remove background
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoder2 = new Views.Main.swing.PanelBoder();
        menu = new Views.Main.component.Menu();
        mainPanel = new javax.swing.JPanel();
        header = new Views.Main.component.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 243, 243));
        setUndecorated(true);

        panelBoder2.setOpaque(true);

        menu.setRoundBottomLeft(20);
        menu.setRoundTopLeft(20);

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBoder2Layout = new javax.swing.GroupLayout(panelBoder2);
        panelBoder2.setLayout(panelBoder2Layout);
        panelBoder2Layout.setHorizontalGroup(
            panelBoder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoder2Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBoder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBoder2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelBoder2Layout.setVerticalGroup(
            panelBoder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(panelBoder2Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Main.component.Header header;
    private javax.swing.JPanel mainPanel;
    private Views.Main.component.Menu menu;
    private Views.Main.swing.PanelBoder panelBoder2;
    // End of variables declaration//GEN-END:variables

}
