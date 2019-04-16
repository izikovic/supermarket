package policyexpert;

//per 1000
public class PricePerWeight extends Price {

    public PricePerWeight(long price) {
        super(price);
    }

    public long cost(long quantity) {
        return Math.round(((double)price / 1000) * quantity);
    }
}
