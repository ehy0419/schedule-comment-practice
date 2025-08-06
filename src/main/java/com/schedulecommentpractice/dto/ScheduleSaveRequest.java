package com.schedulecommentpractice.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequest {

    ///  주의할 것은 여기에서 생성자를 만들지 않는다. - request
//    private Long id;        // 고유 식별자 id는 db에서 생성해주기 때문에 생략
    private String title;
    private String content;
    private String author;
    private String password;

    // 리퀘스트 에서는 생성자가 없어도 동작을 한다.
    ///  기본생성자 - 생성자가 아무것도 없으면 만들어진다.
    /// 파라미터가 없는 것 - 기본생성자
//    public ScheduleSaveRequest() {}
}

// 내부적으로
// Reflection 이라는 걸 써서 강제로 데이터를 매핑해버린다.
///  테스트 코드에서 배운다.

// setter가 필요없고
// 파라미터를 포함한 생성자도 필요 없다