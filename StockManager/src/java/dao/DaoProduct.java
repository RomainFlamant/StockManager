/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import model.Customer;
import model.Product;
import org.hibernate.Session;

/**
 *
 * @author userinsta
 */
public class DaoProduct extends DaoGeneric<Product>{

    public DaoProduct() {
        super();
    }
    
    public Product getProductWithId(Long id) {
        Session session = HibernateUtil.getSession();
        Product pro = (Product) session.load(Product.class, id);
        return pro;
    }
    
}
