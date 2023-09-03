package com.example.appsale.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String ram;
    private int size;
    private int battery;
    private int charging;
    private String video;
    private String chipSet;
    private int storage;
    private int weight;
    private String picUrl;
    private int review;
    private int score;
    private int price;
    private int NumberInCart;

    public PopularDomain(String title, String ram, int size, int battery, int charging, String video, String chipSet, int storage, int weight, String picUrl, int review, int score, int price, int numberInCart) {
        this.setTitle(title);
        this.setRam(ram);
        this.setSize(size);
        this.setBattery(battery);
        this.setCharging(charging);
        this.setVideo(video);
        this.setChipSet(chipSet);
        this.setStorage(storage);
        this.setWeight(weight);
        this.setPicUrl(picUrl);
        this.setReview(review);
        this.setScore(score);
        this.setPrice(price);
        setNumberInCart(numberInCart);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getCharging() {
        return charging;
    }

    public void setCharging(int charging) {
        this.charging = charging;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getChipSet() {
        return chipSet;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberInCart() {
        return NumberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        NumberInCart = numberInCart;
    }
}
