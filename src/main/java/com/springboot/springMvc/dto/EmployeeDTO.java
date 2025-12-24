package com.springboot.springMvc.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class EmployeeDTO
{
    private Long id;

    @NotBlank(message = "Name of the employee cannot be blank")
    @Size(min = 3,max=13,message = "Number of characters in name should be in a range:[3,13]")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age Should not be Null")
    @Min(value = 18,message = "Age Should not be less than 18.")
    @Max(value = 50,message = "Age should not greater than 50.")
    private Integer age;

    @NotBlank(message = "Role of the employee cannot be blank")
    private String role;

    @NotNull(message = "Salary Should not be null")
    @Positive(message = "Salary Should be in positive.")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "Date Of Joining Should not be future.")
    private LocalDate dateOfJoining;

}
