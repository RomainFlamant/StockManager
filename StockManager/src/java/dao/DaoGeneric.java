/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import model.Metier;
import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author userinsta
 * @param <T>
 */
public abstract class DaoGeneric<T extends Metier> extends HibernateDaoSupport{

    
    public DaoGeneric() {
        super();
    }

    public void insert(Metier objet) {
        getHibernateTemplate().getSessionFactory().openSession();
        getHibernateTemplate().getSessionFactory().openStatelessSession();
        getHibernateTemplate().getSessionFactory().getCurrentSession().beginTransaction();
        getHibernateTemplate().save(objet);
        getHibernateTemplate().getSessionFactory().getCurrentSession().getTransaction().commit();
    }

    public void update(Metier objet) {
        getHibernateTemplate().getSessionFactory().openSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().update(objet);
    }

    public void delete(Metier objet) {
        getHibernateTemplate().getSessionFactory().openSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().delete(objet);
    }

    public List<Metier> selectAll(Class obj) {
        return getHibernateTemplate().loadAll(obj);
    }
    
}
