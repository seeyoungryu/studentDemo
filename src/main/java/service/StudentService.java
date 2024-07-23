package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.List;


@Service //서비스 레이어의 컴포넌트임을 명시
public class StudentService {     //학생 관련 비즈니스 로직을 처리하는 서비스 클래스

    @Autowired
    private StudentRepository studentRepository;
    /*
    @Autowired: 스프링이 StudentRepository를 주입하도록 합니다.
    (객체가 필요한 의존성을 직접 생성하거나 찾지 않고, 외부에서 주입받는 방법
    ,나중에 StudentRepository의 구현을 변경하더라도 StudentService 클래스를 수정할 필요가 없디.)
     */

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
