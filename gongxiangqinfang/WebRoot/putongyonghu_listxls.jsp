<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="putongyonghuhsgb" scope="page" class="com.bean.PutongyonghuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=putongyonghu.xls");
%>
<html>
  <head>
    <title>普通用户</title>
  </head>

  <body >
 <%
			String sql="select * from putongyonghu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>用户名</td>    <td align='center'>密码</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td  width='90' align='center'>头像</td>    <td align='center'>手机</td>    <td align='center'>邮箱</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=putongyonghuhsgb.getAllPutongyonghu(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td width='90' align='center'><a href='${u.touxiang}' target='_blank'><img src='${u.touxiang}' width=88 height=99 border=0 /></a></td>    <td>${u.shouji}</td>    <td>${u.youxiang}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

