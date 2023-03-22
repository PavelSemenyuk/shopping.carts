package com.example.shopping.carts.controller;

import com.example.shopping.carts.exception.CartFullException;
import com.example.shopping.carts.service.ShoppingCartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store2")

public class ControllerShoppingCarts2 {
    @Autowired
    private final ShoppingCartsService shoppingCartsService;

    public ControllerShoppingCarts2(ShoppingCartsService shoppingCartsService) {
        this.shoppingCartsService = shoppingCartsService;
    }

    @GetMapping(path = "/order/add")
    public String shoppingCartsAdd(@RequestParam(name = "itemId") Integer... itemId) {
        return shoppingCartsService.add(itemId);
    }

    @GetMapping(path = "/order/get")
    public List<Integer> getEmployees() {
        return shoppingCartsService.getAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CartFullException.class)
    public String handleException(CartFullException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}

