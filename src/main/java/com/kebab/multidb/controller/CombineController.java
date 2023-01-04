package com.kebab.multidb.controller;

import com.kebab.multidb.college.repository.CollegeRepository;
import com.kebab.multidb.model.Response;
import com.kebab.multidb.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CombineController {

    @Autowired
    CollegeRepository collegeRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/")
    public Response getAll() {
        Response response = new Response();
        response.setColleges(collegeRepository.findAll());
        response.setStudents(studentRepository.findAll());
        return response;
    }
}
