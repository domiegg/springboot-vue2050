package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qinfangxinxi;

public interface QinfangxinxiServer {

  public int add(Qinfangxinxi po);

  public int update(Qinfangxinxi po);
  
  
  
  public int delete(int id);

  public List<Qinfangxinxi> getAll(Map<String,Object> map);
  public List<Qinfangxinxi> getsyqinfangxinxi1(Map<String,Object> map);
  public List<Qinfangxinxi> getsyqinfangxinxi2(Map<String,Object> map);
  public List<Qinfangxinxi> getsyqinfangxinxi3(Map<String,Object> map);
  public Qinfangxinxi quchongQinfangxinxi(Map<String, Object> acount);

  public Qinfangxinxi getById( int id);

  public List<Qinfangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Qinfangxinxi> select(Map<String, Object> map);
}
//	所有List
