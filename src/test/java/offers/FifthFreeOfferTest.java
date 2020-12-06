package offers;

import offerts.ExtraFreeOffer;
import offerts.FifthFreeOffer;
import offerts.Offer;
import offerts.OfferDiscount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.Beverage;
import products.Product;
import products.ProductFactory;
import products.ProductName;
import products.extra.ExtraName;

import java.util.ArrayList;
import java.util.List;

public class FifthFreeOfferTest {

    private Offer offer;

    @Before
    public void setUp(){
        this.offer = new FifthFreeOffer();
    }

    @Test
    public void test(){
        //Given
        Beverage smallCoffee = ((Beverage) ProductFactory.create(ProductName.SMALL_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Beverage mediumCoffee = ((Beverage)ProductFactory.create(ProductName.MEDIUM_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);

        //When
        List<Beverage> beverages = new ArrayList<>();
        beverages.add(smallCoffee);
        beverages.add(smallCoffee);
        beverages.add(smallCoffee);
        beverages.add(smallCoffee);
        beverages.add(mediumCoffee);

        List<Product> snacks  = new ArrayList<>();

        List<OfferDiscount> discounts = this.offer.apply(beverages, snacks);

        //then
        List<OfferDiscount> expectedOffers = new ArrayList<>();
        expectedOffers.add(new OfferDiscount("Fifth beverage discount. -$", 3.0));
        Assert.assertEquals(discounts,expectedOffers);

    }
}
