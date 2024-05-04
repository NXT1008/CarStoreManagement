
package Models;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopCarBestSell {
    private String maXe;
    private String tenXe;
    private int soLuongXeDaBan;
    private byte[] hinhAnh;
    private long giaBan;

    public TopCarBestSell(String maXe, String tenXe, int soLuongXeDaBan, byte[] hinhAnh, long giaBan) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.soLuongXeDaBan = soLuongXeDaBan;
        this.hinhAnh = hinhAnh;
        this.giaBan = giaBan;
    }
    
    public TopCarBestSell(ResultSet resultSet) throws SQLException {
        this.maXe = resultSet.getString("maXe");
        this.tenXe = resultSet.getString("tenXe");
        this.soLuongXeDaBan = resultSet.getInt("soLuongXeDaBan");
        InputStream inputStream = resultSet.getBinaryStream("hinhAnh");
        if (inputStream == null){
            this.hinhAnh = null;
        }
        else{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] data = outputStream.toByteArray();
            this.hinhAnh = data;
        } catch (IOException e) {
            this.hinhAnh = null;
        }
        }
        this.giaBan = resultSet.getLong("giaBan");
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public int getSoLuongXeDaBan() {
        return soLuongXeDaBan;
    }

    public void setSoLuongXeDaBan(int soLuongXeDaBan) {
        this.soLuongXeDaBan = soLuongXeDaBan;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
