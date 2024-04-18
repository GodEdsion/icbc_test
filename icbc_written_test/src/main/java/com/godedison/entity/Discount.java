package com.godedison.entity;

import java.math.BigDecimal;

public class Discount {

    /**
     * 目标金额
     */
    private BigDecimal targetPrice;

    /**
     * 优惠金额
     */
    private BigDecimal discount;


    public BigDecimal getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(BigDecimal targetPrice) {
        this.targetPrice = targetPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
