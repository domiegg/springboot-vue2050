package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.PutongyonghuMapper;
import com.entity.Putongyonghu;
import com.server.PutongyonghuServer;
@Service
public class PutongyonghuServerImpi implements PutongyonghuServer {
   @Resource
   private PutongyonghuMapper gdao;
	@Override
	public int add(Putongyonghu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Putongyonghu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Putongyonghu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Putongyonghu> getsyputongyonghu1(Map<String, Object> map) {
		return gdao.getsyputongyonghu1(map);
	}
	public List<Putongyonghu> getsyputongyonghu2(Map<String, Object> map) {
		return gdao.getsyputongyonghu2(map);
	}
	public List<Putongyonghu> getsyputongyonghu3(Map<String, Object> map) {
		return gdao.getsyputongyonghu3(map);
	}
	
	@Override
	public Putongyonghu quchongPutongyonghu(Map<String, Object> account) {
		return gdao.quchongPutongyonghu(account);
	}

	@Override
	public List<Putongyonghu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Putongyonghu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Putongyonghu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

