import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Shopper {

    private List<Product> purchases;

    public Shopper() {
        this.purchases = new ArrayList<Product>();
    }

    public void buy(Product product) {
        this.purchases.add(product);

    }

    public double getTotalPriceCHF() {
        return this.purchases.stream()
                .map(product -> product.getPrice())
                .reduce(0.0, (firstPrice, secondPrice) -> firstPrice + secondPrice);
    }
}
