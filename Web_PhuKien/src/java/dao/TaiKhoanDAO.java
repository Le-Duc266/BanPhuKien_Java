/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NguoiDung;
import entities.NhanVien;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {

    Session ss = null;

    public TaiKhoanDAO() {
    }

    public List<NguoiDung> getNguoiDung() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from NguoiDung");
        List<NguoiDung> nd = q.list();
        ss.close();
        return nd;
    }

    public List<NhanVien> getNhanVien() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from NhanVien");
        List<NhanVien> nv = q.list();
        ss.close();
        return nv;
    }

    public void insertTaiKhoanNguoiDung(NguoiDung nd) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(nd);
        ss.getTransaction().commit();
        ss.close();
    }

    public boolean dangNhap(NguoiDung nd) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NguoiDung n where n.email =? and n.password = ?");
        query.setParameter(0, nd.getEmail());
        query.setParameter(1, nd.getPassword());
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {
            userFound = true;
        }
        ss.close();
        return userFound;

    }

    public NguoiDung checkName(String nhan) {
        ss = HibernateUtil.getSessionFactory().openSession();
        try {

            List<NguoiDung> users = new ArrayList<NguoiDung>();
            users = ss.createQuery("from NguoiDung n where n.email =?")
                    .setParameter(0, nhan).list();
            if (users.size() > 0) {
                return users.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     public NhanVien checkAdmin(String nhan) {
        ss = HibernateUtil.getSessionFactory().openSession();
        try {

            List<NhanVien> admin = new ArrayList<NhanVien>();
            admin = ss.createQuery("from NhanVien n where n.tenTaiKhoan =?")
                    .setParameter(0, nhan).list();
            if (admin.size() > 0) {
                return admin.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     public boolean checkNametontai(String nhan) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NguoiDung n where n.email =?");
        query.setParameter(0, nhan);
       
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;
   
      
    }
}
