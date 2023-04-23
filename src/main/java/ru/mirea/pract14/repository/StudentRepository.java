package ru.mirea.pract14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.pract14.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstName(String firstName);

    List<Student> findAllByLastName(String lastName);

    List<Student> findAllByMiddleName(String middleName);

    List<Student> findAllByUniversity(Long university);
}
