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
}