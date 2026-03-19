package com.hei.springboot.controller;

import com.hei.springboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private List<Student> students;

    public StudentController(){
        students = new ArrayList<>();
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody List<Student> newstudent){
        students.addAll(newstudent);

        return students.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining(","));
    }
    @GetMapping("/students")
    public String getStudents(@RequestHeader("Accept") String acceptHeader){
        if ("text/plain".equals(acceptHeader)){
            return students.stream()
                    .map(s -> s.getFirstName() + " " + s.getLastName())
                    .collect(Collectors.joining(","));
        }
        else {
            return "Format not supported";
        }
    }
}
