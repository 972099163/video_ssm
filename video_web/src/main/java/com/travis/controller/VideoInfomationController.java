package com.travis.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.travis.entity.VideoInfomation;
import com.travis.service.VideoInfomationService;

@Controller
@RequestMapping("/videoInfomationController")
public class VideoInfomationController {
	@Autowired
	private VideoInfomationService videoInfomationService;
	public static Logger logger=Logger.getLogger(VideoInfomationController.class);
	
	@RequestMapping(value="/getVideo",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getVideo(String pageIndex)
	{
		if(null==pageIndex || "".equals(pageIndex))
		{
			return "页码不能为空";
		}
		String jsonString=null;
		Page page=PageHelper.startPage(Integer.parseInt(pageIndex),6);
	
		List<VideoInfomation>listVideoInfomation=videoInfomationService.selectAll(null);
	
		HashMap<String, Object> map=new HashMap();
		map.put("pageCount", page.getPages());
		map.put("current", pageIndex);
		map.put("listVideoInfomation", listVideoInfomation);
			ObjectMapper mapper=new ObjectMapper();
		try {
			
			jsonString=mapper.writeValueAsString(map);
			logger.info(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return jsonString;
	}
	
	@RequestMapping(value="/video_index",produces = "application/json; charset=utf-8")
	public String VideoIndex()
	{
		
		return "/video/video_index";
	}
	
	@RequestMapping(value="/video_add",produces = "application/json; charset=utf-8")
	public String VideoAdd()
	{
		
		return "/video/video_add";
	}
}
