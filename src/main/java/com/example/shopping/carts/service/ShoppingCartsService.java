package com.example.shopping.carts.service;

import com.example.shopping.carts.carts.ShoppingCarts;
import com.example.shopping.carts.exception.CartFullException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope (scopeName = "prototype")
public class ShoppingCartsService implements InterfaceShoppingCertsService {
    @Autowired
    private ShoppingCarts shoppingCarts;
    Logger log = LoggerFactory.getLogger(ShoppingCartsService.class);

    public ShoppingCartsService(ShoppingCarts shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public static Map<Integer, String> MAP_OF_SHOPPING = new HashMap<>();

    static {
        MAP_OF_SHOPPING.put(1, "АПЕЛЬСИН");
        MAP_OF_SHOPPING.put(2, "АНАНАС");
        MAP_OF_SHOPPING.put(3, "КИВИ");
        MAP_OF_SHOPPING.put(4, "Груша");
    }

    public ShoppingCartsService() {
        log.info("Корзина с покупками!");
    }

    @PostConstruct
    public void setup() {
        log.info("Корзина создана");
    }

    public String add(Integer ... itemId) {
        for (int i = 0; i < itemId.length; i++) {
          if(!MAP_OF_SHOPPING.containsKey(itemId[i])) {
              throw new CartFullException("товара не найден");
          }
          else {
              shoppingCarts.shoppingCartsList.add(Integer.valueOf(itemId[i]));
          }
        }
        return "Продукт добавлен!";
    }

    public List<Integer> getAll() {
        return shoppingCarts.shoppingCartsList;
    }
}



