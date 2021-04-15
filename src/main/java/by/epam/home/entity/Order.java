package by.epam.home.entity;

import java.util.Objects;

public class Order {
    private int id;
    private String name;
    private Weight weight;
    private String from;
    private String to;
    private Price price;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public Order(String name, Weight weight) {
        this.name = name;
        this.weight = weight;
    }

    public Order(int id, String name, Weight weight, String from, String to, Price price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(name, order.name) &&
                Objects.equals(weight, order.weight) &&
                Objects.equals(from, order.from) &&
                Objects.equals(to, order.to) &&
                Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, from, to, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                '}';
    }
}
