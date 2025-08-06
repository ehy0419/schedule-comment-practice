package com.schedulecommentpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // 고유 식별자
    private String title;
    private String content;
    private String author;
    private String password;

    ///  BaseEntitiy 에서 상속을 받아서 사용하는 부분
    // 작성일과 수정일 완성.
//    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;
}
