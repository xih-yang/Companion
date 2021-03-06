package yang.postman.community.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Lang;

/**
 * @author : yang9
 * @Date : 2020/3/16 11:08
 * @Description : yang.postman.community.model 问题
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
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
}
