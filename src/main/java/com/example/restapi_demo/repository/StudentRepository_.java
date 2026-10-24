package com.example.restapi_demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.restapi_demo.entity.Student;

@Repository
public class StudentRepository_ {
    private final List<Student> data = new ArrayList<>();

    public List<Student> findAll() {
        return data;
    }

    public Student findById(Long id) {
        for (Student st : data)
            if (st.getSid() == id)
                return st;
        return null;
    }

    public Student save(Student s) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSid() == s.getSid()) {
                data.set(i, s); // thay bản cũ bằng bản mới
                return s;
            }
        }
        data.add(s);
        return s;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(st -> st.getSid() == id);
    }
}