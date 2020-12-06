package products;

import java.util.Optional;

public enum ProductName {
    SMALL_COFFEE("SMALL"),
    MEDIUM_COFFEE("MEDIUM"),
    LARGE_COFFEE("LARGE"),
    BACON_ROLL("BACON"),
    ORANGE_JUICE("JUICE");

    public final String name;

    private ProductName(String name) {
        this.name = name;
    }

    public static Optional<ProductName> getFromOrder(String order) {
        for (ProductName element : values()) {
            if (order.toUpperCase().contains(element.name)){
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

}
