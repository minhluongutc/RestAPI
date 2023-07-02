package com.viettel.restapi_crud.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId")
    private int studentId;
    @Column(name = "StudentName", columnDefinition = "nvarchar(50)", nullable = false, unique = true)
    private String studentName;
    @Column(name = "Age")
    private int age;
    @Column(name = "BirthDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    @Column(name = "StudentStatus")
    private boolean studentStatus;
}
