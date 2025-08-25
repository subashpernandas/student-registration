package com.tech.subash.repository;

import com.tech.subash.entity.jpa.StaffEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {

    @Query("SELECT s FROM StaffEntity s JOIN FETCH s.subjects")
    List<StaffEntity> fetchAllStaffDetails();


    @EntityGraph(attributePaths = "subjects")
    @Query("SELECT s FROM StaffEntity s")
    List<StaffEntity> fetchAllStaffDetailsUsingQueryGraph();
}
