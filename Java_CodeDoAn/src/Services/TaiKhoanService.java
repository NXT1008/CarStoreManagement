
package Services;
import Models.TaiKhoan;
import DAO.TaiKhoanDAO;
import java.util.List;

public class TaiKhoanService {
    private static TaiKhoanService instance;

    public static TaiKhoanService getInstance() {
        if (instance == null)
            instance = new TaiKhoanService();
        return instance;
    }
    
    public boolean login(String username, String password){
        TaiKhoan tk = TaiKhoanDAO.getInstance().login(username, password);
        return tk != null;
    }
    
    public boolean register(TaiKhoan tk){
        return TaiKhoanDAO.getInstance().register(tk);
    }
    
    public TaiKhoan findByMaNhanVien(String maNV){
        return TaiKhoanDAO.getInstance().findByMaNhanVien(maNV);
    }
    
    public List<TaiKhoan> danhSachTaiKhoan(){
        return TaiKhoanDAO.getInstance().danhSachTaiKhoan();
    }
    
    public boolean updatePassword(TaiKhoan tk){
        return TaiKhoanDAO.getInstance().update(tk);
    }
}
