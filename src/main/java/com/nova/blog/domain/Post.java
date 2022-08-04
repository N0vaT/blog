package com.nova.blog.domain;

import javax.persistence.*;

@Entity
@Table( name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "post_title")
    private String postTitle;
    @Column(name = "post_anons")
    private String postAnons;
    @Column(name = "post_full_text")
    private String postFullText;

    public Post() {
    }

    public Post(String postTitle, String postAnons, String postFullText) {
        this.postTitle = postTitle;
        this.postAnons = postAnons;
        this.postFullText = postFullText;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostAnons() {
        return postAnons;
    }

    public void setPostAnons(String postAnons) {
        this.postAnons = postAnons;
    }

    public String getPostFullText() {
        return postFullText;
    }

    public void setPostFullText(String postFullText) {
        this.postFullText = postFullText;
    }
}
