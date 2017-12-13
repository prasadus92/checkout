package com.idealo.checkout.facade;

import com.idealo.checkout.vo.Basket;

import java.util.List;

public interface ComputationService {

    Basket compute(List<String> itemsName);

}
