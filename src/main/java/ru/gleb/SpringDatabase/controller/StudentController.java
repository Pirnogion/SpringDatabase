package ru.gleb.SpringDatabase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gleb.SpringDatabase.entity.Student;
import ru.gleb.SpringDatabase.model.ListResponse;
import ru.gleb.SpringDatabase.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @GetMapping("/students")
    public ResponseEntity<ListResponse> allStudents() {
        try {
            List<Student> students = StudentService.getAllStudents();

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(students).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось получить данные студентов: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ListResponse> getStudent(@PathVariable("id") int id) {
        try {
            Student student = StudentService.getStudent(id);

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(List.of(student)).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось получить данные студента: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @PostMapping("/students")
    public ResponseEntity<ListResponse> saveStudent(@RequestBody Student student) {
        try {
            Student createdStudent = StudentService.saveStudent(student);

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(List.of(createdStudent)).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось создать студента: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @PutMapping("/students")
    public ResponseEntity<ListResponse> updateStudent(@RequestBody Student student) {
        try {
            Student updatedStudent = StudentService.saveStudent(student);

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(List.of(updatedStudent)).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось обновить студента: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<ListResponse> deleteStudent(@PathVariable("id") int id) {
        try {
            boolean result = StudentService.deleteStudent(id);
            if (result) {
                return new ResponseEntity<>(
                        ListResponse.builder().success(true).build(),
                        HttpStatus.OK
                );
            }
        } catch (Exception exception) {
            log.error("Не удалось удалить студента: ");
            log.error(exception.getMessage());

            return new ResponseEntity<>(
                    ListResponse.builder().success(false).build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.NOT_FOUND
        );
    }
}
