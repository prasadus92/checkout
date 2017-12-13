package com.idealo.checkout.transformer;

import com.idealo.checkout.vo.Item;
import com.idealo.checkout.vo.SpecialPrice;

import java.util.List;

import static com.google.common.base.Optional.fromNullable;
import static java.util.stream.Collectors.counting;

public final class ItemTransformer {

    private ItemTransformer() {
        throw new UnsupportedOperationException();
    }

    public static com.idealo.checkout.vo.Item toVO(com.idealo.checkout.item.domain.Item item, List<String> itemsRequest) {
        return Item.builder()
                .setName(item.getName())
                .setPrice(item.getPrice())
                .setQty(countSimilarItemsInRequest(item, itemsRequest))
                .setSpecialPrice(prepareSpecialPrice(item))
                .build();
    }

    private static int countSimilarItemsInRequest(com.idealo.checkout.item.domain.Item item, List<String> itemsName) {
        return itemsName.stream().filter(name -> name.equals(item.getName())).collect(counting()).intValue();
    }

    private static SpecialPrice prepareSpecialPrice(com.idealo.checkout.item.domain.Item item) {
        if (fromNullable(item.getOfferPrice()).isPresent()) {
            return SpecialPrice.builder().setPrice(item.getOfferPrice()).setQty(item.getOfferQty()).build();
        }
        return null;
    }
}