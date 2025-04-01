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

import com.entity.Putongyonghu;
import com.server.PutongyonghuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class PutongyonghuController {
	@Resource
	private PutongyonghuServer putongyonghuService;


   
	@RequestMapping("addPutongyonghu.do")
	public String addPutongyonghu(HttpServletRequest request,Putongyonghu putongyonghu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		putongyonghu.setAddtime(time.toString().substring(0, 19));
		putongyonghuService.add(putongyonghu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "putongyonghuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:putongyonghuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdatePutongyonghu.do")
	public String doUpdatePutongyonghu(int id,ModelMap map,Putongyonghu putongyonghu){
		putongyonghu=putongyonghuService.getById(id);
		map.put("putongyonghu", putongyonghu);
		return "putongyonghu_updt";
	}
	
	@RequestMapping("doUpdatePutongyonghu2.do")
	public String doUpdatePutongyonghu2(ModelMap map,Putongyonghu putongyonghu,HttpServletRequest request){
		putongyonghu=putongyonghuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("putongyonghu", putongyonghu);
		return "putongyonghu_updt2";
	}
	
@RequestMapping("updatePutongyonghu2.do")
	public String updatePutongyonghu2(int id,ModelMap map,Putongyonghu putongyonghu){
		putongyonghuService.update(putongyonghu);
		return "redirect:doUpdatePutongyonghu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("putongyonghuDetail.do")
	public String putongyonghuDetail(int id,ModelMap map,Putongyonghu putongyonghu){
		putongyonghu=putongyonghuService.getById(id);
		map.put("putongyonghu", putongyonghu);
		return "putongyonghu_detail";
	}
//	前台详细
	@RequestMapping("ptyhDetail.do")
	public String ptyhDetail(int id,ModelMap map,Putongyonghu putongyonghu){
		putongyonghu=putongyonghuService.getById(id);
		map.put("putongyonghu", putongyonghu);
		return "putongyonghudetail";
	}
//	
	@RequestMapping("updatePutongyonghu.do")
	public String updatePutongyonghu(int id,ModelMap map,Putongyonghu putongyonghu,HttpServletRequest request,HttpSession session){
		putongyonghuService.update(putongyonghu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:putongyonghuList.do";
	}

//	分页查询
	@RequestMapping("putongyonghuList.do")
	public String putongyonghuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Putongyonghu putongyonghu, String yonghuming, String mima, String xingming, String xingbie, String touxiang, String shouji, String youxiang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=putongyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Putongyonghu> list=putongyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "putongyonghu_list";
	}
	
	
	
	@RequestMapping("ptyhList.do")
	public String ptyhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Putongyonghu putongyonghu, String yonghuming, String mima, String xingming, String xingbie, String touxiang, String shouji, String youxiang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=putongyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Putongyonghu> list=putongyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "putongyonghulist";
	}
	
	@RequestMapping("deletePutongyonghu.do")
	public String deletePutongyonghu(int id,HttpServletRequest request){
		putongyonghuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:putongyonghuList.do";
	}
	
	@RequestMapping("quchongPutongyonghu.do")
	public void quchongPutongyonghu(Putongyonghu putongyonghu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", putongyonghu.getYonghuming());
		   System.out.println("yonghuming==="+putongyonghu.getYonghuming());
		   System.out.println("yonghuming222==="+putongyonghuService.quchongPutongyonghu(map));
		   JSONObject obj=new JSONObject();
		   if(putongyonghuService.quchongPutongyonghu(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
