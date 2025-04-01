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
 <% 
 if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.jsp';</script>");
	return;
}
String id=request.getParameter("id");

%>
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
 <% 
 if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}

%>
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
                                
								<table width="96%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                      <tr>
                        <td height="104" valign="top">
						
						
						
					
                            <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                              <tr>
                                <td width="13%">标题：</td>
                                <td width="87%"><%=connDbBean.readzd("tiezi","biaoti","id",id)%> &nbsp;<img src="bbs/<%=connDbBean.readzd("tiezi","leixing","id",id)%>.gif" width="18" height="18"> 发帖人：<%=connDbBean.readzd("tiezi","faburen","id",id)%> ：<%=connDbBean.readzd("tiezi","addtime","id",id)%> <%
								if(connDbBean.readzd("tiezi","fujian","id",id).equals(""))
								{}
								else
								{
									out.print("<a href='"+connDbBean.readzd("tiezi","fujian","id",id)+"'>附件下载</a>");
								}
								%></td>
                              </tr>
                              <tr>
                                <td>内容：</td>
                                <td height="100"><%=connDbBean.readzd("tiezi","neirong","id",id)%></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                              </tr>
                            </table>
                        
                        </td>
                      </tr>
                      <tr>
                        <td align="right"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                            <tr>
                              <td colspan="2">已有回帖如下：</td>
                            </tr>
							 <%
							int bbsi=0;
							  String sqlbbs =  "select * from tiezi where fid='"+id+"' order by id desc";
							  ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
								while(RS_resultbbs.next()){
								bbsi++;
								%>
								 <tr>
                              <td width="19%"><p>回复人:<%=RS_resultbbs.getString("faburen") %></p>
                                <p><%=RS_resultbbs.getString("addtime") %></p></td>
                              <td width="81%" height="100"><%=RS_resultbbs.getString("neirong") %></td>
                            </tr>
								<%
								}
							 %>
                            <tr>
                              <td colspan="2">我也来回一个：</td>
                            </tr>
                            <tr>
                              <td colspan="2"><form action="addTiezi.do" name="form1" method="post">
                                  <textarea name="neirong" cols="70" rows="5" id="neirong"></textarea>
                                  <input type="submit" name="Submit" value="回复">
                                  
								  <input name="bankuai" type="hidden" id="bankuai" value="<%=connDbBean.readzd("tiezi","bankuai","id",id)%>"> <input name="faburen" type="hidden" id="faburen" value="<%=request.getSession().getAttribute("username")%>"> <input name="fid" type="hidden" id="fid" value="<%=id%>"> <input name="addtime" type="hidden" id="addtime" value="<%=connDbBean.gettime()%>" />
                              </form></td>
                            </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td align="right"><a href="bbs.jsp" >返回</a></td>
                      </tr>
                    </table>
					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
