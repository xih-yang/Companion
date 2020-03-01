package yang.postman.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yang.postman.community.mapper.UserMapper;
import yang.postman.community.model.User;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : yang9
 * @Date : 2020/1/17 15:55
 * @Description : yang.postman.community.controller
 */
@Controller
public class IndexController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        System.out.println("in index.comtroller");
        Cookie[] cookies =request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user=userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
            }
        }
        return "index";
    }
}
