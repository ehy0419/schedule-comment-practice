package com.schedulecommentpractice.repository;

import com.schedulecommentpractice.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
