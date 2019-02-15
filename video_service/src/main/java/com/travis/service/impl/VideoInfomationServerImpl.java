package com.travis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travis.dao.VideoInfomationMapper;
import com.travis.entity.VideoInfomation;
import com.travis.service.VideoInfomationService;

@Service
public class VideoInfomationServerImpl implements VideoInfomationService{

	@Autowired
	private VideoInfomationMapper mapper;
	public List<VideoInfomation> selectAll(VideoInfomation record) {
		// TODO Auto-generated method stub
		List<VideoInfomation> listVideoInfomation =mapper.selectAll(record);
		return listVideoInfomation;
	}

}
