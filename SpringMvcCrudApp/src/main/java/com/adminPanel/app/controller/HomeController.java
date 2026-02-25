package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.productService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController
{
    @Autowired
    private productService productService;


    @RequestMapping("/")
    public String homePage(Model model)
    {
        model.addAttribute("productsList",productService.getAllProducts());

        return "homePage";
    }

    @RequestMapping("/showProductDetails")
   public String showProductDetails(@RequestParam int id, Model productModel){
        Product product = productService.findById(id);

        productModel.addAttribute("product", product.getProductDetails());

        return "viewDetailsPage";
    }


    @RequestMapping("/showUpdateProduct")
    public String showUpdateProductForm(@RequestParam int id, Model productModel){
        Product product = productService.findById(id);
        productModel.addAttribute("product", product.getProductDetails());

        return "updateDetailsForm";
    }

    @RequestMapping(value = "/processUpdateProduct", method = RequestMethod.POST)
    public String processUpdateProductForm(@Valid @ModelAttribute("product") ProductDetails productDetails, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return  "updateDetailsForm";
        }
        productService.updateDetails(productDetails);
        return "redirect:/";

    }
    @RequestMapping(value="/deleteProduct",method=RequestMethod.POST)
    public String deleteProductForm(@RequestParam("id") int id){
        productService.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/showAddProduct")
    public String showAddProductForm(Model product){
        product.addAttribute("product", new ProductDetails());

        return "addProductForm";
    }

    @RequestMapping(value = "/processAddProduct", method = RequestMethod.POST)
    public String processAddProductForm(@Valid@ModelAttribute ("product") ProductDetails productDetails, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "addProductForm";
        }
        productService.insert(productDetails);
        return "redirect:/";
    }





}




