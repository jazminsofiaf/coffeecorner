package offerts;

import products.Beverage;
import products.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FifthFreeOffer extends Offer{


    private static final int FIFTH_INDEX = 4;
    private static final String DESCRIPTION = "Fifth beverage discount. -$";

    @Override
    public List<OfferDiscount> apply(List<Beverage> beverages, List<Product> snacks) {
        if(beverages.size() > FIFTH_INDEX ){
            return Arrays.asList(new OfferDiscount(DESCRIPTION , beverages.get(FIFTH_INDEX).getPrice()));
        }
        return Collections.emptyList();
    }
}

