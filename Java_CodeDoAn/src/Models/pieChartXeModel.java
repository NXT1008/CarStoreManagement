
package Models;


public class pieChartXeModel {
    private String tenXe;
    private long total;

    public pieChartXeModel(String tenXe, long total) {
        this.tenXe = tenXe;
        this.total = total;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    
}
