package com.idealo.checkout.item.domain;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Item {

    @Id
    private final String name;

    @NotNull
    private final Double price;

    @Nullable
    private final Integer offerQty;

    @Nullable
    private final Double offerPrice;

    Item(String name, Double price, Integer offerQty, Double offerPrice) {
        checkNotNull(name);
        checkNotNull(price);

        this.name = name;
        this.price = price;
        this.offerQty = offerQty;
        this.offerPrice = offerPrice;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Nullable
    public Integer getOfferQty() {
        return offerQty;
    }

    @Nullable
    public Double getOfferPrice() {
        return offerPrice;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item that = (Item) o;

        return Objects.equal(this.name, that.name) &&
                Objects.equal(this.price, that.price) &&
                Objects.equal(this.offerQty, that.offerQty) &&
                Objects.equal(this.offerPrice, that.offerPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, price, offerQty, offerPrice);
    }


    public static final class Builder {

        private String name;
        private Double price;
        private Integer offerQty;
        private Double offerPrice;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder offerQty(Integer offerQty) {
            this.offerQty = offerQty;
            return this;
        }

        public Builder offerPrice(Double offerPrice) {
            this.offerPrice = offerPrice;
            return this;
        }

        public Item build() {
            return new Item(name, price, offerQty, offerPrice);
        }
    }
}
