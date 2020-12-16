package com.cg.educationsystem.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.educationsystem.entity.Schedule;

public interface ScheduleService {
	public Schedule addSchedule(Schedule schedule);
	public Schedule updateSchedule(int s_id, LocalDateTime ldt2);
	public List<Schedule> viewSchedule();
}
