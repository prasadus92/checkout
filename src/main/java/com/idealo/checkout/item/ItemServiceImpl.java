package com.idealo.checkout.item;

import com.idealo.checkout.item.repository.ItemRepository;
import com.idealo.checkout.vo.Item;
import com.idealo.checkout.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems(List<String> itemsName) {
        return itemRepository
                .findByNameIn(itemsName)
                .stream()
                .map(item -> ItemTransformer.toVO(item, itemsName))
                .collect(toList());
    }
}
