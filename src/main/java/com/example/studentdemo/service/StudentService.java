package com.example.studentdemo.service;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        // 데이터베이스에서 모든 학생 레코드를 조회하여 리스트로 반환합니다.
        // findAll() 메서드는 JpaRepository 인터페이스에서 제공하는 기본 메서드로,
        // 데이터베이스의 모든 레코드를 조회합니다.
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        // 데이터베이스에서 주어진 ID에 해당하는 학생 레코드를 조회하여 반환합니다.
        // findById(id) 메서드는 JpaRepository 인터페이스에서 제공하는 기본 메서드로,
        // 해당 ID를 가진 레코드를 조회합니다. 레코드가 없으면 Optional의 orElse 메서드를 통해 null을 반환합니다.
        return studentRepository.findById(id).orElse(null); //Optional의 메서드
    }

    public Student saveStudent(Student student) {
        // 주어진 학생 객체를 데이터베이스에 저장하고, 저장된 객체를 반환합니다.
        // save() 메서드는 JpaRepository 인터페이스에서 제공하는 기본 메서드로,
        // 새로운 레코드를 추가하거나 기존 레코드를 업데이트합니다.
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        // 주어진 ID로 특정 학생을 데이터베이스에서 삭제합니다.
        // deleteById() 메서드는 JpaRepository 인터페이스에서 제공하는 기본 메서드로,
        // 해당 ID의 레코드를 삭제합니다.
        studentRepository.deleteById(id);
    }
}
