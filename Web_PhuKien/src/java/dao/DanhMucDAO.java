/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DanhMuc;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class DanhMucDAO {

    Session ss = null;

    public DanhMucDAO() {
    }

    public List<DanhMuc> getAll() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from DanhMuc");
        List<DanhMuc> dm = q.list();
        ss.close();
        return dm;
    }

    public DanhMuc getById(int maDanhMuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (DanhMuc) ss.get(DanhMuc.class, maDanhMuc);
    }
    
     public DanhMuc getByName(String ten) {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query query = ss.createQuery("from DanhMuc where tenDanhMuc =:ten");
        query.setParameter("ten", ten);
        DanhMuc d = (DanhMuc) query.uniqueResult();
        ss.close();
        return d;
    }

    public void Insert(DanhMuc dmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(dmuc);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(DanhMuc danhmuc) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(danhmuc);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        DanhMuc dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
        ss.close();
    }

}
