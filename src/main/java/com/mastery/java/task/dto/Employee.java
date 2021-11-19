package com.mastery.java.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mastery.java.task.annotation.Adult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    //@Adult checks whether employee is at least 18 y.o.
    @Adult

    private Date birthday;


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
