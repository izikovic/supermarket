package policyexpert;

import org.junit.Assert;
import org.junit.Test;
import policyexpert.basket.BasketItem;
import policyexpert.discount.Discount;
import policyexpert.discount.DiscountXforPrice;
import policyexpert.discount.DiscountXforY;
import policyexpert.item.Item;
import policyexpert.price.PricePerUnit;
import policyexpert.price.PricePerWeight;
import policyexpert.price.Quantity;

import java.util.HashSet;
import java.util.Set;

public class DiscountTest {
    private Item coke = new Item("coke", new PricePerUnit(70));
    private Item beans = new Item("beans", new PricePerUnit(50));
    private Item oranges = new Item("oranges", new PricePerWeight(199));

    private Discount coke3for2 = new DiscountXforY(coke, 3, 2);
    private Discount coke2forAPound = new DiscountXforPrice(coke, 2, new PricePerUnit(100));

    @Test
    public void testDiscountXforY() {
        Set<BasketItem> b = new HashSet<>();
        b.add(new BasketItem(coke, Quantity.unit(3)));

        long discount = coke3for2.discount(b);

        Assert.assertEquals(70, discount);
    }

    @Test
    public void testDiscountXforYDouble() {
        Set<BasketItem> b = new HashSet<>();
        b.add(new BasketItem(coke, Quantity.unit(3)));
        b.add(new BasketItem(coke, Quantity.unit(1)));
        b.add(new BasketItem(coke, Quantity.unit(2)));

        long discount = coke3for2.discount(b);

        Assert.assertEquals(140, discount);
    }

    @Test
    public void testDiscountXforYWithExtra() {
        Set<BasketItem> b = new HashSet<>();
        b.add(new BasketItem(coke, Quantity.unit(3)));
        b.add(new BasketItem(coke, Quantity.unit(1)));


        long discount = coke3for2.discount(b);

        Assert.assertEquals(70, discount);
    }

    @Test
    public void testDiscountXforAPrice() {
        Set<BasketItem> b = new HashSet<>();
        b.add(new BasketItem(coke, Quantity.unit(2)));

        long discount = coke2forAPound.discount(b);

        Assert.assertEquals(40, discount);
    }

    @Test
    public void testDiscountXforAPriceDouble() {
        Set<BasketItem> b = new HashSet<>();
        b.add(new BasketItem(coke, Quantity.unit(2)));
        b.add(new BasketItem(coke, Quantity.unit(1)));
        b.add(new BasketItem(coke, Quantity.unit(1)));

        long discount = coke2forAPound.discount(b);

        Assert.assertEquals(80, discount);
    }

    @Test
    public void testDiscountXforAPriceExtra() {
        Set<BasketItem> b = new HashSet<>();
        b.add(new BasketItem(coke, Quantity.unit(2)));
        b.add(new BasketItem(coke, Quantity.unit(1)));
        b.add(new BasketItem(coke, Quantity.unit(2)));

        long discount = coke2forAPound.discount(b);

        Assert.assertEquals(80, discount);
    }
}
