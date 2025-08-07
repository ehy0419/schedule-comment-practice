package com.schedulecommentpractice.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponse {
    /// 일정 수정 - 제목, 작성자명만 수정 가능
    private final String title;
    private final String author;

    public ScheduleUpdateResponse(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
