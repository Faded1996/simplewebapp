package com.mastery.java.task.dto;

import com.mastery.java.task.annotation.Adult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank(message = "first name must be specified")
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "first name must have at least 2 letters")
    private String firstName;

    @NotBlank(message = "last name must be specified")
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "last name must have at least 2 letters")
    private String lastName;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@Adult checks whether employee is at least 18 y.o.
    @Adult(message = "employee should be at least 18 y.o.")
    private LocalDate birthday;


    @Min(value = 1, message = "department Id can't be less than 1")
    @NotNull(message = "department Id must by specified")
    private Long departmentId;

    @Length(min = 2, message = "job title should have at least 2 symbols")
    @NotNull(message = "job title must be specified")
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "gender must be chosen")
    private Gender gender;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", departmentId=" + departmentId +
                ", jobTitle='" + jobTitle + '\'' +
                ", gender=" + gender +
                '}';
    }
}
