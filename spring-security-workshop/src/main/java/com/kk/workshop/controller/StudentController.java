package com.kk.workshop.controller;

import com.kk.workshop.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 1. FormLogin haricinde JWT üzerinden de işlem yapabilmekteyiz.
 *  Bunun için öncelikle Jwt için bir filter  tanımlayıp, Username Password doğru mu onu kontrol ettik.
 *  Eğer authenticate olduysa da library yardımıyla JWT token uretildi
 * 2. Burada onemli noktalardan biri ise Configurationda bu filteri calistirmasi icin ekledik ve sessionin stateless olacagini belirttik
 * @author korayk
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static List<Student> students = Arrays.asList(
            new Student(1, "Koray"),
            new Student(2, "Ahmet"),
            new Student(3, "Mehmet") );

    @GetMapping (path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
         return students.stream()
                        .filter(x -> x.getId() == studentId)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Student with id: " + studentId + " not found"));
    }
}
