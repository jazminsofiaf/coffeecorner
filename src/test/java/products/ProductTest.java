package products;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    private static final double DELTA = 0.001;

    @Test
    public void whenShopperPurchaseOneProduct_thenTheTicketIsThePrice(){
        //Given
        Product largeCoffee = new LargeCoffee();
        Product smallCoffee = new SmallCoffee();

        //Then
        Assert.assertEquals(3.50, largeCoffee.getPrice() ,DELTA);
        Assert.assertEquals(2.50, smallCoffee.getPrice() ,DELTA);

    }

}
