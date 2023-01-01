package com.rakbank.service;

import com.rakbank.dto.Student;
import com.rakbank.dto.StudentResponse;
import com.rakbank.entity.StudentEntity;
import com.rakbank.exception.DuplicateStudentException;
import com.rakbank.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void save(Student student) throws DuplicateStudentException {
        StudentEntity studentEntityDB = studentRepository.findByUniqueId(student.getUniqueId());
        if (studentEntityDB != null) {
            throw new DuplicateStudentException("student already exists, please check and try again!");
        }
        StudentEntity studentEntity = StudentEntity.builder()
                .uniqueId(student.getUniqueId())
                .name(student.getName())
                .grade(student.getGrade())
                .schoolName(student.getSchoolName())
                .mobileNumber(student.getMobileNumber())
                .createdDate(new Date())
                .build();
        studentRepository.save(studentEntity);
    }

    public StudentResponse getStudentDetails(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        if (studentEntity == null) {
            return null;
        }
        return new StudentResponse(studentEntity);
    }

}
