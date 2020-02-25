package com.furniturefuture.controller;

import com.furniturefuture.entity.Product;
import com.furniturefuture.entity.User;
import com.furniturefuture.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/add")
    public String addNewProduct(Model model) {
        model.addAttribute("productForm", new Product());
        return "newProduct";
    }

    @PostMapping("/product/add")
    public String addUser(@ModelAttribute("productForm") @Valid Product productForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newProduct";
        }

        if (productService.findByProductName(productForm.getProductName())!=null) {
            model.addAttribute("Error", "Product already exists");
            return "newProduct";
        }
        productService.save(productForm);
        model.addAttribute("Success","Product was added successfully");

        return "redirect:/";
    }
    @GetMapping("/product/all")
    public String allProducts(Model model) {
        model.addAttribute("allProducts", productService.findAllProducts());
        return "products";
    }
}
