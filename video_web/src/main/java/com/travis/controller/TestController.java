package com.travis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travis.entity.VideoType;
import com.travis.service.VideoTypeService;

@Controller
@RequestMapping("/testController")
public class TestController {
	
	@Autowired
	private VideoTypeService videoTypeService;
	private static Logger logger=Logger.getLogger(TestController.class);
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(int id,HttpServletRequest request)
	{
		return id+"À²À²";
	}
	
	@RequestMapping(value="/getVideoType", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getVideoType(int id,HttpServletRequest request)
	{
		VideoType videoType=videoTypeService.selectByPrimaryKey(id);
		System.out.println(videoType.toString());
		logger.info(videoType.toString());
		return videoType.toString();
	}
}
