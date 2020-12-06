package offers;

import offerts.ExtraFreeOffer;

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

public class ExtraFreeOfferTest {

    private Offer offer;

    @Before
    public void setUp(){
        this.offer = new ExtraFreeOffer();
    }

    @Test
    public void test(){
        //Given
        Beverage smallCoffee = ((Beverage) ProductFactory.create(ProductName.SMALL_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Beverage mediumCoffee = ((Beverage)ProductFactory.create(ProductName.MEDIUM_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Product baconRoll = ProductFactory.create(ProductName.BACON_ROLL);

        //When
        List<Beverage> beverages = new ArrayList<>();
        beverages.add(smallCoffee);
        beverages.add(mediumCoffee);

        List<Product> snacks  = new ArrayList<>();
        snacks.add(baconRoll);
        List<OfferDiscount> discounts = this.offer.apply(beverages, snacks);

        //then
        List<OfferDiscount> expectedOffers = new ArrayList<>();
        expectedOffers.add(new OfferDiscount("Combo discount.......... -$", 0.3));
        Assert.assertEquals(discounts,expectedOffers);

    }
}
