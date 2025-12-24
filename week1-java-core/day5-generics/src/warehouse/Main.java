package warehouse;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Inventory<Product> warehouse = new Inventory<>();
        warehouse.add(new Product(3, "MacBook", 2000.0));
        warehouse.add(new Product(1, "AirPods", 150.0));
        warehouse.add(new Product(2, "Keyboard", 300.0));
        warehouse.add(new Product(50, "HDMI Cable", 10.0));
        warehouse.add(new Product(45, "Type-c Cable", 10.0));

        System.out.println("\nSorting");

        List<Product> products = warehouse.getAll();

        System.out.println("\n1. Natural Order (by ID)");
        Collections.sort(products);
        warehouse.printAll();

        System.out.println("\n2. Custom Order (by Price ascending)");
        Collections.sort(products, new PriceComparator());
        warehouse.printAll();

        System.out.println("\n2. Custom Order (by Price descending)");
        Collections.sort(products, new PriceComparator(){
            @Override
            public int compare(Product product1,Product product2){
                return Double.compare(product2.getPrice(),product1.getPrice());
            }
        });
        warehouse.printAll();

        System.out.println("\n3. Custom Order (by Name) ");

        Collections.sort(products, new PriceComparator() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        warehouse.printAll();
    }
}