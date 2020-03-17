package yang.postman.community.dto;

import lombok.Data;

/**
 * @author : yang9
 * @Date : 2020/1/20 15:20
 * @Description : yang.postman.community.dto
 */
@Data
public class GithubUser {
    //id
    private Long id;
    //名称
    private String name;
    //描述
    private String bio;
    //头像
    private String avatar_url;
}
