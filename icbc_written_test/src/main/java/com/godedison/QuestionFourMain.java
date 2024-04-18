package com.godedison;

import com.godedison.entity.Discount;
import com.godedison.entity.Fruit;
import com.godedison.entity.Order;
import com.godedison.entity.OrderItem;
import com.godedison.service.QuestionService;

import java.math.BigDecimal;

public class QuestionFourMain {
    public static void main(String[] args) {

        QuestionService questionService = new QuestionService();

        //定义苹果
        Fruit apple = new Fruit();
        apple.setName("苹果");
        apple.setPrice(new BigDecimal(8));

        Order order = new Order();
        order.setOrderPrice(new BigDecimal(0));
        order.setTotalPrice(new BigDecimal(0));
        order.setDiscount(new BigDecimal(0));
        order.setFinalPrice(new BigDecimal(0));

        //定义草莓
        Fruit strawberry = new Fruit();
        strawberry.setName("草莓");
        strawberry.setPrice(new BigDecimal(13));
        strawberry.setCoefficient(80);

        //定义芒果
        Fruit mango = new Fruit();
        mango.setName("芒果");
        mango.setPrice(new BigDecimal(20));

        //购买苹果5斤，草莓3斤
        OrderItem appleItem = questionService.buyGoods(apple, 5);

        order = questionService.buildOrder(order, appleItem);
        OrderItem strawberryItem = questionService.buyGoods(strawberry, 8);
        order = questionService.buildOrder(order, strawberryItem);
        OrderItem mangoItem = questionService.buyGoods(mango, 8);
        order = questionService.buildOrder(order, mangoItem);

        //设计折扣
        Discount discount = new Discount();
        discount.setDiscount(new BigDecimal(10));
        discount.setTargetPrice(new BigDecimal(100));

        questionService.calculateOrder(order, discount);
        System.out.println(order);

        int fruitSum = 0;

        for (OrderItem orderGood : order.getOrderGoods()) {
            if (orderGood.getGoods() instanceof Fruit){

                fruitSum = fruitSum + orderGood.getQuantity();
            }
        }
        System.out.println("水果总数：" + fruitSum);


    }
}