package com.example.rabbitmq.Controller;

import com.example.project.entity.MessageFilter;
import com.example.rabbitmq.Rabbit.MessagePublisher;
import com.example.rabbitmq.Rabbit.MessagingConfig;
import com.example.project.entity.Course;
import com.example.project.entity.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/addstudent")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStudent(@RequestBody Student student) throws Exception {
        String action = "Add Student";
        MessageFilter msg = MessageFilter.builder().action(action).object(student).build();
        MessagePublisher publisher = new MessagePublisher(msg);
        publisher.startConnection();
        return action + " request sent!";
    }

    @PostMapping("/addcourse")
    public String addCourse(@RequestBody Course course) throws Exception {
        String action = "Add Course";
        MessageFilter msg = MessageFilter.builder().action(action).object(course).build();
        MessagePublisher publisher = new MessagePublisher(msg);
        publisher.startConnection();
        return action + " request sent!";
    }

    @PostMapping("/addcourses")
    public String addCourses(@RequestBody List<Course> courses) throws Exception {
        String action = "Add Courses";
        MessageFilter msg = MessageFilter.builder().action(action).object(courses).build();
        MessagePublisher publisher = new MessagePublisher(msg);
        publisher.startConnection();
        return action + " request sent!";
    }

    @PostMapping("/signin/course/{title}/student/{id}")
    public String signInStudent(@PathVariable String title, @PathVariable int id) throws Exception {
        String action = "Sign In";
        List<Object> list = new ArrayList<>();
        list.add(title);
        list.add(id);
        MessageFilter msg = MessageFilter.builder().action(action).object(list).build();
        MessagePublisher publisher = new MessagePublisher(msg);
        publisher.startConnection();
        return action + " request sent!";
    }
//
//    @GetMapping("/course/{id}")
//    public Course getCourseById(@PathVariable int id) {
//        return service.findCourseById(id);
//    }
//
//    @GetMapping("/course/{title}")
//    public Course getCourseByName(@PathVariable String title) {
//        return service.findCourseByTitle(title);
//    }
//
//    @GetMapping("/getcourses")
//    public List<Course> getAllCourses() {
//        return service.getAllCourses();
//    }
//
//    @GetMapping("/getstudents")
//    public List<Student> getAllStudents() {
//        return service.findAllStudents();
//    }
//
//    @GetMapping("/student/{id}")
//    public Student getStudentById(@PathVariable int id) {
//        Student student = service.findStudentById(id);
//        System.out.println(student);
//        return student;
//    }
//
//    @GetMapping("/student/{name}")
//    public Student getStudentByName(@PathVariable String name) {
//        return service.findStudentByFirstName(name);
//    }
//
//    @DeleteMapping("/delete/course/{id}")
//    public String deleteCourseById(@PathVariable int id) {
//        return service.deleteCourseById(id);
//    }
//
//    @DeleteMapping("/delete/student/{id}")
//    public String deleteStudentById(@PathVariable int id) {
//        return service.deleteStudentById(id);
//    }
}
