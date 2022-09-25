/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "NhanVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findByMaTaiKhoanNV", query = "SELECT n FROM NhanVien n WHERE n.maTaiKhoanNV = :maTaiKhoanNV"),
    @NamedQuery(name = "NhanVien.findByTenTaiKhoan", query = "SELECT n FROM NhanVien n WHERE n.tenTaiKhoan = :tenTaiKhoan"),
    @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NhanVien.findByCmnd", query = "SELECT n FROM NhanVien n WHERE n.cmnd = :cmnd"),
    @NamedQuery(name = "NhanVien.findBySoDienThoai", query = "SELECT n FROM NhanVien n WHERE n.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "NhanVien.findByEmail", query = "SELECT n FROM NhanVien n WHERE n.email = :email"),
    @NamedQuery(name = "NhanVien.findByPassword", query = "SELECT n FROM NhanVien n WHERE n.password = :password")})
public class NhanVien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTaiKhoanNV")
    private Integer maTaiKhoanNV;
    @Size(max = 250)
    @Column(name = "TenTaiKhoan")
    private String tenTaiKhoan;
    @Size(max = 250)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 20)
    @Column(name = "Cmnd")
    private String cmnd;
    @Size(max = 10)
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "Email")
    private String email;
    @Size(max = 50)
    @Column(name = "Password")
    private String password;
    @JoinColumn(name = "MaQuyen", referencedColumnName = "MaQuyen")
    @ManyToOne
    private Quyen maQuyen;

    public NhanVien() {
    }

    public NhanVien(Integer maTaiKhoanNV) {
        this.maTaiKhoanNV = maTaiKhoanNV;
    }

    public Integer getMaTaiKhoanNV() {
        return maTaiKhoanNV;
    }

    public void setMaTaiKhoanNV(Integer maTaiKhoanNV) {
        this.maTaiKhoanNV = maTaiKhoanNV;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Quyen getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(Quyen maQuyen) {
        this.maQuyen = maQuyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTaiKhoanNV != null ? maTaiKhoanNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maTaiKhoanNV == null && other.maTaiKhoanNV != null) || (this.maTaiKhoanNV != null && !this.maTaiKhoanNV.equals(other.maTaiKhoanNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NhanVien[ maTaiKhoanNV=" + maTaiKhoanNV + " ]";
    }
    
}
