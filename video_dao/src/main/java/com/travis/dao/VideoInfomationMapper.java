package com.travis.dao;

import java.util.List;

import com.travis.entity.VideoInfomation;

public interface VideoInfomationMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(VideoInfomation record);

    int insertSelective(VideoInfomation record);

    VideoInfomation selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(VideoInfomation record);

    int updateByPrimaryKey(VideoInfomation record);
    List<VideoInfomation> selectAll(VideoInfomation record);
}