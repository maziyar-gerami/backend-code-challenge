package com.maziyar.services.packing;


import java.text.NumberFormat;

import com.maziyar.exception.OutOfRangeException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
    @Id
    private int id;
    private float weight;
    private int price;

    public Product() {
    }

    public Product(int id, float weight, int value) {
        this.id = id;
        setWeight(weight);
        setPrice(value);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if ((weight > 0) && (weight <= 100))
            this.weight = weight;
        else
            throw new OutOfRangeException("Weight");
    }

    public String getPrice() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(this.price);
    }

    public void setPrice(int value) {
        if ((value>0) && (value <= 100))
            this.price = value;
        else
            throw new OutOfRangeException("Value");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return  true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.id == other.id &&
                this.price == other.price &&
                this.weight == other.weight;
    }
}
