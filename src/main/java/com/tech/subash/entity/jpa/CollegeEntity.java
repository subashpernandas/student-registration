package com.tech.subash.entity.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "college")
public class CollegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String collegeName;

    private int totalNoOfStudent;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "college") // It won't create new table
    /*@JoinTable(name = "college_student_details",
    joinColumns = @JoinColumn(name = "college_id"),
    inverseJoinColumns = @JoinColumn(name = "student_fk_id"))*/
    private List<StudentEntity> student;
}
