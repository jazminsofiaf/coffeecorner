
import offerts.Offer;
import offerts.OfferDiscount;
import products.Beverage;
import products.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Customer {

    private static final double ZERO = 0.0;
    private List<Beverage> beverages;
    private List<Product> snacks;
    private final Set<Offer> offers;

    public Customer(Set<Offer> offers) {
        this.offers = offers;
        this.beverages= new ArrayList<>();
        this.snacks = new ArrayList<>();
    }

    public void buy(Product product) {
        if(product.isABeverage()){
            Beverage beverage = (Beverage)product;
            this.beverages.add(beverage);
            return;
        }
        this.snacks.add(product);

    }

    public void buy(List<Product> products) {
        products.forEach(product -> this.buy(product));

    }

    private List<OfferDiscount> getDiscounts(){
        List<OfferDiscount> offersDiscounts = new ArrayList<>();
        this.offers.forEach(offer -> {
            offersDiscounts.addAll(offer.apply(this.beverages, this.snacks));
        });
        return offersDiscounts;
    }

    private double getTotalPriceCHF(List<Product> purchases, List<OfferDiscount> offersDiscounts) {
        double totalPrice = purchases.stream().map(product -> product.getPrice()).reduce(ZERO, (firstPrice, secondPrice) -> firstPrice + secondPrice);
        double discounts = offersDiscounts.stream().map(offer -> offer.getDiscount()).reduce(ZERO, (firstPrice, secondPrice) -> firstPrice + secondPrice);
        return totalPrice - discounts;
    }

    public double printTicket(){
        List<OfferDiscount> offerDiscounts = this.getDiscounts();
        List<Product> purchases = Stream.of(beverages,snacks).flatMap(list-> list.stream()).collect(Collectors.toList());
        beverages.forEach(beverage -> purchases.addAll(beverage.getExtras()));
        double total = Math.round(this.getTotalPriceCHF(purchases, offerDiscounts) * 100.0) /100.0;
        this.getMap(purchases, offerDiscounts).forEach((obj, num)-> System.out.println(num +" X "+obj.toString()));
        System.out.println("---------------------------------------");
        System.out.println("Total.......................  $"+ total);
        System.out.println("");
        return total;
    }

    private Map<Object, Integer> getMap(List<Product> purchases, List<OfferDiscount> offerDiscounts){
        Map<Object, Integer> map = new LinkedHashMap<>();
        List<Object> objs = new ArrayList<>();
        objs.addAll(purchases);
        objs.addAll(offerDiscounts);
        objs.forEach(product -> {
            Integer num = map.getOrDefault(product, 0) + 1;
            map.put(product,num);
        });
        return map;
    }

}
