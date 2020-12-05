import org.junit.Assert;
import org.junit.Test;

public class CoffeeShopTest {

    private static final double DELTA = 0.001;

    @Test
    public void whenShopperPurchaseOneProduct_thenTheTicketIsThePrice(){
        //Given
        CoffeeShop coffeeShop = new CoffeeShop();
        Product product = ProductFactory.create("large coffee");

        //When
        coffeeShop.buy(product);
        double price = coffeeShop.getTotalPriceCHF();

        //Then
        Assert.assertEquals(price,3.50 ,DELTA);
    }

}
