package com.schedulecommentpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // 댓글 1~10개는 일정 id 1에 달린 댓글이다.
    private String content;
    private String author;
    private String password;

    /// 댓글을 작성하려면 일정이 있어야 한다.
    private Long scheduleId;            // 일정 id 가 1 일 때,

    public Comment(
            String content,
            String author,
            String password,
            Long scheduleId
    ) {
        this.content = content;
        this.author = password;
        this.password = password;
        this.scheduleId = scheduleId;
    }
}
