package PeriodApplication.DTOs;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateUserRequest {
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private LocalDate dateOfLastPeriod;
    private int lengthOfCycle;
    private int lengthOfPeriod;
}
