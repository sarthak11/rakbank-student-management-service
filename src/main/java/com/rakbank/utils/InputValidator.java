package com.rakbank.utils;

import com.rakbank.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class InputValidator {

    public boolean isValidStudent(Student student) {
        return (validateUniqueId(student.getUniqueId()) && validateStudentName(student.getName())
                && validateStudentGrade(student.getGrade()) && validateMobileNumber(student.getMobileNumber()));
    }

    public boolean validateUniqueId(long uniqueId) {
        int length = String.valueOf(uniqueId).length();
        if (uniqueId <= 0 || length > 10) {
            return false;
        }
        return true;
    }

    public boolean validateStudentName(String name) {
        return !name.matches(".*\\d+.*");
    }

    public boolean validateStudentGrade(int grade) {
        if (grade <= 0 || grade > 12) {
            return false;
        }
        return true;
    }

    public boolean validateMobileNumber(String mobileNumber) {
        return mobileNumber.matches(Constants.MOBILE_NUMBER_REGEX);
    }

}
