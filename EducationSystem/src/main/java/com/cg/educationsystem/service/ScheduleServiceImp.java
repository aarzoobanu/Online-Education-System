package com.cg.educationsystem.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.educationsystem.dao.ScheduleDAO;
import com.cg.educationsystem.dao.ScheduleDAOImp;
import com.cg.educationsystem.entity.Schedule;

public class ScheduleServiceImp implements ScheduleService{

	ScheduleDAO dao;
	
	public ScheduleServiceImp() {

	dao= new ScheduleDAOImp();
	
	}
	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return dao.addSchedule(schedule);
	}
	@Override
	public Schedule updateSchedule(int s_id,LocalDateTime ldt) {
		// TODO Auto-generated method stub
		return dao.updateSchedule(s_id,ldt);
	}
	@Override
	public List<Schedule> viewSchedule() {
		// TODO Auto-generated method stub
		return dao.viewSchedule();
	}

}
