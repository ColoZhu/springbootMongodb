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

    @GetMapping("/get")
    public List<User> getUser() {
        return userService.findAllUser();
    }


    @PostMapping("/add")
    public void insert(@RequestBody User user) {
        userService.insert(user);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        userService.delete(id);
        return "delete success";
    }

    //这个方法没法修改
    @PutMapping("/update")
    public void update(User user){
        userService.update(user);
    }
}