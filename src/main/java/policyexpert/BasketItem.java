package policyexpert;

public class BasketItem {
    private final Item item;
    private final long quantity;
    private final QuantityType type;

    public BasketItem(Item item, long quantity, QuantityType type) {
        this.item = item;
        this.quantity = quantity;
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public long getQuantity() {
        return quantity;
    }

    public QuantityType getType() {
        return type;
    }
}
