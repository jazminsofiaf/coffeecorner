import org.junit.Test;

public class ShopTest {

    @Test
    public void testInput(){
        String arg = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";
        Shop shop = new Shop();
        shop.getOrder(arg);
    }

}
