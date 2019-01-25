package com.travis.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.travis.entity.VideoInfomation;

@Component
public interface VideoInfomationService {
	   List<VideoInfomation> selectAll(VideoInfomation record);
}
