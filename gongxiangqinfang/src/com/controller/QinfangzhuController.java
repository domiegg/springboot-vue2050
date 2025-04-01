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

import com.entity.Qinfangzhu;
import com.server.QinfangzhuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QinfangzhuController {
	@Resource
	private QinfangzhuServer qinfangzhuService;


   
	@RequestMapping("addQinfangzhu.do")
	public String addQinfangzhu(HttpServletRequest request,Qinfangzhu qinfangzhu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qinfangzhu.setAddtime(time.toString().substring(0, 19));
		qinfangzhuService.add(qinfangzhu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qinfangzhuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qinfangzhuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQinfangzhu.do")
	public String doUpdateQinfangzhu(int id,ModelMap map,Qinfangzhu qinfangzhu){
		qinfangzhu=qinfangzhuService.getById(id);
		map.put("qinfangzhu", qinfangzhu);
		return "qinfangzhu_updt";
	}
	
	@RequestMapping("doUpdateQinfangzhu2.do")
	public String doUpdateQinfangzhu2(ModelMap map,Qinfangzhu qinfangzhu,HttpServletRequest request){
		qinfangzhu=qinfangzhuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("qinfangzhu", qinfangzhu);
		return "qinfangzhu_updt2";
	}
	
@RequestMapping("updateQinfangzhu2.do")
	public String updateQinfangzhu2(int id,ModelMap map,Qinfangzhu qinfangzhu){
		qinfangzhuService.update(qinfangzhu);
		return "redirect:doUpdateQinfangzhu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("qinfangzhuDetail.do")
	public String qinfangzhuDetail(int id,ModelMap map,Qinfangzhu qinfangzhu){
		qinfangzhu=qinfangzhuService.getById(id);
		map.put("qinfangzhu", qinfangzhu);
		return "qinfangzhu_detail";
	}
//	前台详细
	@RequestMapping("qfzDetail.do")
	public String qfzDetail(int id,ModelMap map,Qinfangzhu qinfangzhu){
		qinfangzhu=qinfangzhuService.getById(id);
		map.put("qinfangzhu", qinfangzhu);
		return "qinfangzhudetail";
	}
//	
	@RequestMapping("updateQinfangzhu.do")
	public String updateQinfangzhu(int id,ModelMap map,Qinfangzhu qinfangzhu,HttpServletRequest request,HttpSession session){
		qinfangzhuService.update(qinfangzhu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qinfangzhuList.do";
	}

//	分页查询
	@RequestMapping("qinfangzhuList.do")
	public String qinfangzhuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qinfangzhu qinfangzhu, String yonghuming, String mima, String xingming, String xingbie, String shouji, String youxiang, String zhuzhi, String shenfenzheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=qinfangzhuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qinfangzhu> list=qinfangzhuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qinfangzhu_list";
	}
	
	
	
	@RequestMapping("qfzList.do")
	public String qfzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qinfangzhu qinfangzhu, String yonghuming, String mima, String xingming, String xingbie, String shouji, String youxiang, String zhuzhi, String shenfenzheng, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(zhuzhi==null||zhuzhi.equals("")){pmap.put("zhuzhi", null);}else{pmap.put("zhuzhi", zhuzhi);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=qinfangzhuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qinfangzhu> list=qinfangzhuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qinfangzhulist";
	}
	
	@RequestMapping("deleteQinfangzhu.do")
	public String deleteQinfangzhu(int id,HttpServletRequest request){
		qinfangzhuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qinfangzhuList.do";
	}
	
	@RequestMapping("quchongQinfangzhu.do")
	public void quchongQinfangzhu(Qinfangzhu qinfangzhu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", qinfangzhu.getYonghuming());
		   System.out.println("yonghuming==="+qinfangzhu.getYonghuming());
		   System.out.println("yonghuming222==="+qinfangzhuService.quchongQinfangzhu(map));
		   JSONObject obj=new JSONObject();
		   if(qinfangzhuService.quchongQinfangzhu(map)!=null){
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
