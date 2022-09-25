/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DanhMuc;
import entities.NhanHang;
import entities.SanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class SanPhamDAO {

    Session ss = null;

    public SanPhamDAO() {
    }

    public List<SanPham> getAlls() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from SanPham");
        List<SanPham> kt = q.list();
        ss.close();
        return kt;
    }

    public List<SanPham> limit(int n) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session
                    .createQuery("from SanPham");
            query.setMaxResults(n);
            products = query.list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }

    public List<SanPham> oderById(int n) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session
                    .createQuery("from SanPham s ORDER BY s.maSanPham DESC ");
            query.setMaxResults(n);
            products = query.list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;

    }

    public List<SanPham> getDanhMuc(DanhMuc maDanhMuc) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            products = session
                    .createQuery("from SanPham where maDanhMuc=:maDanhMuc").setParameter("maDanhMuc", maDanhMuc).list();
            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }

    
       public List<SanPham> searchByName(String ten) {
           
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from SanPham p where p.tenSanPham like :ten");
        q.setParameter("ten", "%" + ten + "%");
        List<SanPham> re = q.list();
        ss.close();
        return re;
    
    }

    public SanPham getByIdSp(int maSanPham) {
        SanPham product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            product = (SanPham) session
                    .createQuery("from SanPham where MaSanPham=:maSanPham").setParameter("maSanPham", maSanPham).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            product = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return product;
    }
    
     public List<SanPham> SanPhamLienQuan(int maSanPham, DanhMuc maDanhMuc) {
        List<SanPham> products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session
                    .createQuery("from SanPham where not maSanPham=:maSanPham and  maDanhMuc=:maDanhMuc");
            q.setParameter("maSanPham", maSanPham);
            q.setParameter("maDanhMuc", maDanhMuc);
            q.setMaxResults(20);
            products = q.list();

            transaction.commit();
        } catch (Exception e) {
            products = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return products;
    }
    

    public SanPham getById(int maSanPham) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (SanPham) ss.get(SanPham.class, maSanPham);
    }

    public void Insert(SanPham sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(sp);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(SanPham s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        SanPham kt = getById(id);
        ss.getTransaction().begin();
        ss.delete(kt);
        ss.getTransaction().commit();
    }

}
