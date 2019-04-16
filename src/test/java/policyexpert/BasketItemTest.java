package policyexpert;

import org.junit.Test;
import policyexpert.basket.BasketItem;
import policyexpert.item.Item;
import policyexpert.price.PricePerUnit;
import policyexpert.price.PricePerWeight;
import policyexpert.price.Quantity;

import static org.junit.Assert.assertEquals;

public class BasketItemTest {
    private Item coke = new Item("coke", new PricePerUnit(70));
    private Item oranges = new Item("oranges", new PricePerWeight(199));

    @Test
    public void testItemUnitPrice() {
       var b = new BasketItem(coke, Quantity.unit(1));

       assertEquals(70, b.cost());
    }

    @Test
    public void testItemWeight() {
        var b = new BasketItem(oranges, Quantity.g(200));

        assertEquals(40, b.cost());
    }
}
