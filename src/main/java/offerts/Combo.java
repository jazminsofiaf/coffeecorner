package offerts;

import products.Beverage;
import products.Product;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Optional;

public class Combo {
    private static final String DESCRIPTION = "Combo discount.......... -$";
    private final Beverage beverage;
    private final Product snack;

    public Combo(Beverage beverage, Product snack) {
        if(snack.isABeverage()){
            throw new InvalidParameterException("A combo require a snack and a beverage");
        }
        this.beverage = beverage;
        this.snack = snack;
    }

    public Optional<OfferDiscount> getDiscount() {
        return this.beverage.getExtras().stream().findFirst()
                .map(firstExtra -> new OfferDiscount(DESCRIPTION, firstExtra.getPrice()));

    }

}
