/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoSupplier;
import factory.FactoryDao;
import java.util.List;
import model.Metier;
import model.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mou_h_000
 */
@Controller
public class SupplierController {
    
    
     @RequestMapping(value = "/addSupplier",method=RequestMethod.GET)
    public String addSupplier(Model m, @RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        m.addAttribute("supplier", new Supplier());
        m.addAttribute("history", hist1);
        m.addAttribute("history2", hist2);
        m.addAttribute("history3", hist3);
        return "addSupplier";
    }

    
    @RequestMapping(value = "/addSupplier",method=RequestMethod.POST)
    public String addSupplier(Supplier cust, Model m, @RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3) {
        DaoSupplier dao = (DaoSupplier) FactoryDao.getDao(Supplier.class);
        dao.update(cust);
        if (!hist1.equals(""))
            return "redirect:/" + hist1 + ".stk?history="+ hist2 +"&history2=" + hist3 + "&history3=";
        else
            return "redirect:/AllSupplier.stk";
    }
    
      /////////////////////////////////////////
    //LISTE DES FOURNISSUERS
    @RequestMapping("/AllSupplier")
    public String allEmployee(Model m) {
        DaoSupplier dao = (DaoSupplier) FactoryDao.getDao(Supplier.class);
        List<Metier> l = dao.selectAll("Supplier");
        m.addAttribute("myList", l);
        return "listSupplier";
    }
    
     //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //Supression DES FOURNISSEURS
    @RequestMapping(value = "/deleteSupplier",method=RequestMethod.GET)
    public String supSupplier(@RequestParam("id") Long id,Model m) {
        DaoSupplier dao = (DaoSupplier) FactoryDao.getDao(Supplier.class);
        Supplier cust = dao.getSupplierWithId(id);
        m.addAttribute("supplier", cust);
        return "deleteSupplier";
    }
    
    @RequestMapping(value = "/deleteSupplier",method=RequestMethod.POST)
    public String supSupplier(Supplier cust, Model m) {
        DaoSupplier dao = (DaoSupplier) FactoryDao.getDao(Supplier.class);
        dao.delete(cust);
        return "redirect:/listSupplier.stk";
    }
    
        //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //Modif fournisseur
    @RequestMapping(value = "/upSupplier",method=RequestMethod.GET)
    public String upCustomer(@RequestParam("id") Long id,Model m) {
        DaoSupplier dao = (DaoSupplier) FactoryDao.getDao(Supplier.class);
        Supplier cust = dao.getSupplierWithId(id);
        m.addAttribute("supplier", cust);
        return "upSupplier";
    }

    
    @RequestMapping(value = "/upSupplier",method=RequestMethod.POST)
    public String upCustomerToDB(Supplier cust, Model m) {
        DaoSupplier dao = (DaoSupplier) FactoryDao.getDao(Supplier.class);
        dao.update(cust);
        return "redirect:/listSupplier.stk";
    }
}
