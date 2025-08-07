package com.schedulecommentpractice.controller;

import com.schedulecommentpractice.dto.*;
import com.schedulecommentpractice.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /// lv.1 일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule(
            @RequestBody ScheduleSaveRequest request
    ){
        return ResponseEntity.ok(scheduleService.saveSchedule(request));
    }

    ///  lv2. 일정 조회 중 하나의 api로 작성
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetAllResponse>> getSchedules(
            @RequestParam(required = false) String author
    ) {
        return ResponseEntity.ok(scheduleService.findAll(author));
    }

    // ResponseEntity<ScheduleGetAllResponse> : 인터페이스로 정의됨
    ///  @RequestParam(required = false) 에서
    //(required = false) 빼먹지 않고 넣어야 한다.

    //ResponseEntity<ScheduleGetAllResponse>
    // 전체 조회니까 ResponseEntity<List<ScheduleGetAllResponse>> 으로 변경

    ///  선택 일정 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleGetResponse> getSchedule(
            // 비교
            @PathVariable long scheduleId       // <- null이 절대 오지 않고, 기본형 변수 primitive, 클래스가 아니다.
//            @PathVariable Long scheduleId     // <- null이 될 수 있다
    ) {
        return ResponseEntity.ok(scheduleService.findOne(scheduleId));
    }

    ///  일정 수정
    // 수정이기때문 Put
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponse> updateSchedule(
            @PathVariable long scheduleId,
            @RequestBody ScheduleUpdateRequest request
    ) {
        return ResponseEntity.ok(scheduleService.update(scheduleId, request));
    }

    ///  개발 전, 공통 조건으로
    ///  일정 수정, 삭제 시 선택한 일정의 비밀번호와 요청할 때 함께 보낸 비밀번호가 일치할 경우에만 가능하다.

    ///  일정 삭제 verson 1
    /// 삭제 기능에 심화 과정 중으로 Header 라는 것을 배웁니다.
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable long scheduleId, // password 에 해당하는 내용이 없으면 아무나 삭제가 가능
            @RequestParam String password
            // 사실은 RequestParam은 하면 안된다.
            // 비번이 유출될 위험이 있다.
    ) {
        scheduleService.deleteOne(scheduleId, password);
    }                                   // deleteOne 에 경고
                                        // 서비스에 생성자 생성으로 고고

    // Get, Delete 에서 @RequestBody 가 존재하는가???
    // 원래대로라면 get, delete는 @RequestBody에 사용이 안된다.
    // Post, Put, Patch 에만 사용이 가능했다.
    ///  그런데, 최신 사양에 와서 사용이 가능하다.
    // 하지만 될 때도, 안 될때 있기 때문에
    //  @RequestParam 으로 사용하면.

    ///  일정 삭제 verson 2
//    @PostMapping("/schedules/{scheduleId}/delete")          // delete - 컨트롤메서드
//    public ResponseEntity<ScheduleUpdateResponse> deleteSchedule(
//            @PathVariable long scheduleId,
//            @RequestParam String password
//            // @PostMapping으로 하면 RequestParam은 가능하다.
//    ) {
//        return ResponseEntity.ok(scheduleService.update(scheduleId, request));
//    }

    ///  회원가입 기능을 만든다고 할 때, 메서드는 GET? POST? PUT? PATCH?
    ///  답은 애매한 경우,, POST - 로그인도 가능
    // 가능하면 이것도
    // @PostMapping("/auth/login")
}