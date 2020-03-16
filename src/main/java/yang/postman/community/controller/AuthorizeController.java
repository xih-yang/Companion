package yang.postman.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yang.postman.community.dto.AccessTonkenDTO;
import yang.postman.community.dto.GithubUser;
import yang.postman.community.mapper.UserMapper;
import yang.postman.community.model.User;
import yang.postman.community.provideer.GithubProvider;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author : yang9
 * @Date : 2020/1/20 10:47
 * @Description : yang.postman.community.controller
 */
@Controller
public class AuthorizeController {
    @Resource
    private GithubProvider githubProvider;
    /**
     * 读取配置内容
     */
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.Redirect_uri}")
    private String redorectUri;
    @Resource
    private UserMapper userMapper;
    @RequestMapping("/callback")
    public String callback(@RequestParam("code")String code  ,
                           @RequestParam("state")String state,
                          // HttpServletRequest request,
                           HttpServletResponse response){
        AccessTonkenDTO accessTonkenDTO=new AccessTonkenDTO();
        accessTonkenDTO.setClient_id(clientId);
        accessTonkenDTO.setClient_secret(clientSecret);
        accessTonkenDTO.setRedirect_uri(redorectUri);
        accessTonkenDTO.setState(state);
        accessTonkenDTO.setCode(code);
        String accessTonken = githubProvider.getAccessToken(accessTonkenDTO);
        GithubUser githubUser =githubProvider.getUser(accessTonken);
        System.out.println(githubUser.getName()+githubUser.getBio()+githubUser.getId());
        if (githubUser != null&&githubUser.getId()!=null) {//信息不完整时,空白昵称
            User user = new User(null, githubUser.getName(), String.valueOf(githubUser.getId()), UUID.randomUUID().toString(), System.currentTimeMillis(), System.currentTimeMillis());
            userMapper.insert(user);
            //登录成功
            response.addCookie(new Cookie("token",user.getToken()));
           // request.getSession().setAttribute("user", githubUser);
        }
        return "redirect:/index";
    }
}
