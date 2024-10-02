package ru.gleb.SpringDatabase.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gleb.SpringDatabase.dao.DisciplineDAO;
import ru.gleb.SpringDatabase.entity.Discipline;

import java.util.List;

@Service
public class DefaultDisciplineService implements DisciplineService {

    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public boolean deleteDiscipline(int id) {
        return disciplineDAO.deleteDiscipline(id);
    }
}
