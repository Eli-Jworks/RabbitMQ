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
    private static final long serialVersionUID = -2555031097348979935L;

    private Long courseId;
    private String title;
    private Integer credit;

}
