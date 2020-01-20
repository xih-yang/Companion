package yang.postman.community.provideer;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import yang.postman.community.dto.AccessTonkenDTO;
import yang.postman.community.dto.GithubUser;

import java.io.IOException;
import java.rmi.server.ExportException;

/**
 * @author : yang9
 * @Date : 2020/1/20 10:54
 * @Description : yang.postman.community.provideer
 */
@Component//
public class GithubProvider {
    public String getAccessToken(AccessTonkenDTO accessTonkenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient  client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTonkenDTO));
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String split=string.split("&")[0].split("=")[1];
                System.out.println(string);
                System.out.println(split);
                return split;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }


    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            GithubUser githubUser= JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (Exception e) {
        }
            System.out.println("卧槽");
            return null;
    }
}
