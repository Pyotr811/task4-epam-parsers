package by.epam.home.entity;

import java.util.Objects;

public class Customer {
    private int id;
    private String customerFirstName;
    private String customerLastName;
    private String phone;
    private Order order;

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String firstName, String lastName) {
        this.customerFirstName = firstName;
        this.customerLastName = lastName;
    }

    public Customer(int id, String firstName, String lastName, String phone, Order order) {
        this.id = id;
        this.customerFirstName = firstName;
        this.customerLastName = lastName;
        this.phone = phone;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                phone == customer.phone &&
                Objects.equals(customerFirstName, customer.customerFirstName) &&
                Objects.equals(customerLastName, customer.customerLastName) &&
                Objects.equals(order, customer.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerFirstName, customerLastName, phone, order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + customerFirstName + '\'' +
                ", lastName='" + customerLastName + '\'' +
                ", phone=" + phone +
                ", orders=" + order +
                '}';
    }
}
