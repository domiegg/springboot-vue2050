package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Qinfangxinxi;
import com.server.QinfangxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QinfangxinxiController {
	@Resource
	private QinfangxinxiServer qinfangxinxiService;


   
	@RequestMapping("addQinfangxinxi.do")
	public String addQinfangxinxi(HttpServletRequest request,Qinfangxinxi qinfangxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qinfangxinxi.setAddtime(time.toString().substring(0, 19));
		qinfangxinxiService.add(qinfangxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qinfangxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qinfangxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQinfangxinxi.do")
	public String doUpdateQinfangxinxi(int id,ModelMap map,Qinfangxinxi qinfangxinxi){
		qinfangxinxi=qinfangxinxiService.getById(id);
		map.put("qinfangxinxi", qinfangxinxi);
		return "qinfangxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("qinfangxinxiDetail.do")
	public String qinfangxinxiDetail(int id,ModelMap map,Qinfangxinxi qinfangxinxi){
		qinfangxinxi=qinfangxinxiService.getById(id);
		map.put("qinfangxinxi", qinfangxinxi);
		return "qinfangxinxi_detail";
	}
//	前台详细
	@RequestMapping("qfxxDetail.do")
	public String qfxxDetail(int id,ModelMap map,Qinfangxinxi qinfangxinxi){
		qinfangxinxi=qinfangxinxiService.getById(id);
		map.put("qinfangxinxi", qinfangxinxi);
		return "qinfangxinxidetail";
	}
//	
	@RequestMapping("updateQinfangxinxi.do")
	public String updateQinfangxinxi(int id,ModelMap map,Qinfangxinxi qinfangxinxi,HttpServletRequest request,HttpSession session){
		qinfangxinxiService.update(qinfangxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qinfangxinxiList.do";
	}

//	分页查询
	@RequestMapping("qinfangxinxiList.do")
	public String qinfangxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qinfangxinxi qinfangxinxi, String bianhao, String mingcheng, String zhaopian, String mianji1,String mianji2, String zujin1,String zujin2, String dizhi, String kaishiriqi1,String kaishiriqi2, String jieshuriqi1,String jieshuriqi2, String leqiqingkuang, String xiangqingmiaoshu, String qinfangzhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(mianji1==null||mianji1.equals("")){pmap.put("mianji1", null);}else{pmap.put("mianji1", mianji1);}
		if(mianji2==null||mianji2.equals("")){pmap.put("mianji2", null);}else{pmap.put("mianji2", mianji2);}
		if(zujin1==null||zujin1.equals("")){pmap.put("zujin1", null);}else{pmap.put("zujin1", zujin1);}
		if(zujin2==null||zujin2.equals("")){pmap.put("zujin2", null);}else{pmap.put("zujin2", zujin2);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(kaishiriqi1==null||kaishiriqi1.equals("")){pmap.put("kaishiriqi1", null);}else{pmap.put("kaishiriqi1", kaishiriqi1);}
		if(kaishiriqi2==null||kaishiriqi2.equals("")){pmap.put("kaishiriqi2", null);}else{pmap.put("kaishiriqi2", kaishiriqi2);}
		if(jieshuriqi1==null||jieshuriqi1.equals("")){pmap.put("jieshuriqi1", null);}else{pmap.put("jieshuriqi1", jieshuriqi1);}
		if(jieshuriqi2==null||jieshuriqi2.equals("")){pmap.put("jieshuriqi2", null);}else{pmap.put("jieshuriqi2", jieshuriqi2);}
		if(leqiqingkuang==null||leqiqingkuang.equals("")){pmap.put("leqiqingkuang", null);}else{pmap.put("leqiqingkuang", leqiqingkuang);}
		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}
		if(qinfangzhu==null||qinfangzhu.equals("")){pmap.put("qinfangzhu", null);}else{pmap.put("qinfangzhu", qinfangzhu);}
		
		int total=qinfangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qinfangxinxi> list=qinfangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qinfangxinxi_list";
	}
	
	@RequestMapping("qinfangxinxiList2.do")
	public String qinfangxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qinfangxinxi qinfangxinxi, String bianhao, String mingcheng, String zhaopian, String mianji1,String mianji2, String zujin1,String zujin2, String dizhi, String kaishiriqi1,String kaishiriqi2, String jieshuriqi1,String jieshuriqi2, String leqiqingkuang, String xiangqingmiaoshu, String qinfangzhu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("qinfangzhu", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(mianji1==null||mianji1.equals("")){pmap.put("mianji1", null);}else{pmap.put("mianji1", mianji1);}
		if(mianji2==null||mianji2.equals("")){pmap.put("mianji2", null);}else{pmap.put("mianji2", mianji2);}
		if(zujin1==null||zujin1.equals("")){pmap.put("zujin1", null);}else{pmap.put("zujin1", zujin1);}
		if(zujin2==null||zujin2.equals("")){pmap.put("zujin2", null);}else{pmap.put("zujin2", zujin2);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(kaishiriqi1==null||kaishiriqi1.equals("")){pmap.put("kaishiriqi1", null);}else{pmap.put("kaishiriqi1", kaishiriqi1);}
		if(kaishiriqi2==null||kaishiriqi2.equals("")){pmap.put("kaishiriqi2", null);}else{pmap.put("kaishiriqi2", kaishiriqi2);}
		if(jieshuriqi1==null||jieshuriqi1.equals("")){pmap.put("jieshuriqi1", null);}else{pmap.put("jieshuriqi1", jieshuriqi1);}
		if(jieshuriqi2==null||jieshuriqi2.equals("")){pmap.put("jieshuriqi2", null);}else{pmap.put("jieshuriqi2", jieshuriqi2);}
		if(leqiqingkuang==null||leqiqingkuang.equals("")){pmap.put("leqiqingkuang", null);}else{pmap.put("leqiqingkuang", leqiqingkuang);}
		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}
		
		
		int total=qinfangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qinfangxinxi> list=qinfangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qinfangxinxi_list2";
	}
	
	
	@RequestMapping("qfxxList.do")
	public String qfxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qinfangxinxi qinfangxinxi, String bianhao, String mingcheng, String zhaopian, String mianji1,String mianji2, String zujin1,String zujin2, String dizhi, String kaishiriqi1,String kaishiriqi2, String jieshuriqi1,String jieshuriqi2, String leqiqingkuang, String xiangqingmiaoshu, String qinfangzhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(mianji1==null||mianji1.equals("")){pmap.put("mianji1", null);}else{pmap.put("mianji1", mianji1);}
		if(mianji2==null||mianji2.equals("")){pmap.put("mianji2", null);}else{pmap.put("mianji2", mianji2);}
		if(zujin1==null||zujin1.equals("")){pmap.put("zujin1", null);}else{pmap.put("zujin1", zujin1);}
		if(zujin2==null||zujin2.equals("")){pmap.put("zujin2", null);}else{pmap.put("zujin2", zujin2);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(kaishiriqi1==null||kaishiriqi1.equals("")){pmap.put("kaishiriqi1", null);}else{pmap.put("kaishiriqi1", kaishiriqi1);}
		if(kaishiriqi2==null||kaishiriqi2.equals("")){pmap.put("kaishiriqi2", null);}else{pmap.put("kaishiriqi2", kaishiriqi2);}
		if(jieshuriqi1==null||jieshuriqi1.equals("")){pmap.put("jieshuriqi1", null);}else{pmap.put("jieshuriqi1", jieshuriqi1);}
		if(jieshuriqi2==null||jieshuriqi2.equals("")){pmap.put("jieshuriqi2", null);}else{pmap.put("jieshuriqi2", jieshuriqi2);}
		if(leqiqingkuang==null||leqiqingkuang.equals("")){pmap.put("leqiqingkuang", null);}else{pmap.put("leqiqingkuang", leqiqingkuang);}
		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}
		if(qinfangzhu==null||qinfangzhu.equals("")){pmap.put("qinfangzhu", null);}else{pmap.put("qinfangzhu", qinfangzhu);}
		
		int total=qinfangxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qinfangxinxi> list=qinfangxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qinfangxinxilisttp";
	}
	
	@RequestMapping("deleteQinfangxinxi.do")
	public String deleteQinfangxinxi(int id,HttpServletRequest request){
		qinfangxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qinfangxinxiList.do";
	}
	
	
}
