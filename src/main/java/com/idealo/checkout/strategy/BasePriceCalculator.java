package com.idealo.checkout.strategy;

import com.idealo.checkout.vo.Item;

final class BasePriceCalculator implements PriceCalculator {

    @Override
    public double calculateTotal(Item item) {
        return item.getQty() * item.getPrice();
    }
}
