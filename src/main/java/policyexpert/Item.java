package policyexpert;

public class Item {
    private final String name;
    private final Price price;

    public Item(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
