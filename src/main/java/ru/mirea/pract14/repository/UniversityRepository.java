package ru.mirea.pract14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.pract14.entity.University;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findAllByName(String name);

    List<University> findAllByCreationDate(String creationDate);
}
