package products;

public class BaconRoll extends Product {
    private static final double PRICE = 4.50;
    private static final String DOTS = "..............  $";

    public BaconRoll() {
        super(PRICE);
    }


    @Override
    public String toString() {
        return ProductName.BACON_ROLL.name().toLowerCase() + DOTS + this.getPrice();
    }


}
