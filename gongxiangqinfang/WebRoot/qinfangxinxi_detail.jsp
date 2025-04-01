<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>琴房信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  琴房信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${qinfangxinxi.bianhao}</td><td  rowspan=8 align=center><a href=${qinfangxinxi.zhaopian} target=_blank><img src=${qinfangxinxi.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>名称：</td><td width='39%'>${qinfangxinxi.mingcheng}</td></tr><tr><td width='11%' height=44>面积：</td><td width='39%'>${qinfangxinxi.mianji}</td></tr><tr><td width='11%' height=44>租金：</td><td width='39%'>${qinfangxinxi.zujin}</td></tr><tr><td width='11%' height=44>地址：</td><td width='39%'>${qinfangxinxi.dizhi}</td></tr><tr><td width='11%' height=44>开始日期：</td><td width='39%'>${qinfangxinxi.kaishiriqi}</td></tr><tr><td width='11%' height=44>结束日期：</td><td width='39%'>${qinfangxinxi.jieshuriqi}</td></tr><tr><td width='11%' height=44>琴房主：</td><td width='39%'>${qinfangxinxi.qinfangzhu}</td></tr><tr><td width='11%' height=100  >乐器情况：</td><td width='39%' colspan=2 height=100 >${qinfangxinxi.leqiqingkuang}</td></tr><tr><td width='11%' height=100  >详情描述：</td><td width='39%' colspan=2 height=100 >${qinfangxinxi.xiangqingmiaoshu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

