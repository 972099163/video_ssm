package com.travis.dao;

import com.travis.entity.VideoType;

public interface VideoTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(VideoType record);

    int insertSelective(VideoType record);

    VideoType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(VideoType record);

    int updateByPrimaryKey(VideoType record);
}