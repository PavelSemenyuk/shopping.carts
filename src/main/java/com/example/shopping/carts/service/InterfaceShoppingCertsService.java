package com.example.shopping.carts.service;

import java.util.List;

public interface InterfaceShoppingCertsService {
    String add(Integer ... itemId);
    List<Integer> getAll();
}
