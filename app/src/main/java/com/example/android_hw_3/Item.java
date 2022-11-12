package com.example.android_hw_3;

public class Item {
    private int imageRes;
    private String name;
    private int score;

    public Item() {
    }

    public Item(int score) {
        this.score = score;
    }

    public Item setImageRes(int imageRes) {
        this.imageRes = imageRes;
        return this;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setScore(int score) {
        this.score = score;
        return this;
    }


    public int getImageRes() {
        return imageRes;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
