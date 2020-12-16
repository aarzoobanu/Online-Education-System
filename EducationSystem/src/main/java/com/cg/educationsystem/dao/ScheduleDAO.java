package com.cg.educationsystem.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.educationsystem.entity.Schedule;

public interface ScheduleDAO {

	public Schedule addSchedule(Schedule schedule);
	public Schedule updateSchedule(int s_id, LocalDateTime ldt);
	public List<Schedule> viewSchedule();
	

}
