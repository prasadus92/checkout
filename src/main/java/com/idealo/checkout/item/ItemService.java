package com.idealo.checkout.item;

import com.idealo.checkout.vo.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems(List<String> itemsName);

}
