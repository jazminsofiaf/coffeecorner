package offerts;

import java.util.Objects;

public class OfferDiscount {
    private final String description;
    private final double discount;

    public OfferDiscount(String description, double discount) {
        this.description = description;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return this.description + discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferDiscount that = (OfferDiscount) o;
        return Double.compare(that.discount, discount) == 0 &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, discount);
    }
}
