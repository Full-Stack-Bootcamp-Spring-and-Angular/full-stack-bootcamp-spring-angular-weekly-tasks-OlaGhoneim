package main.com.myApp.controller;

import main.com.myApp.model.UserModel;
import main.com.myApp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @Autowired
    private UserDao userDao ;
    @RequestMapping("/showForm")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("userModel") UserModel userModel, Model model)
    {


        //step1: add bean to model
       model.addAttribute("user" , userModel);

        userDao.save(userModel);
       //step2: return view page
        return "resultPage";
    }

    @RequestMapping("/showTestForm")
    public String showTestForm()
    {
        return "test";
    }
}