package com.example.room;

public class Customer {
    String name;
    String add;
    int num;

    public Customer(String name, String add, int num){
        this.name = name;
        this.add = add;
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public String getAdd() {
        return add;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void setAdd(String add) {
        this.add = add;
    }
    public void setName(String name) {
        this.name = name;
    }
}
