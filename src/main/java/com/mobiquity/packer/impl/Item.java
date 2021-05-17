package com.mobiquity.packer.impl;

class Item {
    private int id;
    private double weight;
    private double cost;

    public Item(int id, double weight, double cost) {
        this.id = id;
        this.weight = weight;
        this.cost = cost;
    }

    public int getId() { return id; }


    public double getWeight() { return weight; }


    public double getCost() { return cost; }

}
