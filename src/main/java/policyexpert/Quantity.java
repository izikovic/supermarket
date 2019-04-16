package policyexpert;

public class Quantity {
    private final long quantity;
    private final QuantityType type;

    public Quantity(long quantity, QuantityType type) {
        this.quantity = quantity;
        this.type = type;
    }

    public long value() {
        switch (type) {
            case UNIT:
            case G: return quantity;
            case KG: return quantity * 1000;
            default: throw new IllegalArgumentException("Unknown type");
        }
    }
}
