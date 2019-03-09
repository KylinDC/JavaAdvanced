package main.java.kylindc.model.product;

public class Product {
    private String id;
    private String name;
    private Double price;

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
