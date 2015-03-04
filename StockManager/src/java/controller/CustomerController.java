/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCustomer;
import factory.FactoryDao;
import java.util.List;
import model.Customer;
import model.Metier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Romain
 */
@Controller
//@RequestMapping(value = {"/user", "/admin"})
public class CustomerController {

    /////////////////////////////////////////
    //LISTE DES CLIENTS
    @RequestMapping("/AllCustomers")
    public String allEmployee(Model m) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        List<Metier> l = dao.selectAll("Customer");
        m.addAttribute("myList", l);
        return "listclient";
    }
    //
    /////////////////////////////////////////
    
    
    /////////////////////////////////////////
    //AJOUT DES CLIENTS
    @RequestMapping(value = "/AddClients",method=RequestMethod.GET)
    public String addCustomer(Model m) {
        m.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    
    @RequestMapping(value = "/AddClients",method=RequestMethod.POST)
    public String addCustomerToDB(Customer cust, Model m) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        dao.update(cust);
        return "redirect:/AllCustomers.stk";
    }
    //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //Supression DES CLIENTS
    @RequestMapping(value = "/SupClient",method=RequestMethod.GET)
    public String supCustomer(@RequestParam("id") Long id,Model m) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        Customer cust = dao.getCustomersWithId(id);
        m.addAttribute("customer", cust);
        return "deletecustomers";
    }
    
    @RequestMapping(value = "/SupClient",method=RequestMethod.POST)
    public String supCustomerToDB(Customer cust, Model m) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        dao.delete(cust);
        return "redirect:/AllCustomers.stk";
    }
    //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //Modif DES CLIENTS
    @RequestMapping(value = "/ModifClient",method=RequestMethod.GET)
    public String upCustomer(@RequestParam("id") Long id,Model m) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        Customer cust = dao.getCustomersWithId(id);
        m.addAttribute("customer", cust);
        return "upCustomer";
    }

    
    @RequestMapping(value = "/ModifClient",method=RequestMethod.POST)
    public String upCustomerToDB(Customer cust, Model m) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        dao.update(cust);
        return "redirect:/AllCustomers.stk";
    }
    //
    /////////////////////////////////////////
    
    
    
}
