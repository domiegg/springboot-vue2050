<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="qinfangzhuhsgb" scope="page" class="com.bean.QinfangzhuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=qinfangzhu.xls");
%>
<html>
  <head>
    <title>�ٷ���</title>
  </head>

  <body >
 <%
			String sql="select * from qinfangzhu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�û���</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td  width='40' align='center'>�Ա�</td>    <td align='center'>�ֻ�</td>    <td align='center'>����</td>    <td align='center'>סַ</td>    <td  width='90' align='center'>���֤</td>        <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=qinfangzhuhsgb.getAllQinfangzhu(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.shouji}</td>    <td>${u.youxiang}</td>    <td>${u.zhuzhi}</td>    <td width='90' align='center'><a href='${u.shenfenzheng}' target='_blank'><img src='${u.shenfenzheng}' width=88 height=99 border=0 /></a></td>        <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=qinfangzhu'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

