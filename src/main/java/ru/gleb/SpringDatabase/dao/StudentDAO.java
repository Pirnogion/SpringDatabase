package ru.gleb.SpringDatabase.dao;

import org.springframework.stereotype.Repository;
import ru.gleb.SpringDatabase.entity.Student;

import java.util.List;

@Repository
public interface StudentDAO {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    boolean deleteStudent(int id);
}
