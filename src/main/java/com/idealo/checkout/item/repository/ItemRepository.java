package com.idealo.checkout.item.repository;

import com.idealo.checkout.item.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, String> {

    List<Item> findByNameIn(List<String> name);

}
