<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>琴房主详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  琴房主详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>用户名：</td><td width='39%'>${qinfangzhu.yonghuming}</td><td  rowspan=7 align=center><a href=${qinfangzhu.shenfenzheng} target=_blank><img src=${qinfangzhu.shenfenzheng} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${qinfangzhu.mima}</td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${qinfangzhu.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${qinfangzhu.xingbie}</td></tr><tr><td width='11%' height=44>手机：</td><td width='39%'>${qinfangzhu.shouji}</td></tr><tr><td width='11%' height=44>邮箱：</td><td width='39%'>${qinfangzhu.youxiang}</td></tr><tr><td width='11%' height=44>住址：</td><td width='39%'>${qinfangzhu.zhuzhi}</td></tr><tr><td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${qinfangzhu.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

