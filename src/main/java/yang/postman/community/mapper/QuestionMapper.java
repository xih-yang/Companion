package yang.postman.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import yang.postman.community.model.Question;

/**
 * @author : yang9
 * @Date : 2020/3/16 11:02
 * @Description : yang.postman.community.mapper
 */
@Mapper
public interface QuestionMapper {
    @Insert("Insert into question (title,description,creator,gmt_create,gmt_modified,tag)values (#{title},#{description},#{creator},#{gmt_create},#{gmt_modified},#{tag})")
    Integer createQuestion(Question question);
}
