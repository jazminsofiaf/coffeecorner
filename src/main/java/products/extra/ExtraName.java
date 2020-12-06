package products.extra;

import java.util.Optional;

public enum ExtraName {
    MILK("MILK"),
    FOAMED_MILK("FOAMED"),
    SPECIAL_ROAST("SPECIAL_ROAST");

    public final String name;

    private ExtraName(String name) {
        this.name = name;
    }

    public static Optional<ExtraName> getFromOrder(String order) {
        for (ExtraName element : values()) {
            if (order.toUpperCase().contains(element.name)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }
}
