package com.schedulecommentpractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleSaveResponse {     /// API 응답에서는 비밀번호는 제외

    /// ResponseDto 에서는 한 번 객체가 만들어지면 필드를 바꿀 일은 거의 없다.
    /// 그래서 필드에 final을 붙여서 상수를 붙일 수 있다.

    private final Long id;        // 고유 식별자
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    //    private String password;        // API 응답에서는 비밀번호는 제외

    ///  생성자를 통해서 데이터를 넣어줘야 한다.
    public ScheduleSaveResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
