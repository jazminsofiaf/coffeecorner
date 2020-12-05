package products.extra;

public enum ExtraName {
    MILK("SMALL COFFEE"),
    FOAMED_MILK("MEDIUM COFFEE"),
    SPECIAL_ROAST("LARGE COFFEE");

    public final String name;

    private ExtraName(String name) {
        this.name = name;
    }

    public static ExtraName getFromOrder(String order) {
        for (ExtraName element : values()) {
            if (element.name.equals(order.toUpperCase())) {
                return element;
            }
        }
        return null;
    }
}
