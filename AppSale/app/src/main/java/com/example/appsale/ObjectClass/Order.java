package com.example.appsale.ObjectClass;


import java.util.Date;

public class Order {
    private int id;
    private int user_id;
    private Double totalprice;
    private Date created_date;

    public Order(int id, int user_id, Double totalprice, Date created_date) {
        this.id = id;
        this.user_id = user_id;
        this.totalprice = totalprice;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
