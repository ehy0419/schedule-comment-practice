package com.schedulecommentpractice.dto;

import lombok.Getter;

@Getter
public class CommentSaveRequest {

    private String comment;
    private String author;
    private String password;
}
