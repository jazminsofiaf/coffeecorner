package products.extra;

import products.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ExtraFactory {
    private static final Map<ExtraName,Function<Void,Product>> extras;
    static {
        Map<ExtraName, Function<Void,Product>> map = new HashMap<>();
        map.put(ExtraName.MILK, ExtraFactory::createMilk );
        map.put(ExtraName.FOAMED_MILK, ExtraFactory::createFoamedMilk);
        map.put(ExtraName.SPECIAL_ROAST,  ExtraFactory::specialRoast);
        extras = Collections.unmodifiableMap(map);
    }

    private static Product specialRoast(Void noParams) {
        return new SpecialRoast();
    }

    private static Product createFoamedMilk(Void noParams) {
        return new FoamedMilk();
    }

    private static Product createMilk(Void noParams) {
        return new Milk();
    }

    public static Product create(ExtraName extraProductName) {
        return extras.get(extraProductName).apply(null);
    }


}
