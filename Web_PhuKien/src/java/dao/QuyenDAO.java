/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Quyen;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class QuyenDAO {
    Session ss = null;

    public QuyenDAO() {
    }
    
    
    public List<Quyen> getAll() {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from Quyen");
        List<Quyen> dm = q.list();
        ss.close();
        return dm;
    }

    public Quyen getById(int maQuyen) {
        ss = HibernateUtil.getSessionFactory().openSession();
        return (Quyen) ss.get(Quyen.class, maQuyen);
    }
    
     public Quyen getByName(String ten) {
        ss = HibernateUtil.getSessionFactory().openSession();
        Query query = ss.createQuery("from Quyen where tenQuyen =:ten");
        query.setParameter("name", ten);
        Quyen d = (Quyen) query.uniqueResult();
        ss.close();
        return d;
    }

    public void Insert(Quyen q) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.save(q);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Update(Quyen q) {
        ss = HibernateUtil.getSessionFactory().openSession();
        ss.getTransaction().begin();
        ss.update(q);
        ss.getTransaction().commit();
        ss.close();
    }

    public void Delete(int id) {
        ss = HibernateUtil.getSessionFactory().openSession();
        Quyen dmsp = getById(id);
        ss.getTransaction().begin();
        ss.delete(dmsp);
        ss.getTransaction().commit();
        ss.close();
    }
    
}
