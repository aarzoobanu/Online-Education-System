package com.cg.educationsystem.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.educationsystem.entity.Schedule;
import com.cg.educationsystem.util.DBUtil;

public class ScheduleServiceImpTest {
	ScheduleServiceImp ssi;
	@Before
	public void setUp() throws Exception {
		ssi=new ScheduleServiceImp();
	}

	@After
	public void tearDown() throws Exception {
		ssi=null;
	}

	@Test
	public void testAdd() {
		Schedule sch=new Schedule();
		sch.setC_id(10);
		sch.setC_name("java");
		sch.setT_id(100);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse("2020-12-12T12:23:23", format);
		sch.setTime_slot(ldt);	
		Schedule schedule=ssi.addSchedule(sch);
		assertEquals(schedule.getC_id(),10);
		assertEquals(schedule.getC_name(),"java");		
		assertEquals(schedule.getT_id(),100);
		assertEquals(schedule.getTime_slot().toString(),"2020-12-12T12:23:23");
		
		
	}
	@Test
	public void testUpdate() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse("2020-12-12T12:23:23", format);
		Schedule schedule=ssi.updateSchedule(23,ldt);
		LocalDateTime dt=schedule.getTime_slot();
		assertEquals(dt.toString(),"2020-12-12T12:23:23");

	}
	@Test
	public void testView() {
		List<Schedule> schedule=ssi.viewSchedule();
		Assert.assertEquals(schedule.get(23).getC_id(), 10);
		Assert.assertEquals(schedule.get(23).getC_name(), "java");
		Assert.assertEquals(schedule.get(23).getT_id(), 100);
		Assert.assertEquals(schedule.get(23).getTime_slot().toString(), "2020-12-12T12:23:23");

	}
}
