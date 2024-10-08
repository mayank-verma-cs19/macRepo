package com.example.demo.service.serviceImpl;

import com.example.demo.UtilityClass;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.Users;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repo.StudentRepository;
import com.example.demo.repo.UsersRepository;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.maToStudent(studentDto);
        Student saveStudent  = studentRepository.save(student);

        Users user = new Users();
        user.setName(saveStudent.getName());
        user.setEmail(saveStudent.getEmail());
        user.setStudentId(UtilityClass.longValue(saveStudent.getId()));
        user.setPassword("demo");
        user.setUsername(saveStudent.getEmail());

        usersRepository.save(user);



        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto deleteStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found by id" + id));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : studentList) {
            studentDtoList.add(StudentMapper.mapToStudentDto(student));
        }
        return studentDtoList;
    }
}
