package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getSurName(),
                student.getAge(),
                student.getDob(),
                student.getGender(),
                student.getAddress(),
                student.getPhone(),
                student.getEmail()
        );
    }

    public static Student maToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getSurName(),
                studentDto.getAge(),
                studentDto.getDob(),
                studentDto.getGender(),
                studentDto.getAddress(),
                studentDto.getPhone(),
                studentDto.getEmail()
        );
    }
}
