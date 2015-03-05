/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoEmployee;
import dao.DaoGeneric;
import dao.DaoOrders;
import dao.DaoProduct;
import factory.FactoryDao;
import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import model.Customer;
import model.Employee;
import model.Metier;
import model.Orderproduct;
import model.Orders;
import model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mou_h_000
 */

@Controller
public class CommandesController {
    
  
   @RequestMapping(value = "/addCommandes",method = RequestMethod.GET)
    public String ajoutCommande(Model model, @RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3){
        model.addAttribute("commandes", new Orders());
        model.addAttribute("history", hist1);
        model.addAttribute("history2", hist2);
        model.addAttribute("history3", hist3);
        return "addCommandes";
    }
    
    @RequestMapping(value = "/addCommandes",method = RequestMethod.POST)
    public String ajoutCommande(Model model,Orders order, HttpServletRequest request,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3){
        DaoOrders dao =(DaoOrders) FactoryDao.getDao(Orders.class);
        Employee emp = (Employee) request.getSession().getAttribute("userConnecte");
        order.setEmployee(emp);
        Date d = new Date();
        order.setDateOrders(d);
        dao.insert(order);
        List<Orders> l = new ArrayList<Orders>();
        Session s = HibernateUtil.getSession();
        s.merge(order);
        s.refresh(order);
        l.add(order);
        model.addAttribute("ordp", new Orderproduct());
        model.addAttribute("lOrder", l);
        return "addCommandes_1";
    }
    
    
    @RequestMapping(value = "/addProducttoCmd",method = RequestMethod.POST)
    public String addProducttoCmd(Model model,Orderproduct order, HttpServletRequest request,@RequestParam(value = "history",defaultValue = "") String hist1, @RequestParam(value = "history2",defaultValue = "") String hist2, @RequestParam(value = "history3",defaultValue = "") String hist3){
        DaoOrders dao =(DaoOrders) FactoryDao.getDao(Orders.class);
        DaoProduct daoP =(DaoProduct) FactoryDao.getDao(Product.class);
        Product p = daoP.getProductWithId(order.getProduct().getIdProduct());
        int stock = p.getStockProduct();
        int result = (int) (stock - order.getQuantityOrder());
        if ((stock - order.getQuantityOrder()) >= 0)
            p.setStockProduct(result);
        else{
            p.setStockProduct(0);
            order.setQuantityOrder(Long.parseLong(""+stock));
        }
        daoP.update(p);
        dao.insert(order);
        return "redirect:/listCommandes.stk";
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
            if (p.getMaxStockProduct() < p.getStockProduct() )
                nb++;
        }
        return nb;
    }
    @ModelAttribute(value = "lProduitSurStock")
    public List<Product> lProduitSurStock() {
        DaoProduct dao = (DaoProduct) FactoryDao.getDao(Product.class);
        List<Product> lp = new ArrayList<Product>();
        List l = dao.selectAll("Product");
        for (Object c : l) {
            Product p = (Product) c;
            if (p.getMaxStockProduct() < p.getStockProduct() )
                lp.add(p);
        }
        return lp;
    }
}
