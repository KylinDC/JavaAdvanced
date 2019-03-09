package test.java.kylindc.model.product;

import main.java.kylindc.model.product.Product;
import main.java.kylindc.model.product.ProductJudge;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {
    public static void main(String[] args) {
        Product commodityA = new Product("A01", "phone", 1039.0);
        Product commodityB = new Product("B01", "phone", 139.0);
        Product commodityC = new Product("C01", "computer", 2039.0);
        List<Product> commodities = new ArrayList<>();
        commodities.add(commodityA);
        commodities.add(commodityB);
        commodities.add(commodityC);
        commodities.stream().forEach(e -> System.out.println(ProductJudge.isSuitablePhone(e)));
    }
}
