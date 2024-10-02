package ru.gleb.SpringDatabase.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gleb.SpringDatabase.dao.StudentDAO;
import ru.gleb.SpringDatabase.entity.Student;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
        return studentDAO.deleteStudent(id);
    }
}
