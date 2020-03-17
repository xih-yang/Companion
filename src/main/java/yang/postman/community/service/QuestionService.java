package yang.postman.community.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import yang.postman.community.dto.QuestionDTO;
import yang.postman.community.mapper.QuestionMapper;
import yang.postman.community.mapper.UserMapper;
import yang.postman.community.model.Question;
import yang.postman.community.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : yang9
 * @Date : 2020/3/17 20:28
 * @Description : yang.postman.community.service
 */
@Service
public class QuestionService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private QuestionMapper questionMapper;

    public List<QuestionDTO> queryQuestionList(){
        List<Question> questionList = questionMapper.queryQuestionList();
        List<QuestionDTO> questionDTOList=new ArrayList<>();//返回值
        QuestionDTO questionDTO = null;//工具类
        for (Question question : questionList) {
            User user=userMapper.findById(question.getCreator());
            questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//工具类赋值将question类的属性赋值到questionDTO中
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
