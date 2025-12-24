package warehouse;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2){
        if (Double.compare(product1.getPrice(),product2.getPrice())==0){
            return product1.getId()-product2.getId();
        }
        return Double.compare(product1.getPrice(),product2.getPrice());
    }

}
