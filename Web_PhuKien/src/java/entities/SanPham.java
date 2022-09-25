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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "SanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s"),
    @NamedQuery(name = "SanPham.findByMaSanPham", query = "SELECT s FROM SanPham s WHERE s.maSanPham = :maSanPham"),
    @NamedQuery(name = "SanPham.findByTenSanPham", query = "SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham"),
    @NamedQuery(name = "SanPham.findByGia", query = "SELECT s FROM SanPham s WHERE s.gia = :gia"),
    @NamedQuery(name = "SanPham.findByAnh", query = "SELECT s FROM SanPham s WHERE s.anh = :anh"),
    @NamedQuery(name = "SanPham.findBySoLuong", query = "SELECT s FROM SanPham s WHERE s.soLuong = :soLuong"),
    @NamedQuery(name = "SanPham.findByMoTa", query = "SELECT s FROM SanPham s WHERE s.moTa = :moTa"),
    @NamedQuery(name = "SanPham.findByNgayTao", query = "SELECT s FROM SanPham s WHERE s.ngayTao = :ngayTao")})
public class SanPham implements Serializable {
    @OneToMany(mappedBy = "maSanPham")
    private Collection<HoaDonChiTiet> hoaDonChiTietCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSanPham")
    private Integer maSanPham;
    @Size(max = 250)
    @Column(name = "TenSanPham")
    private String tenSanPham;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @Size(max = 250)
    @Column(name = "Anh")
    private String anh;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Size(max = 2147483647)
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    @JoinColumn(name = "MaDanhMuc", referencedColumnName = "MaDanhMuc")
    @ManyToOne
    private DanhMuc maDanhMuc;
    @JoinColumn(name = "MaNhanHang", referencedColumnName = "MaNhanHang")
    @ManyToOne
    private NhanHang maNhanHang;
    

    public SanPham() {
    }

    public SanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public DanhMuc getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(DanhMuc maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public NhanHang getMaNhanHang() {
        return maNhanHang;
    }

    public void setMaNhanHang(NhanHang maNhanHang) {
        this.maNhanHang = maNhanHang;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSanPham != null ? maSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSanPham == null && other.maSanPham != null) || (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SanPham[ maSanPham=" + maSanPham + " ]";
    }

    @XmlTransient
    public Collection<HoaDonChiTiet> getHoaDonChiTietCollection() {
        return hoaDonChiTietCollection;
    }

    public void setHoaDonChiTietCollection(Collection<HoaDonChiTiet> hoaDonChiTietCollection) {
        this.hoaDonChiTietCollection = hoaDonChiTietCollection;
    }
    
}
