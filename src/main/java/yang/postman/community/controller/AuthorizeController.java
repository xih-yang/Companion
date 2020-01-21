package yang.postman.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yang.postman.community.dto.AccessTonkenDTO;
import yang.postman.community.dto.GithubUser;
import yang.postman.community.provideer.GithubProvider;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : yang9
 * @Date : 2020/1/20 10:47
 * @Description : yang.postman.community.controller
 */
@Controller
public class AuthorizeController {
    @Autowired
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

    @RequestMapping("/callback")
    public String callback(@RequestParam("code")String code  ,
                           @RequestParam("state")String state,
                           HttpServletRequest request){
        AccessTonkenDTO accessTonkenDTO=new AccessTonkenDTO();
        accessTonkenDTO.setClient_id(clientId);
        accessTonkenDTO.setClient_secret(clientSecret);
        accessTonkenDTO.setRedirect_uri(redorectUri);
        accessTonkenDTO.setState(state);
        accessTonkenDTO.setCode(code);
        String accessTonken = githubProvider.getAccessToken(accessTonkenDTO);
        GithubUser user =githubProvider.getUser(accessTonken);
        System.out.println(user.getName()+user.getBio()+user.getId());
        if(user!=null){
            //登录成功
            request.getSession().setAttribute("user",user);
        }
        return "redirect:/index";
    }
}
