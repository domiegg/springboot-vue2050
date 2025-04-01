package com.controller;

import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.entity.Xinwentongzhi;
import com.entity.Yonghuzhuce;
// import com.entity.Putongyonghu;
// import com.entity.Qinfangzhu;
import com.entity.Qinfangxinxi;
//jixacxishxu1

import com.server.XinwentongzhiServer;
import com.server.YonghuzhuceServer;
import com.server.PutongyonghuServer;
import com.server.QinfangzhuServer;
import com.server.QinfangxinxiServer;
//jixacxishxu2

import com.util.PageBean;

@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	// @Resource
	// private PutongyonghuServer putongyonghuServer;
	// @Resource
	// private QinfangzhuServer qinfangzhuServer;
	@Resource
	private QinfangxinxiServer qinfangxinxiServer;
	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Xinwentongzhi> syxinwentongzhi1=xinwentongzhiService.getsyxinwentongzhi1(null);
		List<Xinwentongzhi> syxinwentongzhi2=xinwentongzhiService.getsyxinwentongzhi2(null);
		List<Xinwentongzhi> syxinwentongzhi3=xinwentongzhiService.getsyxinwentongzhi3(null);

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		// List<Putongyonghu> syputongyonghu1=putongyonghuServer.getsyputongyonghu1(null);
		// List<Putongyonghu> syputongyonghu2=putongyonghuServer.getsyputongyonghu2(null);
		// List<Putongyonghu> syputongyonghu3=putongyonghuServer.getsyputongyonghu3(null);
		// List<Qinfangzhu> syqinfangzhu1=qinfangzhuServer.getsyqinfangzhu1(null);
		// List<Qinfangzhu> syqinfangzhu2=qinfangzhuServer.getsyqinfangzhu2(null);
		// List<Qinfangzhu> syqinfangzhu3=qinfangzhuServer.getsyqinfangzhu3(null);
		List<Qinfangxinxi> syqinfangxinxi1=qinfangxinxiServer.getsyqinfangxinxi1(null);
		List<Qinfangxinxi> syqinfangxinxi2=qinfangxinxiServer.getsyqinfangxinxi2(null);
		List<Qinfangxinxi> syqinfangxinxi3=qinfangxinxiServer.getsyqinfangxinxi3(null);
		//jixacxishxu4
		
	    map.put("syxinwentongzhi1", syxinwentongzhi1);
	    map.put("syxinwentongzhi2", syxinwentongzhi2);
	    map.put("syxinwentongzhi3", syxinwentongzhi3);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    // map.put("syputongyonghu1", syputongyonghu1);
	    // map.put("syputongyonghu2", syputongyonghu2);
	    // map.put("syputongyonghu3", syputongyonghu3);
	    // map.put("syqinfangzhu1", syqinfangzhu1);
	    // map.put("syqinfangzhu2", syqinfangzhu2);
	    // map.put("syqinfangzhu3", syqinfangzhu3);
	    map.put("syqinfangxinxi1", syqinfangxinxi1);
	    map.put("syqinfangxinxi2", syqinfangxinxi2);
	    map.put("syqinfangxinxi3", syqinfangxinxi3);
	    //jixacxishxu5

		return "default";
	}

	

	
}
