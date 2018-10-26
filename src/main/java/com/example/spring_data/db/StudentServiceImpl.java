package com.example.spring_data.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService
{
    private List<Student> students = new ArrayList<>();

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
        LOG.debug("find student...");
        return studentRepository.findByName(name);
    }

    @Override
    public void initStudent(List<Student> students)
    {
        this.students.addAll(students);
    }

    @Override
    @Cacheable(cacheNames="student")
    public Student findCacheByName(String name)
    {
        LOG.debug("find student... {}", name);
        final Student student = findByName(name);
        return student;
    }

    private Student findByName(String name)
    {
        Student student = students.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
        return student;
    }

}
