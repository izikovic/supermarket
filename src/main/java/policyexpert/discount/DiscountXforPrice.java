package policyexpert.discount;

import policyexpert.basket.BasketItem;
import policyexpert.item.Item;
import policyexpert.price.Price;

import java.util.Set;

public class DiscountXforPrice implements Discount {
    private final Item item;
    private final long amountX;
    private final Price price;

    public DiscountXforPrice(Item item, long amountX, Price price) {
        this.item = item;
        this.amountX = amountX;
        this.price = price;
    }

    public long discount(Set<BasketItem> items) {
        var count = items.stream()
                .filter(x -> x.getItem() == item)
                .mapToLong(x -> x.getQuantity().value())
                .sum()
                ;

        var discountTimes = (count / amountX);
        var discount = item.getPrice().cost(amountX) - price.getPrice();

        return discount * discountTimes;
    }

    @Override
    public String toString() {
        return item + " " + amountX + " for " + Price.priceToString(price.getPrice());
    }
}
