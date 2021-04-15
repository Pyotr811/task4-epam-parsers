package by.epam.home.entity;

import java.util.List;
import java.util.Objects;

public class CargoService {
    private List<Customer> customers;
    private List<Driver> drivers;

    public CargoService() {
    }

    public CargoService(List<Customer> customers) {
        this.customers = customers;
    }

    public CargoService(List<Customer> customers, List<Driver> drivers) {
        this.customers = customers;
        this.drivers = drivers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoService that = (CargoService) o;
        return Objects.equals(customers, that.customers) &&
                Objects.equals(drivers, that.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers, drivers);
    }

    @Override
    public String toString() {
        return "CargoService{" +
                "customers=" + customers +
                ", drivers=" + drivers +
                '}';
    }
}
