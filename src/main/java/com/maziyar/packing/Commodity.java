package com.maziyar.packing;


import java.text.NumberFormat;

import com.maziyar.exception.OutOfRangeException;

public class Commodity {
    private byte id;
    private float weight;
    private byte value;

    public Commodity() {
    }

    public Commodity(byte id, float weight, byte value) {
        this.id = id;
        setWeight(weight);
        setValue(value);
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

    public String getValue() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(this.value);
    }

    public void setValue(byte value) {
        if ((value>0) && (value <= 100))
            this.value = value;
        else
            throw new OutOfRangeException("Value");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return  true;
        if (!(obj instanceof Commodity)) return false;
        Commodity other = (Commodity) obj;
        return this.id == other.id &&
                this.value == other.value &&
                this.weight == other.weight;
    }
}
