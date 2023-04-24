package PeriodApplication.ServiceLayer;

import PeriodApplication.DTOs.CreateUserRequest;
import PeriodApplication.DTOs.FindUserResponse;
import PeriodApplication.DataLayer.Model.User;
import PeriodApplication.DataLayer.Repository.UserRepository;
import PeriodApplication.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserServiceInterface{
        @Autowired
        private UserRepository userRepo;

        @Override
        public User createAccount(CreateUserRequest createUserRequest) {
            if (userExist(createUserRequest.getFullName())) {
                throw new IllegalArgumentException(createUserRequest.getFullName() + " already exists");
            }
            isValidName(createUserRequest);
            isValidEmail(createUserRequest);
            isValidPassword(createUserRequest);
            isValidUsername(createUserRequest);
            return userRepo.save(Mapper.toModel(createUserRequest));
        }

        @Override
        public User updateUserDetails(CreateUserRequest request, String username) {
        if (userExist(request.getUsername()))
            throw new IllegalArgumentException(request.getUsername() + " does not exist");
        User user = new User();
            Mapper.toModel(request);
            return userRepo.save(user);
    }

        private boolean userExist(String name) {
            Optional<User> foundUser = userRepo.findById(name);
            return foundUser.isPresent();
        }

        @Override
        public void login(String id) {
            try {
                userRepo.findById(id);
            } catch (NoSuchElementException e) {
                System.err.println("User with username does not exist.");
            }
        }

        @Override
        public void deleteAccount(String id) {
            userRepo.delete(id);
        }
        @Override
        public FindUserResponse findUserById(String id) {
            Optional<User> foundUser = userRepo.findById(id);
            if(foundUser.isEmpty()) throw new NullPointerException("No user found with ID : " + id);
            FindUserResponse response = new FindUserResponse();
            Mapper.toDTO(foundUser.get(), response);
            return response;
        }
        @Override
        public void findByUserName(String username) {
            Optional <User> foundUser = Optional.ofNullable(userRepo.findByUserName(username));
            if (foundUser.isEmpty() ) throw new NullPointerException("User does not exist");
            FindUserResponse response = new FindUserResponse();
            Mapper.toDTO(foundUser.get(), response);
        }

    private static void isValidEmail(CreateUserRequest createUserRequest) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!createUserRequest.getEmail().matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email address: " + createUserRequest.getEmail());
        }
    }

    private void isValidPassword(CreateUserRequest createUserRequest) {
        String regex = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[@$!%#?&])[A-Za-z\\d@$!%#?&]{8,20}$";
        if (!createUserRequest.getPassword().matches(regex)){
            throw new IllegalArgumentException("Invalid password : " + createUserRequest.getPassword() + """
                    Password must have:
                    At least one uppercase letter
                    At least one lowercase letter
                    At least one digit
                    At least one special character
                    Must be between 8 and 20 characters)""");
        }
    }

    private void isValidUsername(CreateUserRequest createUserRequest) {
        String regex = "^[a-zA-Z0-9_]{3,16}$";
        if (!createUserRequest.getUsername().matches(regex)) {
            if (!createUserRequest.getPassword().matches(regex)) {
                throw new IllegalArgumentException("Invalid username: " + createUserRequest.getUsername() + """
                         must consisting of:
                        letters, numbers, and underscores with a length between 3 and 16 characters
                        """);
            }
        }
    }

    private void isValidName(CreateUserRequest createUserRequest) {
        String regex = "^(?i)[a-z]+( [a-z]+)+$";
        if (!createUserRequest.getFullName().matches(regex)){
            throw new IllegalArgumentException("Invalid name: " + createUserRequest.getFullName() + """
                     must contain only letters for firstname and lastname separated by a space
                    """);
        }
    }
}
