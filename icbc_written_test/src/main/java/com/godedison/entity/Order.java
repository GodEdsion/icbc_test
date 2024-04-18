package com.godedison.entity;

import java.math.BigDecimal;
import java.util.List;

public class Order {


    /**
     * 订单商品
     */
    private List<OrderItem> orderGoods;

    /**
     * 订单应付价格
     */
    private BigDecimal orderPrice;

    /**
     * 优惠金额
     */
    private BigDecimal discount;

    /**
     * 订单实际应付价格
     */
    private BigDecimal finalPrice;

    /**
     * 订单总价
     */
    private BigDecimal totalPrice;

    public List<OrderItem> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderItem> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "订单总价: " + totalPrice + " 订单应付价格: " + orderPrice + " 优惠金额: " + discount + " 订单实付价格: " + finalPrice;
    }
}
