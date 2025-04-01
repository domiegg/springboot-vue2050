package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yuyuejilu;

public interface YuyuejiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuyuejilu record);

    int insertSelective(Yuyuejilu record);

    Yuyuejilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuyuejilu record);
	int updateByPrimaryKeySelectivelb(Yuyuejilu record);
    int updateByPrimaryKey(Yuyuejilu record);
	public Yuyuejilu quchongYuyuejilu(Map<String, Object> yuyueren);
	public List<Yuyuejilu> getAll(Map<String, Object> map);
	public List<Yuyuejilu> getsyyuyuejilu1(Map<String, Object> map);
	public List<Yuyuejilu> getsyyuyuejilu3(Map<String, Object> map);
	public List<Yuyuejilu> getsyyuyuejilu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yuyuejilu> getByPage(Map<String, Object> map);
	public List<Yuyuejilu> select(Map<String, Object> map);
//	所有List
}

