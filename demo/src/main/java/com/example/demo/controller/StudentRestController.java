package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("api/student")
@AllArgsConstructor
public class StudentRestController {

    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
//        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("getAllStudents")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> getStudent = studentService.getAllStudents();
        return new ResponseEntity<>(getStudent, HttpStatus.OK);
    }

    @GetMapping("getById")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }



}
