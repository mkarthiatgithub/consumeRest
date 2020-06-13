package com.job.restapitest.domain;

public class CommentTest {
    String body;
    int postId;
    int id;
    public CommentTest() {
        this.body = "NewComment";
        this.postId = 3;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CommentTest{" +
                "body='" + body + '\'' +
                ", postId=" + postId +
                ", id=" + id +
                '}';
    }
}
