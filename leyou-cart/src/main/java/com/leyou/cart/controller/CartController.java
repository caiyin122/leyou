package com.leyou.cart.controller;

import com.leyou.cart.pojo.Cart;
import com.leyou.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Auther xcai
 * @Date 2020/2/27
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    //添加购物车信息到数据库
    @PostMapping
    public ResponseEntity<Void> addCart(@RequestBody Cart cart){

        this.cartService.addCart(cart);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //查询购物车信息
    @GetMapping
    public ResponseEntity<List<Cart>> queryCarts(){

        List<Cart> carts =this.cartService.queryCarts();

        if(CollectionUtils.isEmpty(carts)){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(carts);
    }

    //更新购物车信息
    @PutMapping
    public ResponseEntity<Void> updateNum(@RequestBody Cart cart){

        this.cartService.updateNum(cart);
        return ResponseEntity.noContent().build();
    }
}
