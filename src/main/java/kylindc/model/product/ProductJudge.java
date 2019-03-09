package main.java.kylindc.model.product;

import java.util.Optional;

public class ProductJudge {
    public static Boolean isSuitablePhone(Product commodity) {
        Optional<Product> optional = Optional.ofNullable(commodity);
        return optional.filter(
                        e ->
                                e.getName().equals("phone")
                                        && e.getPrice() >= 1000.0
                                        && e.getPrice() <= 2000.0)
                .isPresent();
    }
}
