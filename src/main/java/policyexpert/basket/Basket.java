package policyexpert.basket;

import policyexpert.discount.Discount;
import policyexpert.item.Item;
import policyexpert.price.Price;
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

    public long total() {
        return subtotal() - discounts();
    }

    public void addItem(Item item, Quantity quantity) {
        basketItems.add(new BasketItem(item, quantity));
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public void printReceipt() {
        for(BasketItem i : basketItems) {
            System.out.println(i.getItem() + "\t" + i.getQuantity() + "\t" + Price.priceToString(i.cost()));
        }
        System.out.println("Subtotal: " + Price.priceToString(subtotal()));
        System.out.println();
        for (Discount d : discounts) {
            System.out.println(d + "\t" + Price.priceToString(d.discount(basketItems)));
        }
        System.out.println("Total savings: " + Price.priceToString(discounts()));
        System.out.println();

        System.out.println("Total: " + Price.priceToString(total()));
    }

}
