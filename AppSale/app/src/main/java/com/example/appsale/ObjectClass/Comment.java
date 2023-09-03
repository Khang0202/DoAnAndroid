package com.example.appsale.ObjectClass;

import java.util.Date;



public class Comment {

    private int id;
    private String content;
    private int product_Id;
    private int user_Id;
    private Date createed_data;
    private int star;
    public Comment(int id, String content, int product_Id, int user_Id, Date createed_data, int star) {
        this.id = id;
        this.content = content;
        this.product_Id = product_Id;
        this.user_Id = user_Id;
        this.createed_data = createed_data;
        this.star = star;
    }




}
