package com.hei.springboot.controller;

import com.hei.springboot.exception.BadRequestException;
import com.hei.springboot.model.Student;
import com.hei.springboot.service.StudentService;
import com.hei.springboot.validator.StudentValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
public class StudentController {

    private  StudentService studentService;
    private  StudentValidator studentValidator;


    @PostMapping("/students")
    public ResponseEntity<?> addStudents(@RequestBody List<Student> students) {
        try {
            for (Student s : students) {
                studentValidator.validate(s);
            }
            List<Student> result = studentService.addStudents(students);
            return ResponseEntity.status(201).body(result);

        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur interne");
        }
    }
}
