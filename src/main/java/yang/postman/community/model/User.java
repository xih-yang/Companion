package yang.postman.community.model;

/**
 * @author : yang9
 * @Date : 2020/1/30 21:37
 * @Description : yang.postman.community.model
 */
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;

    public User() {
    }

    public User(Integer id, String name, String accountId, String token, Long gmt_create, Long gmt_modified) {
        this.id = id;
        this.name = name;
        this.accountId = accountId;
        this.token = token;
        this.gmt_create = gmt_create;
        this.gmt_modified = gmt_modified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountId='" + accountId + '\'' +
                ", token='" + token + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                '}';
    }
}
