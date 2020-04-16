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
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    //添加
    public void insert(User user) {
        userRepository.insert(user);
    }

    //删除
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    //修改,这个方法没法修改,走的还是insert, 因为检查了@version的属性版本号
    public void update(User user) {
        userRepository.save(user);

    }
}
