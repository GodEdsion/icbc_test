package com.godedison.entity;

public class OrderItem {

    /**
     * 商品
     */
    private Goods goods;

    /**
     * 数量
     */
    private int quantity;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "goods=" + goods +
                ", quantity=" + quantity +
                '}';
    }
}
