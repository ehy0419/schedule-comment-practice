package com.schedulecommentpractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {

    private final Long id; // 응답에서 id 있어도 되나??  - db에서 만들어주니까
    private final String comment;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentGetResponse(Long id, String comment, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        // api 응답에 비밀번호 제외.
    }
}
