package policyexpert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PricePerWeightTest {
    @Test
    public void testFullWeightPrice() {
        Price perKilo = new PricePerWeight(199);

        assertEquals(199, perKilo.cost(1000));
    }

    @Test
    public void testPartWeightPrice() {
        Price perKilo = new PricePerWeight(199);

        assertEquals(40, perKilo.cost(200));
    }
}
