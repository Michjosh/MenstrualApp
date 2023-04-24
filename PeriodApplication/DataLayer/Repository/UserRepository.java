package PeriodApplication.DataLayer.Repository;

import PeriodApplication.DataLayer.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


    User findByUserName(String name);

    void delete(String id);
}
