package com.travis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travis.dao.VideoTypeMapper;
import com.travis.entity.VideoType;
import com.travis.service.VideoTypeService;

@Service
public class VideoTypeServiceImpl implements VideoTypeService {

	@Autowired
	private VideoTypeMapper videoTypeMapper;
	
	public int deleteByPrimaryKey(Integer typeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(VideoType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(VideoType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public VideoType selectByPrimaryKey(Integer typeId) {
		// TODO Auto-generated method stub
		return videoTypeMapper.selectByPrimaryKey(typeId);
	}

	public int updateByPrimaryKeySelective(VideoType record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(VideoType record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
