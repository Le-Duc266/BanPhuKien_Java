/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NhanHang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class NhanHangDAO {
    Session ss = null;

    public NhanHangDAO() {
    }
    
    public List<NhanHang> getAll() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from NhanHang");
        List<NhanHang> nh = q.list();
        return nh;
    }

    public NhanHang getById(int maNhanHang) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (NhanHang) ss.get(NhanHang.class, maNhanHang);
    }
    
    public NhanHang getByName(String ten) {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query query = ss.createQuery("from NhanHang where tenNhanHang =:ten");
        query.setParameter("ten", ten);
        NhanHang nh = (NhanHang) query.uniqueResult();
        ss.close();
        return nh;
    }

    public void Insert(NhanHang dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(NhanHang danhmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(danhmuc);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        NhanHang dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
        ss.close();
    }
    
}
