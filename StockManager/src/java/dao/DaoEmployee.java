/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
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
        
        Session session = HibernateUtil.getSession();
        String sql = "FROM  Employee WHERE emailEmployee = ? AND mdpEmployee = ?";
        Query query  = session.createQuery(sql);
        query.setString(0, emp.getEmailEmployee());
        query.setString(1, emp.getMdpEmployee());
        
         Employee employe = (Employee) query.uniqueResult();
        
         return employe;
        
    }

    public Employee getEmployeeWithId(Long id) {
        Session session = HibernateUtil.getSession();
        Employee emp = (Employee) session.load(Employee.class, id);
        return emp;
    }
    
      public Employee getEmployeeWithMdp(String mdp) {
        Session session = HibernateUtil.getSession();
        Employee emp = (Employee) session.load(Employee.class, mdp);
        return emp;
    }
}
