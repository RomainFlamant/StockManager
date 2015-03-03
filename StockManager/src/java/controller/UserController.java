/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoEmployee;
import dao.DaoGeneric;
import factory.FactoryDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

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
 
    @RequestMapping("/AllEmployee")
    public String allEmployee(Model m) {
        DaoEmployee dao = (DaoEmployee) FactoryDao.getDao(Employee.class);
        dao.selectAll("Employee");
        m.addAttribute("myList", dao.selectAll("Employee"));
        return "listEmployee";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String inscription(Model model) {

        model.addAttribute("user", new Employee());
        return "inscription";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String inscription(@ModelAttribute(value = "user") Employee user) {
        DaoGeneric dao = FactoryDao.getDao(Employee.class);
        dao.insert(user);
        return "index";
    }

}
