package yang.postman.community.dto;

import lombok.Data;
import yang.postman.community.model.User;

/**
 * @author : yang9
 * @Date : 2020/3/17 20:29
 * @Description : yang.postman.community.dto
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;//标题
    private String description;//问题详情
    private Integer creator;//创建人id
    private Long gmt_create;//创建时间
    private Long gmt_modified;//修改时间
    private Integer comment_count;//评论
    private Integer view_count;//浏览
    private Integer like_count;//喜欢
    private String tag;//标签
    private User user;//user对象 1对1
}
