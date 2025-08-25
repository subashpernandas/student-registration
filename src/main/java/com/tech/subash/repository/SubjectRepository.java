package com.tech.subash.repository;

import com.tech.subash.entity.jpa.SubjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectsEntity, Integer> {
}
