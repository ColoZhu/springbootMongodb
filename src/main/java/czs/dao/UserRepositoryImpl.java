package czs.dao;

import com.mongodb.client.result.UpdateResult;
import czs.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @return
     */
    @Override
    public List<User> findAllUsers( ) {
        Query query = new Query();
        return  mongoTemplate.find(query, User.class);
    }


    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    @Override
    public List<User> findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return  mongoTemplate.find(query, User.class);
    }

    /**
     * 更新对象
     *
     * @param user
     */
    @Override
    public long updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if (result != null) {
            return result.getMatchedCount();
        } else {
            return 0;
        }

    }

    /**
     * 删除对象
     *
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }


}
