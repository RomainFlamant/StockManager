/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoGeneric;
import factory.FactoryDao;
import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author userinsta
 */
@Controller
//@RequestMapping(value = {"/user", "/admin"})
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "login";
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
