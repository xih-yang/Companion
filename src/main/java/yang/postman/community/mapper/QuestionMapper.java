package yang.postman.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yang.postman.community.model.Question;

import java.util.List;

/**
 * @author : yang9
 * @Date : 2020/3/16 11:02
 * @Description : yang.postman.community.mapper
 */
@Mapper
public interface QuestionMapper {
    @Insert("Insert into question (title,description,creator,gmt_create,gmt_modified,tag)values (#{title},#{description},#{creator},#{gmt_create},#{gmt_modified},#{tag})")
    Integer createQuestion(Question question);
    @Select("Select * from question")
    List<Question> queryQuestionList();
}
