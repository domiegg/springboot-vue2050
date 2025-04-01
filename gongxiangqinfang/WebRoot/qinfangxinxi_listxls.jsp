<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="qinfangxinxihsgb" scope="page" class="com.bean.QinfangxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=qinfangxinxi.xls");
%>
<html>
  <head>
    <title>琴房信息</title>
  </head>

  <body >
 <%
			String sql="select * from qinfangxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>名称</td>    <td  width='90' align='center'>照片</td>    <td align='center'>面积</td>    <td align='center'>租金</td>    <td align='center'>地址</td>    <td  width='65' align='center'>开始日期</td>    <td  width='65' align='center'>结束日期</td>            <td align='center'>琴房主</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=qinfangxinxihsgb.getAllQinfangxinxi(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.mingcheng}</td>    <td width='90' align='center'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.mianji}</td>    <td>${u.zujin}</td>    <td>${u.dizhi}</td>    <td>${u.kaishiriqi}</td>    <td>${u.jieshuriqi}</td>            <td>${u.qinfangzhu}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

