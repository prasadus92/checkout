package com.idealo.checkout.api;

import com.idealo.checkout.facade.ComputationService;
import com.idealo.checkout.vo.Basket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/api/basket")
class BasketEvaluation {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasketEvaluation.class);

    private final ComputationService computationService;

    @Autowired
    BasketEvaluation(ComputationService computationService) {
        this.computationService = computationService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Basket calculateTotal(@RequestBody @NotNull List<String> itemsName) {
        return computationService.compute(itemsName);
    }
}
