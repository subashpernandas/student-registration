package com.tech.subash.entity.jpa;

import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subject")
@Getter @Setter
@ToString
public class SubjectsOneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subjectName;
}
