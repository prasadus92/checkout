package com.idealo;

import com.idealo.checkout.facade.ComputationService;
import com.idealo.checkout.item.domain.Item;
import com.idealo.checkout.item.repository.ItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.idealo.CheckoutApplication.DEFAULT_ITEMS;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CheckoutApplication.class)
@WebAppConfiguration()
@DirtiesContext
public class InitializationTest {

    @Autowired
    protected ComputationService sut;

    @Autowired
    protected ItemRepository itemRepository;

    @Test
    public void applicationShouldStart_withGivenConfiguration() {
    }

    @Test
    public void repositoryShouldBeInitialized() {
        Iterable<Item> persisted = itemRepository.findAll();
        Assert.assertThat(persisted, containsInAnyOrder(DEFAULT_ITEMS.toArray()));
    }
}
