package PeriodApplication.ServiceLayer;

import PeriodApplication.DTOs.CreateUserRequest;
import PeriodApplication.DTOs.FindUserResponse;
import PeriodApplication.DataLayer.Model.User;

public interface UserServiceInterface {

        User createAccount(CreateUserRequest createUserRequest);
        void login(String id);
        void deleteAccount(User user);
        FindUserResponse findUserById(String id);
        void findByUserName(String username);
}
