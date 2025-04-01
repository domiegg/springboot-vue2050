package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YuyuejiluMapper;
import com.entity.Yuyuejilu;
import com.server.YuyuejiluServer;
@Service
public class YuyuejiluServerImpi implements YuyuejiluServer {
   @Resource
   private YuyuejiluMapper gdao;
	@Override
	public int add(Yuyuejilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yuyuejilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Yuyuejilu po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yuyuejilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yuyuejilu> getsyyuyuejilu1(Map<String, Object> map) {
		return gdao.getsyyuyuejilu1(map);
	}
	public List<Yuyuejilu> getsyyuyuejilu2(Map<String, Object> map) {
		return gdao.getsyyuyuejilu2(map);
	}
	public List<Yuyuejilu> getsyyuyuejilu3(Map<String, Object> map) {
		return gdao.getsyyuyuejilu3(map);
	}
	
	@Override
	public Yuyuejilu quchongYuyuejilu(Map<String, Object> account) {
		return gdao.quchongYuyuejilu(account);
	}

	@Override
	public List<Yuyuejilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yuyuejilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yuyuejilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

