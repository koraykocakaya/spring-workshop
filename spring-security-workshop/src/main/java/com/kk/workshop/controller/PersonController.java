package com.kk.workshop.controller;

import com.kk.workshop.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @PostMapping
    public String getStudent(@RequestBody String personId){
        return personId;
    }
}
