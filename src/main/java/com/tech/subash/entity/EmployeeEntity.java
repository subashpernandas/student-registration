package com.tech.subash.entity;

import com.tech.subash.entity.audit.AuditEntity;
import com.tech.subash.enums.EmployeeTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "dept")
    private String dept;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeTypeEnum employeeType;

    @Column(name = "salary")
    private int salary;
}
