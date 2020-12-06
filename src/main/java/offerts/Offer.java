package offerts;

import products.Beverage;
import products.Product;

import java.util.List;


public abstract class Offer {
    public abstract List<OfferDiscount> apply(List<Beverage> beverage, List<Product> snacks);

}
