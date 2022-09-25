/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "HoaDonChiTietJoin")
public class HoaDonChiTietJoin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    private Integer maHoaDonChiTiet;
    
    private Integer soLuong;
    private String tenSanPham;
   
    private Double giaTien;
    
    private Double thanhTien;
   
    private int maHoaDon;
   
    private int maSanPham;

    public HoaDonChiTietJoin() {
    }
    

    public HoaDonChiTietJoin(Integer maHoaDonChiTiet, Integer soLuong,String tenSanPham, Double giaTien, Double thanhTien, int maHoaDon, int maSanPham) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.soLuong = soLuong;
        this.tenSanPham = tenSanPham;
        this.giaTien = giaTien;
        this.thanhTien = thanhTien;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
    }

    public Integer getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(Integer maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }
    
    
}
