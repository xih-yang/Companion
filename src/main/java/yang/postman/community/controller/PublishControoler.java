package yang.postman.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import yang.postman.community.mapper.QuestionMapper;
import yang.postman.community.mapper.UserMapper;
import yang.postman.community.model.Question;
import yang.postman.community.model.User;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : yang9
 * @Date : 2020/3/1 20:39
 * @Description : yang.postman.community.controller
 */
@Controller
public class PublishControoler {
    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionMapper questionMapper;
    @RequestMapping("/publish")
    public String publish(){return "publish";}
    @RequestMapping("/goPublish")
    public ModelAndView goPublish(
            @RequestParam("title")String title, @RequestParam("description")String description, @RequestParam("tag")String tag,
            HttpServletRequest request, ModelAndView modelAndView
            ){
        //获取用户信息
        Cookie[] cookies =request.getCookies();
        User user=null;
        if(cookies!=null){
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                user=userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
            }
        }
        }else {
            modelAndView.addObject("error","用户未登录");
            modelAndView.setViewName("publish");
            return modelAndView;
        }
        if (user==null){
            modelAndView.addObject("error","用户未登录");
            modelAndView.setViewName("publish");
            return modelAndView;
        }
        //添加信息
        Question question=new Question(null,title,description,user.getId(),System.currentTimeMillis(),System.currentTimeMillis(),null,null,null,tag);
        Integer info = questionMapper.createQuestion(question);
        if(info>-1){
            modelAndView.addObject("success","添加成功");
            modelAndView.setViewName("redirect:/index");
        }else{
            modelAndView.addObject("error","断片了,请稍后重试..");
            modelAndView.setViewName("publish");
        }
        return modelAndView;
    }
}
