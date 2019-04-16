package policyexpert;

import org.junit.Test;
import policyexpert.basket.Basket;
import policyexpert.discount.Discount;
import policyexpert.discount.DiscountXforPrice;
import policyexpert.discount.DiscountXforY;
import policyexpert.item.Item;
import policyexpert.price.PricePerUnit;
import policyexpert.price.PricePerWeight;
import policyexpert.price.Quantity;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    private Item coke = new Item("coke", new PricePerUnit(70));
    private Item beans = new Item("beans", new PricePerUnit(50));
    private Item oranges = new Item("oranges", new PricePerWeight(199));

    private Discount beans3for2 = new DiscountXforY(beans, 3, 2);
    private Discount coke2forAPound = new DiscountXforPrice(coke, 2, new PricePerUnit(100));

    @Test
    public void testBasketCost() {
        var b = new Basket();

        b.addItem(coke, Quantity.unit(1));
        b.addItem(coke, Quantity.unit(1));
        b.addItem(beans, Quantity.unit(1));
        b.addItem(beans, Quantity.unit(1));
        b.addItem(beans, Quantity.unit(1));
        b.addItem(oranges, Quantity.g(200));

        assertEquals(330, b.subtotal());
    }

    @Test
    public void testBasketCostDiscount() {
        var b = new Basket();

        b.addDiscount(beans3for2);
        b.addDiscount(coke2forAPound);

        b.addItem(coke, Quantity.unit(1));
        b.addItem(coke, Quantity.unit(1));
        b.addItem(beans, Quantity.unit(1));
        b.addItem(beans, Quantity.unit(1));
        b.addItem(beans, Quantity.unit(1));
        b.addItem(oranges, Quantity.g(200));

        assertEquals(330, b.subtotal());
        assertEquals(90, b.discounts());
    }
}
