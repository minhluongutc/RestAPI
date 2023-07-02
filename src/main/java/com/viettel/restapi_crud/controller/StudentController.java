package com.viettel.restapi_crud.controller;

import com.viettel.restapi_crud.model.StudentService;
import com.viettel.restapi_crud.model.entity.Student;
import com.viettel.restapi_crud.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int id) {
        return studentService.findById(id);
    }

    @PostMapping ("/")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int id,
                                 @RequestBody Student student) {
        Student studentUpdate = studentService.findById(id);
        studentUpdate.setStudentName(student.getStudentName());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setBirthDate(student.getBirthDate());
        studentUpdate.setStudentStatus(student.isStudentStatus());
        return studentService.saveOrUpdate(studentUpdate);
    }

    @DeleteMapping("/{studentId}")
    public List<Student> addStudent(@PathVariable("studentId") int id) {
        studentService.delete(id);
        return studentService.findAll();
    }

//    @GetMapping("/default")
//    public List<Student> getAll() {
//        return studentRepository.findAll();
//    }
}
