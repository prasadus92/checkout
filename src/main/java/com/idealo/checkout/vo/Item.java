package com.idealo.checkout.vo;

import com.idealo.checkout.vo.AutoValue_Item;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@AutoValue
@JsonDeserialize(builder = AutoValue_Item.Builder.class)
public abstract class Item {

    @NotNull
    public abstract String getName();

    @NotNull
    public abstract double getPrice();

    @NotNull
    public abstract int getQty();

    @Nullable
    public abstract SpecialPrice getSpecialPrice();


    protected Item() {
    }

    public static Builder builder() {
        return new AutoValue_Item.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setName(String name);

        public abstract Builder setPrice(double price);

        public abstract Builder setQty(int qty);

        @Nullable
        public abstract Builder setSpecialPrice(SpecialPrice specialPrice);

        public abstract Item build();
    }
}
