/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "HoaDon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h"),
    @NamedQuery(name = "HoaDon.findByMaHoaDon", query = "SELECT h FROM HoaDon h WHERE h.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "HoaDon.findByDiaChi", query = "SELECT h FROM HoaDon h WHERE h.diaChi = :diaChi"),
    @NamedQuery(name = "HoaDon.findByNgayLap", query = "SELECT h FROM HoaDon h WHERE h.ngayLap = :ngayLap"),
    @NamedQuery(name = "HoaDon.findByTinhTrang", query = "SELECT h FROM HoaDon h WHERE h.tinhTrang = :tinhTrang"),
    @NamedQuery(name = "HoaDon.findByTongTien", query = "SELECT h FROM HoaDon h WHERE h.tongTien = :tongTien")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHoaDon;
    @Size(max = 250)
    @Column(name = "DiaChi")
    private String diaChi;
    @Temporal(TemporalType.DATE)
    @Column(name = "NgayLap")
    private Date ngayLap;
    @Column(name = "TinhTrang")
    private Integer tinhTrang;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TongTien")
    private Double tongTien;
    @JoinColumn(name = "MaTaiKhoanND", referencedColumnName = "MaTaiKhoanND")
    @ManyToOne
    private NguoiDung maTaiKhoanND;
    @OneToMany(mappedBy = "maHoaDon")
    private Collection<HoaDonChiTiet> hoaDonChiTietCollection;

    public HoaDon() {
    }

    public HoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public NguoiDung getMaTaiKhoanND() {
        return maTaiKhoanND;
    }

    public void setMaTaiKhoanND(NguoiDung maTaiKhoanND) {
        this.maTaiKhoanND = maTaiKhoanND;
    }

    @XmlTransient
    public Collection<HoaDonChiTiet> getHoaDonChiTietCollection() {
        return hoaDonChiTietCollection;
    }

    public void setHoaDonChiTietCollection(Collection<HoaDonChiTiet> hoaDonChiTietCollection) {
        this.hoaDonChiTietCollection = hoaDonChiTietCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HoaDon[ maHoaDon=" + maHoaDon + " ]";
    }

}
