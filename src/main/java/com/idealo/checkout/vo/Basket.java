package com.idealo.checkout.vo;


import com.idealo.checkout.vo.AutoValue_Basket;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.validation.constraints.NotNull;
import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_Basket.Builder.class)
public abstract class Basket {

    @NotNull
    public abstract List<Item> getItems();

    @NotNull
    public abstract String getTotal();

    protected Basket() {
    }

    public static Builder builder() {
        return new AutoValue_Basket.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setItems(List<Item> items);

        public abstract Builder setTotal(String total);

        public abstract Basket build();
    }
}
