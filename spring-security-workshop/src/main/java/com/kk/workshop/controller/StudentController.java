package com.kk.workshop.controller;

import com.kk.workshop.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Rol bazli yetki verilebilmektedir, burada Config dosyasi icerisinde matcher ile hangi rolun yetkisi oldugu verilebildi
 *  Boylece roel sahip olmayan userlarin yetkisi olmayan API'ye istek atmasi engellendi
 * 2. Bununla birlikte ayrica authority de verilebilmektedir, temelde Role Authority'i kapsar.
 *  Bir role bagli n tane authority olabilmektedir ve authority uzerinden de yetkilendirme yapilabilemektedir
 * 3. Bu ornekte de PersonControllerindaki Post req icin authority tanimlandi ve bsadece bu authoritye sahip User bu istegi atabildi
 *  Burada rolden farkli olarak Set<GrantedAuthority> setlendi, bunun icin sadece permission name'ini GrantedAuthority cevirmek yeterli oldu
 * 4. Burada Post kullandigimiz icin ayrica anlik CSRF'i disabled ettik
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
