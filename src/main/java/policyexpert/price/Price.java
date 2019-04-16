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
}
