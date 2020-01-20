package yang.postman.community.dto;

/**
 * @author : yang9
 * @Date : 2020/1/20 15:20
 * @Description : yang.postman.community.dto
 */
public class GithubUser {
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String bio;

    public GithubUser() {
    }

    public GithubUser(Long id, String name, String bio) {
        this.id = id;
        this.name = name;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
