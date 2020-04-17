package czs.dao;

import czs.bean.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserRepository {

    /**
     * 创建对象
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    List<User> findUserByUserName(String userName);

    /**
     * 更新对象
     *
     * @param user
     */
    long updateUser(User user);

    /**
     * 删除对象
     *
     * @param id
     */
    void deleteUserById(Long id);
}