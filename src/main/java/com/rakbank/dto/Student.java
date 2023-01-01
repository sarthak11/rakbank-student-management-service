package com.rakbank.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private long uniqueId;

    private String name;

    private int grade;

    private String mobileNumber;

    private String schoolName;
}
