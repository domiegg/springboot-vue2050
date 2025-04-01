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

<title>预约记录</title>

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
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	var yuyueriqiobj = document.getElementById("yuyueriqi"); if(yuyueriqiobj.value==""){document.getElementById("clabelyuyueriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入预约日期</font>";return false;}else{document.getElementById("clabelyuyueriqi").innerHTML="  "; } 
	var yuyueshiduanobj = document.getElementById("yuyueshiduan"); if(yuyueshiduanobj.value==""){document.getElementById("clabelyuyueshiduan").innerHTML="&nbsp;&nbsp;<font color=red>请输入预约时段</font>";return false;}else{document.getElementById("clabelyuyueshiduan").innerHTML="  "; } 
	if(document.form1.yuyueriqi.value<document.form1.kaishiriqi.value){alert("对不起，预约日期必需大于开始日期");return false;}
	if(document.form1.yuyueriqi.value>document.form1.jieshuriqi.value){alert("对不起，预约日期必需小于结束日期");return false;}
	
}
function gow()
{
	document.location.href="yuyuejiluadd.jsp?id=<%=id%>";
}
</script>


<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>

<jsp:include page="bht.jsp"></jsp:include>


<div class="center-content">
	<div class="leftbox">
          <div class="c-left">
              <ul><h2>预约记录/<span>Details</span></h2></ul>
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
        	<h2>预约记录</h2>
            <p><a href="index.do">首页</a>/ 预约记录</p>
        </div>
<div class="news_content">
                                
								<% 




%>

  
<form action="addYuyuejilu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.bianhao.value='<%=connDbBean.readzd("qinfangxinxi","bianhao","id",request.getParameter("id"))%>';document.form1.bianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.mingcheng.value='<%=connDbBean.readzd("qinfangxinxi","mingcheng","id",request.getParameter("id"))%>';document.form1.mingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">租金：</td><td><input name='zujin' type='text' id='zujin' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zujin.value='<%=connDbBean.readzd("qinfangxinxi","zujin","id",request.getParameter("id"))%>';document.form1.zujin.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">开始日期：</td><td><input name='kaishiriqi' type='text' id='kaishiriqi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.kaishiriqi.value='<%=connDbBean.readzd("qinfangxinxi","kaishiriqi","id",request.getParameter("id"))%>';document.form1.kaishiriqi.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">结束日期：</td><td><input name='jieshuriqi' type='text' id='jieshuriqi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.jieshuriqi.value='<%=connDbBean.readzd("qinfangxinxi","jieshuriqi","id",request.getParameter("id"))%>';document.form1.jieshuriqi.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">琴房主：</td><td><input name='qinfangzhu' type='text' id='qinfangzhu' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.qinfangzhu.value='<%=connDbBean.readzd("qinfangxinxi","qinfangzhu","id",request.getParameter("id"))%>';document.form1.qinfangzhu.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">预约日期：</td><td><input name='yuyueriqi' type='text' id='yuyueriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelyuyueriqi' /></td></tr>
		<tr ><td width="200">预约时段：</td><td><select name='yuyueshiduan' id='yuyueshiduan'><option value="8:30-10:00">8:30-10:00</option><option value="10:00-11:30">10:00-11:30</option><option value="13:00-14:30">13:00-14:30</option><option value="14:30-16:00">14:30-16:00</option></select>&nbsp;*<label id='clabelyuyueshiduan' /></td></tr>
		<tr style='display:none'><td width="200">预约状态：</td><td><select name='yuyuezhuangtai' id='yuyuezhuangtai'><option value="待确认">待确认</option><option value="已确认">已确认</option><option value="已拒绝">已拒绝</option></select></td></tr>
		<tr 0><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr 1><td width="200">预约人：</td><td><input name='yuyueren' type='text' id='yuyueren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
			<script language="javascript">popheight = 450;</script>
					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
