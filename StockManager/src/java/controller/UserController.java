/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoEmployee;
import factory.FactoryDao;
import javax.servlet.http.HttpSession;
import java.util.List;
import model.Employee;
import model.Metier;
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
    public String login(@ModelAttribute(value = "user") Employee user,HttpSession session) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        Employee employe = dao.connection(user);
        if (employe != null) {
            session.setAttribute("userConnecte", employe);
            return "index";
        } else {
            return "login";
        }

    }

    /////////////////////////////////////////
    //LISTE DES EMPLOYEES
    @RequestMapping("/AllEmployee")
    public String allEmployee(Model m) {
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
    @RequestMapping(value = "/AddEmployee",method=RequestMethod.GET)
    public String addEmployee(Model m) {
        m.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    
    @RequestMapping(value = "/AddEmployee",method=RequestMethod.POST)
    public String addEmployeeToDB(Employee emp, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        emp.setIsActive(1);
        dao.insert(emp);
        m.addAttribute("ResultForm","success");
        m.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    //
    /////////////////////////////////////////
    
    /////////////////////////////////////////
    //DELETE EMPLOYEE
    //
    @RequestMapping(value = "/SupEmployee",method=RequestMethod.GET)
    public String supEmployee(@RequestParam("id") Long id,Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        Employee emp = dao.getEmployeeWithId(id);
        m.addAttribute("employee", emp);
        return "deleteEmployee";
    }
    
    @RequestMapping(value = "/SupEmployee",method=RequestMethod.POST)
    public String supEmployeeToDB(Employee emp, Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        emp.setIsActive(0);
        dao.update(emp);
        m.addAttribute("ResultForm","success");
        m.addAttribute("employee", emp);
        return "redirect:/AllEmployee.stk";
    }
    //
    /////////////////////////////////////////
}
