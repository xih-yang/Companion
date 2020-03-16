package yang.postman.community.model;

import org.apache.ibatis.annotations.Lang;

/**
 * @author : yang9
 * @Date : 2020/3/16 11:08
 * @Description : yang.postman.community.model 问题
 */
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Integer creator;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;

    public Question() {
    }

    public Question(Integer id, String title, String description, Integer creator, Long gmt_create, Long gmt_modified, Integer comment_count, Integer view_count, Integer like_count, String tag) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.gmt_create = gmt_create;
        this.gmt_modified = gmt_modified;
        this.comment_count = comment_count;
        this.view_count = view_count;
        this.like_count = like_count;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }
}
