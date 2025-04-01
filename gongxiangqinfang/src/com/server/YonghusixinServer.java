package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yonghusixin;

public interface YonghusixinServer {

  public int add(Yonghusixin po);

  public int update(Yonghusixin po);
  
  
  
  public int delete(int id);

  public List<Yonghusixin> getAll(Map<String,Object> map);
  public List<Yonghusixin> getsyyonghusixin1(Map<String,Object> map);
  public List<Yonghusixin> getsyyonghusixin2(Map<String,Object> map);
  public List<Yonghusixin> getsyyonghusixin3(Map<String,Object> map);
  public Yonghusixin quchongYonghusixin(Map<String, Object> acount);

  public Yonghusixin getById( int id);

  public List<Yonghusixin> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yonghusixin> select(Map<String, Object> map);
}
//	所有List
