package products.extra;

import products.Product;

public class FoamedMilk extends Product {
    private static final double PRICE = 0.5;
    private static final String DOTS = ".....  $";

    protected FoamedMilk() {
        super(PRICE);
    }

    @Override
    public String toString() {
        return  "w extra " + ExtraName.FOAMED_MILK.name.toLowerCase() + DOTS + this.getPrice();
    }
}
