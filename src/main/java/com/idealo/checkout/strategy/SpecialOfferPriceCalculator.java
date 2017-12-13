package com.idealo.checkout.strategy;

import com.idealo.checkout.vo.Item;

final class SpecialOfferPriceCalculator implements PriceCalculator {

    @Override
    public double calculateTotal(Item item) {
        double underOfferTotal = (item.getQty() / item.getSpecialPrice().getQty()) * item.getSpecialPrice().getPrice();
        double standardTotal = (item.getQty() % item.getSpecialPrice().getQty()) * item.getPrice();
        return underOfferTotal + standardTotal;
    }
}
