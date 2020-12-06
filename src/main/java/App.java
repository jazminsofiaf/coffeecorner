
public class App {
    public static void main (String [] args ) {
        if(args.length < 1) {
            System.out.println("Need order argument");
            return;
        }
        Shop shop = new Shop();
        String order = args[0];
        System.out.println("order = " + order);
        shop.getOrder(order);
    }
}
