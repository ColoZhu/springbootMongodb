package czs.service;

import czs.bean.User;

import czs.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //查询所有
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    //根据名称查询
    public List<User> findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    //添加
    public void save(User user) {
        userRepository.saveUser(user);
    }

    //删除
    public void delete(Long id) {
        userRepository.deleteUserById(id);
    }

    //修改, 如果用MongodbRepository的save这个方法没法修改,走的还是insert, 因为检查了@version的属性版本号,这里使用Mongotemplate的方法
    public void update(User user) {
        userRepository.updateUser(user);
    }
}
