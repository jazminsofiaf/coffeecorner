package products;

public enum ProductName {
    SMALL_COFFEE("SMALL COFFEE"),
    MEDIUM_COFFEE("MEDIUM COFFEE"),
    LARGE_COFFEE("LARGE COFFEE"),
    BACON_ROLL("BACON ROLL"),
    ORANGE_JUICE("ORANGE JUICE");

    public final String name;

    private ProductName(String name) {
        this.name = name;
    }

    public static ProductName getFromOrder(String order) {
        for (ProductName element : values()) {
            if (element.name.equals(order.toUpperCase())) {
                return element;
            }
        }
        return null;
    }

}
