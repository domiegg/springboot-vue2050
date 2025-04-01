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

import com.entity.Yonghusixin;
import com.server.YonghusixinServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YonghusixinController {
	@Resource
	private YonghusixinServer yonghusixinService;


   
	@RequestMapping("addYonghusixin.do")
	public String addYonghusixin(HttpServletRequest request,Yonghusixin yonghusixin,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yonghusixin.setAddtime(time.toString().substring(0, 19));
		yonghusixinService.add(yonghusixin);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yonghusixinList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yonghusixinList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYonghusixin.do")
	public String doUpdateYonghusixin(int id,ModelMap map,Yonghusixin yonghusixin){
		yonghusixin=yonghusixinService.getById(id);
		map.put("yonghusixin", yonghusixin);
		return "yonghusixin_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("yonghusixinDetail.do")
	public String yonghusixinDetail(int id,ModelMap map,Yonghusixin yonghusixin){
		yonghusixin=yonghusixinService.getById(id);
		map.put("yonghusixin", yonghusixin);
		return "yonghusixin_detail";
	}
//	前台详细
	@RequestMapping("yhsxDetail.do")
	public String yhsxDetail(int id,ModelMap map,Yonghusixin yonghusixin){
		yonghusixin=yonghusixinService.getById(id);
		map.put("yonghusixin", yonghusixin);
		return "yonghusixindetail";
	}
//	
	@RequestMapping("updateYonghusixin.do")
	public String updateYonghusixin(int id,ModelMap map,Yonghusixin yonghusixin,HttpServletRequest request,HttpSession session){
		yonghusixinService.update(yonghusixin);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yonghusixinList.do";
	}

//	分页查询
	@RequestMapping("yonghusixinList.do")
	public String yonghusixinList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghusixin yonghusixin, String yonghuming, String biaoti, String neirong, String fajianren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}		
		int total=yonghusixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghusixin> list=yonghusixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghusixin_list";
	}
	
	@RequestMapping("yonghusixinList3.do")
	public String yonghusixinList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghusixin yonghusixin, String yonghuming, String biaoti, String neirong, String fajianren,HttpServletRequest request){
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
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		
		
		int total=yonghusixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghusixin> list=yonghusixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghusixin_list3";
	}	@RequestMapping("yonghusixinList2.do")
	public String yonghusixinList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghusixin yonghusixin, String yonghuming, String biaoti, String neirong, String fajianren,HttpServletRequest request){
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
		
		pmap.put("fajianren", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		
		
		int total=yonghusixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghusixin> list=yonghusixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghusixin_list2";
	}	
	
	@RequestMapping("yhsxList.do")
	public String yhsxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghusixin yonghusixin, String yonghuming, String biaoti, String neirong, String fajianren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}		
		int total=yonghusixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghusixin> list=yonghusixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghusixinlist";
	}
	
	@RequestMapping("deleteYonghusixin.do")
	public String deleteYonghusixin(int id,HttpServletRequest request){
		yonghusixinService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yonghusixinList.do";
	}
	
	
}
