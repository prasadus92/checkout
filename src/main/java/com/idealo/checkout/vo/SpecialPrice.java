package com.idealo.checkout.vo;

import com.idealo.checkout.vo.AutoValue_SpecialPrice;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.validation.constraints.NotNull;

@AutoValue
@JsonDeserialize(builder = AutoValue_SpecialPrice.Builder.class)
public abstract class SpecialPrice {

    @NotNull
    public abstract int getQty();

    @NotNull
    public abstract double getPrice();

    protected SpecialPrice() {
    }

    public static Builder builder() {
        return new AutoValue_SpecialPrice.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setQty(int qty);

        public abstract Builder setPrice(double price);

        public abstract SpecialPrice build();
    }
}
