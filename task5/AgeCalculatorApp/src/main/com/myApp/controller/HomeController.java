package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.*;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String home() {
        return "formPage";
    }


    @RequestMapping("/showForm")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {
        // Getting parameters from request and converting to integers
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));

        // Processing the data that received from the request
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birthDate, today);

        // Adding attributes to the model
        model.addAttribute("year", age.getYears());
        model.addAttribute("month", age.getMonths());
        model.addAttribute("day", age.getDays());

        // Return the view with model
        return "resultPage";
    }

}
