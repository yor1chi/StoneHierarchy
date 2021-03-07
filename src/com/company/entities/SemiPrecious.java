package com.company.entities;

public class SemiPrecious { //class to create objects of semi precious stones
    private int id, weight;
    private String name;
    private boolean authenticity;

    public SemiPrecious(int id, int weight, String name, boolean authenticity) {
        setAuthenticity(authenticity);
        setWeight(weight);
        setName(name);
    }

    public SemiPrecious(int weight, String name, boolean authenticity) {
        setName(name);
        setWeight(weight);
        setAuthenticity(authenticity);
    }

    public boolean isAuthenticity() {
        return authenticity;
    }

    public void setAuthenticity(boolean authenticity) {
        this.authenticity = authenticity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SemiPrecious{" +
                "id=" + id +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", authenticity=" + authenticity +
                '}';
    }
}
