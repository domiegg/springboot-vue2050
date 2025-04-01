package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QinfangxinxiMapper;
import com.entity.Qinfangxinxi;
import com.server.QinfangxinxiServer;
@Service
public class QinfangxinxiServerImpi implements QinfangxinxiServer {
   @Resource
   private QinfangxinxiMapper gdao;
	@Override
	public int add(Qinfangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qinfangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qinfangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qinfangxinxi> getsyqinfangxinxi1(Map<String, Object> map) {
		return gdao.getsyqinfangxinxi1(map);
	}
	public List<Qinfangxinxi> getsyqinfangxinxi2(Map<String, Object> map) {
		return gdao.getsyqinfangxinxi2(map);
	}
	public List<Qinfangxinxi> getsyqinfangxinxi3(Map<String, Object> map) {
		return gdao.getsyqinfangxinxi3(map);
	}
	
	@Override
	public Qinfangxinxi quchongQinfangxinxi(Map<String, Object> account) {
		return gdao.quchongQinfangxinxi(account);
	}

	@Override
	public List<Qinfangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qinfangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qinfangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

