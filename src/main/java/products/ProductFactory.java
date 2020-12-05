package products;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ProductFactory {
    private static final Map<ProductName,Function<Void,Product>> products;
    static {
        Map<ProductName, Function<Void,Product>> map = new HashMap<>();
        map.put(ProductName.SMALL_COFFEE, ProductFactory::createSmallCoffee);
        map.put(ProductName.MEDIUM_COFFEE, ProductFactory::createMediumCoffee);
        map.put(ProductName.LARGE_COFFEE, ProductFactory::createLargeCoffee);
        map.put(ProductName.ORANGE_JUICE, ProductFactory::createOrangeCoffee);
        map.put(ProductName.BACON_ROLL, ProductFactory::createBaconCoffee);
        products = Collections.unmodifiableMap(map);
    }

    private static Product createBaconCoffee(Void noParams) {
        return new BaconRoll();
    }

    private static Product createOrangeCoffee(Void noParams) {
        return new OrangeJuice();
    }

    private static Product createLargeCoffee(Void noParams) {
        return new LargeCoffee();
    }

    private static Product createMediumCoffee(Void noParams) {
        return new MediumCoffee();
    }

    private static Product createSmallCoffee(Void noParams) {
        return new SmallCoffee();
    }


    public static Product create(ProductName name) {
        return products.get(name).apply(null);
    }
}
