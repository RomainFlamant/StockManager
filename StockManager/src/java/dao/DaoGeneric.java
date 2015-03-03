/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import hibernate.HibernateUtil;
import java.util.List;
import model.Metier;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author userinsta
 * @param <T>
 */
public abstract class DaoGeneric<T extends Metier> {

    private Session session;
    public DaoGeneric() {
        this.session = HibernateUtil.getSession();
    }
    
    

    public void insert(Metier objet) {
        session = HibernateUtil.getSession();
        Transaction trx = session.beginTransaction();
        try {
            session.save(objet);
            trx.commit();

        } catch (HibernateException ex) {
            trx.rollback();
        }
    }

    public void update(Metier objet) {
        session = HibernateUtil.getSession();
        Transaction trx = session.beginTransaction();

        try {
            session.update(objet);
            trx.commit();
        } catch (HibernateException ex) {
            trx.rollback();
        }
    }

    public void delete(Metier objet) {
        session = HibernateUtil.getSession();
        Transaction trx = session.beginTransaction();

        try {
            session.delete(objet);
            trx.commit();
        } catch (HibernateException ex) {
            trx.rollback();
        }
    }

    public List<Metier> selectAll(String metier) {
        session = HibernateUtil.getSession();

        Query q = session.createQuery("From " + metier);
        List<Metier> l = q.list();
        session.close();
        return l;
        

    }
    
}
