package com.example.restapi_demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.restapi_demo.entity.Student;
import com.example.restapi_demo.service.StudentService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id) {
        Student st = service.getStudentById(id);
        return st != null ? ResponseEntity.ok(st) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(s));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody Student s) {
        s.setSid(id); // lấy id từ URL, tránh lệch với body
        Student updated = service.updateStudent(s);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return service.deleteStudentById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam("name") String name) {
        return service.getStudentsByName(name);
    }
}
