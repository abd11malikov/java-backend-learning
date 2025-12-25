package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1,"Laptop",1200,"DELIVERED"));
        orders.add(new Order(2, "Mouse", 25.0, "DELIVERED"));
        orders.add(new Order(3, "TV", 1000.0, "PENDING"));
        orders.add(new Order(4, "HDMI Cable", 10.0, "SHIPPED"));
        orders.add(new Order(5, "Phone", 800.0, "CANCELLED"));

        System.out.println("Number of orders : "+orders.size());

        // get all orders with status of Delivered


        System.out.println("\nDelivered orders");
        orders.stream()
                .filter(order -> order.getStatus().toString()
                        .equals("DELIVERED")).toList().forEach(System.out::println);

        // List of prices with the tax of 1.1 (canceled items does not have tax)
        System.out.println("\nPrice with tax");
        orders.stream()
                .filter(order -> !order.getStatus()
                .toString().equals("CANCELED"))
                .map(order -> order.getPrice()*1.1)
                .toList().forEach(price-> System.out.println("price with tax "+price ));

        System.out.println("\nSorted by price ");
            orders.stream().sorted(Comparator.comparing(Order::getPrice)).forEach(System.out::println);

            // Calculating the total value of earning including delivered and shifted

        System.out.println(orders.stream().filter(order -> order.getStatus().toString()
                .equals("DELIVERED") || order.getStatus().toString().equals("SHIFTED")).mapToDouble(Order::getPrice).sum());

        // Finding most expensive order

        System.out.println("The most expensive order was: "+
                orders.stream().
                        max(Comparator.comparingDouble(Order::getPrice))
                        .orElse(null));

        // printing name and price
        System.out.println("\nAll orders");
        orders.stream().map(order -> order.getProduct()+" ($"+order.getPrice()+")").forEach(System.out::println);

        // checking if all element of orders is valid

        System.out.println(orders.stream().anyMatch(order ->  order.getPrice() <= 0)?"\nthere is a product which is not valid\n":"\nall products are valid\n");

        // Grouping by Status
        Map<Status, List<Order>> collect = orders.stream().collect(Collectors.groupingBy(Order::getStatus));

        collect.forEach((status, orders1) -> System.out.println(status.toString()+": "+orders1));
    }
}
