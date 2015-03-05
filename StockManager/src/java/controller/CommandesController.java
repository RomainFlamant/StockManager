/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoEmployee;
import dao.DaoGeneric;
import dao.DaoOrders;
import factory.FactoryDao;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Customer;
import model.Employee;
import model.Metier;
import model.Orders;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mou_h_000
 */

@Controller
public class CommandesController {
    
  
   @RequestMapping(value = "/addCommandes",method = RequestMethod.GET)
    public String ajoutCommande(Model model){
        model.addAttribute("commandes", new Orders());
        return "addCommandes";
    }
    
    @RequestMapping(value = "/addCommandes",method = RequestMethod.POST)
    public String ajoutCommande(Orders order, HttpServletRequest request){
        DaoOrders dao =(DaoOrders) FactoryDao.getDao(Orders.class);
        Employee emp = (Employee) request.getSession().getAttribute("userConnecte");
        order.setEmployee(emp);
        Date d = new Date();
        order.setDateOrders(d);
        dao.insert(order);
        return "redirect:/index.stk";
    }
    
    @ModelAttribute(value = "lCustomer")
    public List<Customer> listeCustomer(){
        DaoGeneric dao = FactoryDao.getDao(Customer.class);
        return dao.selectAll("Customer");
    }
     @ModelAttribute(value = "lProduct")
    public List<Product> listeProduct(){
        DaoGeneric dao = FactoryDao.getDao(Product.class);
        return dao.selectAll("Product");
    }
    
    @RequestMapping("/listCommandes")
    public String listCommande(Model m) {
        DaoOrders dao =(DaoOrders)FactoryDao.getDao(Orders.class);
        List<Metier> l = dao.selectAll("Orders");
        m.addAttribute("myList", l);
        return "listCommandes";
    }
}
