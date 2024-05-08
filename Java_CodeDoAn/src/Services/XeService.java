
package Services;
import Models.Xe;
import DAO.XeDAO;
import java.util.ArrayList;
import java.util.List;

public class XeService {
    private static XeService instance;

    public static XeService getInstance() {
        if (instance == null)
            instance = new XeService();
        return instance;
    }
    
    public List<Xe> danhSachXe(){
        return XeDAO.getInstance().danhSachXe();
    }
    
    public List<String> listMaXe(){
        return XeDAO.getInstance().listMaXe();
    }
    
    public Xe findOne(String maXe){
        return XeDAO.getInstance().findOne(maXe);
    }
    
    public Xe findTop1(){
        return XeDAO.getInstance().findTop1();
    }
    
    public Xe findTop2(){
        return XeDAO.getInstance().findTop2();
    }
    
    public boolean insert(Xe model){
        return XeDAO.getInstance().insert(model);
    }
    
    public boolean update(Xe model){
        return XeDAO.getInstance().update(model);
    }
    
    public boolean delete(String model){
        return XeDAO.getInstance().delete(model);
    }
    
    // Method to search Xe objects based on a keyword
    public List<Xe> timKiemXe(String keyword) {
        List<Xe> result = new ArrayList<>();
        // Iterate through your list of Xe objects and filter them based on the keyword
        for (Xe xe : danhSachXe()) {
            // Perform your search logic here, for example, if you want to search based on a field like tenXe
            if (xe.getTenXe().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(xe);
            }
        }
        return result;
    }
}
