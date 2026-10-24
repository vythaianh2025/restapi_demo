package com.example.restapi_demo.service;

import java.util.List;

import com.example.restapi_demo.entity.Student;

public interface StudentService {
    List<Student> getAllStudent();

    Student getStudentById(Long id);

    Student createStudent(Student s);

    Student updateStudent(Student s);

    boolean deleteStudentById(Long id);

    List<Student> getStudentsByName(String name);

}
