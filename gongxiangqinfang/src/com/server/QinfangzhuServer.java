package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qinfangzhu;

public interface QinfangzhuServer {

  public int add(Qinfangzhu po);

  public int update(Qinfangzhu po);
  
  
  
  public int delete(int id);

  public List<Qinfangzhu> getAll(Map<String,Object> map);
  public List<Qinfangzhu> getsyqinfangzhu1(Map<String,Object> map);
  public List<Qinfangzhu> getsyqinfangzhu2(Map<String,Object> map);
  public List<Qinfangzhu> getsyqinfangzhu3(Map<String,Object> map);
  public Qinfangzhu quchongQinfangzhu(Map<String, Object> acount);

  public Qinfangzhu getById( int id);

  public List<Qinfangzhu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Qinfangzhu> select(Map<String, Object> map);
}
//	所有List
