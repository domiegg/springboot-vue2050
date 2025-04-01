package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yonghusixin;

public interface YonghusixinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghusixin record);

    int insertSelective(Yonghusixin record);

    Yonghusixin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yonghusixin record);
	
    int updateByPrimaryKey(Yonghusixin record);
	public Yonghusixin quchongYonghusixin(Map<String, Object> fajianren);
	public List<Yonghusixin> getAll(Map<String, Object> map);
	public List<Yonghusixin> getsyyonghusixin1(Map<String, Object> map);
	public List<Yonghusixin> getsyyonghusixin3(Map<String, Object> map);
	public List<Yonghusixin> getsyyonghusixin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yonghusixin> getByPage(Map<String, Object> map);
	public List<Yonghusixin> select(Map<String, Object> map);
//	所有List
}

