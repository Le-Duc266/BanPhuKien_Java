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
@Table(name = "HoaDonChiTiet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDonChiTiet.findAll", query = "SELECT h FROM HoaDonChiTiet h"),
    @NamedQuery(name = "HoaDonChiTiet.findByMaHoaDonChiTiet", query = "SELECT h FROM HoaDonChiTiet h WHERE h.maHoaDonChiTiet = :maHoaDonChiTiet"),
    @NamedQuery(name = "HoaDonChiTiet.findBySoLuong", query = "SELECT h FROM HoaDonChiTiet h WHERE h.soLuong = :soLuong"),
    @NamedQuery(name = "HoaDonChiTiet.findByGiaTien", query = "SELECT h FROM HoaDonChiTiet h WHERE h.giaTien = :giaTien"),
    @NamedQuery(name = "HoaDonChiTiet.findByThanhTien", query = "SELECT h FROM HoaDonChiTiet h WHERE h.thanhTien = :thanhTien")})
public class HoaDonChiTiet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHoaDonChiTiet")
    private Integer maHoaDonChiTiet;
    @Column(name = "SoLuong")
    private Integer soLuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GiaTien")
    private Double giaTien;
    @Column(name = "ThanhTien")
    private Double thanhTien;
    @JoinColumn(name = "MaHoaDon", referencedColumnName = "MaHoaDon")
    @ManyToOne
    private HoaDon maHoaDon;
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham")
    @ManyToOne
    private SanPham maSanPham;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
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

    public HoaDon getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(HoaDon maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDonChiTiet != null ? maHoaDonChiTiet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDonChiTiet)) {
            return false;
        }
        HoaDonChiTiet other = (HoaDonChiTiet) object;
        if ((this.maHoaDonChiTiet == null && other.maHoaDonChiTiet != null) || (this.maHoaDonChiTiet != null && !this.maHoaDonChiTiet.equals(other.maHoaDonChiTiet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HoaDonChiTiet[ maHoaDonChiTiet=" + maHoaDonChiTiet + " ]";
    }
    
}
