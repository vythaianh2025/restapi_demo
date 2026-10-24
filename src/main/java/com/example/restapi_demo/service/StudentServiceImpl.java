package com.example.restapi_demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.restapi_demo.entity.Student;
import com.example.restapi_demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Không tìm thấy student id = " + id));
    }

    @Override
    public Student createStudent(Student s) {
        return repo.save(s);
    }

    @Override
    public Student updateStudent(Student s) {
        if (s.getSid() == null || !repo.existsById(s.getSid())) {
            return null; // không tồn tại thì không cập nhật
        }
        return repo.save(s);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        if (!repo.existsById(id)) {
            return false; // không tồn tại thì không xóa
        }
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return repo.findByName(name);
    }

}