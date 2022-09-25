/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.HibernateUtil;
import entities.Quyen;
import entities.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class NhanVienDAO {

    Session ss;

    public NhanVienDAO() {
    }

    public boolean loginStudent(NhanVien nhanVien) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NhanVien n where n.email =? and n.password = ?");
        query.setParameter(0, nhanVien.getEmail());
        query.setParameter(1, nhanVien.getPassword());
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;

    }

    public NhanVien checkName(String nhan) {
        ss = HibernateUtil.getSessionFactory().openSession();
        try {

            List<NhanVien> users = new ArrayList<NhanVien>();
            users = ss.createQuery("from NhanVien n where n.email =?")
                    .setParameter(0, nhan).list();
            if (users.size() > 0) {
                return users.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkNametontai(String nhan) {

        ss = HibernateUtil.getSessionFactory().openSession();
        boolean userFound = false;

        Query query = ss.createQuery("from NhanVien n where n.email =?");
        query.setParameter(0, nhan);
       
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {

            userFound = true;
        }

        ss.close();
        return userFound;
   
      
    }

    public boolean Insert(NhanVien nhanvien) {
       
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
       Quyen chucVu=new Quyen();
       chucVu.setMaQuyen(2);
        nhanvien.setMaQuyen(chucVu);
        ss.save(nhanvien);
        ss.getTransaction().commit();
        ss.close();
        return true;
    }

}
