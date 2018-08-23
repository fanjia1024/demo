package com.imooc.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo.entity.Area;
import com.imooc.demo.entity.Usr;
import com.imooc.demo.service.UsrService;

@RestController
@RequestMapping("/login")
public class UsrController {
	@Autowired
	private UsrService usrService;
	protected static Logger logger=LoggerFactory.getLogger(UsrController.class);
	
	/**
	 * 登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usrLogin", method = RequestMethod.POST)
	private Map<String, Object> login(@RequestBody Usr usr)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 用户登陆
		String name =usr.getUsrName();
        String pass =usr.getUsrPassword();
        logger.info(name);
        logger.info(pass);
		modelMap.put("success", usrService.verifyUser(usr));
		return modelMap;
	}
	
//	
//    String userLogin(@RequestBody Usr usr,Model model) {
//		
//        boolean verify = usrService.verifyUser(usr);
//       
//        String name =usr.getUsrName();
//        String pass =usr.getUsrPassword();
//        logger.info(name);
//        logger.info(pass);
//        System.out.println(name+"密码是："+pass);
//        if (verify) {
//            String result="1";
//            return result;
//        } else {
//            return "redirect:/notVerify";
//        }
//
//    }
	/**
	 * 获取所有的用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listusr", method = RequestMethod.GET)
	private Map<String, Object> listUsr() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Usr> list = new ArrayList<Usr>();
		// 获取区域列表
		list = usrService.getUsrList();
		modelMap.put("usrList", list);
		return modelMap;
	}
	/**
	 * 通过用户名获取用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getusrbyname", method = RequestMethod.GET)
	private Map<String, Object> getUsrByName(String usrName) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取用户信息
		Usr usr = usrService.getUsrByName(usrName);
		modelMap.put("usr", usr);
		return modelMap;
	}
	/**
	 * 添加用户信息
	 * 
	 * @param usrStr
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/addusr", method = RequestMethod.POST)
	private Map<String, Object> addUsr(@RequestBody Usr usr)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加用户信息
		modelMap.put("success", usrService.addUsr(usr));
		return modelMap;
	}
	/**
	 * 修改区域信息，主要修改名字
	 * 
	 * @param areaStr
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = "/modifyusr", method = RequestMethod.POST)
	private Map<String, Object> modifyUsr(@RequestBody Usr usr)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success",usrService.modifyUsr(usr));
		return modelMap;
	}

	@RequestMapping(value = "/removeusr", method = RequestMethod.GET)
	private Map<String, Object> removeUsr(String usrName) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", usrService.deleteUsr(usrName));
		return modelMap;
	}
	
}
