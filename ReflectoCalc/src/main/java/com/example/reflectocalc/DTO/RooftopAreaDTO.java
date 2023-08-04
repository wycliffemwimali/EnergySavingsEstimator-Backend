package com.example.reflectocalc.DTO;

public class RooftopAreaDTO {
        private double area;

    public double getReflectance() {
        return reflectance;
    }

    public void setReflectance(double reflectance) {
        this.reflectance = reflectance;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    private double reflectance;
    private String material;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
