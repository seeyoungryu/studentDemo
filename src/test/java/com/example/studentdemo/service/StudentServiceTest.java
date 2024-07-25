package com.example.studentdemo.service;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void testGetAllStudents() {
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setAge(22);

        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setAge(20);

        List<Student> students = Arrays.asList(student1, student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Doe", result.get(1).getName());
    }

    // 추가 테스트 메서드
}
