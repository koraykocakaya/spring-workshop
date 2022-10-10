package com.kk.workshop.controller;

import com.kk.workshop.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 1. SecurityConfig classi uzerinden ayarlar verebilmekteyiz.
 *  Burada / istekleri icin authentication gerekmeyecegi, dgier istekler icin ise basic auth kullancagimizi belirtmis olduk
 *  .formLogin() ile de herhangi bir URL'e gitmek istedigimizde username password icin popup yerine login'e yonlendirmesini saglamis olduk
 * 2. SpS'in kendi InMemoryUserDetailsManager kullanarak User tanimi yapabildik boylece bu user ile login olabiliriz
 *  Basic Auth oldugu icin her istekte username, password bilgisini gondermemiz gerekecektir
 *  User'i bir sekilde setlemezsek Sps'in default User'i user ve password'u de random bir UUID olacaktir ve console'a acilis aninda basilacaktir
 * 3.
 *
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
