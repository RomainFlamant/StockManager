/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCustomer;
import dao.DaoProduct;
import factory.FactoryDao;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Metier;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String addCustomer(Model m,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        m.addAttribute("customer", new Customer());
        m.addAttribute("history", hist1);
        m.addAttribute("history2", hist2);
        m.addAttribute("history3", hist3);
        return "addCustomer";
    }

    
    @RequestMapping(value = "/AddClients",method=RequestMethod.POST)
    public String addCustomerToDB(Customer cust, Model m,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        DaoCustomer dao = (DaoCustomer) FactoryDao.getDao(Customer.class);
        dao.update(cust);
        if (!hist1.equals(""))
            return "redirect:/" + hist1 + ".stk?history="+ hist2 +"&history2=" + hist3 + "&history3=";
        else
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
    
    @ModelAttribute(value = "lProduitHorsStock")
    public List<Product> lProduitHorsStock() {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        List<Product> lp = new ArrayList<Product>();
        List l = dao.selectAll("Product");
        for (Object c : l) {
            Product p = (Product) c;
            if (p.getMinStockProduct() > p.getStockProduct() )
                lp.add(p);
        }
        return lp;
    }
    
    @ModelAttribute(value = "nbProduitHorsStock")
    public int nbProduitHorsStock() {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        List<Product> lp = new ArrayList<Product>();
        List l = dao.selectAll("Product");
        int nb = 0;
        for (Object c : l) {
            Product p = (Product) c;
            if (p.getMinStockProduct() > p.getStockProduct() )
                nb++;
        }
        return nb;
    }
    
}
