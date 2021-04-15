package by.epam.home.entity;

import java.util.Objects;

public class Price {
    private String currency;
    private int amount;

    public Price() {
    }

    public Price(String currency, int value) {
        this.currency = currency;
        this.amount = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return amount == price.amount &&
                Objects.equals(currency, price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency='" + currency + '\'' +
                ", value=" + amount +
                '}';
    }
}
