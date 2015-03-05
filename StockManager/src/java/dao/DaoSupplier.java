/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import model.Customer;
import model.Supplier;
import org.hibernate.Session;

/**
 *
 * @author userinsta
 */
public class DaoSupplier extends DaoGeneric<Supplier>{

    public DaoSupplier() {
        super();
    }
    
    
    public Supplier getSupplierWithId(Long id) {
        Session session = HibernateUtil.getSession();
        Supplier cust = (Supplier) session.load(Supplier.class, id);
        return cust;
    }

    
}
