package yang.postman.community.dto;

import lombok.Data;

/**
 * @author : yang9
 * @Date : 2020/1/20 10:57
 * @Description : yang.postman.community
 */
@Data
public class AccessTonkenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
