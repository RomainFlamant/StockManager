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
    
    
}
