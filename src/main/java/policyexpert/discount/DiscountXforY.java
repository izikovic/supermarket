package policyexpert.discount;

import policyexpert.basket.BasketItem;
import policyexpert.item.Item;

import java.util.Set;

public class DiscountXforY implements Discount {

    private final Item item;
    private final long amountX;
    private final long amountY;

    public DiscountXforY(Item item, long amountX, long amountY) {
        this.item = item;
        this.amountX = amountX;
        this.amountY = amountY;
    }

    public long discount(Set<BasketItem> items) {
        long count = items.stream()
                .filter(x -> x.getItem() == item)
                .mapToLong(x -> x.getQuantity().value())
                .sum()
                ;

        long discountTimes = (count / amountX);
        long discount = item.getPrice().getPrice() * (amountX - amountY);

        return discount * discountTimes;
    }
}
