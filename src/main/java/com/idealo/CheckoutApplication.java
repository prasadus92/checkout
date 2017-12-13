package com.idealo;

import com.idealo.checkout.item.domain.Item;
import com.idealo.checkout.item.repository.ItemRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class CheckoutApplication implements CommandLineRunner {

    public static final List DEFAULT_ITEMS = ImmutableList
            .builder()
            .add(Item.builder().name("A").price(50D).offerPrice(130D).offerQty(3).build())
            .add(Item.builder().name("B").price(30D).offerPrice(45D).offerQty(2).build())
            .add(Item.builder().name("C").price(20D).build())
            .add(Item.builder().name("D").price(15D).build())
            .build();

    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(CheckoutApplication.class, args);
    }

    public void run(String... args) throws Exception {
        itemRepository.save(DEFAULT_ITEMS);
    }
}
