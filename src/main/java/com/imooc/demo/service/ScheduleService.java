package com.imooc.demo.service;

import java.util.List;

import com.imooc.demo.entity.Schedule;

public interface ScheduleService {
	/**
	 * 获取排期列表
	 * 
	 * @return
	 */
	List<Schedule> getScheduleList();

	/**
	 * 通过排期号获取排期信息
	 * 
	 * @param scheduleId
	 * @return
	 */
	Schedule getScheduleById(String scheduleId);

	/**
	 * 增加排期信息
	 * 
	 * @param schedule
	 * @return
	 */
	boolean addSchedule(Schedule schedule);

	/**
	 * 修改排期信息
	 * 
	 * @param schedule
	 * @return
	 */
	boolean modifySchedule(Schedule schedule);

	/**
	 * 删除排期信息
	 * 
	 * @param schedule
	 * @return
	 */
	boolean deleteSchedule(String  scheduleId);
}
