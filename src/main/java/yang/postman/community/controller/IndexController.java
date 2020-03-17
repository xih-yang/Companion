package yang.postman.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yang.postman.community.dto.QuestionDTO;
import yang.postman.community.mapper.QuestionMapper;
import yang.postman.community.mapper.UserMapper;
import yang.postman.community.model.Question;
import yang.postman.community.model.User;
import yang.postman.community.service.QuestionService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : yang9
 * @Date : 2020/1/17 15:55
 * @Description : yang.postman.community.controller
 */
@Controller
public class IndexController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionService questionService;
    @RequestMapping("index")
    public String index(HttpServletRequest request,
                        Model model) {
        System.out.println("in index.controller");
        Cookie[] cookies = request.getCookies();
        if (cookies != null || cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
        }
        List<QuestionDTO> questionList= questionService.queryQuestionList();//首页数据
        model.addAttribute("questionList",questionList);
        return "index";
    }
}
