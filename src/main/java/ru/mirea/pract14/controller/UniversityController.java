package ru.mirea.pract14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pract14.entity.University;
import ru.mirea.pract14.service.UniversityService;

import java.util.List;

@RestController
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }
    @PostMapping(value="/universities")
    public ResponseEntity<?> create(@RequestBody University university) {
        universityService.create(university);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/universities")
    public ResponseEntity<List<University>> readAll() {
        final List<University> universities = universityService.readAll();
        return universities != null && !universities.isEmpty()
                ? new ResponseEntity<>(universities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/universities/name")
    public ResponseEntity<List<University>> readByName(@RequestParam String property) {
        final List<University> universities = universityService.readByName(property);
        return universities != null && !universities.isEmpty()
                ? new ResponseEntity<>(universities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/universities/creationdate")
    public ResponseEntity<List<University>> readByCreationDate(@RequestParam String property) {
        final List<University> universities = universityService.readByCreationDate(property);
        return universities != null && !universities.isEmpty()
                ? new ResponseEntity<>(universities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/universities/{id}")
    public ResponseEntity<University> read(@PathVariable(name="id") long id) {
        final University university = universityService.read(id);
        return university != null
                ? new ResponseEntity<>(university, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/universities/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        universityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
