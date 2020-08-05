package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Harden"),
            new Student(2, "Russell Westbrook"),
            new Student(3, "Larry Bird")
    );

//    @GetMapping
//    public ResponseEntity<String> check() {
//        return ResponseEntity.ok("Ok");
//    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Integer studentId) {
        return ResponseEntity.ok(STUDENTS.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student "+studentId+" does not exist")));
    }
}
