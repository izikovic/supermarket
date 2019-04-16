package policyexpert;

import java.util.HashSet;
import java.util.Set;

public class Basket {

    private final Set<BasketItem> basketItems;

    public Basket() {
        basketItems = new HashSet<BasketItem>();
    }

    public long totalCost() {
        return basketItems.stream().mapToLong(x -> x.cost()).sum();
    }


    public void addItem(Item item, Quantity quantity) {
        basketItems.add(new BasketItem(item, quantity));
    }
}
