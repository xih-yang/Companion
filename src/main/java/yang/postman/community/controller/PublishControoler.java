package yang.postman.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : yang9
 * @Date : 2020/3/1 20:39
 * @Description : yang.postman.community.controller
 */
@Controller
public class PublishControoler {
    @RequestMapping("/publish")
    public String publish(){
        return "publish";
    }
}
