package PeriodApplication.Utils;

import PeriodApplication.DTOs.CreateUserRequest;
import PeriodApplication.DTOs.FindUserResponse;
import PeriodApplication.DataLayer.Model.User;

public class Mapper {
        public static void toDTO(User user, FindUserResponse response){
            response.setFullName(user.getFullName());
            response.setDateOfBirth(user.getDateOfBirth());
            response.setDateOfLastPeriod(user.getDateOfLastPeriod());
            response.setLengthOfCycle(user.getLengthOfCycle());
            response.setLengthOfPeriod(user.getLengthOfPeriod());
        }

        public static User toModel(CreateUserRequest createUserRequest){
            User user = new User();
            user.setFullName(createUserRequest.getFullName());
            user.setDateOfBirth(createUserRequest.getDateOfBirth());
            user.setEmail(createUserRequest.getEmail());
            user.setPassword(createUserRequest.getPassword());
            user.setUsername(createUserRequest.getUsername());
            user.setDateOfLastPeriod(createUserRequest.getDateOfLastPeriod());
            user.setLengthOfCycle(createUserRequest.getLengthOfCycle());
            user.setLengthOfPeriod(createUserRequest.getLengthOfPeriod());
            return user;
        }

    }
