package com.example.appsale.ObjectClass;

public class Product {
    private int id;//ma sp
    private int manufacturerId;
    private String name;//tên sp
    private Double price;//giá
    private String image;//ảnh
    private int num;
    private Character size;
    private Character weight;
    private Character chipset;
    private Character ram;
    private Character storage;
    private Character battery;
    private Character charging;
    private Character video;

    public Product(int id, int manufacturerId, String name
            , Double price, String image, int num, Character size
            , Character weight, Character chipset, Character ram
            , Character storage, Character battery, Character charging, Character video) {
        this.id = id;
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.price = price;
        this.image = image;
        this.num = num;
        this.size = size;
        this.weight = weight;
        this.chipset = chipset;
        this.ram = ram;
        this.storage = storage;
        this.battery = battery;
        this.charging = charging;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Character getSize() {
        return size;
    }

    public void setSize(Character size) {
        this.size = size;
    }

    public Character getWeight() {
        return weight;
    }

    public void setWeight(Character weight) {
        this.weight = weight;
    }

    public Character getChipset() {
        return chipset;
    }

    public void setChipset(Character chipset) {
        this.chipset = chipset;
    }

    public Character getRam() {
        return ram;
    }

    public void setRam(Character ram) {
        this.ram = ram;
    }

    public Character getStorage() {
        return storage;
    }

    public void setStorage(Character storage) {
        this.storage = storage;
    }

    public Character getBattery() {
        return battery;
    }

    public void setBattery(Character battery) {
        this.battery = battery;
    }

    public Character getCharging() {
        return charging;
    }

    public void setCharging(Character charging) {
        this.charging = charging;
    }

    public Character getVideo() {
        return video;
    }

    public void setVideo(Character video) {
        this.video = video;
    }
}
