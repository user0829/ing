<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${basePath}/static/css/url.css"/>
</head>
<script type="text/javascript">

var name="${name}";
var pass="${pass}";

</script>

<body>
<form action="" method="get" id="myform">
    <span>
        <label>所属站点</label>
        <select>
            <option value="">外高桥</option>
            <option value="">嘉定</option>
        </select>
    </span>
    <span>
        <label>业务代码</label>
        <input type="text"/>
    </span>
    <span>
        <label>管理状态</label>
        <select>
            <option value="">请选择...</option>
        </select>
    </span>
    <input type="submit" value="查询"/>
    <input type="reset" value="重置"/>
</form>
<div class="tab_nav">
    <ul class="clearfix">
        <li>
            <span class="glyphicon glyphicon-play"></span>
            <span>启动</span>
        </li>
        <li>
            <span class="glyphicon glyphicon-pause"></span>
            <span>停止</span>
        </li>
        <li>
            <span class="glyphicon glyphicon-briefcase"></span>
            <span>备份</span>
        </li>
        <li id="deleteExample">
            <span class="glyphicon glyphicon-trash"></span>
            <span>删除</span>
        </li>
        <li>
            <span class="glyphicon glyphicon-cog"></span>
            <span>导出</span>
        </li>
        <li>
            <span class="glyphicon glyphicon-open"></span>
            <span>重建</span>
        </li>
    </ul>
</div>

<div id="podsList">
<c:choose>
<c:when test='${name=="000" }'>
    <table id="mytable0" border="1" style="border-collapse:collapse;border-color: rgb(160,168,176)">
        <tr id="con">
            <th></th>
            <th>英文简称</th>
            <th>应用名称</th>
<!--             <th>数据库用途</th> -->
            <th>应用节点描述</th>
            <!-- <th>应用等级</th>
            <th>灾备等级</th> -->
            <th>高可用</th>
            <th>主备类型</th>
            <th>IP地址</th>
            <th>VIP地址</th>
            <th>端口号</th>
            <th>操作系统</th>
            <th>用户名/密码</th>
            <th>MySQL版本</th>
            <th>全备时间</th>
            <th>备份目录</th>
            <th>物理虚拟</th>
            <th>搭建时间</th>
            <th>物理位置</th>
            <th>cpu-内存</th>
        </tr>
        <tbody>
        <c:forEach items="${listContent}" var="item">
        <tr>
        <td><input type="radio" name="example" value=""/></td>
        <td class="sub_system_code" valueNum="${item.subSystemCode}">${item.subSystemCode}</td>
        <td>${item.systemName}</td>
        <td></td>
        <td></td>
        <td>${item.deployment}</td>
        <td></td>
        <td></td>
        <td>${item.portNum}</td>
        <td>${item.osVersion}</td>
        <td></td>
        <td>${item.mysqlVersion}</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>${item.performanceNeed}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</c:when>
<c:otherwise>
    <table id="mytable1" border="1" style="border-collapse:collapse;border-color: rgb(160,168,176)">
        <tr id="con">
            <th></th>
            <th>英文简称</th>
            <th>应用名称</th>
            <th>数据库用途</th>
            <th>应用节点描述</th>
            <th>IP地址</th>
            <th>VIP地址</th>
            <th>域名</th>
            <th>端口号</th>
            <th>高可用</th>
            <th>主备类型</th>
            <!-- <th>操作系统</th>
            <th>物理虚拟</th>
            <th>MySQL版本</th>
            <th>全备时间</th> -->
        </tr>
        <tbody>
        <c:forEach items="${listContent}" var="item">
        <tr>
        <td><input type="radio" name="example" value=""/></td>
        <td class="sub_system_code" valueNum="${item.subSystemCode}">${item.subSystemCode}</td>
        <td>${item.systemName}</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>${item.databaseDomainName}</td>
        <td>${item.portNum}</td>
        <td></td>
        <td>${item.deployment}</td>
        
        
        </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:otherwise>
    </c:choose>
</div>
<script src="${basePath}/static/js/jquery-1.11.3.min.js"></script>
<script src="${basePath}/static/js/contentList.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
</script>
</body>
</html>