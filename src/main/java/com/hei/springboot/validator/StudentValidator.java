package com.hei.springboot.validator;

import com.hei.springboot.exception.BadRequestException;
import com.hei.springboot.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validate(Student student) {
        if (student.getReference() == null || student.getReference().isBlank()) {
            throw new BadRequestException("reference cannot be null");
        }

        if (student.getFirstName() == null || student.getFirstName().isBlank()) {
            throw new BadRequestException("firstName cannot be null");
        }

        if (student.getLastName() == null || student.getLastName().isBlank()) {
            throw new BadRequestException("lastName cannot be null");
        }
    }
}
