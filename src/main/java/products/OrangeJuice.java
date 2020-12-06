package products;

public class OrangeJuice extends Beverage {
    private static final double PRICE = 3.95;
    private static final String DOTS = "............  $";

    public OrangeJuice() {
        super(PRICE);
    }

    @Override
    public boolean isABeverage() {
        return true;
    }

    @Override
    public String toString() {
        return ProductName.ORANGE_JUICE.name().toLowerCase() + DOTS + this.getPrice();
    }
}
