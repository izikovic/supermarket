package policyexpert;

import policyexpert.basket.Basket;
import policyexpert.discount.Discount;
import policyexpert.discount.DiscountXforPrice;
import policyexpert.discount.DiscountXforY;
import policyexpert.item.Item;
import policyexpert.price.PricePerUnit;
import policyexpert.price.PricePerWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop {
    private List<Item> items;
    private List<Discount> discounts;

    public Shop() {
        var coke = new Item("coke", new PricePerUnit(70));
        var beans = new Item("beans", new PricePerUnit(50));
        var oranges = new Item("oranges", new PricePerWeight(199));

        var beans3for2 = new DiscountXforY(beans, 3, 2);
        var coke2forAPound = new DiscountXforPrice(coke, 2, new PricePerUnit(100));

        items = new ArrayList<>() {{
            add(coke);
            add(beans);
            add(oranges);
        }};
        discounts = new ArrayList<>() {{
            add(beans3for2);
            add(coke2forAPound);
        }};
    }

    public Optional<Item> getItemByName(String name) {
        return items.stream().filter(x -> x.getName().equals(name)).findFirst();
    }

    public Basket newBasket() {
        var basket = new Basket();
        discounts.forEach(d -> basket.addDiscount(d));
        return basket;
    }
}
