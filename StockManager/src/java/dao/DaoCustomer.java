/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import model.Customer;
import org.hibernate.Session;

/**
 *
 * @author userinsta
 */
public class DaoCustomer extends DaoGeneric<Customer>{

    public DaoCustomer() {
        super();
    }

   
    public Customer getCustomersWithId(Long id) {
        Session session = HibernateUtil.getSession();
        Customer cust = (Customer) session.load(Customer.class, id);
        return cust;
    }
}
