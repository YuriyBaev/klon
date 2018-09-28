package com.example.spring_data.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(long id)
    {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student)
    {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student getByName(String name)
    {
        return studentRepository.findByName(name);
    }

}
