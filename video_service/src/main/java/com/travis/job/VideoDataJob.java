package com.travis.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travis.entity.VideoInfomation;
import com.travis.service.VideoInfomationService;

@Component("videoData")
public class VideoDataJob {

	Logger logger=Logger.getLogger(VideoDataJob.class);
	@Autowired
	private VideoInfomationService videoInfomationService;
	public void PrintVideoData()
	{
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("videoData:" + sf.format(date));
	List<VideoInfomation> list=	videoInfomationService.selectAll(null);
	logger.info("videoData:" + list.toString());
		
	}
}
