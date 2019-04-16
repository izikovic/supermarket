package policyexpert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PricePerUnitTest {

    @Test
    public void testSingleItemCost() {
        Price p = new PricePerUnit(70);

        assertEquals(70, p.cost(1L));
    }

    @Test
    public void testMultipleItemCost() {
        Price p = new PricePerUnit(70);

        assertEquals(140, p.cost(2L));
    }
}
