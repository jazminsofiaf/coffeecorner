package products;

import products.extra.ExtraFactory;
import products.extra.ExtraName;

import java.util.*;

public abstract class Product {
    private final double price;
    private Set<Product> extra;

    protected Product(double price) {
        this.price = price;
        this.extra = new HashSet<>();
    }

    public Product with(ExtraName extraName){
        Product extra = ExtraFactory.create(extraName);
        this.extra.add(extra);
        return this;
    }

    public Double getPrice() {
        return this.price + extra.stream().map(extra -> extra.getPrice()).reduce(Double::sum).orElse(0.0);
    }


}
