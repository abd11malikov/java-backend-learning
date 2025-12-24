package warehouse;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;


    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product product){
        return this.id - product.getId();
    }

    @Override
    public String toString() {
        return "Product: " +
                "id = " + id +
                ", name ='" + name + '\'' +
                ", price = $" + price;
    }
}
