package com.nothrim.database.models.images;

import com.nothrim.database.models.security.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Notrim on 24.04.2017.
 */

@Entity
@Table(name = "image")
public class Image {
    private Long id;
    private Long imgurAccountId;
    private String url;
    private String title;
    private String imgurId;
    private Long usageCount;
    private Long skipCount;
    private Set<User> users;
    private Set<User> favUsers;
    private Set<User> currentUsers;
    private ApiCall apiCall;

    public Long getImgurAccountId() {
        return imgurAccountId;
    }

    public void setImgurAccountId(Long imgurAccountId) {
        this.imgurAccountId = imgurAccountId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurId() {
        return imgurId;
    }

    public void setImgurId(String imgurId) {
        this.imgurId = imgurId;
    }

    public Long getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Long usageCount) {
        this.usageCount = usageCount;
    }

    public Long getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(Long skipCount) {
        this.skipCount = skipCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "images")
    public Set<User> getUsers() {
        return users;
    }

    @ManyToMany(mappedBy = "favImages")
    public Set<User> getFavUsers() {
        return favUsers;
    }

    public void setFavUsers(Set<User> favUsers) {
        this.favUsers = favUsers;
    }

    @ManyToOne
    @JoinColumn(name = "api_call_id")
    public ApiCall getApiCall() {
        return apiCall;
    }

    public void setApiCall(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "currentImage", cascade = CascadeType.ALL)
    public Set<User> getCurrentUsers() {
        return currentUsers;
    }

    public void setCurrentUsers(Set<User> currentUsers) {
        this.currentUsers = currentUsers;
    }

    @Transient
    public void mapFromJSON(com.nothrim.json.imgur.Image image) {
        setImgurAccountId((long) image.getAccountId());
        setImgurId(image.getId());
        setSkipCount(0L);
        setTitle(image.getTitle());
        setUrl(image.getLink());
        setUsageCount(0L);
    }
}