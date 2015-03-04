/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCustomer;
import dao.DaoEmployee;
import dao.DaoProduct;
import factory.FactoryDao;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Customer;
import model.Employee;
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
 * @author userinsta
 */
@Controller
//@RequestMapping(value = {"/user", "/admin"})
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new Employee());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "user") Employee user, HttpSession session) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        Employee employe = dao.connection(user);
        if (employe != null && employe.getIsActive()==1) {
            session.setAttribute("userConnecte", employe);
            return "redirect:/index.stk";
        } else {
            return "login";
        }
    }
    
    /////////////////////////////////////////
    //DECO EMPLOYEES
    @RequestMapping("/deconection")
    public String decoEmployee(Model m, HttpSession session) {
        session.removeAttribute("userConnecte");
        return "redirect:/index.stk";
    }
    //
    /////////////////////////////////////////

    /////////////////////////////////////////
    //LISTE DES EMPLOYEES
    @RequestMapping("/AllEmployee")
    public String decoEmployee(Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        List<Metier> l = dao.selectAll("Employee");
        m.addAttribute("myList", l);
        return "listEmployee";
    }
    //
    /////////////////////////////////////////

    /////////////////////////////////////////
    //AJOUT EMPLOYEE
    //
    @RequestMapping(value = "/AddEmployee", method = RequestMethod.GET)
    public String addEmployee(Model m) {
        m.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @RequestMapping(value = "/AddEmployee", method = RequestMethod.POST)
    public String addEmployeeToDB(Employee emp, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        emp.setIsActive(1);
        dao.insert(emp);
        m.addAttribute("ResultForm", "success");
        m.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    //
    /////////////////////////////////////////

    /////////////////////////////////////////
    //DELETE EMPLOYEE
    //
    @RequestMapping(value = "/SupEmployee", method = RequestMethod.GET)
    public String supEmployee(@RequestParam("id") Long id, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        Employee emp = dao.getEmployeeWithId(id);
        m.addAttribute("employee", emp);
        return "deleteEmployee";
    }

    @RequestMapping(value = "/SupEmployee", method = RequestMethod.POST)
    public String supEmployeeToDB(Employee emp, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        emp.setIsActive(0);
        dao.update(emp);
        m.addAttribute("ResultForm", "success");
        m.addAttribute("employee", emp);
        return "redirect:/AllEmployee.stk";
    }
    //
    /////////////////////////////////////////

    @RequestMapping(value = "/profileUser")
    public String showProfileUser() {
        return "profileUser";

    }

    //
    /////////////////////////////////////////
    /////////////////////////////////////////
    //Modification mot de passe
    //
    @RequestMapping(value = "/modifierProfile", method = RequestMethod.GET)
    public String modifierProfile(Model m) {
        m.addAttribute("employee", new Employee());
        return "modifierProfile";
    }

    @RequestMapping(value = "/modifierProfile", method = RequestMethod.POST)
    public String modifierProfile(HttpServletRequest request, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        String nouveaumdp = request.getParameter("nouveaumdp");
        String confirmationmdp = request.getParameter("confirmationmdp");
        Employee emp = (Employee) request.getSession().getAttribute("userConnecte");
        //vérifie si les deux mots de passe correspondent
        if (!nouveaumdp.equals(confirmationmdp)) {
            m.addAttribute("ResultFormError", "error");
            m.addAttribute("employee", new Employee());
        } else {
            if (emp != null) {
                emp.setMdpEmployee(nouveaumdp);
                dao.update(emp);
                m.addAttribute("ResultForm", "success");
                m.addAttribute("employee", new Employee());
            }
        }
        return "modifierProfile";
    }
    
    //
    /////////////////////////////////////////
    /////////////////////////////////////////
    //Modification employé
    //
   @RequestMapping(value = "/modifierEmploye",method=RequestMethod.GET)
    public String upEmploye(@RequestParam("id") Long id,Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        Employee emp = dao.getEmployeeWithId(id);
        m.addAttribute("employe", emp);
        return "modifierEmploye";
    }
    
    @RequestMapping(value = "/modifierEmploye",method=RequestMethod.POST)
    public String upEmploye(Employee emp, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        Employee empWithId=dao.getEmployeeWithId(emp.getIdEmployee());
        emp.setMdpEmployee(empWithId.getMdpEmployee());
        emp.setIsActive(empWithId.getIsActive());
        dao.update(emp); 
        return "redirect:/AllEmployee.stk";
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
