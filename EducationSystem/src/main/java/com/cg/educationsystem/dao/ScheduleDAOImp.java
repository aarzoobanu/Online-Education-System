package com.cg.educationsystem.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.cg.educationsystem.entity.Schedule;
import com.cg.educationsystem.util.DBUtil;

public class ScheduleDAOImp implements ScheduleDAO {
	
	
	EntityManager manager;
	public  ScheduleDAOImp() {
		// TODO Auto-generated constructor stub		
		manager= DBUtil.getConnection();
	}
	@Override
	public Schedule addSchedule(Schedule schedule) {
		Logger logger=Logger.getLogger(ScheduleDAOImp.class); 
		logger.info("adding schedule");
		manager.getTransaction().begin();
		manager.persist(schedule);
		manager.getTransaction().commit();
		return schedule;
	}
	@Override
	public Schedule updateSchedule(int s_id,LocalDateTime ldt) {
		Logger logger=Logger.getLogger(ScheduleDAOImp.class); 
		logger.info("updating schedule");
		
		if(manager.find(Schedule.class, s_id) != null) {
		Schedule schedule1 = manager.find(Schedule.class, s_id);

		  manager.getTransaction().begin();
		  schedule1.setTime_slot(ldt);
		  manager.getTransaction().commit();
		return schedule1;
		}else {
			logger.error("Schedule ID not found");
			System.err.println("Schedule ID not found");
			return null;
		}
		
	}
	@Override
	public List<Schedule> viewSchedule() {
		Logger logger=Logger.getLogger(ScheduleDAOImp.class); 
		logger.info("viewing schedule");
		
		TypedQuery<Schedule> query=manager.createQuery("select s from Schedule s",Schedule.class);
		List<Schedule> list=query.getResultList();
		return list;
	}
	
	
}
