package PeriodApplication.DataLayer.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class User {
    @Id
    private String userId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String username;
    private CharSequence dateOfLastPeriod;
    private int lengthOfCycle;
    private int lengthOfPeriod;
}