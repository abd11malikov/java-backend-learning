package streams;

public class Order {
    private int id;
    private String product;
    private double price;
    private Status status;

    public Order(int id, String product, double price, String status) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.status = Status.helper(status);
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order " + id + " [" + product + "] - $" + price + " (" + status + ")";
    }


}
