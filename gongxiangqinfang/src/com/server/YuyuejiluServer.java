package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yuyuejilu;

public interface YuyuejiluServer {

  public int add(Yuyuejilu po);

  public int update(Yuyuejilu po);
  
  public int updatelb(Yuyuejilu po);
  
  public int delete(int id);

  public List<Yuyuejilu> getAll(Map<String,Object> map);
  public List<Yuyuejilu> getsyyuyuejilu1(Map<String,Object> map);
  public List<Yuyuejilu> getsyyuyuejilu2(Map<String,Object> map);
  public List<Yuyuejilu> getsyyuyuejilu3(Map<String,Object> map);
  public Yuyuejilu quchongYuyuejilu(Map<String, Object> acount);

  public Yuyuejilu getById( int id);

  public List<Yuyuejilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yuyuejilu> select(Map<String, Object> map);
}
//	所有List
