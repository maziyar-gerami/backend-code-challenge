package org.packing;

import java.util.UUID;

public class Commodity {
    private UUID id;
    private float weight;
    private byte value;

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
        this.weight = weight;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
