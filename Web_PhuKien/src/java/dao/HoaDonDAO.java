/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.HibernateUtil;
import entities.HoaDonChiTiet;
import entities.HoaDon;
import entities.HoaDonChiTietJoin;
import entities.SanPham;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class HoaDonDAO {

    Session ss = null;

    public HoaDonDAO() {
//         ss = HibernateUtil.getSessionFactory().openSession();
    }

    public int getMaHoaDon() {
        ss = HibernateUtil.getSessionFactory().openSession();
        SQLQuery query = ss.createSQLQuery("SELECT IDENT_CURRENT('HoaDon')");
        int results = Integer.parseInt(query.uniqueResult().toString());
        ss.close();
        return results;
    }

    public HoaDon getById(int maHoaDon) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (HoaDon) ss.get(HoaDon.class, maHoaDon);
    }

    public HoaDon getHoaDonLatest() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query query = ss.createQuery("from HoaDon order by maHoaDon desc");
        HoaDon result = (HoaDon) query.list().get(0);
        ss.close();
        return result;
    }

    public List<HoaDon> getAll() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query query = ss.createQuery("from HoaDon order by maHoaDon desc");
        List<HoaDon> result = query.list();
        ss.close();
        return result;
    }

    public List<HoaDonChiTietJoin> getByIdChiTietHD(int maHoaDon) {
        List<HoaDonChiTietJoin> dm = null;
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = ss.beginTransaction();
            SQLQuery q = ss.createSQLQuery("Select hdct.*,s.tenSanPham FROM HoaDonChiTiet hdct,SanPham s,HoaDon hd where hdct.maHoaDon=:maHoaDon and hdct.maSanPham=s.maSanPham and hdct.maHoaDon=hd.maHoaDon");
            dm = q.addEntity(HoaDonChiTietJoin.class).setParameter("maHoaDon", maHoaDon).list();

            transaction.commit();

        } catch (Exception e) {
            dm = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            ss.close();
        }
        return dm;
    }

    public int getLatestDonHang() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("select maHoaDon from HoaDon order by maHoaDon desc");
        int maHoaDon = (int) q.list().get(0);
        ss.close();

        return maHoaDon;
    }

    public boolean Insert(HoaDon sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(sp);
        ss.getTransaction().commit();
        return true;
    }

    public boolean Insertchitiet(HoaDonChiTiet sp) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(sp);
        ss.getTransaction().commit();
        ss.close();
        return true;
    }

    public HoaDon detail(int maHoaDon) {
        HoaDon products = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session
                    .createQuery("from HoaDon where  maHoaDon=:maHoaDon");
            q.setParameter("maHoaDon", maHoaDon);
            products = (HoaDon) q.uniqueResult();
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

    public List<HoaDon> getHoadonDaDuyet() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from HoaDon where tinhTrang=2");
        List<HoaDon> dm = q.list();
        ss.close();
        return dm;
    }

    public boolean UpdateStatus(HoaDon s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();

        return true;
    }

    public void UpdateSoLuong(SanPham sl) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(sl);
        ss.getTransaction().commit();
    }

    public void Update(HoaDon s) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(s);
        ss.getTransaction().commit();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        HoaDon kt = getById(id);
        ss.getTransaction().begin();
        ss.delete(kt);
        ss.getTransaction().commit();
    }
}
