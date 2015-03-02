/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author userinsta
 */
public class DaoEmployee extends DaoGeneric<Employee>
{
    public DaoEmployee() {
        super();
    }
    
    public Employee connection (Employee emp){
        
        Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql = "FROM Clients WHERE EMail = :email AND mdp = :mdp";
        Query query  = session.createQuery(sql);
        query.setString(":email", emp.getEmailEmployee());
        query.setString(":mdp", emp.getMdpEmployee());
        
         Employee employe = (Employee) query.uniqueResult();
        
         return employe;
        
    }
}
