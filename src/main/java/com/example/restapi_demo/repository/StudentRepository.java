package com.example.restapi_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi_demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // WHERE name = ?
    List<Student> findByName(String name);

    // Tìm gần đúng, không phân biệt hoa thường (WHERE LOWER(name) LIKE %?%)
    List<Student> findByNameContainingIgnoreCase(String keyword);
}