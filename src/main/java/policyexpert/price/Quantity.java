package policyexpert.price;

public class Quantity {
    private final long quantity;
    private final QuantityType type;

    private Quantity(long quantity, QuantityType type) {
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

    public static Quantity unit(long quantity) {
        return new Quantity(quantity, QuantityType.UNIT);
    }

    public static Quantity g(long quantity) {
        return new Quantity(quantity, QuantityType.G);
    }

    public static Quantity kg(long quantity) {
        return new Quantity(quantity, QuantityType.KG);
    }
}
