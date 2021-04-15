package by.epam.home.entity;

import java.util.Objects;

public class LiftCapacity {
    private String unit;
    private int capacity;

    public LiftCapacity() {
    }

    public LiftCapacity(String unit, int value) {
        this.unit = unit;
        this.capacity = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiftCapacity that = (LiftCapacity) o;
        return capacity == that.capacity &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, capacity);
    }

    @Override
    public String toString() {
        return "LiftCapacity{" +
                "unit='" + unit + '\'' +
                ", value=" + capacity +
                '}';
    }
}
