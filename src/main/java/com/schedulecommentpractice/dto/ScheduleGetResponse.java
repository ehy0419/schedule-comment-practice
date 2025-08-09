package com.schedulecommentpractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ScheduleGetResponse {  // 컨트롤러에.

    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final List<CommentGetResponse> comments;    // CommentGetResponse 에 Comment 는 안된다.
                        // 일정 단건 조회 시, 해당 일정에 등록된 댓글들을 포함하여 함께 응답받기
                        // Comment 안되는 이유
                        // 1. JPA 사용시 버그
                        // 2. 리스폰스 부분에 레포지토리에 있는 클래스가 들어온 것은 좀 거시기해..
                // comment 는 레포지토리에.
                // 서비스를 건너띄고.
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleGetResponse(
            Long id,
            String title,
            String content,
            String author,
            List<CommentGetResponse> comments,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
