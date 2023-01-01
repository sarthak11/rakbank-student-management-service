package com.rakbank.dto;

import com.rakbank.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
public class StudentResponse {

    private long id;

    private long uniqueId;

    private String name;

    private int grade;

    private String mobileNumber;

    private String schoolName;

    private Date createdDate;

    public StudentResponse(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.uniqueId = studentEntity.getUniqueId();
        this.name = studentEntity.getName();
        this.grade = studentEntity.getGrade();
        this.mobileNumber = studentEntity.getMobileNumber();
        this.schoolName = studentEntity.getSchoolName();
        this.createdDate = studentEntity.getCreatedDate();
    }

}
