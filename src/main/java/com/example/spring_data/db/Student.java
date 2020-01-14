package com.example.spring_data.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="student")
public class Student
{
    @Id
    //@GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="passport_number")
    private String passportNumber;

    public Student()
    {
    }

    @Override
    public String toString()
    {
        return String.format("Students [id= %s, name=%s, passportNumber= %s]", id, name, passportNumber);
    }

}
