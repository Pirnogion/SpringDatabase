
package ru.gleb.SpringDatabase.dao;

import org.springframework.stereotype.Repository;
import ru.gleb.SpringDatabase.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDAO {

    List<Discipline> getAllDisciplines();
    Discipline saveDiscipline(Discipline discipline);
    Discipline getDiscipline(int id);
    boolean deleteDiscipline(int id);
}
