package ru.netology.domain;

public class Product {
    protected int id;
    protected String name;
    protected int cost;

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    //public void setId(int id) {
    //this.id = id;
    //}

    public String getName() {
        return name;
    }

    //public void setName(String name) {
    //this.name = name;
    //}

    //public int getCost() {
    //return cost;
    //}

    //public void setCost(int cost) {
    //this.cost = cost;
    //}
}
