package com.schedulecommentpractice.controller;

import com.schedulecommentpractice.dto.ScheduleSaveRequest;
import com.schedulecommentpractice.dto.ScheduleSaveResponse;
import com.schedulecommentpractice.entity.Schedule;
import com.schedulecommentpractice.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule(
            @RequestBody ScheduleSaveRequest request
    ){
        return ResponseEntity.ok(scheduleService.saveSchedule(request));
    }
}
