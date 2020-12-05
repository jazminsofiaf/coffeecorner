import products.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static final Map<ProductName, Product> productClass;
    static {
        Map<ProductName, Product> map = new HashMap<>();
        map.put(ProductName.SMALL_COFFEE,new SmallCoffee());
        map.put(ProductName.MEDIUM_COFFEE,new MediumCoffee());
        map.put(ProductName.LARGE_COFFEE,new LargeCoffee());
        map.put(ProductName.BACON_ROLL,new BaconRoll());
        map.put(ProductName.ORANGE_JUICE,new OrangeJuice());
        productClass = Collections.unmodifiableMap(map);
    }
    public static Product create(ProductName productName) {
        return productClass.get(productName);
    }

}
