package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qinfangzhu;

public interface QinfangzhuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qinfangzhu record);

    int insertSelective(Qinfangzhu record);

    Qinfangzhu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qinfangzhu record);
	
    int updateByPrimaryKey(Qinfangzhu record);
	public Qinfangzhu quchongQinfangzhu(Map<String, Object> yonghuming);
	public List<Qinfangzhu> getAll(Map<String, Object> map);
	public List<Qinfangzhu> getsyqinfangzhu1(Map<String, Object> map);
	public List<Qinfangzhu> getsyqinfangzhu3(Map<String, Object> map);
	public List<Qinfangzhu> getsyqinfangzhu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qinfangzhu> getByPage(Map<String, Object> map);
	public List<Qinfangzhu> select(Map<String, Object> map);
//	所有List
}

