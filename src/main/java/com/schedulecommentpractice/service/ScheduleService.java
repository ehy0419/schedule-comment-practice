package com.schedulecommentpractice.service;

import com.schedulecommentpractice.dto.ScheduleSaveRequest;
import com.schedulecommentpractice.dto.ScheduleSaveResponse;
import com.schedulecommentpractice.entity.Schedule;
import com.schedulecommentpractice.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponse saveSchedule(ScheduleSaveRequest request) {
        Schedule schedule = new Schedule(           // Schedule 의 생성자 부분
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule); // saveSchedule 는 schedule과 구분 짓기 위해서
        return new ScheduleSaveResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getAuthor(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()

        );
    }
}
