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
	<TITLE>预约记录查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">预约记录列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="yuyuejiluList2.do" name="myform" method="post">
									查询   编号：<input name="bianhao" type="text" id="bianhao" style='border:solid 1px #000000; color:#666666' size="12" />  名称：<input name="mingcheng" type="text" id="mingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  琴房主：<input name="qinfangzhu" type="text" id="qinfangzhu" style='border:solid 1px #000000; color:#666666' size="12" />  预约日期：<input name="yuyueriqi1" type="text" id="yuyueriqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="yuyueriqi2" type="text" id="yuyueriqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' /> 预约时段：<select name='yuyueshiduan' id='yuyueshiduan' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="8:30-10:00">8:30-10:00</option><option value="10:00-11:30">10:00-11:30</option><option value="13:00-14:30">13:00-14:30</option><option value="14:30-16:00">14:30-16:00</option></select> 预约状态：<select name='yuyuezhuangtai' id='yuyuezhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="待确认">待确认</option><option value="已确认">已确认</option><option value="已拒绝">已拒绝</option></select>
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>编号</td>
    <td align='center'>名称</td>
    <td align='center'>租金</td>
    <td align='center'>开始日期</td>
    <td align='center'>结束日期</td>
    <td align='center'>琴房主</td>
    <td  width='65' align='center'>预约日期</td>
    <td align='center'>预约时段</td>
    <td align='center'>预约状态</td>
    
    <td align='center'>预约人</td>
    <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.bianhao}</td>
    <td>${u.mingcheng}</td>
    <td>${u.zujin}</td>
    <td>${u.kaishiriqi}</td>
    <td>${u.jieshuriqi}</td>
    <td>${u.qinfangzhu}</td>
    <td>${u.yuyueriqi}</td>
    <td>${u.yuyueshiduan}</td>
    <td>${u.yuyuezhuangtai}</td>
    
    <td>${u.yuyueren}</td>
    <td align='center'>${u.issh} </td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateYuyuejilulb.do?id=${u.id }">预约确认</a>  <a href="deleteYuyuejilu.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="yyjlDetail.do?id=${u.id }" target="_blank">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from yuyuejilu where qinfangzhu='"+(String)request.getSession().getAttribute("username")+"'  ";
				
if(request.getParameter("bianhao")=="" ||request.getParameter("bianhao")==null ){}else{String nbianhao=new String(request.getParameter("bianhao").getBytes("8859_1"));if(nbianhao.contains("?")){nbianhao=request.getParameter("bianhao");}sql=sql+" and bianhao like '%"+nbianhao+"%'";}
if(request.getParameter("mingcheng")=="" ||request.getParameter("mingcheng")==null ){}else{String nmingcheng=new String(request.getParameter("mingcheng").getBytes("8859_1"));if(nmingcheng.contains("?")){nmingcheng=request.getParameter("mingcheng");}sql=sql+" and mingcheng like '%"+nmingcheng+"%'";}
if(request.getParameter("qinfangzhu")=="" ||request.getParameter("qinfangzhu")==null ){}else{String nqinfangzhu=new String(request.getParameter("qinfangzhu").getBytes("8859_1"));if(nqinfangzhu.contains("?")){nqinfangzhu=request.getParameter("qinfangzhu");}sql=sql+" and qinfangzhu like '%"+nqinfangzhu+"%'";}
if (request.getParameter("yuyueriqi1")==""  ||request.getParameter("yuyueriqi1")==null ) {}else{sql=sql+" and yuyueriqi >= '"+request.getParameter("yuyueriqi1")+"'";}
if (request.getParameter("yuyueriqi2")==""  ||request.getParameter("yuyueriqi2")==null ) {}else {sql=sql+" and yuyueriqi <= '"+request.getParameter("yuyueriqi2")+"'";}
if(request.getParameter("yuyueshiduan")=="" ||request.getParameter("yuyueshiduan")==null ){}else{sql=sql+" and yuyueshiduan like '%"+request.getParameter("yuyueshiduan")+"%'";}
if(request.getParameter("yuyuezhuangtai")=="" ||request.getParameter("yuyuezhuangtai")==null ){}else{sql=sql+" and yuyuezhuangtai like '%"+request.getParameter("yuyuezhuangtai")+"%'";}
			sql+=" order by id desc";
double zujinz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zujinz=zujinz+Float.valueOf(RS_result.getString("zujin")).floatValue();

						
						
			 }
			%>
		共计租金:<%=zujinz%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="yuyuejiluList2.do?page=1" >首页</a>
             <a href="yuyuejiluList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="yuyuejiluList2.do?page=${page.page+1 }">下一页</a>
			<a href="yuyuejiluList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
