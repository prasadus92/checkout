package com.idealo.checkout.strategy;


import com.idealo.checkout.vo.Item;

public interface PriceCalculator {

    double calculateTotal(Item item);
}
