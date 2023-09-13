package model;

import java.io.Serializable;

public class Location implements Serializable {
    private Double x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private float z;

    public Location(Double x, Integer y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(){}

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}