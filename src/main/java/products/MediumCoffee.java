package products;

public class MediumCoffee extends Beverage {
    private static final double PRICE = 3.00;
    private static final String DOTS = "...........  $";

    public MediumCoffee() {
        super(PRICE);
    }

    @Override
    public String toString() {
        return ProductName.MEDIUM_COFFEE.name().toLowerCase() + DOTS + this.getPrice();
    }
}
