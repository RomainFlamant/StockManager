/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoProduct;
import factory.FactoryDao;
import java.util.Collections;
import java.util.List;
import model.Category;
import model.Metier;
import model.Product;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    
}
