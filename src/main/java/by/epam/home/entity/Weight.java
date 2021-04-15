package by.epam.home.entity;

import java.util.Objects;

public class Weight {
    private String unit;
    private int value;

    public Weight() {
    }

    public Weight(String unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return value == weight.value &&
                Objects.equals(unit, weight.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }

    @Override
    public String toString() {
        return "Weight{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
