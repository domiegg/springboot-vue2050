<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>设置预约记录</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
//islbd1q 
   %>
<script language="javascript">

function gows()
{
	document.location.href="yuyuejilu_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateYuyuejilu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">设置预约记录<input type="hidden" name="id" value="${yuyuejilu.id}" /></td>
						</tr>
						<tr style='display:none'><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr style='display:none'><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr style='display:none'><td width="200">租金：</td><td><input name='zujin' type='text' id='zujin' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr style='display:none'><td width="200">开始日期：</td><td><input name='kaishiriqi' type='text' id='kaishiriqi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr style='display:none'><td width="200">结束日期：</td><td><input name='jieshuriqi' type='text' id='jieshuriqi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr style='display:none'><td width="200">琴房主：</td><td><input name='qinfangzhu' type='text' id='qinfangzhu' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr style='display:none'><td width="200">预约日期：</td><td><input name='yuyueriqi' type='text' id='yuyueriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelyuyueriqi' /></td></tr>		<tr style='display:none'><td width="200">预约时段：</td><td><select name='yuyueshiduan' id='yuyueshiduan'><option value="8:30-10:00">8:30-10:00</option><option value="10:00-11:30">10:00-11:30</option><option value="13:00-14:30">13:00-14:30</option><option value="14:30-16:00">14:30-16:00</option></select>&nbsp;*<label id='clabelyuyueshiduan' /></td></tr>		<tr ><td width="200">预约状态：</td><td><select name='yuyuezhuangtai' id='yuyuezhuangtai'><option value="待确认">待确认</option><option value="已确认">已确认</option><option value="已拒绝">已拒绝</option></select></td></tr>		<tr style='display:none'0><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr style='display:none'1><td width="200">预约人：</td><td><input name='yuyueren' type='text' id='yuyueren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${yuyuejilu.bianhao}';</script>	<script language="javascript">document.form1.mingcheng.value='${yuyuejilu.mingcheng}';</script>	<script language="javascript">document.form1.zujin.value='${yuyuejilu.zujin}';</script>	<script language="javascript">document.form1.kaishiriqi.value='${yuyuejilu.kaishiriqi}';</script>	<script language="javascript">document.form1.jieshuriqi.value='${yuyuejilu.jieshuriqi}';</script>	<script language="javascript">document.form1.qinfangzhu.value='${yuyuejilu.qinfangzhu}';</script>	<script language="javascript">document.form1.yuyueriqi.value='${yuyuejilu.yuyueriqi}';</script>	<script language="javascript">document.form1.yuyueshiduan.value='${yuyuejilu.yuyueshiduan}';</script>	<script language="javascript">document.form1.yuyuezhuangtai.value='${yuyuejilu.yuyuezhuangtai}';</script>	<script language="javascript">document.form1.beizhu.value='${yuyuejilu.beizhu}';</script>	<script language="javascript">document.form1.yuyueren.value='${yuyuejilu.yuyueren}';</script>	
					 </table>
			</form>
   </body>
</html>





<script language=javascript >  
 
 function checkform(){  
 
	var yuyueriqiobj = document.getElementById("yuyueriqi"); if(yuyueriqiobj.value==""){document.getElementById("clabelyuyueriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入预约日期</font>";return false;}else{document.getElementById("clabelyuyueriqi").innerHTML="  "; } 	var yuyueshiduanobj = document.getElementById("yuyueshiduan"); if(yuyueshiduanobj.value==""){document.getElementById("clabelyuyueshiduan").innerHTML="&nbsp;&nbsp;<font color=red>请输入预约时段</font>";return false;}else{document.getElementById("clabelyuyueshiduan").innerHTML="  "; } 	if(parseInt(document.form1.yuyueriqi.value)<parseInt(document.form1.kaishiriqi.value)){alert("对不起，预约日期必需大于开始日期");return false;}	


return true;   
}   
popheight=450;
</script>  
