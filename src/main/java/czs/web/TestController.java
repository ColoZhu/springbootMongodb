package czs.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



//下面是一个测试controller，模拟请求接口，发送消息，
@Controller
public class TestController {



    //http://localhost:8888/mongodb/testSendMsg
    @RequestMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg() {
        return "success";
    }









}
