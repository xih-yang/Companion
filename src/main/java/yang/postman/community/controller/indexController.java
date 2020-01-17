package yang.postman.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : yang9
 * @Date : 2020/1/17 15:55
 * @Description : yang.postman.community.controller
 */
@Controller
public class indexController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
