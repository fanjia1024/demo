package com.imooc.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo.entity.Area;
import com.imooc.demo.entity.Schedule;
import com.imooc.demo.entity.Usr;
import com.imooc.demo.service.ScheduleService;
import com.imooc.demo.service.UsrService;

@RestController
@RequestMapping("/paiqi")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	
	
	/**
	 * 获取所有的用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listpaiqi", method = RequestMethod.GET)
	private Map<String, Object> listSchedule() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Schedule> list = new ArrayList<Schedule>();
		// 获取排期列表
		list = scheduleService.getScheduleList();
		modelMap.put("paiqiList", list);
		return modelMap;
	}
	
}
