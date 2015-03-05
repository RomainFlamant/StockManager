/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoProduct;
import factory.FactoryDao;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Romain
 */
@Controller
//@RequestMapping(value = {"/user", "/admin"})
public class ProductController {

    
    /////////////////////////////////////////
    //LISTE DES CLIENTS
    @RequestMapping("/AllProduct")
    public String allEmployee(Model m) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        List l = dao.selectAll("Product");
        m.addAttribute("myList", l);
        return "listproduit";
    }
    //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //AJOUT DES CLIENTS
    @RequestMapping(value = "/AddProduit",method=RequestMethod.GET)
    public String addProduct(Model m) {
        m.addAttribute("produit", new Product());
        return "addProduct";
    }

    
    @RequestMapping(value = "/AddProduit",method=RequestMethod.POST)
    public String addPrductToDB(Product cust, Model m) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
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
