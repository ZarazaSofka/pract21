package ru.mirea.pract14.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "students_seq", sequenceName = "students_seq", allocationSize = 1)
    @GeneratedValue(generator = "students_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
     private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private University university;
}
