package com.viettel.restapi_crud.model;

import com.viettel.restapi_crud.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int studentId);
    Student saveOrUpdate(Student student);
    void delete(int studentId);
}
