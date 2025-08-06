package com.schedulecommentpractice.service;

import com.schedulecommentpractice.dto.ScheduleGetAllResponse;
import com.schedulecommentpractice.dto.ScheduleSaveRequest;
import com.schedulecommentpractice.dto.ScheduleSaveResponse;
import com.schedulecommentpractice.entity.Schedule;
import com.schedulecommentpractice.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<ScheduleGetAllResponse> findAll(String author) {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleGetAllResponse> scheduleGetAllResponses = new ArrayList<>();
        if (author == null) {

            new ScheduleGetAllResponse();
        }

        ///  수정일 기준 내림차순을 정렬
        // 첫 번째는 JPA로 정렬하는 방법 ' JPA 수정일 정렬' 으로 검색 해보기
        // 두 번째는 findAll로 찾고 그 후에 정렬하는

        ///  lv2. 일정 조회 과제 중, 작성자명은 조회 조건으로 포함될 수 있고, 포함되지 않을수 있다고 한다.
        ///  findAll(String author)의 의미는???

    }


}
