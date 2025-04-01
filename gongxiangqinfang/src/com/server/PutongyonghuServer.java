package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Putongyonghu;

public interface PutongyonghuServer {

  public int add(Putongyonghu po);

  public int update(Putongyonghu po);
  
  
  
  public int delete(int id);

  public List<Putongyonghu> getAll(Map<String,Object> map);
  public List<Putongyonghu> getsyputongyonghu1(Map<String,Object> map);
  public List<Putongyonghu> getsyputongyonghu2(Map<String,Object> map);
  public List<Putongyonghu> getsyputongyonghu3(Map<String,Object> map);
  public Putongyonghu quchongPutongyonghu(Map<String, Object> acount);

  public Putongyonghu getById( int id);

  public List<Putongyonghu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Putongyonghu> select(Map<String, Object> map);
}
//	所有List
