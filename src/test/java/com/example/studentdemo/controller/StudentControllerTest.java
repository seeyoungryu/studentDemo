package com.example.studentdemo.controller;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)   //이 어노테이션은 StudentController를 테스트하기 위한 설정을 자동으로 구성합니다.
// 스프링 MVC 관련 컴포넌트만 로드하여 테스트 성능을 향상시킵니다.
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;   //MockMvc를 주입하여 컨트롤러의 HTTP 요청과 응답을 테스트합니다.

    @MockBean        //StudentService를 모킹하여 실제 서비스 레이어를 호출하지 않고 테스트할 수 있습니다.
    private StudentService studentService;


    //GetStudent Test

    @Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setAge(22);

        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setAge(20);

        List<Student> students = Arrays.asList(student1, student2);

        Mockito.when(studentService.getAllStudents()).thenReturn(students);    //studentService.getAllStudents() 메서드가 호출되면 students 리스트를 반환하도록 모킹합니다.

        mockMvc.perform(get("/students"))           //GET /students 요청을 모킹합니다.
                .andExpect(status().isOk())                     //HTTP 응답 상태가 200 OK인지 검증합니다.
                .andExpect(jsonPath("$[0].name").value("John Doe"))  //JSON 응답의 첫 번째 요소의 name 필드 값이 "John Doe"인지 검증합니다.
                .andExpect(jsonPath("$[0].age").value(22))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"))
                .andExpect(jsonPath("$[1].age").value(20));
    }


    //CtreateStudent Test


    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(22);

        Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn(student);

        String studentJson = "{ \"name\": \"John Doe\", \"age\": 22 }";

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.age").value(22));
    }

    // 추가 테스트 메서드
}

