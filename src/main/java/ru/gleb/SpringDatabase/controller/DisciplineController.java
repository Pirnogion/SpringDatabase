package ru.gleb.SpringDatabase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gleb.SpringDatabase.entity.Discipline;
import ru.gleb.SpringDatabase.model.ListResponse;
import ru.gleb.SpringDatabase.service.DisciplineService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public ResponseEntity<ListResponse> allDisciplines() {
        try {
            List<Discipline> disciplines = disciplineService.getAllDisciplines();

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(disciplines).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось получить данные дисциплин: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<ListResponse> getDiscipline(@PathVariable("id") int id) {
        try {
            Discipline discipline = disciplineService.getDiscipline(id);

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(List.of(discipline)).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось получить данные дисциплины: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @PostMapping("/disciplines")
    public ResponseEntity<ListResponse> saveDiscipline(@RequestBody Discipline discipline) {
        try {
            Discipline createdDiscipline = disciplineService.saveDiscipline(discipline);

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(List.of(createdDiscipline)).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось создать дисциплину: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @PutMapping("/disciplines")
    public ResponseEntity<ListResponse> updateDiscipline(@RequestBody Discipline discipline) {
        try {
            Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);

            return new ResponseEntity<>(
                    ListResponse.builder().success(true).entities(List.of(updatedDiscipline)).build(),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            log.error("Не удалось обновить дисциплину: ");
            log.error(exception.getMessage());
        }

        return new ResponseEntity<>(
                ListResponse.builder().success(false).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<ListResponse> deleteDiscipline(@PathVariable("id") int id) {
        try {
            boolean result = disciplineService.deleteDiscipline(id);
            if (result) {
                return new ResponseEntity<>(
                        ListResponse.builder().success(true).build(),
                        HttpStatus.OK
                );
            }
        } catch (Exception exception) {
            log.error("Не удалось удалить дисциплину: ");
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
