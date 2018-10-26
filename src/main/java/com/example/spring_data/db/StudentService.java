package com.example.spring_data.db;


import java.util.List;
import java.util.Optional;

public interface StudentService
{
    Optional<Student> findById(long id);

    Student addStudent(Student student);

    Student getByName(String name);

    void initStudent(List<Student> students);

    Student findCacheByName(String name);

}
