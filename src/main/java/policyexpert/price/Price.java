package policyexpert.price;

public abstract class Price {
    protected final long price;

    public Price(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public abstract long cost(long quantity);

    public static String priceToString(long price) {
        return "£" + (price / 100) + "." + (price % 100);
    };
}
