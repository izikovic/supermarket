package policyexpert.price;

public class PricePerUnit extends Price {

    public PricePerUnit(long price) {
        super(price);
    }

    @Override
    public long cost(long quantity) {
        return price * quantity;
    }
}
