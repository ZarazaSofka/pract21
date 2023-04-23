package ru.mirea.pract14.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.pract14.entity.University;
import ru.mirea.pract14.repository.UniversityRepository;

import java.util.List;

@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class UniversityService{

    private final UniversityRepository universityRepository;

    public void create(University university) {
        log.info("Creating university {}", university);
        universityRepository.save(university);
    }

    public List<University> readAll() {
        log.info("Reading of universities");
        return universityRepository.findAll();
    }

    public University read(long id) {
        log.info("Looking for university by id {}", id);
        return universityRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        log.info("Deleting university by id {}", id);
        universityRepository.deleteById(id);
    }

    public List<University> readByName(String name) {
        log.info("Looking for universities by first name {}", name);
        return universityRepository.findAllByName(name);
    }

    public List<University> readByCreationDate(String creationDate) {
        log.info("Looking for universities by creation date {}", creationDate);
        return universityRepository.findAllByCreationDate(creationDate);
    }
}