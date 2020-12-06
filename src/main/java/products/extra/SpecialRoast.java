package products.extra;

import products.Product;

public class SpecialRoast extends Product {
    private static final double PRICE = 0.9;
    private static final String DOTS = "...  $";

    protected SpecialRoast() {
        super(PRICE);
    }

    @Override
    public String toString() {
        return  "w extra " +ExtraName.SPECIAL_ROAST.name.toLowerCase() + DOTS + this.getPrice();
    }
}
