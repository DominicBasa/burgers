package com.example.burgers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.burgers.models.Burger;
import com.example.burgers.services.BurgerService;

@Controller
public class MainController {
  
  @Autowired BurgerService burgerService;

  //! CREATE/ READ ALL
  @RequestMapping("/")
  public String index(@ModelAttribute("burger")Burger burger) {
    return "index.jsp";
  }


  @PostMapping("/burgers")
  public String create(@Valid @ModelAttribute("burger")Burger burger,  BindingResult result){
    if(result.hasErrors()) {
      return "index.jsp";
    } else {
      burgerService.createBurger(burger);
    }
    return"redirect:/";
  }



}
