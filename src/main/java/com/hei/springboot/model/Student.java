package com.hei.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private Integer age;
}
