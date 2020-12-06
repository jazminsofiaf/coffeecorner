package products;

public class SmallCoffee extends Beverage {
    private static final double PRICE = 2.50;

    public SmallCoffee() {
        super(PRICE);
    }


    @Override
    public String toString() {
        return ProductName.SMALL_COFFEE.name().toLowerCase() + "............  $" + this.getPrice();
    }
}
