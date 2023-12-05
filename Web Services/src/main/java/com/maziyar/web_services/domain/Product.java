package com.maziyar.web_services.domain;

import com.maziyar.exception.OutOfRangeException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a product with an ID, weight, and price.
 */
@Entity
@Table(name = "product")
public class Product {
    
    /** The unique identifier of the product. */
    @Id
    private int id;

    /** The weight of the product. Must be between 0 and 100. */
    private double weight;

    /** The price of the product. Must be between 0 and 100. */
    private int price;

    /**
     * Default constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Constructs a Product object with the specified ID, weight, and price.
     *
     * @param id    The unique identifier of the product.
     * @param weight The weight of the product. Must be between 0 and 100.
     * @param price  The price of the product. Must be between 0 and 100.
     */
    public Product(int id, double weight, int price) {
        this.id = id;
        setWeight(weight);
        setPrice(price);
    }

    /**
     * Gets the ID of the product.
     *
     * @return The unique identifier of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the weight of the product.
     *
     * @return The weight of the product.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the product.
     *
     * @param weight The weight of the product. Must be between 0 and 100.
     * @throws OutOfRangeException If the input is out of the specified range.
     */
    public void setWeight(double weight) {
        validateInRange(weight, "Weight", 0, 100);
        this.weight = weight;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product. Must be between 0 and 100.
     * @throws OutOfRangeException If the input is out of the specified range.
     */
    public void setPrice(int price) {
        validateInRange(price, "Price", 0, 100);
        this.price = price;
    }

    /**
     * Validates that a value is within a specified range.
     *
     * @param value    The value to be validated.
     * @param name     The name of the value for error reporting.
     * @param minValue The minimum allowed value (inclusive).
     * @param maxValue The maximum allowed value.
     * @throws OutOfRangeException If the value is outside the specified range.
     */
    private void validateInRange(double value, String name, double minValue, double maxValue) {
        if (value <= minValue || value > maxValue) {
            throw new OutOfRangeException(name);
        }
    }

    /**
     * Compares this product to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return id == other.id && price == other.price && Double.compare(weight, other.weight) == 0;
    }
}
