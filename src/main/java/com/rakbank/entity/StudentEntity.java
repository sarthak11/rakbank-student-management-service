package com.rakbank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private long uniqueId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int grade;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String schoolName;

    @Column(nullable = false)
    private Date createdDate;
}

