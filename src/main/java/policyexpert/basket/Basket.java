package policyexpert.basket;

import policyexpert.discount.Discount;
import policyexpert.item.Item;
import policyexpert.price.Quantity;

import java.util.HashSet;
import java.util.Set;

public class Basket {

    private final Set<BasketItem> basketItems;
    private final Set<Discount> discounts;

    public Basket() {
        discounts = new HashSet<>();
        basketItems = new HashSet<>();
    }

    public long subtotal() {
        return basketItems.stream().mapToLong(x -> x.cost()).sum();
    }

    public long discounts() {
        return discounts.stream().mapToLong(d -> d.discount(basketItems)).sum();
    }



    public void addItem(Item item, Quantity quantity) {
        basketItems.add(new BasketItem(item, quantity));
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }
}
