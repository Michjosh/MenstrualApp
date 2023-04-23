package PeriodApplication.DTOs;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FindUserResponse {
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private CharSequence dateOfLastPeriod;
    private int lengthOfCycle;
    private int lengthOfPeriod;
}
