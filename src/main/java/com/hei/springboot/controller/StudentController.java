package com.hei.springboot.controller;

import com.hei.springboot.model.Student;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> newStudents) {
        try {
            students.addAll(newStudents);
            return ResponseEntity
                    .status(201)
                    .body(students);
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .build();
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", required = false) String acceptHeader) {
        try {
            if (acceptHeader == null) {
                return ResponseEntity
                        .badRequest()
                        .body("Header 'Accept' est obligatoire");
            }

            if ("text/plain".equals(acceptHeader)) {
                String result = students.stream()
                        .map(s -> s.getFirstName() + " " + s.getLastName())
                        .collect(Collectors.joining(", "));
                return ResponseEntity.ok(result);

            } else if ("application/json".equals(acceptHeader)) {
                return ResponseEntity.ok(students);

            } else {
                return ResponseEntity
                        .status(501)
                        .body("Format non supporté");
            }

        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body("Erreur interne: " + e.getMessage());
        }
    }

}
