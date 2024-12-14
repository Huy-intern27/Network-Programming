package TCP;

import java.io.Serializable;

public class Product implements Serializable{
    private int id, discount;
    private String name;
    private double price;
    
    private static final long serialVersionUID = 20231107;

    public Product(int id, int discount, String name, double price) {
        this.id = id;
        this.discount = discount;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", discount=" + discount + ", name=" + name + ", price=" + price + '}';
    }
}