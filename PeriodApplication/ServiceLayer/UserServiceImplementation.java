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
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            String email = createUserRequest.getEmail();
            if (email.matches(emailRegex)) {
                System.out.println("Valid email address");
            } else {
                System.out.println("Invalid email address");
            }
            return userRepo.save(Mapper.toModel(createUserRequest));
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
        public void deleteAccount(User user) {
            userRepo.delete(user);
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
}
