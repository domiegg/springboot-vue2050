package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QinfangzhuMapper;
import com.entity.Qinfangzhu;
import com.server.QinfangzhuServer;
@Service
public class QinfangzhuServerImpi implements QinfangzhuServer {
   @Resource
   private QinfangzhuMapper gdao;
	@Override
	public int add(Qinfangzhu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qinfangzhu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qinfangzhu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qinfangzhu> getsyqinfangzhu1(Map<String, Object> map) {
		return gdao.getsyqinfangzhu1(map);
	}
	public List<Qinfangzhu> getsyqinfangzhu2(Map<String, Object> map) {
		return gdao.getsyqinfangzhu2(map);
	}
	public List<Qinfangzhu> getsyqinfangzhu3(Map<String, Object> map) {
		return gdao.getsyqinfangzhu3(map);
	}
	
	@Override
	public Qinfangzhu quchongQinfangzhu(Map<String, Object> account) {
		return gdao.quchongQinfangzhu(account);
	}

	@Override
	public List<Qinfangzhu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qinfangzhu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qinfangzhu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

