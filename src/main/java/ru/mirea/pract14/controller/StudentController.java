package ru.mirea.pract14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pract14.entity.Student;
import ru.mirea.pract14.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping(value="/students")
    public ResponseEntity<?> create(@RequestBody Student student) {;
        studentService.create(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/students")
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentService.readAll();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/students/firstname")
    public ResponseEntity<List<Student>> readByFirstName(@RequestParam String property) {
        final List<Student> students = studentService.readByFirstName(property);
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/students/lastname")
    public ResponseEntity<List<Student>> readByLastName(@RequestParam String property) {
        final List<Student> students = studentService.readByLastName(property);
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/students/middlename")
    public ResponseEntity<List<Student>> readByMiddleName(@RequestParam String property) {
        final List<Student> students = studentService.readByMiddleName(property);
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/students/university")
    public ResponseEntity<List<Student>> readByUniversity(@RequestParam Long property) {
        final List<Student> students = studentService.readByUniversity(property);
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/students/{id}")
    public ResponseEntity<Student> read(@PathVariable(name="id") long id) {
        final Student student = studentService.read(id);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/students/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
