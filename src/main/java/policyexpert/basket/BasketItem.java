package policyexpert.basket;

import policyexpert.item.Item;
import policyexpert.price.Quantity;

public class BasketItem {
    private final Item item;
    private final Quantity quantity;

    public BasketItem(Item item, Quantity quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public long cost() {
        return item.getPrice().cost(quantity.value());
    }
}
