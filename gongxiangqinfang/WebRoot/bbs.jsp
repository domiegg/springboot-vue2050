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
-->
</style>
</head>

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
                                
								<table border="0" cellpadding="0" bgcolor="#35A2AE" cellspacing="1" style="border-collapse: collapse" bordercolor="#FFFFFF" width="98%" align="center" class="newsline">
                          <% 
    int bbsi=0;
    String sqlbbs =  "select * from bankuai  order by id desc";
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;
     %>
                          <tr bgcolor="#E1F3F4" height="60" valign="middle">
                            <td width="13%" align="center" bgcolor="#FFFFFF"><a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>"><img src="bbs/1.gif" border="0"></a> </td>
                            <td width="37%" align="left" bgcolor="#FFFFFF"><a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>">&nbsp;<%=RS_resultbbs.getString("mingcheng") %>&nbsp;</a> </td>
                            <td width="27%" align="left" bgcolor="#FFFFFF">共有<%=connDbBean.getwzs(RS_resultbbs.getString("mingcheng"))%> 篇文章 </td>
                            <td width="23%" bgcolor="#FFFFFF">版主： <%=RS_resultbbs.getString("banzhu") %> </td>
                          </tr>
                          <%
					   	}
					   %>
                        </table>
					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
