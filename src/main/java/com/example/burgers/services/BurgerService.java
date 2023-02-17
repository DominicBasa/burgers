package com.example.burgers.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.burgers.models.Burger;
import com.example.burgers.repositories.BurgerRepository;

@Service
public class BurgerService {
  
  @Autowired BurgerRepository burgerRepository;

  public void createBurger(Burger burger) {
    burgerRepository.save(burger);
  }
}
