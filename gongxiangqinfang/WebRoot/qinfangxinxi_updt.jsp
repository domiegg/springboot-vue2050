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
		<TITLE>修改琴房信息</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="xiangqingmiaoshu"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
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
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="qinfangxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateQinfangxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改琴房信息<input type="hidden" name="id" value="${qinfangxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmingcheng' /></td></tr>		<tr ><td width="200">照片：</td><td><input name='zhaopian' type='text' id='zhaopian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zhaopian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">面积：</td><td><input name='mianji' type='text' id='mianji' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelmianji' />必需数字型</td></tr>		<tr ><td width="200">租金：</td><td><input name='zujin' type='text' id='zujin' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelzujin' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">开始日期：</td><td><input name='kaishiriqi' type='text' id='kaishiriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelkaishiriqi' /></td></tr>		<tr ><td width="200">结束日期：</td><td><input name='jieshuriqi' type='text' id='jieshuriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeljieshuriqi' /></td></tr>		<tr ><td width="200">乐器情况：</td><td><textarea name='leqiqingkuang' cols='50' rows='5' id='leqiqingkuang' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr 0><td width="200">详情描述：</td><td><textarea name="xiangqingmiaoshu" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>		<tr 1><td width="200">琴房主：</td><td><input name='qinfangzhu' type='text' id='qinfangzhu' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${qinfangxinxi.bianhao}';</script>	<script language="javascript">document.form1.mingcheng.value='${qinfangxinxi.mingcheng}';</script>	<script language="javascript">document.form1.zhaopian.value='${qinfangxinxi.zhaopian}';</script>	<script language="javascript">document.form1.mianji.value='${qinfangxinxi.mianji}';</script>	<script language="javascript">document.form1.zujin.value='${qinfangxinxi.zujin}';</script>	<script language="javascript">document.form1.dizhi.value='${qinfangxinxi.dizhi}';</script>	<script language="javascript">document.form1.kaishiriqi.value='${qinfangxinxi.kaishiriqi}';</script>	<script language="javascript">document.form1.jieshuriqi.value='${qinfangxinxi.jieshuriqi}';</script>	<script language="javascript">document.form1.leqiqingkuang.value='${qinfangxinxi.leqiqingkuang}';</script>	<script language="javascript">document.form1.xiangqingmiaoshu.value='${qinfangxinxi.xiangqingmiaoshu}';</script>	<script language="javascript">document.form1.qinfangzhu.value='${qinfangxinxi.qinfangzhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var mingchengobj = document.getElementById("mingcheng"); if(mingchengobj.value==""){document.getElementById("clabelmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入名称</font>";return false;}else{document.getElementById("clabelmingcheng").innerHTML="  "; } 	    var zujinobj = document.getElementById("zujin"); if(zujinobj.value==""){document.getElementById("clabelzujin").innerHTML="&nbsp;&nbsp;<font color=red>请输入租金</font>";return false;}else{document.getElementById("clabelzujin").innerHTML="  "; } 	    var kaishiriqiobj = document.getElementById("kaishiriqi"); if(kaishiriqiobj.value==""){document.getElementById("clabelkaishiriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入开始日期</font>";return false;}else{document.getElementById("clabelkaishiriqi").innerHTML="  "; } 	var jieshuriqiobj = document.getElementById("jieshuriqi"); if(jieshuriqiobj.value==""){document.getElementById("clabeljieshuriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入结束日期</font>";return false;}else{document.getElementById("clabeljieshuriqi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
