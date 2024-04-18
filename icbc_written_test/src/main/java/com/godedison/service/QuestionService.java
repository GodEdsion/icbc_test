package com.godedison.service;

import com.godedison.entity.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class QuestionService {


    /**
     * 计算订单
     * @param order
     * @param discount
     * @return
     */
    public  void calculateOrder(Order order, Discount discount){


        for (OrderItem orderItem : order.getOrderGoods()){
            calculateGoodsPrice(orderItem, order);
        }

        if (discount != null){
            calculateOrderDiscount(order, discount);
        }
    }

    /**
     * 购买商品
     * @param goods
     * @param quantity
     * @return
     */
    public  OrderItem buyGoods(Goods goods, int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setGoods(goods);
        orderItem.setQuantity(quantity);
        return orderItem;

    }

    /**
     * 创建订单
     * @param order
     * @param orderItem
     */
    public  Order buildOrder(Order order, OrderItem orderItem){
        List<OrderItem> hadOrderItem = order.getOrderGoods();
        if (hadOrderItem == null || hadOrderItem.isEmpty()){
            hadOrderItem = new LinkedList<>();
        }

        hadOrderItem.add(orderItem);
        order.setOrderGoods(hadOrderItem);
        return order;
    }

    /**
     * 计算商品价格
     * @param orderItem
     * @return
     */
    public  void calculateGoodsPrice(OrderItem orderItem, Order order){
        BigDecimal price = orderItem.getGoods().getPrice();
        if (orderItem.getGoods().getCoefficient() != null){

            int coefficient = orderItem.getGoods().getCoefficient();
            //折扣转换
            BigDecimal coefficientHundred = new BigDecimal(coefficient).divide(new BigDecimal(100)).setScale(2);
            order.setDiscount(order.getDiscount().add(price.subtract(price.multiply(coefficientHundred)).multiply(BigDecimal.valueOf(orderItem.getQuantity()))));
        }

        int quantity = orderItem.getQuantity();
        order.setTotalPrice(order.getTotalPrice().add(price.multiply(new BigDecimal(quantity))));
        order.setOrderPrice(order.getTotalPrice().subtract(order.getDiscount()));
        order.setFinalPrice(order.getTotalPrice().subtract(order.getDiscount()));
    }

    /**
     * 计算优惠折扣
     * @param order
     * @param discount
     */
    public  void calculateOrderDiscount(Order order, Discount discount){

        //当前逻辑按照满减叠加计算
        if (discount.getTargetPrice().compareTo(order.getOrderPrice()) <= 0){
            int discountNum = order.getOrderPrice().divide(discount.getTargetPrice()).intValue();
            BigDecimal discountPrice = order.getDiscount();
            discountPrice = discountPrice.add(discount.getDiscount().multiply(new BigDecimal(discountNum)));
            order.setDiscount(discountPrice);
            order.setFinalPrice(order.getTotalPrice().subtract(order.getDiscount()));
        }


    }
}
