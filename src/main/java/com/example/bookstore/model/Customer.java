package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contact_name;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth_day;



    protected Customer() {

    }

    public Customer(String contact_name, String phone, Date birth_day) {
        this.contact_name = contact_name;
        this.phone = phone;
        this.birth_day = birth_day;
    }

    public Long getId() {
        return id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirth_day() {
        return birth_day;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "contact_name='" + contact_name + '\'' +
                ", phone='" + phone + '\'' +
                ", birth_day=" + birth_day +
                '}';
    }
}
