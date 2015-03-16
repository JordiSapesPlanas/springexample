package com.udl.softarch.springexample.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by debian-jordi on 23/02/15.
 */
@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "this field cannot be blank")
    @Size(max = 256, message = "content maximum length is {max} characters long")
    private String content;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    public Greeting(){
    }
    public Greeting(String content, Date date){
        this.content = content;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
