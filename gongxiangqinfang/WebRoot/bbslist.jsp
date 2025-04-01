<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>在线论坛</title>
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
<% String bk=request.getParameter("bk"); %>
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
                                <tr>
                                  <td width="30" bgcolor="#EBE2FE">序号</td>
                                  <td width="352" bgcolor='#EBE2FE'>标题</td>
                                  <td width="48" bgcolor='#EBE2FE'>类型</td>
                                  <td width="60" bgcolor='#EBE2FE'>发帖人</td>
                                  <td width="130" align="center" bgcolor="#EBE2FE">发布时间</td>
                                  <td width="65" align="center" bgcolor="#EBE2FE">已有回帖</td>
                                </tr>
                                 <% 

  	
    String sqlbbs =  "select * from tiezi where bankuai='"+bk+"' and fid='0' order by issh desc, id desc";
	int bbsi=0;
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;

     %>
                                <tr>
                                  <td width="30"><%=bbsi%></td>
                                  <td><a href="tiezidetail.jsp?id=<%=RS_resultbbs.getString("id") %>"><%
								  if(RS_resultbbs.getString("issh").equals("是"))
								  {
								  %>
								  <img src="bbs/zhiding.png" width="15" height="15" style="padding-top:5px;">
								  <%
								  }
								  %><%=RS_resultbbs.getString("biaoti") %> </a></td>
                                  <td><img src="bbs/<%=RS_resultbbs.getString("leixing") %>.gif" width="18" height="18"></td>
                                  <td><%=RS_resultbbs.getString("faburen") %></td>
                                  <td width="130" align="center"><%=RS_resultbbs.getString("addtime") %></td>
                                  <td width="65" align="center"><%=connDbBean.gettzs((String)RS_resultbbs.getString("id")) %></td>
                                </tr>
	<%
  }
   %>
                            </table></td>
                          </tr>
                          <tr>
                            <td align="right"><a href="tieziadd.jsp?bk=<%=bk%>">我要发帖</a> <a href="bbs.jsp" onClick="javascript:history.back();">返回</a></td>
                          </tr>
                        </table>
					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
