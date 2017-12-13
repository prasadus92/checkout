package com.idealo.checkout.facade;

import com.idealo.checkout.item.ItemService;
import com.idealo.checkout.vo.Basket;
import com.idealo.checkout.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.idealo.checkout.strategy.PriceProvider.getCalculator;
import static java.lang.String.valueOf;

@Service
public final class ComputationServiceImpl implements ComputationService {

    private final ItemService itemService;

    @Autowired
    public ComputationServiceImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public Basket compute(List<String> itemsName) {
        List<Item> itemsVo = itemService.getItems(itemsName);
        return Basket.builder()
                .setItems(itemsVo)
                .setTotal(getTotal(itemsVo))
                .build();
    }

    private String getTotal(List<Item> itemsVo) {
        double sum = itemsVo
                .stream()
                .mapToDouble(item -> getCalculator(item).calculateTotal(item))
                .sum();
        return valueOf(sum);
    }
}
