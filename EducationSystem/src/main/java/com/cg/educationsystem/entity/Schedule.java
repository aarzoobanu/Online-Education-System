package com.cg.educationsystem.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule_info")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="schedule_id")
	private int s_id;
	
	@Column(name="trainer_id")
	private int t_id;
	
	@Column(name="course_id")
	private int c_id;
	
	@Column(name="course_name")
	private String c_name;
	
	@Column(name="time_slot")
	private LocalDateTime time_slot;
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public LocalDateTime getTime_slot() {
		return time_slot;
	}
	public void setTime_slot(LocalDateTime zdt1) {
		this.time_slot = zdt1;
	}
	
	

}
