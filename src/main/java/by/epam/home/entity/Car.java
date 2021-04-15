package by.epam.home.entity;

import java.util.Objects;

public class Car {
    private int id;
    private String brand;
    private String model;
    private LiftCapacity liftCapacity;
    private int yearOfIssue;

    public Car() {
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(String name, String model) {
        this.brand = name;
        this.model = model;
    }

    public Car(int id, String name, String model, LiftCapacity liftCapacity, int yearOfIssue) {
        this.id = id;
        this.brand = name;
        this.model = model;
        this.liftCapacity = liftCapacity;
        this.yearOfIssue = yearOfIssue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LiftCapacity getLiftCapacity() {
        return liftCapacity;
    }

    public void setLiftCapacity(LiftCapacity liftCapacity) {
        this.liftCapacity = liftCapacity;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                yearOfIssue == car.yearOfIssue &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(liftCapacity, car.liftCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, liftCapacity, yearOfIssue);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", liftCapacity=" + liftCapacity +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }
}
