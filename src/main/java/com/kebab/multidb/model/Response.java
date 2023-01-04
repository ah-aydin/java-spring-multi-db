package com.kebab.multidb.model;

import com.kebab.multidb.college.entity.College;
import com.kebab.multidb.student.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class Response {
    List<Student> students;
    List<College> colleges;
}
