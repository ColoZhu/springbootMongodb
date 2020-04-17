package czs.web;

import czs.bean.User;
import czs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8888/mongodb/user/get
    @GetMapping("/get")
    public List<User> getUser() {
        return userService.findAllUsers();
    }

    //http://localhost:8888/mongodb/user/add

    /**
     * 参数
     * {
     * "id": 1,
     * "userName": "李云1",
     * "passWord": "liyun1"
     * }
     */
    @PostMapping("/add")
    public void insert(@RequestBody User user) {
        userService.save(user);
    }

    //http://localhost:8888/mongodb/user/delete/1
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "delete success";
    }


    //
    /** http://localhost:8888/mongodb/user/update  (PUT方式)
       参数
     {
     "id": 1,
     "userName": "李云111",
     "passWord": "liyun1111"
     }
    * */
    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }
}