package com.godedison;

import com.godedison.entity.Fruit;
import com.godedison.entity.Order;
import com.godedison.entity.OrderItem;
import com.godedison.service.QuestionService;

import java.math.BigDecimal;

public class QuestionOneMain {
    public static void main(String[] args) {

        QuestionService questionService = new QuestionService();

        //定义苹果
        Fruit apple = new Fruit();
        apple.setName("苹果");
        apple.setPrice(new BigDecimal(8));

        //定义草莓
        Fruit strawberry = new Fruit();
        strawberry.setName("草莓");
        strawberry.setPrice(new BigDecimal(13));

        //购买苹果5斤，草莓3斤
        OrderItem appleItem = questionService.buyGoods(apple, 5);
        Order order = new Order();
        order.setOrderPrice(new BigDecimal(0));
        order.setTotalPrice(new BigDecimal(0));
        order.setDiscount(new BigDecimal(0));
        order.setFinalPrice(new BigDecimal(0));
        order = questionService.buildOrder(order, appleItem);
        OrderItem strawberryItem = questionService.buyGoods(strawberry, 3);
        order = questionService.buildOrder(order, strawberryItem);

        questionService.calculateOrder(order, null);
        System.out.println(order);


    }
}