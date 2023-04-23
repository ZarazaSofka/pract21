package ru.mirea.pract14.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "universities")
@Getter
@Setter
@NoArgsConstructor
public class University {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "universities_seq", sequenceName = "universities_seq", allocationSize = 1)
    @GeneratedValue(generator = "universities_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private String creationDate;

    @OneToMany(mappedBy = "university", fetch = FetchType.EAGER)
    private List<Student> students;
}