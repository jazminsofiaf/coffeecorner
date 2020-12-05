package products;

public abstract class Product {
    private final double price;

    protected Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
