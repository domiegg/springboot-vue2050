package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qinfangxinxi;

public interface QinfangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qinfangxinxi record);

    int insertSelective(Qinfangxinxi record);

    Qinfangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qinfangxinxi record);
	
    int updateByPrimaryKey(Qinfangxinxi record);
	public Qinfangxinxi quchongQinfangxinxi(Map<String, Object> qinfangzhu);
	public List<Qinfangxinxi> getAll(Map<String, Object> map);
	public List<Qinfangxinxi> getsyqinfangxinxi1(Map<String, Object> map);
	public List<Qinfangxinxi> getsyqinfangxinxi3(Map<String, Object> map);
	public List<Qinfangxinxi> getsyqinfangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qinfangxinxi> getByPage(Map<String, Object> map);
	public List<Qinfangxinxi> select(Map<String, Object> map);
//	所有List
}

