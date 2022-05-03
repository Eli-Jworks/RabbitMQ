package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Course implements Serializable {

    private Long courseId;
    private String title;
    private Integer credit;

    public void addStudent(Student student) {
        student.addCourse(this);
    }

}
