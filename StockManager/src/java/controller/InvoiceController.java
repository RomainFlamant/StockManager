/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCategory;
import dao.DaoGeneric;
import dao.DaoInvoice;
import dao.DaoProduct;
import factory.FactoryDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Category;
import model.Invoice;
import model.Metier;
import model.Product;
import model.Supplier;
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
public class InvoiceController {

     /////////////////////////////////////////
    //LISTE DES INVOICE
    @RequestMapping("/AllInvoice")
    public String allEmployee(Model m) {
        DaoInvoice dao = (DaoInvoice) FactoryDao.getDao(Invoice.class);
        List<Metier> l = dao.selectAll("Invoice");
        m.addAttribute("myList", l);
        return "listInvoice";
    }
    
    
    /////////////////////////////////////////
    //AJOUT DES Invoice
    @RequestMapping(value = "/addInvoice",method=RequestMethod.GET)
    public String addProduct(Model m,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        m.addAttribute("history", hist1);
        m.addAttribute("history2", hist2);
        m.addAttribute("history3", hist3);
        m.addAttribute("invoice", new Invoice());
        return "addInvoice";
    }

    
    @RequestMapping(value = "/addInvoice",method=RequestMethod.POST)
    public String addPrductToDB(Invoice inv, Model m, @RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        DaoInvoice dao = (DaoInvoice) FactoryDao.getDao(Invoice.class);
        dao.update(inv);
        if (!hist1.equals(""))
            return "redirect:/" + hist1 + ".stk?history="+ hist2 +"&history2=" + hist3 + "&history3=";
        else
            return "redirect:/AllProduct.stk";
    }
    //
    /////////////////////////////////////////
    
    @ModelAttribute(value = "lSupplier")
    public List<Supplier> lSupplier(){
        DaoGeneric dao = FactoryDao.getDao(Supplier.class);
        return dao.selectAll("Supplier");
    }
    
    @ModelAttribute(value = "lProduct")
    public List<Product> listeProduct(){
        DaoGeneric dao = FactoryDao.getDao(Product.class);
        return dao.selectAll("Product");
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
