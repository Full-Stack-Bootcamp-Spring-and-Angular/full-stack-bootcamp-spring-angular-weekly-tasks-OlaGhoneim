package main.com.myApp.controller;
import javax.validation.Valid;

import main.com.myApp.dao.UserDao;
import main.com.myApp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @Autowired
    private UserDao userDao ;
    @Autowired
    private Validator mvcValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/")
    public String HomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }
    @RequestMapping("/showForm")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult, Model model)
    {
        if( userModel.getPassword() != null &&
                userModel.getConfirmPassword() != null &&
                !userModel.getPassword().equals(userModel.getConfirmPassword() )){

            bindingResult.rejectValue("confirmPassword", null, "Passwords do not match!");
        }
        if( bindingResult.hasErrors() ){
            return "formPage";
        }

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