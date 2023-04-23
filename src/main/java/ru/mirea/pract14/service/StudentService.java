package ru.mirea.pract14.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.pract14.entity.Student;
import ru.mirea.pract14.repository.StudentRepository;

import java.util.List;

@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService{
    private final StudentRepository studentRepository;

    public void create(Student student) {
        log.info("Creating student {}", student);
        studentRepository.save(student);
    }

    public List<Student> readAll() {
        log.info("Reading of students");
        return studentRepository.findAll();
    }

    public Student read(long id) {
        log.info("Looking for student by id {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        log.info("Deleting student by id {}", id);
        studentRepository.deleteById(id);
    }

    public List<Student> readByFirstName(String firstName) {
        log.info("Looking for students by first name {}", firstName);
        return studentRepository.findAllByFirstName(firstName);
    }

    public List<Student> readByLastName(String lastName) {
        log.info("Looking for students by last name {}", lastName);
        return studentRepository.findAllByLastName(lastName);
    }

    public List<Student> readByMiddleName(String middleName) {
        log.info("Looking for students by middle name {}", middleName);
        return studentRepository.findAllByMiddleName(middleName);
    }

    public List<Student> readByUniversity(Long university) {
        log.info("Looking for students by university id {}", university);
        return studentRepository.findAllByUniversity(university);
    }
}