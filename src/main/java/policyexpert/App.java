package policyexpert;

import policyexpert.basket.Basket;
import policyexpert.price.Quantity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {

    private static Shop shop = new Shop();

    private static void readBasketFromFile(Basket basket, List<String> filelines) throws IOException {

        filelines
                    .forEach(line -> {
                        var parts = line.split("#");
                        if (parts.length != 2) {
                            throw new IllegalArgumentException("A line in the file must contain the item name " +
                                    "and item quantity separated by a hash symbol '#'");
                        }

                        var itemName = parts[0];

                        var item = shop.getItemByName(itemName)
                                .orElseThrow(() -> new IllegalArgumentException("Unknown item " + itemName));

                        var quantityPart = parts[1];

                        var quantityParts = quantityPart.split(" ");

                        if (quantityParts.length == 1) {
                            basket.addItem(item, Quantity.unit(Long.valueOf(quantityParts[0])));
                        } else {
                            var type = quantityParts[1];

                            if (type.toLowerCase().equals("kg")) {
                                var quantityLong = (long) (Double.parseDouble(quantityParts[0]) * 1000);
                                basket.addItem(item, Quantity.g(quantityLong));
                            } else if (type.toLowerCase().equals("g")) {
                                basket.addItem(item, Quantity.g(Long.valueOf(quantityParts[0])));
                            }
                        }

                    });

    }

    public static void main(String[] args) throws IOException {
        var b = shop.newBasket();
        App.readBasketFromFile(b, Files.readAllLines(Paths.get(args[0])));
        b.printReceipt();
    }
}
