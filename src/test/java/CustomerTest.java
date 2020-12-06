import offerts.ExtraFreeOffer;
import offerts.FifthFreeOffer;
import offerts.Offer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.Beverage;
import products.Product;
import products.ProductFactory;
import products.extra.ExtraName;
import products.ProductName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CustomerTest {

    private static final double DELTA = 0.001;
    private HashSet<Offer> offers;

    @Before
    public void setUp(){
        this.offers = new HashSet<>();
        this.offers.add(new FifthFreeOffer());
        this.offers.add(new ExtraFreeOffer());

    }

    @Test
    public void whenCustomerPurchaseOneProduct_thenTheTicketIsThePrice(){
        //Given
        Customer customer = new Customer(this.offers);
        Product product = ProductFactory.create(ProductName.LARGE_COFFEE);

        //When
        customer.buy(product);
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(3.50, price ,DELTA);
    }

    @Test
    public void whenCustomerPurchaseMoreThanOneProduct_thenTheTicketPriceIsTheSum(){
        //Given
        Customer customer = new Customer(this.offers);
        Product firstProduct = ProductFactory.create(ProductName.LARGE_COFFEE);
        Product secondProduct = ProductFactory.create(ProductName.BACON_ROLL);

        //When
        customer.buy(firstProduct);
        customer.buy(secondProduct);
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(8.00, price  ,DELTA);
    }

    @Test
    public void whenCustomerPurchaseOneProductWithExtra_thenTheTicketPriceIsTheSum(){
        //Given
        Customer customer = new Customer(this.offers);
        Product firstProduct = ((Beverage)ProductFactory.create(ProductName.LARGE_COFFEE)).with(ExtraName.MILK);

        //When
        customer.buy(firstProduct);
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(3.8, price, DELTA);
    }


    /**
     * She decides to offer a customer stamp card, where every 5th beverage is for free.
     */
    @Test
    public void whenCustomerBuyManyBeverage_then5IsFree(){
        //Given
        Customer customer = new Customer(this.offers);
        Product firstProduct = ProductFactory.create(ProductName.SMALL_COFFEE);
        Product secondProduct = ProductFactory.create(ProductName.SMALL_COFFEE);
        Product thirdProduct = ProductFactory.create(ProductName.SMALL_COFFEE);
        Product forthProduct = ProductFactory.create(ProductName.SMALL_COFFEE);
        Product fifthProduct = ProductFactory.create(ProductName.LARGE_COFFEE);
        Product sixthProduct = ProductFactory.create(ProductName.SMALL_COFFEE);

        //When
        List<Product> productsToBuy = Arrays.asList(firstProduct, secondProduct,
                thirdProduct, forthProduct, fifthProduct, sixthProduct);
        customer.buy(productsToBuy);
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(2.5*5, price, DELTA);
    }

    @Test
    public void whenCustomerBuyManyBeverage_then5IsFreeWithExtra(){
        //Given

        Customer customer = new Customer(this.offers);
        List<Product> productsToBuy = new ArrayList<>();
        productsToBuy.add(ProductFactory.create(ProductName.SMALL_COFFEE));
        productsToBuy.add(ProductFactory.create(ProductName.SMALL_COFFEE));
        productsToBuy.add(ProductFactory.create(ProductName.SMALL_COFFEE));
        productsToBuy.add(ProductFactory.create(ProductName.SMALL_COFFEE));
        productsToBuy.add(((Beverage)ProductFactory.create(ProductName.LARGE_COFFEE)).with(ExtraName.MILK));
        productsToBuy.add(ProductFactory.create(ProductName.SMALL_COFFEE));

        //When
        customer.buy(productsToBuy);
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(2.5*5 + 0.3, price, DELTA);
    }


    /***
     * If a customer orders a beverage and a snack, one of the products.extra's is free.
     */
    @Test
    public void whenCustomerBuyABeverageAndSnake_thenExtraIsFree(){
        //Given
        Customer customer = new Customer(this.offers);
        List<Product> productsToBuy = new ArrayList<>();
        productsToBuy.add(((Beverage)ProductFactory.create(ProductName.SMALL_COFFEE)).with(ExtraName.SPECIAL_ROAST));
        productsToBuy.add(ProductFactory.create(ProductName.BACON_ROLL));

        //When
        customer.buy(productsToBuy);
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(7.00, price, DELTA);
    }

    /***
     * If a customer orders more than five beverage and a snack,
     * one of the products.extra's is free and the fifth beverage is also free.
     */
    @Test
    public void whenCustomerPurchaseAllProducts_thenTicketIsWellFormatted(){
        //Given
        Customer customer = new Customer(this.offers);
        Product smallCoffee = ((Beverage)ProductFactory.create(ProductName.SMALL_COFFEE)).with(ExtraName.MILK).with(ExtraName.SPECIAL_ROAST);
        Product mediumCoffee = ((Beverage)ProductFactory.create(ProductName.MEDIUM_COFFEE)).with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Product largeCoffee = ((Beverage)ProductFactory.create(ProductName.LARGE_COFFEE)).with(ExtraName.FOAMED_MILK);
        Product orangeJuice = ProductFactory.create(ProductName.ORANGE_JUICE);
        Product baconRoll = ProductFactory.create(ProductName.BACON_ROLL);

        //When
        customer.buy(Arrays.asList(smallCoffee, mediumCoffee, largeCoffee, orangeJuice, orangeJuice, baconRoll));
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(20.55, price, DELTA);
    }

    /***
     * If a customer orders two beverage and two snack,
     * the first extra of each beverage is free.
     */
    @Test
    public void whenCustomerPurchaseTwoCombos_OneExtraOfEachBeverageIsFree(){
        //Given
        Customer customer = new Customer(this.offers);
        Product smallCoffee = ((Beverage)ProductFactory.create(ProductName.SMALL_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Product mediumCoffee = ((Beverage)ProductFactory.create(ProductName.MEDIUM_COFFEE))
                .with(ExtraName.SPECIAL_ROAST).with(ExtraName.MILK).with(ExtraName.FOAMED_MILK);
        Product baconRoll = ProductFactory.create(ProductName.BACON_ROLL);

        //When
        customer.buy(Arrays.asList(smallCoffee, mediumCoffee, baconRoll, baconRoll));
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(16.7, price, DELTA);
    }

    /***
     * Two Combos with the same price are grouped
     */
    @Test
    public void whenCustomerPurchaseTwoCombos_ThenTheyAppearGrouped(){
        //Given
        Customer customer = new Customer(this.offers);
        Product smallCoffee = ((Beverage)ProductFactory.create(ProductName.SMALL_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Product mediumCoffee = ((Beverage)ProductFactory.create(ProductName.MEDIUM_COFFEE))
                .with(ExtraName.MILK).with(ExtraName.FOAMED_MILK).with(ExtraName.SPECIAL_ROAST);
        Product baconRoll = ProductFactory.create(ProductName.BACON_ROLL);

        //When
        customer.buy(Arrays.asList(smallCoffee, mediumCoffee, baconRoll, baconRoll));
        double price = customer.printTicket();

        //Then
        Assert.assertEquals(17.30, price, DELTA);
    }
}
