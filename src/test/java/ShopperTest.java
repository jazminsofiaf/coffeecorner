import org.junit.Assert;
import org.junit.Test;
import products.Product;
import products.ProductFactory;
import products.extra.ExtraName;
import products.ProductName;

public class ShopperTest {

    private static final double DELTA = 0.001;

    @Test
    public void whenShopperPurchaseOneProduct_thenTheTicketIsThePrice(){
        //Given
        Shopper shopper = new Shopper();
        Product product = ProductFactory.create(ProductName.LARGE_COFFEE);

        //When
        shopper.buy(product);
        double price = shopper.getTotalPriceCHF();

        //Then
        Assert.assertEquals(3.50, price ,DELTA);
    }

    @Test
    public void whenShopperPurchaseMoreThanOneProduct_thenTheTicketPriceIsTheSum(){
        //Given
        Shopper shopper = new Shopper();
        Product firstProduct = ProductFactory.create(ProductName.LARGE_COFFEE);
        Product secondProduct = ProductFactory.create(ProductName.BACON_ROLL);

        //When
        shopper.buy(firstProduct);
        shopper.buy(secondProduct);
        double price = shopper.getTotalPriceCHF();

        //Then
        Assert.assertEquals(8.00, price  ,DELTA);
    }

    @Test
    public void whenShopperPurchaseOneProductWithExtra_thenTheTicketPriceIsTheSum(){
        //Given
        Shopper shopper = new Shopper();
        Product firstProduct = ProductFactory.create(ProductName.LARGE_COFFEE).with(ExtraName.MILK);

        //When
        shopper.buy(firstProduct);
        double price = shopper.getTotalPriceCHF();

        //Then
        Assert.assertEquals(3.8, price, DELTA);
    }

    //She decides to offer a customer stamp card, where every 5th beverage is for free.
    //If a customer orders a beverage and a snack, one of the products.extra's is free.
}
