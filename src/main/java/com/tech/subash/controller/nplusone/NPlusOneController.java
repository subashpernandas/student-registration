package com.tech.subash.controller.nplusone;

import com.tech.subash.entity.jpa.StaffEntity;
import com.tech.subash.entity.jpa.StaffOneEntity;
import com.tech.subash.entity.jpa.SubjectsEntity;
import com.tech.subash.entity.jpa.SubjectsOneEntity;
import com.tech.subash.repository.StaffOneRepository;
import com.tech.subash.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/n+1")
public class NPlusOneController {

    @Autowired
    private StaffOneRepository staffRepository;

    @GetMapping()
    public void store() {
        //StaffEntity staff = new StaffEntity();
        StaffOneEntity staff = new StaffOneEntity();

        staff.setStaffName("daniel");
        staff.setNoOfExpeience(23);

        SubjectsOneEntity subjectsOOPS = new SubjectsOneEntity();
        subjectsOOPS.setSubjectName("OOPS");
        //subjectsOOPS.setStaffName("Daniel");

        SubjectsOneEntity subjectsOOAD = new SubjectsOneEntity();
        subjectsOOAD.setSubjectName("OOAD");
        //subjectsOOAD.setStaffName("Daniel");

        staff.setSubjects(List.of(subjectsOOPS,subjectsOOAD));

        StaffOneEntity staff2 = new StaffOneEntity();
        staff2.setStaffName("Selvaraj");
        staff2.setNoOfExpeience(27);

        SubjectsOneEntity subjectsRDBMS = new SubjectsOneEntity();
        subjectsRDBMS.setSubjectName("RDBMS");
        //subjectsRDBMS.setStaffName("Selvaraj");


        SubjectsOneEntity subjectsDS = new SubjectsOneEntity();
        subjectsDS.setSubjectName("Data Structure");
        //subjectsDS.setStaffName("Selvaraj");
        staff2.setSubjects(List.of(subjectsRDBMS,subjectsDS));

        StaffOneEntity staff3 = new StaffOneEntity();
        staff3.setStaffName("Ilangovan");
        staff3.setNoOfExpeience(32);

        SubjectsOneEntity subjectsNetwork = new SubjectsOneEntity();
        subjectsNetwork.setSubjectName("Network");
        //subjectsNetwork.setStaffName("Ilangovan");
        staff3.setSubjects(List.of(subjectsNetwork));
        staffRepository.saveAll(List.of(staff,staff2,staff3));

    }

    /*@GetMapping("/all")
    public List<StaffEntity> nPlusOne() {
        return staffRepository.findAll();
    }

    @GetMapping("/resolve")
    public List<StaffEntity> nPlusOneResolve() {
        return staffRepository.fetchAllStaffDetails();
    }

    @GetMapping("/resolveQueryGraph")
    public List<StaffEntity> nPlusOneResolveUsingQueryGraph() {
        return staffRepository.fetchAllStaffDetailsUsingQueryGraph();
    }*/
}
