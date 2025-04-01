<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yuyuejiluhsgb" scope="page" class="com.bean.YuyuejiluBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yuyuejilu.xls");
%>
<html>
  <head>
    <title>预约记录</title>
  </head>

  <body >
 <%
			String sql="select * from yuyuejilu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>名称</td>    <td align='center'>租金</td>    <td align='center'>开始日期</td>    <td align='center'>结束日期</td>    <td align='center'>琴房主</td>    <td  width='65' align='center'>预约日期</td>    <td align='center'>预约时段</td>    <td align='center'>预约状态</td>        <td align='center'>预约人</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=yuyuejiluhsgb.getAllYuyuejilu(14);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.mingcheng}</td>    <td>${u.zujin}</td>    <td>${u.kaishiriqi}</td>    <td>${u.jieshuriqi}</td>    <td>${u.qinfangzhu}</td>    <td>${u.yuyueriqi}</td>    <td>${u.yuyueshiduan}</td>    <td>${u.yuyuezhuangtai}</td>        <td>${u.yuyueren}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=yuyuejilu'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

