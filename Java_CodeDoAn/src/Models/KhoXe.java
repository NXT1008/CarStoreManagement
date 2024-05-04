/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 *
 * @author WIN 10
 */
public class KhoXe {
    private String maXe;
    private String tenXe;
    private int soLuongXeCon;
    private int soLuongXeDaBan;
    private byte[] hinhAnh;

    public KhoXe(String maXe, String tenXe, int soLuongXeCon, int soLuongXeDaBan, byte[] hinhAnh) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.soLuongXeCon = soLuongXeCon;
        this.soLuongXeDaBan = soLuongXeDaBan;
        this.hinhAnh = hinhAnh;
    }

    
    
    public KhoXe(ResultSet resultSet) throws SQLException {
        this.maXe = resultSet.getString("maXe");
        this.tenXe = resultSet.getString("tenXe");
        this.soLuongXeCon = resultSet.getInt("soLuongXeCon");
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

    public int getSoLuongXeCon() {
        return soLuongXeCon;
    }

    public void setSoLuongXeCon(int soLuongXeCon) {
        this.soLuongXeCon = soLuongXeCon;
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

    @Override
    public String toString() {
        return "KhoXe{" + "maXe=" + maXe + ", tenXe=" + tenXe + ", soLuongXeCon=" + soLuongXeCon + ", soLuongXeDaBan=" + soLuongXeDaBan + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
}
