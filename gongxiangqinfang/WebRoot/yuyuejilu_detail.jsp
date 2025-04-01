<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>预约记录详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  预约记录详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${yuyuejilu.bianhao}</td>     <td width='11%'>名称：</td><td width='39%'>${yuyuejilu.mingcheng}</td></tr><tr>     <td width='11%'>租金：</td><td width='39%'>${yuyuejilu.zujin}</td>     <td width='11%'>开始日期：</td><td width='39%'>${yuyuejilu.kaishiriqi}</td></tr><tr>     <td width='11%'>结束日期：</td><td width='39%'>${yuyuejilu.jieshuriqi}</td>     <td width='11%'>琴房主：</td><td width='39%'>${yuyuejilu.qinfangzhu}</td></tr><tr>     <td width='11%'>预约日期：</td><td width='39%'>${yuyuejilu.yuyueriqi}</td>     <td width='11%'>预约时段：</td><td width='39%'>${yuyuejilu.yuyueshiduan}</td></tr><tr>     <td width='11%'>预约状态：</td><td width='39%'>${yuyuejilu.yuyuezhuangtai}</td>     <td width='11%'>备注：</td><td width='39%'>${yuyuejilu.beizhu}</td></tr><tr>     <td width='11%'>预约人：</td><td width='39%'>${yuyuejilu.yuyueren}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

