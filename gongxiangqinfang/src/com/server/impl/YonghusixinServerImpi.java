package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YonghusixinMapper;
import com.entity.Yonghusixin;
import com.server.YonghusixinServer;
@Service
public class YonghusixinServerImpi implements YonghusixinServer {
   @Resource
   private YonghusixinMapper gdao;
	@Override
	public int add(Yonghusixin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yonghusixin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yonghusixin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yonghusixin> getsyyonghusixin1(Map<String, Object> map) {
		return gdao.getsyyonghusixin1(map);
	}
	public List<Yonghusixin> getsyyonghusixin2(Map<String, Object> map) {
		return gdao.getsyyonghusixin2(map);
	}
	public List<Yonghusixin> getsyyonghusixin3(Map<String, Object> map) {
		return gdao.getsyyonghusixin3(map);
	}
	
	@Override
	public Yonghusixin quchongYonghusixin(Map<String, Object> account) {
		return gdao.quchongYonghusixin(account);
	}

	@Override
	public List<Yonghusixin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yonghusixin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yonghusixin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

