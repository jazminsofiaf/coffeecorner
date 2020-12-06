import offerts.ExtraFreeOffer;
import offerts.FifthFreeOffer;
import offerts.Offer;
import products.Beverage;
import products.Product;
import products.ProductFactory;
import products.ProductName;
import products.extra.ExtraFactory;
import products.extra.ExtraName;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Shop {
    private HashSet<Offer> offers;
    private static final int PRINCIPAL_PRODUCT_INDEX = 0;
    private static final int EXTRA_INDEX = 1;

    public Shop() {
        this.offers = new HashSet<>();
        this.offers.add(new FifthFreeOffer());
        this.offers.add(new ExtraFreeOffer());
    }

    public void getOrder(String order){
        Customer customer = new Customer(this.offers);
        String[] productsArray = order.split(",");
        for(int i = 0; i < productsArray.length; i++ ){
            String[] products  = productsArray[i].split("with");
            Optional<ProductName> principalProductName = ProductName.getFromOrder(products[PRINCIPAL_PRODUCT_INDEX]);
            Product product = ProductFactory.create(principalProductName.orElseThrow(() -> new InvalidParameterException("principal product required ")));
            for(int j = EXTRA_INDEX; j < products.length ; j++ ){
                Optional<ExtraName> extraName = ExtraName.getFromOrder(products[j]);
                if(extraName.isPresent()){
                    product = ((Beverage)product).with(extraName.get());
                }
            }
            customer.buy(product);
        }
        customer.printTicket();
    }
}
