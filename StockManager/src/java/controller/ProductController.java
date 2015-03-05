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
import java.util.List;
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
public class ProductController {

    
    /////////////////////////////////////////
    //LISTE DES PRODUIT
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
    //AJOUT DES PRODUIT
    @RequestMapping(value = "/AddProduit",method=RequestMethod.GET)
    public String addProduct(Model m,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        m.addAttribute("product", new Product());
        m.addAttribute("history", hist1);
        m.addAttribute("history2", hist2);
        m.addAttribute("history3", hist3);
        return "addProduct";
    }

    
    @RequestMapping(value = "/AddProduit",method=RequestMethod.POST)
    public String addPrductToDB(Product cust, Model m,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        dao.update(cust);
        if (!hist1.equals(""))
            return "redirect:/" + hist1 + ".stk?history="+ hist2 +"&history2=" + hist3 + "&history3=";
        else
            return "redirect:/AllProduct.stk";
    }
    //
    /////////////////////////////////////////
    
    
    /////////////////////////////////////////
    //Supression DES produit
    @RequestMapping(value = "/SupProduit",method=RequestMethod.GET)
    public String supProduct(@RequestParam("id") Long id,Model m) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        Product prod = dao.getProductWithId(id);
        m.addAttribute("product", prod);
        return "deleteProduct";
    }
    
    @RequestMapping(value = "/SupProduit",method=RequestMethod.POST)
    public String supProductToDB(Product prod, Model m) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        dao.delete(prod);
        return "redirect:/AllProduct.stk";
    }
    //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //Modif DES produit
    @RequestMapping(value = "/ModifProduit",method=RequestMethod.GET)
    public String upCustomer(@RequestParam("id") Long id,Model m) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        Product prod = dao.getProductWithId(id);
        m.addAttribute("product", prod);
        return "upProduct";
    }

    
    @RequestMapping(value = "/ModifProduit",method=RequestMethod.POST)
    public String upCustomerToDB(Product prod, Model m) {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        dao.update(prod);
        return "redirect:/AllProduct.stk";
    }
    //
    /////////////////////////////////////////
    
    @ModelAttribute(value = "lCateg")
    public List<Metier> lCateg() {
        DaoCategory dao = (DaoCategory) FactoryDao.getDao(Category.class);
        List<Metier> l = dao.selectAll("Category");
        return l;
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
