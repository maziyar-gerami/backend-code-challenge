package com.maziyar.services.packing;

import com.maziyar.exception.OutOfRangeException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;
    private double weight;
    private int price;

    public Product() {
    }

    public Product(int id, double weight, int price) {
        this.id = id;
        setWeight(weight);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        validateInRange(weight, "Weight", 0, 100);
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        validateInRange(price, "Price", 0, 100);
        this.price = price;
    }

    private void validateInRange(double value, String name, double minValue, double maxValue) {
        if (value <= minValue || value > maxValue) {
            throw new OutOfRangeException(name);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return id == other.id && price == other.price && Double.compare(weight, other.weight) == 0;
    }
}
