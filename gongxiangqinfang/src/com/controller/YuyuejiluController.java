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

import com.entity.Yuyuejilu;
import com.server.YuyuejiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YuyuejiluController {
	@Resource
	private YuyuejiluServer yuyuejiluService;


   
	@RequestMapping("addYuyuejilu.do")
	public String addYuyuejilu(HttpServletRequest request,Yuyuejilu yuyuejilu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		String sql="";
		sql="select id from yuyuejilu where 1=1  and bianhao='"+yuyuejilu.getBianhao()+"' and yuyueriqi='"+yuyuejilu.getYuyueriqi()+"' and yuyueshiduan='"+yuyuejilu.getYuyueshiduan()+"'";
		db dbo = new db();
		ResultSet rs=null;
		rs=dbo.executeQuery(sql);
		int tt=0;
		while(rs.next()){

				tt++;
		}

		if(tt>=1)
		{
			
			session.setAttribute("backxx", "已约满！操作失败");
			session.setAttribute("backurl", request.getHeader("Referer"));
			
			//session.setAttribute("backurl", "yuyuejiluList.do");
			
			return "redirect:postback.jsp";
			//return "redirect:yuyuejiluList.do";
		}
		yuyuejilu.setAddtime(time.toString().substring(0, 19));
		yuyuejiluService.add(yuyuejilu);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yuyuejiluList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yuyuejiluList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYuyuejilu.do")
	public String doUpdateYuyuejilu(int id,ModelMap map,Yuyuejilu yuyuejilu){
		yuyuejilu=yuyuejiluService.getById(id);
		map.put("yuyuejilu", yuyuejilu);
		return "yuyuejilu_updt";
	}
	
	
	
	@RequestMapping("doUpdateYuyuejilulb.do")
	public String doUpdateYuyuejilulb(int id,ModelMap map,Yuyuejilu yuyuejilu){
		yuyuejilu=yuyuejiluService.getById(id);
		map.put("yuyuejilu", yuyuejilu);
		return "yuyuejilu_updtlb";
	}
	
@RequestMapping("updateYuyuejilulb.do")
	public String updateYuyuejilulb(int id,ModelMap map,Yuyuejilu yuyuejilu){
		yuyuejiluService.updatelb(yuyuejilu);
		return "redirect:yuyuejiluList.do";
	}
	
//	后台详细
	@RequestMapping("yuyuejiluDetail.do")
	public String yuyuejiluDetail(int id,ModelMap map,Yuyuejilu yuyuejilu){
		yuyuejilu=yuyuejiluService.getById(id);
		map.put("yuyuejilu", yuyuejilu);
		return "yuyuejilu_detail";
	}
//	前台详细
	@RequestMapping("yyjlDetail.do")
	public String yyjlDetail(int id,ModelMap map,Yuyuejilu yuyuejilu){
		yuyuejilu=yuyuejiluService.getById(id);
		map.put("yuyuejilu", yuyuejilu);
		return "yuyuejiludetail";
	}
//	
	@RequestMapping("updateYuyuejilu.do")
	public String updateYuyuejilu(int id,ModelMap map,Yuyuejilu yuyuejilu,HttpServletRequest request,HttpSession session){
		yuyuejiluService.update(yuyuejilu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yuyuejiluList.do";
	}

//	分页查询
	@RequestMapping("yuyuejiluList.do")
	public String yuyuejiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejilu yuyuejilu, String bianhao, String mingcheng, String zujin, String kaishiriqi, String jieshuriqi, String qinfangzhu, String yuyueriqi1,String yuyueriqi2, String yuyueshiduan, String yuyuezhuangtai, String beizhu, String yuyueren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(zujin==null||zujin.equals("")){pmap.put("zujin", null);}else{pmap.put("zujin", zujin);}		if(kaishiriqi==null||kaishiriqi.equals("")){pmap.put("kaishiriqi", null);}else{pmap.put("kaishiriqi", kaishiriqi);}		if(jieshuriqi==null||jieshuriqi.equals("")){pmap.put("jieshuriqi", null);}else{pmap.put("jieshuriqi", jieshuriqi);}		if(qinfangzhu==null||qinfangzhu.equals("")){pmap.put("qinfangzhu", null);}else{pmap.put("qinfangzhu", qinfangzhu);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(yuyueshiduan==null||yuyueshiduan.equals("")){pmap.put("yuyueshiduan", null);}else{pmap.put("yuyueshiduan", yuyueshiduan);}		if(yuyuezhuangtai==null||yuyuezhuangtai.equals("")){pmap.put("yuyuezhuangtai", null);}else{pmap.put("yuyuezhuangtai", yuyuezhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}		
		int total=yuyuejiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejilu> list=yuyuejiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejilu_list";
	}
	
	@RequestMapping("yuyuejiluList3.do")
	public String yuyuejiluList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejilu yuyuejilu, String bianhao, String mingcheng, String zujin, String kaishiriqi, String jieshuriqi, String qinfangzhu, String yuyueriqi1,String yuyueriqi2, String yuyueshiduan, String yuyuezhuangtai, String beizhu, String yuyueren, String issh,HttpServletRequest request){
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
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(zujin==null||zujin.equals("")){pmap.put("zujin", null);}else{pmap.put("zujin", zujin);}		if(kaishiriqi==null||kaishiriqi.equals("")){pmap.put("kaishiriqi", null);}else{pmap.put("kaishiriqi", kaishiriqi);}		if(jieshuriqi==null||jieshuriqi.equals("")){pmap.put("jieshuriqi", null);}else{pmap.put("jieshuriqi", jieshuriqi);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(yuyueshiduan==null||yuyueshiduan.equals("")){pmap.put("yuyueshiduan", null);}else{pmap.put("yuyueshiduan", yuyueshiduan);}		if(yuyuezhuangtai==null||yuyuezhuangtai.equals("")){pmap.put("yuyuezhuangtai", null);}else{pmap.put("yuyuezhuangtai", yuyuezhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=yuyuejiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejilu> list=yuyuejiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejilu_list3";
	}	@RequestMapping("yuyuejiluList2.do")
	public String yuyuejiluList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejilu yuyuejilu, String bianhao, String mingcheng, String zujin, String kaishiriqi, String jieshuriqi, String qinfangzhu, String yuyueriqi1,String yuyueriqi2, String yuyueshiduan, String yuyuezhuangtai, String beizhu, String yuyueren, String issh,HttpServletRequest request){
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
		
		pmap.put("yuyueren", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(zujin==null||zujin.equals("")){pmap.put("zujin", null);}else{pmap.put("zujin", zujin);}		if(kaishiriqi==null||kaishiriqi.equals("")){pmap.put("kaishiriqi", null);}else{pmap.put("kaishiriqi", kaishiriqi);}		if(jieshuriqi==null||jieshuriqi.equals("")){pmap.put("jieshuriqi", null);}else{pmap.put("jieshuriqi", jieshuriqi);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(yuyueshiduan==null||yuyueshiduan.equals("")){pmap.put("yuyueshiduan", null);}else{pmap.put("yuyueshiduan", yuyueshiduan);}		if(yuyuezhuangtai==null||yuyuezhuangtai.equals("")){pmap.put("yuyuezhuangtai", null);}else{pmap.put("yuyuezhuangtai", yuyuezhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=yuyuejiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejilu> list=yuyuejiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejilu_list2";
	}	
	
	@RequestMapping("yyjlList.do")
	public String yyjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejilu yuyuejilu, String bianhao, String mingcheng, String zujin, String kaishiriqi, String jieshuriqi, String qinfangzhu, String yuyueriqi1,String yuyueriqi2, String yuyueshiduan, String yuyuezhuangtai, String beizhu, String yuyueren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(zujin==null||zujin.equals("")){pmap.put("zujin", null);}else{pmap.put("zujin", zujin);}		if(kaishiriqi==null||kaishiriqi.equals("")){pmap.put("kaishiriqi", null);}else{pmap.put("kaishiriqi", kaishiriqi);}		if(jieshuriqi==null||jieshuriqi.equals("")){pmap.put("jieshuriqi", null);}else{pmap.put("jieshuriqi", jieshuriqi);}		if(qinfangzhu==null||qinfangzhu.equals("")){pmap.put("qinfangzhu", null);}else{pmap.put("qinfangzhu", qinfangzhu);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(yuyueshiduan==null||yuyueshiduan.equals("")){pmap.put("yuyueshiduan", null);}else{pmap.put("yuyueshiduan", yuyueshiduan);}		if(yuyuezhuangtai==null||yuyuezhuangtai.equals("")){pmap.put("yuyuezhuangtai", null);}else{pmap.put("yuyuezhuangtai", yuyuezhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}		
		int total=yuyuejiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejilu> list=yuyuejiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejilulist";
	}
	
	@RequestMapping("deleteYuyuejilu.do")
	public String deleteYuyuejilu(int id,HttpServletRequest request){
		yuyuejiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yuyuejiluList.do";
	}
	
	
}
