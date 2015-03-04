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
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author userinsta
 */
@Controller

public class IndexController {
    
    
    @RequestMapping(value = "/index")
    public String home(Model model)
    {
        DaoCustomer daoC = (DaoCustomer) FactoryDao.getDao(Customer.class);
        List lc = daoC.selectAll("Customer");
        int clientNbr = 0;
        for (Object c : lc) {
            clientNbr++;
        }
        model.addAttribute("clientNbr", clientNbr);
        
        DaoProduct daoP = (DaoProduct) FactoryDao.getDao(Product.class);
        List lp = daoP.selectAll("Product");
        int ProduitHSNbr = 0;
        int ProduitSSNbr = 0;
        for (Object c : lp) {
            Product p = (Product) c;
            if (p.getMinStockProduct() > p.getStockProduct() )
                ProduitHSNbr++;
            if (p.getMaxStockProduct() < p.getStockProduct() )
                ProduitSSNbr++;
        }
        model.addAttribute("clientNbr", clientNbr);
        model.addAttribute("produitHSNbr", ProduitHSNbr);
        model.addAttribute("produitSSNbr", ProduitSSNbr);
        return "index";
        
    }
    
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
