/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "NguoiDung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiDung.findAll", query = "SELECT n FROM NguoiDung n"),
    @NamedQuery(name = "NguoiDung.findByMaTaiKhoanND", query = "SELECT n FROM NguoiDung n WHERE n.maTaiKhoanND = :maTaiKhoanND"),
    @NamedQuery(name = "NguoiDung.findByTenTaiKhoan", query = "SELECT n FROM NguoiDung n WHERE n.tenTaiKhoan = :tenTaiKhoan"),
    @NamedQuery(name = "NguoiDung.findByDiaChi", query = "SELECT n FROM NguoiDung n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NguoiDung.findBySoDienThoai", query = "SELECT n FROM NguoiDung n WHERE n.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "NguoiDung.findByEmail", query = "SELECT n FROM NguoiDung n WHERE n.email = :email"),
    @NamedQuery(name = "NguoiDung.findByPassword", query = "SELECT n FROM NguoiDung n WHERE n.password = :password")})
public class NguoiDung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTaiKhoanND")
    private Integer maTaiKhoanND;
    @Size(max = 250)
    @Column(name = "TenTaiKhoan")
    private String tenTaiKhoan;
    @Size(max = 250)
    @Column(name = "DiaChi")
    private String diaChi;
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
    @OneToMany(mappedBy = "maTaiKhoanND")
    private Collection<HoaDon> hoaDonCollection;

    public NguoiDung() {
    }

    public NguoiDung(Integer maTaiKhoanND) {
        this.maTaiKhoanND = maTaiKhoanND;
    }

    public Integer getMaTaiKhoanND() {
        return maTaiKhoanND;
    }

    public void setMaTaiKhoanND(Integer maTaiKhoanND) {
        this.maTaiKhoanND = maTaiKhoanND;
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

    @XmlTransient
    public Collection<HoaDon> getHoaDonCollection() {
        return hoaDonCollection;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hoaDonCollection = hoaDonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTaiKhoanND != null ? maTaiKhoanND.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.maTaiKhoanND == null && other.maTaiKhoanND != null) || (this.maTaiKhoanND != null && !this.maTaiKhoanND.equals(other.maTaiKhoanND))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NguoiDung[ maTaiKhoanND=" + maTaiKhoanND + " ]";
    }
    
}
