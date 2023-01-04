package com.kebab.multidb.student.repository;

import com.kebab.multidb.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
