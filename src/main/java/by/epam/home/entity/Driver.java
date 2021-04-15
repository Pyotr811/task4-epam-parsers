package by.epam.home.entity;

import java.util.Objects;

public class Driver {
    private int id;
    private String driverFirstName;
    private String driverLastName;
    private String driverPhone;
    private Car car;

    public Driver() {
    }

    public Driver(int id) {
        this.id = id;
    }

    public Driver(String firstName, String lastName) {
        this.driverFirstName = firstName;
        this.driverLastName = lastName;
    }

    public Driver(int id, String driverFirstName, String driverLastName, String phone, Car car) {
        this.id = id;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.driverPhone = phone;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id &&
                driverPhone == driver.driverPhone &&
                Objects.equals(driverFirstName, driver.driverFirstName) &&
                Objects.equals(driverLastName, driver.driverLastName) &&
                Objects.equals(car, driver.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverFirstName, driverLastName, driverPhone, car);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + driverFirstName + '\'' +
                ", lastName='" + driverLastName + '\'' +
                ", phone=" + driverPhone +
                ", cars=" + car +
                '}';
    }
}
