package PeriodApplication.ServiceLayer;

import PeriodApplication.DTOs.CreateUserRequest;
import PeriodApplication.DTOs.FindUserResponse;
import PeriodApplication.DataLayer.Model.User;

public interface UserServiceInterface {

        User createAccount(CreateUserRequest createUserRequest);
        User updateUserDetails(CreateUserRequest request, String username);
        void login(String id);
        void deleteAccount(String id);
        FindUserResponse findUserById(String id);
        void findByUserName(String username);
}
