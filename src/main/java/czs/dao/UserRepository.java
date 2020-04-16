package czs.dao;

import czs.bean.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface UserRepository extends MongoRepository<User, String> {
}