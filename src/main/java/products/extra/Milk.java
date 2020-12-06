package products.extra;

import products.Product;

public class Milk extends Product {
    private static final double PRICE = 0.3;
    private static final String DOTS = "............  $";

    protected Milk() {
        super(PRICE);
    }

    @Override
    public String toString() {
        return  "w extra " +ExtraName.MILK.name.toLowerCase() + DOTS + this.getPrice();
    }
}
