package com.example.spring_data.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest
{
    private static final Long id = 2L;
    private static final String name = "Ted";
    private static final String passportNumber = "123";

    @Autowired
    StudentService studentService;

    @Test
    public void addStudent()
    {
        Student student = studentService.addStudent(new Student(id, name, passportNumber));
        Assert.assertNotNull(student);
    }

    @Test
    public void findByName()
    {
        studentService.addStudent(new Student(id, name, passportNumber));
        Student student = studentService.getByName(name);
        Assert.assertEquals("Ted", student.getName());
    }

    @Test
    public void findById()
    {
        studentService.addStudent(new Student(id, name, passportNumber));
        Optional<Student> student = studentService.findById(id);
        student.ifPresent(student1 -> Assert.assertEquals("Ted", student1.getName()));
    }


}
