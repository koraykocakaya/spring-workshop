package com.kk.workshop.controller;

import com.kk.workshop.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Basic Auth yerine Form Auth da kullanabiliriz, boylece kullanici bir kere login olduktan sonra
 *  sessionId Cookie setlenecek ve logout veya expired olana kadar sistemdeki istek atabilecektir
 * 2. Burada kendi Sps'in kendi logini haric custom Login sayfasi da yapabilmek icin ayrica TemplateController ve login.html yaratildi
 *  Burada thymeleaf kullanarak login.html goruntulenmesi saglandi
 * 3. Ek olarak SecurityConfig uzerindne login basarili oldugunda defaultURL de verilebilir
 * 4. Ayrica Sps'de direkt remember-me setlenebilir. Bunu direkt html sayfasi uzerinden bir checkbox yardimiyla gonderebiliriz
 *  Eger configde de izin verirsek remember-me setlenecektir ve sessionId olmasa bile remember-me cookie uzerinden istek atmaya devam edebilecektir
 * 5. username, password ve remember-me otomatik oalrak eslesecektir, ancak farkli id ile gelecekse bunu Config'de parameter uzerinden setleyebilmekteyiz
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
