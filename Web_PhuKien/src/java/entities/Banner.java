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
@Table(name = "Banner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banner.findAll", query = "SELECT b FROM Banner b"),
    @NamedQuery(name = "Banner.findByMaBanner", query = "SELECT b FROM Banner b WHERE b.maBanner = :maBanner"),
    @NamedQuery(name = "Banner.findByAnh", query = "SELECT b FROM Banner b WHERE b.anh = :anh"),
    @NamedQuery(name = "Banner.findByVitri", query = "SELECT b FROM Banner b WHERE b.vitri = :vitri")})
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBanner")
    private Integer maBanner;
    @Size(max = 250)
    @Column(name = "Anh")
    private String anh;
    @Column(name = "Vitri")
    private Integer vitri;

    public Banner() {
    }

    public Banner(Integer maBanner) {
        this.maBanner = maBanner;
    }

    public Integer getMaBanner() {
        return maBanner;
    }

    public void setMaBanner(Integer maBanner) {
        this.maBanner = maBanner;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Integer getVitri() {
        return vitri;
    }

    public void setVitri(Integer vitri) {
        this.vitri = vitri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBanner != null ? maBanner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banner)) {
            return false;
        }
        Banner other = (Banner) object;
        if ((this.maBanner == null && other.maBanner != null) || (this.maBanner != null && !this.maBanner.equals(other.maBanner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Banner[ maBanner=" + maBanner + " ]";
    }
    
}
