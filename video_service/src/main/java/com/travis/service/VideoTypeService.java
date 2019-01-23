package com.travis.service;

import org.springframework.stereotype.Component;

import com.travis.entity.VideoType;

@Component
public interface VideoTypeService {
	 int deleteByPrimaryKey(Integer typeId);

	    int insert(VideoType record);

	    int insertSelective(VideoType record);

	    VideoType selectByPrimaryKey(Integer typeId);

	    int updateByPrimaryKeySelective(VideoType record);

	    int updateByPrimaryKey(VideoType record);
}
