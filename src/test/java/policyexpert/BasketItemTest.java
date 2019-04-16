package policyexpert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketItemTest {
    private Item coke = new Item("coke", new PricePerUnit(70));
    private Item beans = new Item("beans", new PricePerUnit(50));
    private Item oranges = new Item("oranges", new PricePerWeight(199));

    @Test
    public void testItemUnitPrice() {
       var b = new BasketItem(coke, new Quantity(1, QuantityType.UNIT));

       assertEquals(70, b.cost());
    }

    @Test
    public void testItemWeight() {
        var b = new BasketItem(oranges, new Quantity(200, QuantityType.G));

        assertEquals(40, b.cost());
    }
}
