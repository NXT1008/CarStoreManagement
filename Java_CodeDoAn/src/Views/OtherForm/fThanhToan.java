
package Views.OtherForm;

import DAO.FormatMoney;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import Models.HoaDon;
import Models.KhachHang;
import Models.NhanVien;
import Models.Xe;
import Report.Fields_Report_ThanhToan;
import Report.Parameter_Report_ThanhToan;
import Report.ReportManager_ThanhToan;
import Services.KhachHangService;
import Services.NhanVienService;
import Views.Login.LoginForm.fLogin;
import Views.OtherForm.swing.MyButton;
import Views.OtherForm.swing.TextField_2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import raven.alerts.MessageAlerts;


public class fThanhToan extends javax.swing.JPanel {

    private Xe xe = new Xe();
    
    public MyButton getBtnQuayLai(){
        return btnQuayLai;
    }
    
    public MyButton getBtnThanhToan(){
        return btnThanhToan;
    }
    
    public String getHoTenKhacHang(){
        return tfHo.getText() + " " + tfTen.getText();
    }

    public fThanhToan() {
        initComponents();
        loadAll();
    }
    
    public void setData(Xe xe){
        this.xe = xe;
        tfTenXe.setText(xe.getTenXe());
        tfGia.setText(FormatMoney.formatMoney(xe.getGiaBan()));
        tfHangXe.setText(xe.getHangXe());
        tfXuatXu.setText(xe.getXuatXu());
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
        long giaBan = xe.getGiaBan();
        long thueVAT = (long)((long)xe.getGiaBan() * 0.1);
        long tongTien = (long)((long)xe.getGiaBan() * 1.1 + 20000000);
        lblGiaBan.setText(FormatMoney.formatMoney(giaBan));
        lblThueVAT.setText(FormatMoney.formatMoney(thueVAT));
        lblTongTien.setText(FormatMoney.formatMoney(tongTien));
    }

    private void loadAll(){
        loadTinhThanh();
        loadGioiTinh();
    }
    
    private void loadGioiTinh(){
        List<String> list = new ArrayList<>();
        list.add("Nam");
        list.add("Nữ");
        String[] arr = new String[list.size()];
        for (int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbGioiTinh.setModel(model);
    }
    
    private void loadTinhThanh(){
        // Tạo danh sách chứa 63 tỉnh thành
        List<String> tinhThanh = new ArrayList<>();
        
        // Thêm các tỉnh thành vào danh sách
        tinhThanh.add("Hà Nội");
        tinhThanh.add("Hồ Chí Minh");
        tinhThanh.add("Hải Phòng");
        tinhThanh.add("Đà Nẵng");
        tinhThanh.add("Cần Thơ");
        tinhThanh.add("Hà Giang");
        tinhThanh.add("Cao Bằng");
        tinhThanh.add("Lai Châu");
        tinhThanh.add("Lào Cai");
        tinhThanh.add("Tuyên Quang");
        tinhThanh.add("Lạng Sơn");
        tinhThanh.add("Bắc Kạn");
        tinhThanh.add("Thái Nguyên");
        tinhThanh.add("Yên Bái");
        tinhThanh.add("Sơn La");
        tinhThanh.add("Phú Thọ");
        tinhThanh.add("Vĩnh Phúc");
        tinhThanh.add("Bắc Giang");
        tinhThanh.add("Bắc Ninh");
        tinhThanh.add("Quảng Ninh");
        tinhThanh.add("Hòa Bình");
        tinhThanh.add("Hà Nam");
        tinhThanh.add("Nam Định");
        tinhThanh.add("Thái Bình");
        tinhThanh.add("Ninh Bình");
        tinhThanh.add("Thanh Hóa");
        tinhThanh.add("Nghệ An");
        tinhThanh.add("Hà Tĩnh");
        tinhThanh.add("Quảng Bình");
        tinhThanh.add("Quảng Trị");
        tinhThanh.add("Thừa Thiên Huế");
        tinhThanh.add("Quảng Nam");
        tinhThanh.add("Quảng Ngãi");
        tinhThanh.add("Bình Định");
        tinhThanh.add("Phú Yên");
        tinhThanh.add("Khánh Hòa");
        tinhThanh.add("Ninh Thuận");
        tinhThanh.add("Bình Thuận");
        tinhThanh.add("Kon Tum");
        tinhThanh.add("Gia Lai");
        tinhThanh.add("Đắk Lắk");
        tinhThanh.add("Đắk Nông");
        tinhThanh.add("Lâm Đồng");
        tinhThanh.add("Bình Phước");
        tinhThanh.add("Tây Ninh");
        tinhThanh.add("Bình Dương");
        tinhThanh.add("Đồng Nai");
        tinhThanh.add("Bà Rịa - Vũng Tàu");
        tinhThanh.add("Long An");
        tinhThanh.add("Tiền Giang");
        tinhThanh.add("Bến Tre");
        tinhThanh.add("Trà Vinh");
        tinhThanh.add("Vĩnh Long");
        tinhThanh.add("Đồng Tháp");
        tinhThanh.add("An Giang");
        tinhThanh.add("Kiên Giang");
        tinhThanh.add("Cần Thơ");
        tinhThanh.add("Hậu Giang");
        tinhThanh.add("Sóc Trăng");
        tinhThanh.add("Bạc Liêu");
        tinhThanh.add("Cà Mau");
        tinhThanh.add("Điện Biên");
        tinhThanh.add("Sơn La");
        
        String[] arr = new String[tinhThanh.size()];
        for (int i=0; i<tinhThanh.size(); i++){
            arr[i] = tinhThanh.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
        cbbTinhThanh.setModel(model);

    }
    
    private void loadQuanHuyen(String tenTinh){
        // Danh sách các quận (huyện) tương ứng với mỗi tỉnh thành
        Map<String, List<String>> districtMap = new HashMap<>();
        districtMap.put("An Giang", Arrays.asList("An Phú", "Châu Phú", "Châu Thành", "Chợ Mới", "Phú Tân", "Thoại Sơn", "Tịnh Biên", "Tri Tôn"));
        districtMap.put("Bà Rịa - Vũng Tàu", Arrays.asList("Bà Rịa", "Châu Đức", "Côn Đảo", "Đất Đỏ", "Long Điền", "Tân Thành", "Vũng Tàu", "Xuyên Mộc"));
        districtMap.put("Bạc Liêu", Arrays.asList("Bạc Liêu", "Đông Hải", "Giá Rai", "Hòa Bình", "Phước Long"));
        districtMap.put("Bắc Kạn", Arrays.asList("Bắc Kạn", "Bạch Thông", "Chợ Đồn", "Chợ Mới", "Na Rì", "Ngân Sơn", "Pác Nặm"));
        districtMap.put("Bắc Giang", Arrays.asList("Bắc Giang", "Hiệp Hòa", "Lạng Giang", "Lục Nam", "Lục Ngạn", "Sơn Động", "Tân Yên", "Việt Yên", "Yên Dũng", "Yên Thế"));
        districtMap.put("Bắc Ninh", Arrays.asList("Bắc Ninh", "Gia Bình", "Lương Tài", "Quế Võ", "Thuận Thành", "Tiên Du", "Từ Sơn", "Yên Phong"));
        districtMap.put("Bến Tre", Arrays.asList("Ba Tri", "Bến Tre", "Bình Đại", "Châu Thành", "Chợ Lách", "Giồng Trôm", "Mỏ Cày", "Thạnh Phú"));
        districtMap.put("Bình Dương", Arrays.asList("Bàu Bàng", "Bến Cát", "Dầu Tiếng", "Dĩ An", "Phú Giáo", "Tân Uyên", "Thuận An"));
        districtMap.put("Bình Định", Arrays.asList("An Lão", "An Nhơn", "Hoài Ân", "Hoài Nhơn", "Phù Mỹ", "Phù Cát", "Tây Sơn", "Tuy Phước", "Vân Canh", "Vĩnh Thạnh"));
        districtMap.put("Bình Phước", Arrays.asList("Bình Long", "Bù Đăng", "Bù Đốp", "Bù Gia Mập", "Chơn Thành", "Đồng Phú", "Hớn Quản", "Lộc Ninh", "Phú Riềng"));
        districtMap.put("Bình Thuận", Arrays.asList("Bắc Bình", "Đức Linh", "Hàm Tân", "Hàm Thuận Bắc", "Hàm Thuận Nam", "Phan Thiết", "Phú Quý", "Tánh Linh", "Tuy Phong"));
        districtMap.put("Cà Mau", Arrays.asList("Cái Nước", "Đầm Dơi", "Năm Căn", "Ngọc Hiển", "Phú Tân", "Thới Bình", "Trần Văn Thời", "U Minh"));
        districtMap.put("Cao Bằng", Arrays.asList("Bảo Lâm", "Bảo Lạc", "Hạ Lang", "Hà Quảng", "Hòa An", "Nguyên Bình", "Phục Hoà", "Quảng Uyên", "Thạch An", "Thông Nông", "Trà Lĩnh", "Trùng Khánh"));
        districtMap.put("Cần Thơ", Arrays.asList("Bình Thuỷ", "Cái Răng", "Cờ Đỏ", "Ninh Kiều", "Ô Môn", "Thốt Nốt"));
        districtMap.put("Đà Nẵng", Arrays.asList("Cẩm Lệ", "Hải Châu", "Hòa Vang", "Liên Chiểu", "Ngũ Hành Sơn", "Sơn Trà", "Thanh Khê"));
        districtMap.put("Đắk Lắk", Arrays.asList("Buôn Đôn", "Buôn Hồ", "Buôn Ma Thuột", "Cư Kuin", "Cư M'gar", "Krông A Na", "Krông Bông", "Krông Búk", "Krông Năng", "Krông Pắk", "Lắk", "M'Đrắk"));
        districtMap.put("Đắk Nông", Arrays.asList("Cư Jút", "Đắk Glong", "Đắk Mil", "Đắk R'Lấp", "Krông Nô", "Tuy Đức"));
        districtMap.put("Điện Biên", Arrays.asList("Điện Biên", "Điện Biên Đông", "Điện Biên Phủ", "Mường Ảng", "Mường Chà", "Mường Nhé", "Nậm Pồ", "Tủa Chùa", "Tuần Giáo"));
        districtMap.put("Đồng Nai", Arrays.asList("Biên Hòa", "Cẩm Mỹ", "Định Quán", "Long Khánh", "Long Thành", "Nhơn Trạch", "Tân Phú", "Thống Nhất", "Trảng Bom", "Vĩnh Cửu", "Xuân Lộc"));
        districtMap.put("Đồng Tháp", Arrays.asList("Cao Lãnh", "Châu Thành", "Hồng Ngự", "Lai Vung", "Lấp Vò", "Tam Nông", "Tân Hồng", "Thanh Bình", "Tháp Mười"));
        districtMap.put("Gia Lai", Arrays.asList("Chư Păh", "Chư Prông", "Chư Pưh", "Chư Sê", "Đắk Đoa", "Đắk Pơ", "Đức Cơ", "Ia Grai", "Ia Pa", "KBang", "Kông Chro", "Krông Pa", "Mang Yang", "Phú Thiện", "Plei Ku"));
        districtMap.put("Hà Giang", Arrays.asList("Bắc Mê", "Bắc Quang", "Đồng Văn", "Hà Giang", "Hoàng Su Phì", "Mèo Vạc", "Quản Bạ", "Quang Bình", "Vị Xuyên", "Xín Mần", "Yên Minh"));
        districtMap.put("Hà Nam", Arrays.asList("Bình Lục", "Duy Tiên", "Kim Bảng", "Lý Nhân", "Thanh Liêm"));
        districtMap.put("Hà Nội", Arrays.asList("Ba Đình", "Bắc Từ Liêm", "Cầu Giấy", "Đống Đa", "Hà Đông", "Hai Bà Trưng", "Hoàn Kiếm", "Hoàng Mai", "Long Biên", "Nam Từ Liêm", "Tây Hồ", "Thanh Xuân"));
        districtMap.put("Hà Tĩnh", Arrays.asList("Cẩm Xuyên", "Can Lộc", "Đức Thọ", "Hà Tĩnh", "Hồng Lĩnh", "Hương Khê", "Hương Sơn", "Kỳ Anh", "Lộc Hà", "Nghi Xuân", "Thạch Hà", "Vũ Quang"));
        districtMap.put("Hải Dương", Arrays.asList("Bình Giang", "Cẩm Giàng", "Chí Linh", "Gia Lộc", "Hải Dương", "Kim Thành", "Kinh Môn", "Nam Sách", "Ninh Giang", "Thanh Hà", "Thanh Miện", "Tứ Kỳ"));
        districtMap.put("Hải Phòng", Arrays.asList("An Dương", "An Lão", "Bạch Long Vĩ", "Cát Hải", "Dương Kinh", "Hải An", "Hồng Bàng", "Kiến An", "Kiến Thụy", "Lê Chân", "Ngô Quyền", "Thủy Nguyên", "Tiên Lãng", "Vĩnh Bảo"));
        districtMap.put("Hậu Giang", Arrays.asList("Châu Thành", "Châu Thành A", "Long Mỹ", "Phụng Hiệp", "Vị Thanh"));
        districtMap.put("Hòa Bình", Arrays.asList("Cao Phong", "Đà Bắc", "Hòa Bình", "Kim Bôi", "Lạc Sơn", "Lạc Thủy", "Lương Sơn", "Mai Châu", "Tân Lạc", "Yên Thủy"));
        districtMap.put("Hưng Yên", Arrays.asList("Ân Thi", "Hưng Hà", "Khoái Châu", "Kim Động", "Mỹ Hào", "Phù Cừ", "Tiên Lữ", "Văn Giang", "Văn Lâm", "Yên Mỹ"));
        districtMap.put("Khánh Hòa", Arrays.asList("Cam Lâm", "Cam Ranh", "Diên Khánh", "Khánh Sơn", "Khánh Vĩnh", "Nha Trang", "Ninh Hòa", "Trường Sa", "Vạn Ninh"));
        districtMap.put("Kiên Giang", Arrays.asList("An Biên", "An Minh", "Châu Thành", "Giang Thành", "Giồng Riềng", "Gò Quao", "Hà Tiên", "Hòn Đất", "Kiên Hải", "Kiên Lương", "Phú Quốc", "Rạch Giá", "Tân Hiệp", "U Minh Thượng", "Vĩnh Thuận"));
        districtMap.put("Kon Tum", Arrays.asList("Đắk Glei", "Đắk Hà", "Đắk Tô", "Kon Plông", "Kon Rẫy", "Ngọc Hồi", "Sa Thầy", "Tu Mơ Rông"));
        districtMap.put("Lai Châu", Arrays.asList("Mường Tè", "Nậm Nhùn", "Phong Thổ", "Sìn Hồ", "Tam Đường", "Tân Uyên", "Than Uyên"));
        districtMap.put("Lâm Đồng", Arrays.asList("Bảo Lâm", "Bảo Lộc", "Cát Tiên", "Đạ Huoai", "Đà Lạt", "Đạ Tẻh", "Đam Rông", "Di Linh", "Đơn Dương", "Đức Trọng", "Lạc Dương", "Lâm Hà"));
        districtMap.put("Lạng Sơn", Arrays.asList("Bắc Sơn", "Bình Gia", "Cao Lộc", "Chi Lăng", "Đình Lập", "Hữu Lũng", "Lộc Bình", "Tràng Định", "Văn Lãng", "Văn Quan"));
        districtMap.put("Lào Cai", Arrays.asList("Bắc Hà", "Bảo Thắng", "Bảo Yên", "Bát Xát", "Mường Khương", "Sa Pa", "Si Ma Cai", "Văn Bàn"));
        districtMap.put("Long An", Arrays.asList("Bến Lức", "Cần Đước", "Cần Giuộc", "Châu Thành", "Đức Hòa", "Đức Huệ", "Mộc Hóa", "Tân Hưng", "Tân Thạnh", "Tân Trụ", "Thạnh Hóa", "Thủ Thừa", "Vĩnh Hưng"));
        districtMap.put("Nam Định", Arrays.asList("Giao Thủy", "Hải Hậu", "Mỹ Lộc", "Nam Định", "Nam Trực", "Nghĩa Hưng", "Trực Ninh", "Vụ Bản", "Xuân Trường", "Ý Yên"));
        districtMap.put("Nghệ An", Arrays.asList("Anh Sơn", "Con Cuông", "Diễn Châu", "Đô Lương", "Hoàng Mai", "Hưng Nguyên", "Kỳ Sơn", "Nam Đàn", "Nghĩa Đàn", "Quế Phong", "Quỳ Châu", "Quỳ Hợp", "Quỳnh Lưu", "Tân Kỳ", "Thái Hòa", "Thanh Chương", "Tương Dương", "Yên Thành"));
        districtMap.put("Ninh Bình", Arrays.asList("Gia Viễn", "Hoa Lư", "Kim Sơn", "Nho Quan", "Ninh Bình", "Tam Điệp", "Yên Khánh", "Yên Mô"));
        districtMap.put("Ninh Thuận", Arrays.asList("Bác Ái", "Ninh Hải", "Ninh Phước", "Ninh Sơn", "Thuận Bắc", "Thuận Nam"));
        districtMap.put("Phú Thọ", Arrays.asList("Cẩm Khê", "Đoan Hùng", "Hạ Hoà", "Lâm Thao", "Phù Ninh", "Tam Nông", "Tân Sơn", "Thanh Ba", "Thanh Sơn", "Thanh Thủy", "Yên Lập"));
        districtMap.put("Phú Yên", Arrays.asList("Đông Hòa", "Đồng Xuân", "Phú Hoà", "Sông Cầu", "Sơn Hòa", "Sông Hinh", "Tây Hòa", "Tuy An"));
        districtMap.put("Quảng Bình", Arrays.asList("Bố Trạch", "Đồng Hới", "Lệ Thủy", "Minh Hóa", "Quảng Ninh", "Quảng Trạch", "Tuyên Hóa"));
        districtMap.put("Quảng Nam", Arrays.asList("Bắc Trà My", "Đại Lộc", "Điện Bàn", "Đông Giang", "Duy Xuyên", "Hiệp Đức", "Hội An", "Nam Giang", "Nam Trà My", "Nông Sơn", "Núi Thành", "Phú Ninh", "Phước Sơn", "Quế Sơn", "Tam Kỳ", "Tây Giang", "Thăng Bình"));
        districtMap.put("Quảng Ngãi", Arrays.asList("Ba Tơ", "Bình Sơn", "Đức Phổ", "Lý Sơn", "Minh Long", "Mộ Đức", "Nghĩa Hành", "Sơn Hà", "Sơn Tây", "Sơn Tịnh", "Tư Nghĩa", "Trà Bồng", "Tư Nghĩa"));
        districtMap.put("Quảng Ninh", Arrays.asList("Ba Chẽ", "Bình Liêu", "Cô Tô", "Đầm Hà", "Đông Triều", "Hải Hà", "Hoành Bồ", "Tiên Yên", "Uông Bí", "Vân Đồn", "Yên Hưng"));
        districtMap.put("Quảng Trị", Arrays.asList("Cam Lộ", "Con Cươnng", "Đa Krông", "Gio Linh", "Hải Lăng", "Hướng Hóa", "Triệu Phong", "Vĩnh Linh"));
        districtMap.put("Sóc Trăng", Arrays.asList("Châu Thành", "Cù Lao Dung", "Kế Sách", "Long Phú", "Mỹ Tú", "Mỹ Xuyên", "Ngã Năm", "Thạnh Trị", "Trần Đề", "Vĩnh Châu"));
        districtMap.put("Sơn La", Arrays.asList("Bắc Yên", "Mai Sơn", "Mộc Châu", "Mường La", "Phù Yên", "Quỳnh Nhai", "Sông Mã", "Sốp Cộp", "Thuận Châu", "Vân Hồ", "Yên Châu"));
        districtMap.put("Tây Ninh", Arrays.asList("Bến Cầu", "Châu Thành", "Dương Minh Châu", "Gò Dầu", "Hòa Thành", "Tân Biên", "Tân Châu", "Tây Ninh", "Trảng Bàng"));
        districtMap.put("Thái Bình", Arrays.asList("Đông Hưng", "Hưng Hà", "Kiến Xương", "Quỳnh Phụ", "Thái Bình", "Thái Thụy", "Tiền Hải", "Vũ Thư"));
        districtMap.put("Thái Nguyên", Arrays.asList("Đại Từ", "Định Hóa", "Đồng Hỷ", "Phổ Yên", "Phú Bình", "Phú Lương", "Võ Nhai"));
        districtMap.put("Thanh Hóa", Arrays.asList("Bá Thước", "Cẩm Thủy", "Đông Sơn", "Hà Trung", "Hậu Lộc", "Hoằng Hóa", "Lang Chánh", "Mường Lát", "Nga Sơn", "Ngọc Lặc", "Như Thanh", "Như Xuân", "Nông Cống", "Quan Hóa", "Quan Sơn", "Quảng Xương", "Thạch Thành", "Thiệu Hóa", "Thọ Xuân", "Thường Xuân", "Tĩnh Gia", "Triệu Sơn", "Vĩnh Lộc", "Yên Định"));
        districtMap.put("Thừa Thiên Huế", Arrays.asList("A Lưới", "Hương Thủy", "Hương Trà", "Nam Đông", "Phong Điền", "Phú Lộc", "Phú Vang", "Quảng Điền", "Thị Xã Hương Thủy", "Thị Xã Hương Trà"));
        districtMap.put("Tiền Giang", Arrays.asList("Cái Bè", "Cai Lậy", "Châu Thành", "Cù Lao Dung", "Gò Công", "Gò Công Đông", "Gò Công Tây", "Tân Phước", "Tân Phước", "Tân Phước", "Tân Phước"));
        districtMap.put("Trà Vinh", Arrays.asList("Càng Long", "Cầu Kè", "Cầu Ngang", "Châu Thành", "Duyên Hải", "Tiểu Cần", "Trà Cú", "Trà Vinh"));
        districtMap.put("Tuyên Quang", Arrays.asList("Chiêm Hóa", "Định Hóa", "Hàm Yên", "Lâm Bình", "Na Hang", "Sơn Dương", "Yên Sơn"));
        districtMap.put("Vĩnh Long", Arrays.asList("Bình Tân", "Long Hồ", "Mang Thít", "Tam Bình", "Trà Ôn", "Vũng Liêm"));
        districtMap.put("Vĩnh Phúc", Arrays.asList("Bình Xuyên", "Lập Thạch", "Sông Lô", "Tam Đảo", "Tam Dương", "Vĩnh Tường", "Yên Lạc"));
        districtMap.put("Yên Bái", Arrays.asList("Lục Yên", "Mù Căng Chải", "Trạm Tấu", "Trấn Yên", "Văn Chấn", "Văn Yên", "Yên Bình"));
        districtMap.put("Hồ Chí Minh", Arrays.asList("Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12", "Bình Tân", "Bình Thạnh", "Gò Vấp", "Phú Nhuận", "Tân Bình", "Tân Phú", "Thủ Đức", "Bình Chánh", "Cần Giờ", "Củ Chi", "Hóc Môn", "Nhà Bè"));
        
        List<String> tenQuan = districtMap.get(tenTinh);
        if (tenQuan != null){
            String[] modelQuan = new String[tenQuan.size()];
            for (int i=0; i<tenQuan.size(); i++){
                modelQuan[i] = tenQuan.get(i);
            }
            ComboBoxModel<String> model = new DefaultComboBoxModel<>(modelQuan);
            cbbQuanHuyen.setModel(model);
        }
        
        
    }
    
    private boolean CheckEmptyInput() {
        for (Component c : panelRoundThongTin.getComponents()) {
            if (c instanceof TextField_2) {
                if (((TextField_2) c).getText().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void ClearText() {
        for (Component c : panelRoundThongTin.getComponents()) {
            if (c instanceof TextField_2) {
                ((TextField_2) c).setText("");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRoundThongTin = new Views.OtherForm.swing.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfHo = new Views.OtherForm.swing.TextField_2();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTen = new Views.OtherForm.swing.TextField_2();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfNgaySinh = new Views.OtherForm.swing.TextField_2();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbQuanHuyen = new Views.OtherForm.component.Combobox.Combobox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbbTinhThanh = new Views.OtherForm.component.Combobox.Combobox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfSoDienThoai = new Views.OtherForm.swing.TextField_2();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfCCCD = new Views.OtherForm.swing.TextField_2();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfSoNha = new Views.OtherForm.swing.TextField_2();
        tfXaPhuong = new Views.OtherForm.swing.TextField_2();
        cbbGioiTinh = new Views.OtherForm.component.Combobox.Combobox();
        panelRound2 = new Views.OtherForm.swing.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        picHinhAnh = new Views.OtherForm.swing.PictureBox();
        jLabel22 = new javax.swing.JLabel();
        tfTenXe = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tfGia = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tfXuatXu = new javax.swing.JLabel();
        tfHangXe = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        panelRound3 = new Views.OtherForm.swing.PanelRound();
        btnThanhToan = new Views.OtherForm.swing.MyButton();
        btnQuetMaQR = new Views.OtherForm.swing.MyButton();
        jLabel23 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        panelRound1 = new Views.OtherForm.swing.PanelRound();
        jLabel25 = new javax.swing.JLabel();
        lblGiaBan = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblThueVAT = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        panelRound4 = new Views.OtherForm.swing.PanelRound();
        jLabel36 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnQuayLai = new Views.OtherForm.swing.MyButton();

        panelRoundThongTin.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundThongTin.setRoundBottomLeft(30);
        panelRoundThongTin.setRoundBottomRight(30);
        panelRoundThongTin.setRoundTopLeft(30);
        panelRoundThongTin.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("THÔNG TIN THANH TOÁN");

        tfHo.setShadowColor(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Họ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("*");

        tfTen.setShadowColor(new java.awt.Color(0, 0, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("*");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Giới tính");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("*");

        tfNgaySinh.setShadowColor(new java.awt.Color(0, 0, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Ngày sinh");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("*");

        txt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt.setText("Quận, Huyện");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");

        cbbQuanHuyen.setLabeText("");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Tỉnh thành");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");

        cbbTinhThanh.setLabeText("");
        cbbTinhThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTinhThanhActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setText("Xã, Phường");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("*");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setText("Số nhà");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("*");

        tfSoDienThoai.setShadowColor(new java.awt.Color(0, 0, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setText("Số điện thoại");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*");

        tfCCCD.setShadowColor(new java.awt.Color(0, 0, 204));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("CCCD");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("*");

        tfSoNha.setShadowColor(new java.awt.Color(0, 0, 255));

        tfXaPhuong.setShadowColor(new java.awt.Color(0, 0, 255));

        cbbGioiTinh.setLabeText("");

        javax.swing.GroupLayout panelRoundThongTinLayout = new javax.swing.GroupLayout(panelRoundThongTin);
        panelRoundThongTin.setLayout(panelRoundThongTinLayout);
        panelRoundThongTinLayout.setHorizontalGroup(
            panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                        .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfXaPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfHo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRoundThongTinLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRoundThongTinLayout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel13))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRoundThongTinLayout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel7))
                                        .addComponent(cbbTinhThanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel15))
                                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRoundThongTinLayout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel19)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundThongTinLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbQuanHuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel5))
                                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel9))
                                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                        .addComponent(txt)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel11))
                                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel17))
                                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel21)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfSoNha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRoundThongTinLayout.setVerticalGroup(
            panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt)
                        .addComponent(jLabel11))
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTinhThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15))
                    .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSoNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfXaPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                        .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(0, 0, 0)
                        .addComponent(tfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRoundThongTinLayout.createSequentialGroup()
                        .addGroup(panelRoundThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(0, 0, 0)
                        .addComponent(tfCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("THÔNG TIN Ô TÔ");

        picHinhAnh.setImage(new javax.swing.ImageIcon(getClass().getResource("/Views/OtherForm/Image/7.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setText("Tên");

        tfTenXe.setText("Mercedes-Benz C-Class");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel24.setText("Giá");

        tfGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tfGia.setText("5460000000");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel26.setText("Xuất Xứ");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel27.setText("Hãng Xe");

        tfXuatXu.setText("Nhật Bản");

        tfHangXe.setText("Hyundai");

        jLabel30.setText("VNĐ");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfHangXe, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRound2Layout.createSequentialGroup()
                                        .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tfTenXe))
                        .addGap(10, 10, 10)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(tfGia)
                            .addComponent(jLabel30))
                        .addGap(10, 10, 10)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(tfXuatXu))
                        .addGap(10, 10, 10)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(tfHangXe)))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(picHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);

        btnThanhToan.setText("Xác Nhận Thanh Toán");
        btnThanhToan.setBorderColor(new java.awt.Color(72, 108, 255));
        btnThanhToan.setRadius(15);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnQuetMaQR.setText("QR Thanh Toán");
        btnQuetMaQR.setBorderColor(new java.awt.Color(72, 108, 255));
        btnQuetMaQR.setRadius(15);
        btnQuetMaQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetMaQRActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Chi Phí");

        panelRound1.setBackground(new java.awt.Color(244, 244, 246));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Giá Bán*");

        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGiaBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGiaBan.setText("1,000,000,000");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("VNĐ");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(lblGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Tổng các loại phí");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 153, 153));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("20,000,000");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("VND");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Thuế giá trị gia tăng (VAT) (10%)");

        lblThueVAT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblThueVAT.setForeground(new java.awt.Color(153, 153, 153));
        lblThueVAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThueVAT.setText("100,000,000");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(153, 153, 153));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("VND");

        panelRound4.setBackground(new java.awt.Color(244, 244, 246));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Tổng tiền*");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTien.setText("1,120,000,000");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("VNĐ");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnQuetMaQR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(lblThueVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound3Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(12, 12, 12)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblThueVAT)
                    .addComponent(jLabel42))
                .addGap(15, 15, 15)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuetMaQR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound3Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(240, Short.MAX_VALUE)))
        );

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 102));
        jLabel31.setText("THANH TOÁN");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Nhập Thông Tin Cá Nhân Để Tiến Hành Thanh Toán");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Các mục bắt buộc phải điền có dấu");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 0, 51));
        jLabel34.setText("*");

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.setBorderColor(new java.awt.Color(214, 147, 214));
        btnQuayLai.setRadius(15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRoundThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)))
                    .addComponent(jLabel31)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRoundThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTinhThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTinhThanhActionPerformed
        String tenTinhThanh = cbbTinhThanh.getSelectedItem().toString();
        loadQuanHuyen(tenTinhThanh);
    }//GEN-LAST:event_cbbTinhThanhActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        String hoTen = tfHo.getText() + " " + tfTen.getText();
        String gioitinh = cbbGioiTinh.getSelectedItem().toString();
        String ngaySinh = tfNgaySinh.getText();
        
        String sdt = tfSoDienThoai.getText();
        String cccd = tfCCCD.getText();
        
        if (CheckEmptyInput()){
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        java.sql.Date date = null;
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
            date = new java.sql.Date(d.getTime());
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Nhập ngày tháng không đúng định dạng yyyy-MM-dd!",
                    MessageAlerts.MessageType.ERROR);
            tfNgaySinh.requestFocus();
            return;
        }
        
        String diaChi = "";
        if (cbbQuanHuyen.getSelectedItem() != null && cbbTinhThanh.getSelectedItem() != null){
            diaChi = tfSoNha.getText() + ", " + tfXaPhuong.getText() + ", " + 
                cbbQuanHuyen.getSelectedItem().toString() + ", " + 
                cbbTinhThanh.getSelectedItem().toString();
        }
        else{
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng chọn quận huyện!",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        // Check SDT hợp lệ, CCCD hợp lệ
        if(!checkLegalNumberPhone(sdt)){
            MessageAlerts.getInstance().showMessage("Fail!", "Số điện thoại phải đúng 10 ký tự số!",
                    MessageAlerts.MessageType.ERROR);
            tfSoDienThoai.requestFocus();
            return;
        }
        
        // Check Trùng CCCD, sdt ...
        if (!checkLegalCCCD(cccd)){
            MessageAlerts.getInstance().showMessage("Fail!", "CCCD phải đúng 12 ký tự số!",
                    MessageAlerts.MessageType.ERROR);
            tfCCCD.requestFocus();
            return;
        }
        
        KhachHang kh = KhachHangDAO.getInstance().findOne(hoTen, sdt, cccd);
        if (kh != null){ // Đã có khách hàng => Cho thanh toán
            kh.setNgaySinh(date);
            kh.setGioiTinh(gioitinh);
            kh.setDiaChi(diaChi);
            // Cập nhật thông tin theo tên, sdt, cccd
            KhachHangDAO.getInstance().update(kh); 
        }
        
        else{ 
            // Kiểm tra nếu trùng CCCD || Sdt
            KhachHang kh1 = KhachHangDAO.getInstance().findByNumberPhone(sdt);
            KhachHang kh2 = KhachHangDAO.getInstance().findByCCCD(cccd);
            if (kh1 == null && kh2 == null) {
                kh = new KhachHang();
                kh.setHoTenKhachHang(hoTen);
                kh.setNgaySinh(date);
                kh.setGioiTinh(gioitinh);
                kh.setSoDienThoai(sdt);
                kh.setcCCD(cccd);
                kh.setDiaChi(diaChi);
                KhachHangDAO.getInstance().insert(kh);
            }
            if (kh1 != null){
                MessageAlerts.getInstance().showMessage("Fail!", "Số điện thoại đã được sử dụng!",
                    MessageAlerts.MessageType.ERROR);
                return;
            }
            if (kh2 != null){
                MessageAlerts.getInstance().showMessage("Fail!", "CCCD đã được sử dụng!",
                    MessageAlerts.MessageType.ERROR);
                return;
            }
        }
        
        //------------------
        //Insert hóa đơn
        Date ngayHienTai = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date1 = null;
        try {
            // Format ngày hiện tại thành chuỗi theo định dạng "yyyy-MM-dd"
            String ngayHienTaiString = sdf.format(ngayHienTai);

            // Chuyển đổi chuỗi thành đối tượng java.util.Date
            Date d = sdf.parse(ngayHienTaiString);

            // Chuyển đối tượng java.util.Date thành java.sql.Date
            date1 = new java.sql.Date(d.getTime());
            
        } catch (ParseException e) {
        }
        
        kh = KhachHangDAO.getInstance().findByNumberPhone(sdt);
        HoaDon hd = new HoaDon(
            "", date1, xe.getMaXe(), (long)((long)xe.getGiaBan() * 1.1 + 20000000) , "Đã thanh toán", kh.getMaKhachHang(), fLogin.getTk().getMaNhanVien()
        );
        boolean res = HoaDonDAO.getInstance().insert(hd);
        if (res){
            MessageAlerts.getInstance().showMessage("Success!", "Thanh toán thành công!",
                    MessageAlerts.MessageType.SUCCESS);
            ClearText();
        }
        else{
            MessageAlerts.getInstance().showMessage("Error!", "Thanh toán thất bại!",
                    MessageAlerts.MessageType.ERROR);
        }
       
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnQuetMaQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaQRActionPerformed
        String hoTen = tfHo.getText() + " " + tfTen.getText();
        String ngaySinh = tfNgaySinh.getText();
        
        String sdt = tfSoDienThoai.getText();
        String cccd = tfCCCD.getText();
        
        if (CheckEmptyInput()){
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng nhập đầy đủ thông tin",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        java.sql.Date date = null;
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
            date = new java.sql.Date(d.getTime());
        } catch (ParseException e) {
            MessageAlerts.getInstance().showMessage("Fail!", "Nhập ngày tháng không đúng định dạng yyyy-MM-dd!",
                    MessageAlerts.MessageType.ERROR);
            tfNgaySinh.requestFocus();
            return;
        }
        
        String diaChi = "";
        if (cbbQuanHuyen.getSelectedItem() != null && cbbTinhThanh.getSelectedItem() != null){
            diaChi = tfSoNha.getText() + " " + tfXaPhuong.getText() + " " + 
                cbbQuanHuyen.getSelectedItem().toString() + " " + 
                cbbTinhThanh.getSelectedItem().toString();
        }
        else{
            MessageAlerts.getInstance().showMessage("Fail!", "Vui lòng chọn quận huyện!",
                    MessageAlerts.MessageType.ERROR);
            return;
        }
        
        // Check SDT hợp lệ, CCCD hợp lệ
        if(!checkLegalNumberPhone(sdt)){
            MessageAlerts.getInstance().showMessage("Fail!", "Số điện thoại không hợp lệ!",
                    MessageAlerts.MessageType.ERROR);
            tfSoDienThoai.requestFocus();
            return;
        }
        
        // Check Trùng CCCD, sdt ...
        if (!checkLegalCCCD(cccd)){
            MessageAlerts.getInstance().showMessage("Fail!", "CCCD không hợp lệ!",
                    MessageAlerts.MessageType.ERROR);
            tfCCCD.requestFocus();
            return;
        }
        
        
        
        if (KhachHangService.getInstance().checkDuplicateCCCD(cccd)) { // Aldready CCCD
            MessageAlerts.getInstance().showMessage("Fail!", "CCCD này đã tồn tại, vui lòng kiểm tra lại!",
                    MessageAlerts.MessageType.ERROR);
            tfCCCD.requestFocus();
            return;
        }

        if (KhachHangService.getInstance().checkDuplicatePhone(sdt)) { // Aldready CCCD
            MessageAlerts.getInstance().showMessage("Fail!", "Số điện thoại này đã tồn tại, vui lòng kiểm tra lại!",
                    MessageAlerts.MessageType.ERROR);
            tfSoDienThoai.requestFocus();
            return;
        }
        
        // Trùng 3 thông tin sau thì mới cho phép xuất Report
        KhachHang kh = KhachHangDAO.getInstance().findOne(hoTen, sdt, cccd);
        if (kh == null) {
            
            // Kiểm tra nếu trùng CCCD || Sdt
            KhachHang kh1 = KhachHangDAO.getInstance().findByNumberPhone(sdt);
            KhachHang kh2 = KhachHangDAO.getInstance().findByCCCD(cccd);

            if (kh1 != null) {
                MessageAlerts.getInstance().showMessage("Fail!", "Số điện thoại đã được sử dụng!",
                        MessageAlerts.MessageType.ERROR);
                return;
            }
            if (kh2 != null) {
                MessageAlerts.getInstance().showMessage("Fail!", "CCCD đã được sử dụng!",
                        MessageAlerts.MessageType.ERROR);
                return;
            }
        }
        
        // Xuất Report
        String tenKhachHang = getHoTenKhacHang();
        NhanVien nv = NhanVienService.getInstance().findOne(fLogin.getTk().getMaNhanVien());
        String tenNhanVien = nv.getHoTenNhanVien();
        Date ngayNhap = new Date();
        List<Fields_Report_ThanhToan> fields = new ArrayList<>();
        fields.add(new Fields_Report_ThanhToan(xe.getTenXe(), xe.getXuatXu(), xe.getHangXe(), xe.getGiaBan()));

        try {
            Parameter_Report_ThanhToan dataPrint = new Parameter_Report_ThanhToan(tenNhanVien, tenKhachHang,
                    String.valueOf(FormatMoney.formatMoney((long)((long)xe.getGiaBan() * 1.1 + 20000000)) + " VNĐ"), 
                    Report.ReportManager_ThanhToan.getInstance().generateQrcode(), ngayNhap,
                    String.valueOf(FormatMoney.formatMoney(xe.getGiaBan()) + " VNĐ"), 
                    String.valueOf(FormatMoney.formatMoney((long)20000000) + " VNĐ"),
                    String.valueOf(FormatMoney.formatMoney((long)((long)xe.getGiaBan() * 0.1)) + " VNĐ"),
                    fields);
            ReportManager_ThanhToan.getInstance().compileReport();
            ReportManager_ThanhToan.getInstance().printReportPayment(dataPrint);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnQuetMaQRActionPerformed

    private boolean checkLegalNumberPhone(String phone){
        if (phone.length() != 10){
            return false;
        }
        try {
            long i = (long) Double.parseDouble(phone);
            return i > 0;
        } catch (Exception e) {
        }
        return false;
    }
    
    private boolean checkLegalCCCD(String CCCD){
        if (CCCD.length() != 12){
            return false;
        }
        try {
            long i = (long) Double.parseDouble(CCCD);
            return i > 0;
        } catch (Exception e) {
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.swing.MyButton btnQuayLai;
    private Views.OtherForm.swing.MyButton btnQuetMaQR;
    private Views.OtherForm.swing.MyButton btnThanhToan;
    private Views.OtherForm.component.Combobox.Combobox cbbGioiTinh;
    private Views.OtherForm.component.Combobox.Combobox cbbQuanHuyen;
    private Views.OtherForm.component.Combobox.Combobox cbbTinhThanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblThueVAT;
    private javax.swing.JLabel lblTongTien;
    private Views.OtherForm.swing.PanelRound panelRound1;
    private Views.OtherForm.swing.PanelRound panelRound2;
    private Views.OtherForm.swing.PanelRound panelRound3;
    private Views.OtherForm.swing.PanelRound panelRound4;
    private Views.OtherForm.swing.PanelRound panelRoundThongTin;
    private Views.OtherForm.swing.PictureBox picHinhAnh;
    private Views.OtherForm.swing.TextField_2 tfCCCD;
    private javax.swing.JLabel tfGia;
    private javax.swing.JLabel tfHangXe;
    private Views.OtherForm.swing.TextField_2 tfHo;
    private Views.OtherForm.swing.TextField_2 tfNgaySinh;
    private Views.OtherForm.swing.TextField_2 tfSoDienThoai;
    private Views.OtherForm.swing.TextField_2 tfSoNha;
    private Views.OtherForm.swing.TextField_2 tfTen;
    private javax.swing.JLabel tfTenXe;
    private Views.OtherForm.swing.TextField_2 tfXaPhuong;
    private javax.swing.JLabel tfXuatXu;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
