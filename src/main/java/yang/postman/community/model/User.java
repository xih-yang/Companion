package yang.postman.community.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : yang9
 * @Date : 2020/1/30 21:37
 * @Description : yang.postman.community.model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmt_create;//创建
    private Long gmt_modified;//修改
    private String avatar_url;//头像
}
