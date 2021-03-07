package com.company.entities;

public class Precious { //class to create objects of precious stones
    private int id, weight;
    private String name;
    private boolean authenticity;

    public Precious(int id, int weight, String name, boolean authenticity) {
        setAuthenticity(authenticity);
        setWeight(weight);
        setName(name);
    }

    public Precious(int weight, String name, boolean authenticity) {
        setName(name);
        setWeight(weight);
        setAuthenticity(authenticity);
    }

    public String getName() {
        return name;
    }

    public boolean isAuthenticity() {
        return authenticity;
    }

    public void setAuthenticity(boolean authenticity) {
        this.authenticity = authenticity;
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
        return "Precious{" +
                "id=" + id +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", authenticity=" + authenticity +
                '}';
    }
}
