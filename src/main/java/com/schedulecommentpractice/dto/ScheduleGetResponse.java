package com.schedulecommentpractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ScheduleGetResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final List<CommentGetResponse> comments;    // CommentGetResponse 에 Comment 는 안된다.
                        // 일정 단건 조회 시, 해당 일정에 등록된 댓글들을 포함하여 함께 응답받기
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleGetResponse(
            Long id,
            String title,
            String content,
            String author,
            List<CommentGetResponse> comments,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
