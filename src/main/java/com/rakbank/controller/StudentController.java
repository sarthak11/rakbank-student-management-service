package com.rakbank.controller;

import com.rakbank.dto.ErrorResponse;
import com.rakbank.dto.Student;
import com.rakbank.dto.StudentResponse;
import com.rakbank.exception.DuplicateStudentException;
import com.rakbank.service.StudentService;
import com.rakbank.utils.Constants;
import com.rakbank.utils.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private InputValidator inputValidator;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
    public ResponseEntity save(@RequestBody Student student) {
        if (inputValidator.isValidStudent(student)) {
            try {
                studentService.save(student);
            } catch (DuplicateStudentException e) {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage()), HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "invalid input"), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
    public ResponseEntity save(@PathVariable Long id) {
        StudentResponse response = studentService.getStudentDetails(id);
        if (response == null) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "student not found!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
