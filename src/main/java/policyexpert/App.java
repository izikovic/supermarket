package policyexpert;

public class App {
    public static void main(String[] args) {
        Item coke = new Item("coke", new Price(70, QuantityType.UNIT));
        Item beans = new Item("beans", new Price(50, QuantityType.UNIT));
        Item oragnes = new Item("oranges", new Price(199, QuantityType.WEIGHT));
    }
}
