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
@Table(name = "DanhMuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhMuc.findAll", query = "SELECT d FROM DanhMuc d"),
    @NamedQuery(name = "DanhMuc.findByMaDanhMuc", query = "SELECT d FROM DanhMuc d WHERE d.maDanhMuc = :maDanhMuc"),
    @NamedQuery(name = "DanhMuc.findByTenDanhMuc", query = "SELECT d FROM DanhMuc d WHERE d.tenDanhMuc = :tenDanhMuc")})
public class DanhMuc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDanhMuc")
    private Integer maDanhMuc;
    @Size(max = 250)
    @Column(name = "TenDanhMuc")
    private String tenDanhMuc;
    @OneToMany(mappedBy = "maDanhMuc")
    private Collection<SanPham> sanPhamCollection;

    public DanhMuc() {
    }

    public DanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public Integer getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    @XmlTransient
    public Collection<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Collection<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDanhMuc != null ? maDanhMuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhMuc)) {
            return false;
        }
        DanhMuc other = (DanhMuc) object;
        if ((this.maDanhMuc == null && other.maDanhMuc != null) || (this.maDanhMuc != null && !this.maDanhMuc.equals(other.maDanhMuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DanhMuc[ maDanhMuc=" + maDanhMuc + " ]";
    }
    
}
