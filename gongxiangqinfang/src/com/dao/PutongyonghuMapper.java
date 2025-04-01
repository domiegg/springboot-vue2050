package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Putongyonghu;

public interface PutongyonghuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Putongyonghu record);

    int insertSelective(Putongyonghu record);

    Putongyonghu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Putongyonghu record);
	
    int updateByPrimaryKey(Putongyonghu record);
	public Putongyonghu quchongPutongyonghu(Map<String, Object> yonghuming);
	public List<Putongyonghu> getAll(Map<String, Object> map);
	public List<Putongyonghu> getsyputongyonghu1(Map<String, Object> map);
	public List<Putongyonghu> getsyputongyonghu3(Map<String, Object> map);
	public List<Putongyonghu> getsyputongyonghu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Putongyonghu> getByPage(Map<String, Object> map);
	public List<Putongyonghu> select(Map<String, Object> map);
//	所有List
}

