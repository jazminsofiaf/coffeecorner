package products;

public class LargeCoffee extends Beverage {
    private static final double PRICE = 3.50;
    private static final String DOTS = "............  $";

    public LargeCoffee() {
        super(PRICE);
    }

    @Override
    public String toString() {
        return ProductName.LARGE_COFFEE.name().toLowerCase() + DOTS + this.getPrice();
    }
}
