/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCategory;
import dao.DaoProduct;
import factory.FactoryDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Category;
import model.Metier;
import model.Product;
import org.hibernate.mapping.Collection;
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
public class CategorieController {

    
    /////////////////////////////////////////
    //AJOUT DES Categori
    @RequestMapping(value = "/AddCategori",method=RequestMethod.GET)
    public String addProduct(Model m,@RequestParam("history") String hist1, @RequestParam("history2") String hist2, @RequestParam("history3") String hist3) {
        m.addAttribute("history", hist1);
        m.addAttribute("history2", hist2);
        m.addAttribute("history3", hist3);
        m.addAttribute("categ", new Category());
        return "addCategori";
    }

    
    @RequestMapping(value = "/AddCategori",method=RequestMethod.POST)
    public String addPrductToDB(Category categ, Model m, @RequestParam("history") String hist1, @RequestParam("history2") String hist2, @RequestParam("history3") String hist3) {
        DaoCategory dao = (DaoCategory) FactoryDao.getDao(Category.class);
        dao.update(categ);
        if (!hist1.equals(""))
            return "redirect:/" + hist1 + ".stk?history="+ hist2 +"&history2=" + hist3 + "&history3=";
        else
            return "redirect:/AllProduct.stk";
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
