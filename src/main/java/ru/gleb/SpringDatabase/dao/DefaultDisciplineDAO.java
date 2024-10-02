package ru.gleb.SpringDatabase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gleb.SpringDatabase.entity.Discipline;

import java.util.List;

@Slf4j
@Repository
public class DefaultDisciplineDAO implements DisciplineDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDisciplines() {
        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query.getResultList();

        log.info("getAllDisciplines" + allDisciplines);

        return allDisciplines;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return entityManager.merge(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        return entityManager.find(Discipline.class, id);
    }

    @Override
    public boolean deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from Discipline where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();

        return result == 1;
    }
}
