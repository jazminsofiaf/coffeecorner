package products;

import offerts.Combo;
import products.extra.ExtraFactory;
import products.extra.ExtraName;

import java.util.ArrayList;
import java.util.List;

public abstract class Beverage extends Product{
    private final List<Product> extras;

    protected Beverage(double price) {
        super(price);
        this.extras = new ArrayList<>();
    }

    @Override
    public boolean isABeverage() {
        return true;
    }

    public Beverage with(ExtraName extraName){
        this.extras.add(ExtraFactory.create(extraName));
        return this;
    }

    public List<Product> getExtras(){
        return this.extras;
    }

    public Combo createCombo(Product snack){
        return new Combo(this, snack);
    }
}
