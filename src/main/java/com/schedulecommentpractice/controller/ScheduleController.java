package com.schedulecommentpractice.controller;

import com.schedulecommentpractice.dto.ScheduleGetAllResponse;
import com.schedulecommentpractice.dto.ScheduleSaveRequest;
import com.schedulecommentpractice.dto.ScheduleSaveResponse;
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

}

