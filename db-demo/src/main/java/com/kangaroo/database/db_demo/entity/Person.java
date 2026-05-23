package com.kangaroo.database.db_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;
    private String name;
    private String location;
    private Date birthday;
}
