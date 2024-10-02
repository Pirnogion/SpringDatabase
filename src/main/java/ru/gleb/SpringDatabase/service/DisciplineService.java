package ru.gleb.SpringDatabase.service;

import org.springframework.stereotype.Service;
import ru.gleb.SpringDatabase.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {

    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    boolean deleteDiscipline(int id);
}
