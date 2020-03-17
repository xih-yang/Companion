package yang.postman.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import yang.postman.community.model.User;

/**
 * @author : yang9
 * @Date : 2020/1/30 21:32
 * @Description : yang.postman.community.mapper
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_Id,token,gmt_create,gmt_modified,avatar_url)values (#{name},#{accountId},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User findById(@Param("id")Integer id);
}
