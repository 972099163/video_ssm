package com.travis.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travis.entity.VideoType;
import com.travis.service.VideoTypeService;

@Controller
@RequestMapping(value="/videoTyperController")
public class VideoTypeController {
	
	@Autowired
	private VideoTypeService videoTypeService;
	private Logger logger=Logger.getLogger(VideoTypeController.class);
	
	
	@RequestMapping(value="/getVideoAll",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String GetVideoTypeAll()
	{
		List<VideoType> listVideoType=videoTypeService.selectAll(null);
		ObjectMapper objMapper=new ObjectMapper();
		String jsonString=null;
		try {
			jsonString= objMapper.writeValueAsString(listVideoType);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e);
		}
		return jsonString;
	}
	
}
