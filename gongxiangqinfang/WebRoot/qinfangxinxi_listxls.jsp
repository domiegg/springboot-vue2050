<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="qinfangxinxihsgb" scope="page" class="com.bean.QinfangxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=qinfangxinxi.xls");
%>
<html>
  <head>
    <title>�ٷ���Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from qinfangxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���</td>    <td align='center'>����</td>    <td  width='90' align='center'>��Ƭ</td>    <td align='center'>���</td>    <td align='center'>���</td>    <td align='center'>��ַ</td>    <td  width='65' align='center'>��ʼ����</td>    <td  width='65' align='center'>��������</td>            <td align='center'>�ٷ���</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

