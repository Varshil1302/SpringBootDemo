package com.springboot.springMvc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private String role;
    private Double salary;
}
