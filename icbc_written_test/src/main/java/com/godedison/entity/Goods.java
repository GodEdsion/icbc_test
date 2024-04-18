package com.godedison.entity;

import java.math.BigDecimal;

public class Goods {

    /**
     * 名称
     */
    private String name;

    /**
     * 折扣(8折 输入80 85折输入85)
     */
    private Integer coefficient;

    /**
     * 价格
     */
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "coefficient='" + coefficient + '\'' +
                ", price=" + price +
                '}';
    }
}
