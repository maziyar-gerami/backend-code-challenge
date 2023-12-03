package org.packing;

import org.exception.OutOfRangeException;

import java.util.UUID;

public class Commodity {
    private UUID id;
    private float weight;
    private byte value;

    public Commodity() {
    }

    public Commodity(float weight, byte value) {
        this.weight = weight;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if ((weight > 0) && (weight < 100))
            this.weight = weight;
        else
            throw new OutOfRangeException("Weight");
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        if ((value>0) && (value < 100))
            this.value = value;
        else
            throw new OutOfRangeException("Value");
    }
}
