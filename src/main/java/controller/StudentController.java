package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController //RESTful 웹 서비스의 컨트롤러임
@RequestMapping("/students") //이 클래스의 모든 핸들러 메서드가 /students 경로에 매핑됨
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping     //Http 메서드 get
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")  //경로 변수 id를 사용하여 특정 학생을 조회
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();    // -> 특정 값을 조회한 후 HTTP 응답으로 반환하는 메서드.
        }
        return ResponseEntity.ok(student);
    }

    //@PathVariable Long id* 는 URL 경로에서 추출된 id 값을 Long 타입의 id 파라미터로 전달받는다는 의미입니다.
    //즉, GET /students/1 요청이 들어오면, 1이 id 파라미터로 전달됩니다.

    /*
    Student student = studentService.getStudentById(id); 줄은
    데이터베이스에서 특정 ID에 해당하는 학생 정보를 조회하고, 이를 student 변수에 저장합니다.
    이 과정은 데이터베이스에서 데이터를 가져와 메모리에 저장하는 역할을 하며,
    이후 로직에서 이 데이터를 사용하여 학생의 존재 여부를 확인하고, 적절한 HTTP 응답을 반환하는 데 사용됩니다.
     */


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    /*
    파라미터: @RequestBody Student student
    : JSON 데이터를 Student 객체로 변환합니다.
      (클라이언트가 전송한 학생 데이터를 Student 객체로 매핑합니다.)
     */

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        Student updatedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }


    /*
    @RequestBody Student studentDetails를 사용하여 새로운 Student 객체를 받아오는 이유는
    클라이언트가 보낸 새로운 학생 정보를 받아오기 위해서입니다.
    즉, 클라이언트가 보내는 JSON 데이터를 자바 객체로 변환하여 메서드의 파라미터로 전달받는 것입니다.
    -------------------------------
        JSON 데이터의 예시)

        {
        "name": "John Doe",
        "age": 22
         }
    -------------------------------
    -> 서버는 @RequestBody 어노테이션을 사용하여 요청 본문에 포함된 JSON 데이터를 자바 객체로 변환합니다.
    이때 변환된 자바 객체가 studentDetails 변수에 저장됩니다.

       */


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
