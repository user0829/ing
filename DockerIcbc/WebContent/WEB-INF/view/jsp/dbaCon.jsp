<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
	<title>DBA配置管理</title>
	<link rel="stylesheet" href="${basePath}/superui/superui-master/content/ui/global/bootstrap/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link href="${basePath}/superui/superui-master/content/ui/global/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<!-- Theme style -->
	<link rel="stylesheet" href="${basePath}/superui/superui-master/content/adminlte/dist/css/AdminLTE.css">
	<link rel="stylesheet" href="${basePath}/superui/superui-master/content/adminlte/dist/css/skins/_all-skins.min.css">
	<link href="${basePath}/superui/superui-master/content/min/css/supershopui.common.min.css" rel="stylesheet"/>

	<link href="${basePath}/superui/superui-master/content/ui/global/bootstrap-switch/css/bootstrap-switch.css" rel="stylesheet" />
	<link href="${basePath}/superui/superui-master/content/ui/global/layer/skin/moon/style.css" rel="stylesheet" />
	<link rel="stylesheet" href="${basePath}/static/css/dbaCon.css">
	

</head>
<body>
<ul id="dbaNav" class="clearfix">
    <li class="fl myactive">mysql版本</li>
    <li class="fl">字符集</li>
    <li class="fl">DBA管理人员</li>
    <li class="fl">部门管理</li>
    <li class="fl">站点信息</li>
    <li class="fl">站点-网络</li>

</ul>


<div class="mybody" style="padding-top: 100px;">
    <!-- DBA管理列表开始 -->
    <!-- mysql版本 -->
    <div class="mytab myshow">
        <table id="mysqlTab" class="tabInfo" border="1" style="text-align: center;margin: 0 auto;">
            <c:forEach items="${listMysql}" var="item">
                        
                        <tr>
                            <td style="padding: 5px 70px;">${item}</td>
                            <td style="padding: 5px 70px;">
                                <a href="###" class="deleteMysqlPort" onclick='deleteMysqlPort(this)' >删除</a>
                            </td>
                        </tr>
                        </c:forEach>
        </table>
        <button id="addMySQLport" class="btn btn-primary">新增</button>
        <div class="myform" id="MySQLportForm">
            <form action="#" method="post" class="form-horizontal" style="text-align: center">
                <div>
                    <label>mysql版本:</label>
                    <input id="mysqlPort" type="text" name="mysqlPort"/>
                    <div class="">
                    <input type="reset" class="btn btn-default" data-dismiss="modal" value="重置">
                    <input id="subPort" type="button" class="btn btn-default" data-dismiss="modal" value="提交">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- 字符集 -->
    <div class="mytab">
        <table id="charTab" class="tabInfo" border="1" style="text-align: center;margin: 0 auto;">
            <tr>
                <th style="padding: 5px 70px;text-align: center">字符集</th>
                <th style="padding: 5px 70px;text-align: center">操作</th>
            </tr>
            <c:forEach items="${listChar}" var="item">
                        <tr>
                            <td style="padding: 5px 70px;">${item}</td>
                            <td style="padding: 5px 70px;">
                                <a href="###" class="deleteCharacter_set" onclick='deleteCharacter(this)'>删除

</a>
                            </td>
                        </tr>
                       </c:forEach>
        </table>
        <button id="addCharacter_set" class="btn btn-primary">新增</button>
        <div class="myform" id="character_setForm">
            <form action="#" method="post" class="form-horizontal" style="text-align: center">
                <div>
                    <label>字符集:</label>
                    <input id="character_set" type="text" name="character_set"/>
                    <div class="">
                        <input type="reset" class="btn btn-default" data-dismiss="modal" value="重置">
                        <input id="subcharacter_set" type="button" class="btn btn-default" data-dismiss="modal" value="提交">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- DBA管理人员 -->
    <div class="mytab">
        <table id="DBAtab" class="tabInfo" border="1" style="text-align: center;margin: 0 auto;">
            <tr>
                <th style="padding: 5px 70px;text-align: center">工号</th>
                <th style="padding: 5px 70px;text-align: center">DBA管理人员</th>
                <th style="padding: 5px 70px;text-align: center">操作</th>
            </tr>
             <c:forEach items="${listDba}" var="item">
                        <tr>
                            <td style="padding: 5px 70px;" class="dbaNum" valueNum="${item.dba_id}">${item.dba_id}

</td>
                            <td style="padding: 5px 70px;">${item.dba_name}</td>
                            <td style="padding: 5px 70px;">
                                <a href="###" class="deleteDBAperson" onclick='deleteDBAperson(this)'>删除</a>
                            </td>
                        </tr>
                       </c:forEach>
        </table>
        <button id="addDBA" class="btn btn-primary">新增</button>
        <div class="myform" id="DBApersonForm">
            <form action="#" method="post" class="form-horizontal">
                <div style="text-align: center">
                    <div>
                        <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                        <input id="DBANum" type="text" name="DBANum"/>
                    </div>
                    <div>
                        <label>DBA管理人员:</label>
                        <input id="DBAperson" type="text" name="DBAperson"/>
                    </div>
                    <div>
                        <input type="reset" class="btn btn-default" data-dismiss="modal" value="重置">
                        <input id="subDBAperson" type="button" class="btn btn-default" data-dismiss="modal" value="提交">
                    </div>
                </div>

            </form>
        </div>
    </div>
    <!-- 部门管理 -->
    <div class="mytab">
        <table id="depTab" class="tabInfo" border="1" style="text-align: center;margin: 0 auto;">
            <tr>
                <th style="padding: 5px 70px;text-align: center">工号</th>
                <th style="padding: 5px 70px;text-align: center">部门</th>
                <th style="padding: 5px 70px;text-align: center">部门管理员</th>
                <th style="padding: 5px 70px;text-align: center">操作</th>
            </tr>
            <c:forEach items="${listPart}" var="item">
                        <tr>
                            <td style="padding: 5px 70px;" class="dep" valueNum="${item.manager_id}">${item.manager_id}</td>
                            <td style="padding: 5px 70px;">${item.depart_name}</td>
                            <td style="padding: 5px 70px;">${item.manager_name}</td>
                            <td style="padding: 5px 70px;">
                                <a href="###" class="deleteDepManager" onclick='deleteDepManager(this)'>删除</a>
                            </td>
                        </tr>
                       </c:forEach>
        </table>
        <button id="addDep" class="btn btn-primary">新增</button>
        <div class="myform" id="depManagerForm">
            <form action="#" method="post" class="form-horizontal">
                <div style="text-align: center">
                    <div>
                        <label>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                        <input id="depNum" type="text" name="depNum"/>
                    </div>
                    <div>
                        <label>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:</label>
                        <input id="dep" type="text" name="dep"/>
                    </div>
                    <div>
                        <label>部门管理员:</label>
                        <input id="depManager" type="text" name="depManager"/>
                    </div>
                    <div>
                        <input type="reset" class="btn btn-default" data-dismiss="modal" value="重置">
                        <input id="subdepManager" type="button" class="btn btn-default" data-dismiss="modal" value="提交">
                    </div>
                </div>

            </form>
        </div>
    </div>
    <!-- 站点信息 -->
    <div class="mytab">
        <table id="siteTab" class="tabInfo" border="1" style="text-align: center;margin: 0 auto;">
            <tr>
                <th style="padding: 5px 70px;text-align: center">站点名称</th>
                <th style="padding: 5px 70px;text-align: center">管理节点IP</th>
                <th style="padding: 5px 70px;text-align: center">端口</th>
                <th style="padding: 5px 70px;text-align: center">备注</th>
                <th style="padding: 5px 70px;text-align: center">操作</th>
            </tr>
            <c:forEach items="${listSite}" var="item">
            <tr>
                <td style="padding: 5px 70px;">${item.site}</td>
                <td style="padding: 5px 70px;" class="dbaNum" valueNum="${item.api_server_ip}">${item.api_server_ip}</td>
                <td style="padding: 5px 70px;">${item.port}</td>
                <td style="padding: 5px 70px;">${item.remark}</td>
                <td style="padding: 5px 70px;">
                    <a href="###" class="deleteSite" onclick="deleteSite(this)">删除</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <button id="addSite" class="btn btn-primary">新增</button>
        <div class="myform" id="siteForm">
            <form action="#" method="post" class="form-horizontal" style="width: 35%;margin: 0 auto;">
                <div>
                    <div>
                        <label style="width: 80px">站点名称:</label>
                        <input id="siteInfo" type="text" name="siteName"/>
                    </div>
                    <div>
                        <label style="width: 80px">管理节点IP:</label>
                        <input id="masterIP" type="text" name="masterIP"/>
                    </div>
                    <div>
                        <label style="width: 80px">端口:</label>
                        <input id="port" type="text" name="port"/>
                    </div>
                    <div>
                        <label style="width: 80px">备注:</label>
                        <input id="remark" type="text" name="remark"/>
                    </div>
                    <div style="text-align: center">
                        <input type="reset" class="btn btn-default" data-dismiss="modal" value="重置">
                        <input id="subSite" type="button" class="btn btn-default" data-dismiss="modal" value="提交">
                    </div>
                </div>

            </form>
        </div>
    </div>
    <!-- 站点网络 -->
    <div class="mytab">
        <table id="colonyTab" class="tabInfo" border="1" style="text-align: center;margin: 0 auto;">
            <tr>
                <th style="padding: 5px 45px;text-align: center">站点名称</th>
                <th style="padding: 5px 45px;text-align: center">起始IP</th>
                <th style="padding: 5px 45px;text-align: center">终止IP</th>
                <th style="padding: 5px 45px;text-align: center">网关</th>
                <th style="padding: 5px 45px;text-align: center">掩码</th>
                <th style="padding: 5px 45px;text-align: center">vlan</th>
                <th style="padding: 5px 45px;text-align: center">操作</th>
            </tr>
            <c:forEach items="${listNetwork}" var="item">
            <tr>
                <td style="padding: 5px 45px;" class="nodeSite" valueNum="${item.site}">${item.site}</td>
                <td style="padding: 5px 45px;" class="nodeIP" valueNum="${item.start_ip}">${item.start_ip}</td>
                <td style="padding: 5px 45px;">${item.end_ip}</td>
                <td style="padding: 5px 45px;">${item.route}</td>
                <td style="padding: 5px 45px;">${item.mask}</td>
                <td style="padding: 5px 45px;">${item.vlan}</td>
                <td style="padding: 5px 45px;">
                    <a href="###" class="deleteColony" onclick="deleteColony(this)">删除</a>
                </td>
            </tr>
            </c:forEach>
           
        </table>
        <button id="addColony" class="btn btn-primary">新增</button>
        <div class="myform" id="colonyForm">
            <form action="#" method="post" class="form-horizontal" style="width: 35%;margin: 0 auto;">
                <div>
                    <div>
                        <label style="width: 80px">站点名称:</label>
                        <input id="siteName" type="text" name="siteName"/>
                    </div>
                    <div>
                        <label style="width: 80px">起始IP:</label>
                        <input id="startIP" type="text" name="startIP"/>
                    </div>
                    <div>
                        <label style="width: 80px">终止IP:</label>
                        <input id="endIP" type="text" name="endIP"/>
                    </div>
                    <div>
                        <label style="width: 80px">网关:</label>
                        <input id="gateway" type="text" name="gateway"/>
                    </div>
                    <div>
                        <label style="width: 80px">掩码:</label>
                        <input id="mask" type="text" name="mask"/>
                    </div>
                    <div>
                        <label style="width: 80px">vlan:</label>
                        <input id="vlan" type="text" name="vlan"/>
                    </div>
                    <div style="text-align: center">
                        <input type="reset" class="btn btn-default" data-dismiss="modal" value="重置">
                        <input id="subColony" type="button" class="btn btn-default" data-dismiss="modal" value="提交">
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>


<div id="formHintSuccess" class="layer-ext-moon clearfix">
    <div class="layui-layer-ico layui-layer-ico1 myico"></div>
    新增成功
</div>
<div id="formHintWarning" class="layer-ext-moon clearfix">
    <div class="layui-layer-ico layui-layer-ico3 myico"></div>
    不能为空
</div>
<div id="deleteSuccess" class="layer-ext-moon clearfix">
    <div class="layui-layer-ico layui-layer-ico1 myico"></div>
    删除成功
</div>
<div id="deleteError" class="layer-ext-moon clearfix">
    <div class="layui-layer-ico layui-layer-ico2 myico"></div>
    删除失败
</div>



</body>
<script src="${basePath}/static/js/jquery-1.11.3.min.js"></script>
<script src="${basePath}/superui/superui-master/content/ui/global/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/superui/superui-master/content/min/js/supershopui.common.js"></script>
<script src="${basePath}/superui/superui-master/content/ui/global/bootstrap-switch/js/bootstrap-switch.js"></script>
<script src="${basePath}/static/js/dbaCon.js"></script>
<script>
var basePath="${basePath}";
</script>
</html>