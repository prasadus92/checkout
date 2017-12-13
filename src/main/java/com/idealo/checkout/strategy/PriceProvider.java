package com.idealo.checkout.strategy;

import com.idealo.checkout.vo.Item;

import static com.google.common.base.Optional.fromNullable;

public final class PriceProvider {

    private static final PriceCalculator basePriceCalculator = new BasePriceCalculator();
    private static final PriceCalculator specialOfferPriceCalculator = new SpecialOfferPriceCalculator();

    private PriceProvider() {
        throw new UnsupportedOperationException();
    }

    public static PriceCalculator getCalculator(Item item) {
        if(fromNullable(item.getSpecialPrice()).isPresent()){
            return specialOfferPriceCalculator;
        }
        return basePriceCalculator;
    }
}
