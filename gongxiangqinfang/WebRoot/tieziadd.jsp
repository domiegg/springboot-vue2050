﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>在线论坛</title>
 <% 
 if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.jsp';</script>");
	return;
}
 String bk=request.getParameter("bk");


%>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
	<script type="text/javascript" src="js/popup.js"></script>
	<script language=javascript src='js/ajax.js'></script>
	<script language="javascript">
function checkform()
{
	var bankuaiobj = document.getElementById("bankuai"); if(bankuaiobj.value==""){document.getElementById("clabelbankuai").innerHTML="&nbsp;&nbsp;<font color=red>请输入版块</font>";return false;}else{document.getElementById("clabelbankuai").innerHTML="  "; } 
	var biaotiobj = document.form1.biaoti; if(biaotiobj.value==""){document.getElementById("clabelbiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入标题</font>";return false;}else{document.getElementById("clabelbiaoti").innerHTML="  "; } 
	
}
popheight="450";
</script>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
	color: #147001;
}
</style>
</head>
 <% 
 if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.jsp';</script>");
	return;
}


%>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
	<script type="text/javascript" src="js/popup.js"></script>
	<script language=javascript src='js/ajax.js'></script>
	<script language="javascript">
function checkform()
{
	var bankuaiobj = document.getElementById("bankuai"); if(bankuaiobj.value==""){document.getElementById("clabelbankuai").innerHTML="&nbsp;&nbsp;<font color=red>请输入版块</font>";return false;}else{document.getElementById("clabelbankuai").innerHTML="  "; } 
	var biaotiobj = document.form1.biaoti; if(biaotiobj.value==""){document.getElementById("clabelbiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入标题</font>";return false;}else{document.getElementById("clabelbiaoti").innerHTML="  "; } 
	
}
popheight="450";
</script>
<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>

<jsp:include page="bht.jsp"></jsp:include>


<div class="center-content">
	<div class="leftbox">
          <div class="c-left">
              <ul><h2>在线论坛/<span>BBS</span></h2></ul>
              <!--<ol>
                  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
				  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
				  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
              </ol>-->
          </div>

          <div class="albaba">
          	<a href="#"><img src="qtimages/alibaba.png" width="250" height="500"/></a>
          </div>
                    <div class="conacts">
                	
					<ul>
                    	<li>公司地址：xxxxxxxxC-xxxxxx室
</li>
                     	<li>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：xxxx</li>
                        <li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：xxx-xxxx xxx-xxxxx</li>
                        <li>传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：0871-xxxxx</li>
                        <li>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：xxxxxxx@163.com
</li>                 
                    </ul>
           </div>
    </div>
    <div class="c-right">
    	<div class="tree-nav">
        	<h2>在线论坛</h2>
            <p><a href="index.do">首页</a>/ 在线论坛</p>
        </div>
<div class="news_content">
                                
								<table width="100%" border="0" align="left" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" class="newsline" style="border-collapse:collapse">
                          <tr>
                            <td height="104" valign="top"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
                                <form action="addTiezi.do" name="form1" method="post"> 
                                  <tr>
                                    <td width="10%">板块：</td>
                                    <td width="90%"><input name='bankuai' type='text' id='bankuai' value="<%=bk%>" readonly="readonly" />
                                      &nbsp;* 
                                      <label id='clabelbankuai' />
                                      </td>
                                  </tr>
                                  <tr>
                                    <td width="10%">标题：</td>
                                    <td width="90%">
                                    <input name='biaoti' type='text'  value='' size='50'  onblur='checkform()'  />
                                      &nbsp;* <label id='clabelbiaoti' /></td>
                                  </tr>
                                  <tr>
                                    <td>类型：</td>
                                    <td><input name="leixing" type="radio" value="putong" checked>
                                        <img src="bbs/putong.gif" width="18" height="18"> 普通
                                      <input type="radio" name="leixing" value="jiaji">
                                        <img src="bbs/jiaji.gif" width="18" height="18"> 加急
                                      <input type="radio" name="leixing" value="qiuzhu">
                                        <img src="bbs/qiuzhu.gif" width="18" height="18"> 求助
                                      <input type="radio" name="leixing" value="tuijian">
                                        <img src="bbs/tuijian.gif" width="15" height="17"> 推荐</td>
                                  </tr>
                                  <tr>
                                    <td>内容：</td>
                                    <td><textarea name='neirong' cols='50' rows='8' id='neirong' ></textarea> <label id='clabelneirong' /></td>
                                  </tr>
                                  <tr>
                                    <td>附件：</td>
                                    <td><input name="fujian" type="text" id="fujian" size="50">
                                     <input type='button' value='上传' onClick="up('fujian')" style='border:solid 1px #000000; color:#666666'/></td>
                                  </tr>
                                  <tr>
                                    <td>发帖人：</td>
                                    <td><input name='faburen' type='text' id='faburen' value='<%=request.getSession().getAttribute("username")%>' /></td>
                                  </tr>
                                  <tr>
                                    <td>&nbsp;</td>
                                    <td>
                                        <input type="submit" name="Submit5" value="提交" onClick="return checkform();"/><input name="fid" type="hidden" id="fid" value="0"> <input name="addtime" type="hidden" id="addtime" value="<%=connDbBean.gettime()%>" />
                                        <input type="reset" name="Submit2" value="重置" /></td>
                                  </tr>
                                </form>
                            </table></td>
                          </tr>
                          <tr>
                            <td align="right"> <a href="bbs.jsp" >返回</a></td>
                          </tr>
                        </table>
					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
