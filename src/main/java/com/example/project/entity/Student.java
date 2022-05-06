package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student implements Serializable {
    private static final long serialVersionUID = -7597688394935897908L;

    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private transient List<Course> courses;
}
