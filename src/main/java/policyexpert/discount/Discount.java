package policyexpert.discount;

import policyexpert.basket.BasketItem;

import java.util.Set;

public interface Discount {
    long discount(Set<BasketItem> items);
}
