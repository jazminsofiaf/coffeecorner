package products;

import products.extra.ExtraFactory;
import products.extra.ExtraName;

import java.util.*;

public abstract class Product {
    private final double unitPrice;

    protected Product(double price) {
        this.unitPrice = price;
    }

    public Double getPrice() {
        return this.unitPrice;
    }

    public boolean isABeverage(){
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.unitPrice, unitPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitPrice);
    }


}
