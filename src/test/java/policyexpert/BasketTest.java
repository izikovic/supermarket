package policyexpert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    private Item coke = new Item("coke", new PricePerUnit(70));
    private Item beans = new Item("beans", new PricePerUnit(50));
    private Item oranges = new Item("oranges", new PricePerWeight(199));

    @Test
    public void testBasketCost() {
        var b = new Basket();

        b.addItem(coke, new Quantity(1, QuantityType.UNIT));
        b.addItem(coke, new Quantity(1, QuantityType.UNIT));
        b.addItem(beans, new Quantity(1, QuantityType.UNIT));
        b.addItem(beans, new Quantity(1, QuantityType.UNIT));
        b.addItem(beans, new Quantity(1, QuantityType.UNIT));
        b.addItem(oranges, new Quantity(200, QuantityType.G));

        assertEquals(330, b.totalCost());
    }
}
