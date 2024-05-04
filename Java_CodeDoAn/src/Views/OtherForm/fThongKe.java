
package Views.OtherForm;

import DAO.KhoXeDAO;
import Models.HoaDon;
import Models.KhachHang;
import Models.NhanVien;
import Models.PhieuBaoDuong;
import Models.PhieuNhap;
import Models.Xe;
import Services.HoaDonService;
import Services.KhachHangService;
import Services.NhanVienService;
import Services.PhieuBaoDuongService;
import Services.PhieuNhapService;
import Services.XeService;
import Views.Main.Model.Model_Card;
import java.util.List;
import javax.swing.ImageIcon;


public class fThongKe extends javax.swing.JPanel {


    public fThongKe() {
        initComponents();
        LoadDataToCard();
        
    }

    public void LoadDataToCard(){
        List<KhachHang> listKH = KhachHangService.getInstance().danhSachKhachHang();
        List<NhanVien> listNV = NhanVienService.getInstance().danhSachNhanVien();
        List<Xe> listOto = XeService.getInstance().danhSachXe();
        int soLuongOTO = KhoXeDAO.getInstance().tongSoLuongXe();
        List<HoaDon> listHD = HoaDonService.getInstance().danhSachHoaDon();
        List<PhieuNhap> listPN = PhieuNhapService.getInstance().danhSachPhieuNhap();
        List<PhieuBaoDuong> listPBD = PhieuBaoDuongService.getInstance().danhSachPhieuBaoDuong();
        
        int soLuongKH = listKH.size();
        int soLuongHD = listHD.size();
        int soluongOTo = listOto.size();
        int soLuongNV = listNV.size();
        int soLuongPN = listPN.size();
        int soLuongPBD = listPBD.size();
        
        cardTongNhanVien.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/customer.png")), "Số Lượng Nhân Viên", String.valueOf(soLuongNV), "Increased by 25%"));
        cardTongKhachHang.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/employee.png")), "Số Lượng Khách Hàng", String.valueOf(soLuongKH) + " khách", "Increased by 60%"));
        cardTongOTo.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/car.png")), "Số Lượng Ô Tô", String.valueOf(soLuongOTO) + " chiếc", "Increased by 70%"));
        cardTongHoaDon.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/invoice.png")), "Tổng Hóa Đơn", String.valueOf(soLuongHD) + " hóa đơn", "Increased by 25%"));
        cardTongPhieuNhap.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/receipt.png")), "Tổng Phiếu Nhập", String.valueOf(soLuongPN) + " phiếu", "Increased by 25%"));
        cardTongPhieuBaoDuong.setData(new Model_Card(new ImageIcon(getClass().getResource("/Views/Main/icon/maintaince_bill.png")), "Tổng Phiếu Bảo Dưỡng", String.valueOf(soLuongPBD) + " phiếu", "Increased by 25%"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        cardTongNhanVien = new Views.Main.component.Card();
        cardTongKhachHang = new Views.Main.component.Card();
        cardTongOTo = new Views.Main.component.Card();
        cardTongHoaDon = new Views.Main.component.Card();
        cardTongPhieuNhap = new Views.Main.component.Card();
        cardTongPhieuBaoDuong = new Views.Main.component.Card();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 246, 249));

        jLayeredPane1.setLayout(new java.awt.GridLayout(2, 2, 10, 20));

        cardTongNhanVien.setColor1(new java.awt.Color(149, 95, 203));
        cardTongNhanVien.setColor2(new java.awt.Color(87, 22, 186));
        jLayeredPane1.add(cardTongNhanVien);

        cardTongKhachHang.setColor1(new java.awt.Color(121, 222, 142));
        cardTongKhachHang.setColor2(new java.awt.Color(0, 149, 60));
        jLayeredPane1.add(cardTongKhachHang);

        cardTongOTo.setColor1(new java.awt.Color(80, 154, 253));
        cardTongOTo.setColor2(new java.awt.Color(0, 0, 255));
        jLayeredPane1.add(cardTongOTo);

        cardTongHoaDon.setColor1(new java.awt.Color(255, 173, 119));
        cardTongHoaDon.setColor2(new java.awt.Color(178, 73, 2));
        jLayeredPane1.add(cardTongHoaDon);

        cardTongPhieuNhap.setColor1(new java.awt.Color(255, 197, 204));
        cardTongPhieuNhap.setColor2(new java.awt.Color(228, 63, 86));
        jLayeredPane1.add(cardTongPhieuNhap);

        cardTongPhieuBaoDuong.setColor1(new java.awt.Color(108, 215, 210));
        cardTongPhieuBaoDuong.setColor2(new java.awt.Color(1, 86, 85));
        jLayeredPane1.add(cardTongPhieuBaoDuong);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ SỐ LƯỢNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Main.component.Card cardTongHoaDon;
    private Views.Main.component.Card cardTongKhachHang;
    private Views.Main.component.Card cardTongNhanVien;
    private Views.Main.component.Card cardTongOTo;
    private Views.Main.component.Card cardTongPhieuBaoDuong;
    private Views.Main.component.Card cardTongPhieuNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
