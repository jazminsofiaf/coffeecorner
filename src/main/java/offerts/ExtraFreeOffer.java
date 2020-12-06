package offerts;

import products.Beverage;
import products.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

public class ExtraFreeOffer extends Offer{

    @Override
    public List<OfferDiscount> apply(List<Beverage> beverages, List<Product> snacks) {
        List<Combo> combos = new ArrayList<>();
        Iterator<Beverage> beverageIterator = beverages.iterator();
        snacks.forEach(snack -> {
            if(beverageIterator.hasNext()){
                combos.add(beverageIterator.next().createCombo(snack));
            }
        });

        return combos.stream()
                .map(combo -> combo.getDiscount())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
