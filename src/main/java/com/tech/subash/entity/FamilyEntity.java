package com.tech.subash.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "family")
public class FamilyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String familyName;

    private int noMembers;

    @ElementCollection
    @CollectionTable(name = "family_contacts",
    joinColumns = @JoinColumn(name = "family_id"))
    private List<String> familyMemberNames;
}
