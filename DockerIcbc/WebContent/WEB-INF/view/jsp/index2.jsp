<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>容器与容器云</title>
        <%-- <link rel="shortcut icon" href="${basePath}/images/favicon.ico" type="image/x-icon" /> --%>
		<link rel="stylesheet" type="text/css" href="${basePath}/jquery-easyui/themes/default/easyui.css"/>  
		<link rel="stylesheet" type="text/css" href="${basePath}/jquery-easyui/themes/icon.css"/>  
<!--2个js文件 ,要先引入jquery,然后再引入easyui-->  
		<script src="${basePath}/jquery-easyui/jquery.min.js" type="text/javascript"></script>  
		<script src="${basePath}/jquery-easyui/jquery.easyui.min.js" type="text/javascript"></script>  
		<script src="${basePath}/jquery-easyui/js/index.js" type="text/javascript"></script> 
		 <style>
        .leftNav div p:hover{
            cursor: pointer;
            font-weight: bolder;
        }
    </style>
		 
    </head>  
<body>
<div class="easyui-layout" data-options="fit:true" style="width: 800px;height: 600px;">  
            <!--顶部-->  
            <!-- <div region="north" style="height: 70px;">  
                <h1>XX公司后台</h1>  
            </div> -->  
            <!--左侧菜单start-->  
            <div region="west" title="导航菜单" split="true" style="width: 150px;">  
                <div class="easyui-panel" data-options="fit:true">  
                    <!--手风琴菜单-->  
                    <div class="leftNav easyui-accordion" data-options="multiple:true,fit:true">  
                        <div title="资源管理" style="padding:10px;">
                            <p onclick="addNewTab('DBA配置管理','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/search.png"> DBA配置管理
                            </p>
                        </div>  
                        <div title="业务管理" style="overflow:auto;padding:10px;">
                            <p onclick="addNewTab('系统管理','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/edit_add.png"> 系统管理
                            </p>
                            <p onclick="addNewTab('子系统管理','${basePath}/sendInfo/addConfig.do')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/pencil.png"> 子系统管理
                            </p>
                            <p onclick="addNewTab('实例管理','${basePath}/sendInfo/contentList.do')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/filesave.png"> 实例管理
                            </p>
                            <p onclick="addNewTab('申请审批','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/cut.png"> 申请审批
                            </p>
                            <p onclick="addNewTab('变更审批','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/reload.png"> 变更审批
                            </p>
                        </div>  
                        <div title="监控管理" style="padding:10px;">  
                            <p onclick="addNewTab('客户消息','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/tip.png"> 客户消息
                            </p>
                            <p onclick="addNewTab('我的消息','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/undo.png"> 我的消息
                            </p>
                            <p onclick="addNewTab('广告代理消息','')">
                                <img style="-webkit-user-select: none;" src="${basePath}/jquery-easyui/themes/icons/redo.png"> 广告代理消息
                            </p>  
                        </div>  
                        <div title="日志管理" style="padding:10px;">  
                            <p>Jae world.</p>  
                        </div>  
                        <div title="系统维护" style="padding:10px;">  
                            <p>Jae world.</p>  
                        </div>  
                    </div> 
                    <!--手风琴菜单end-->  
                </div>  
            </div>  
            <!--中间主要区域-->  
            <div data-options="region:'center',split:true,fit:true">  
                <div id="mainTabs" class="easyui-tabs" data-options="fit:true">  
                </div>  
            </div>  
            <!--页脚-->  
            <!-- <div region="south" style="text-align: center;height: 50px;">  
                <h3>XX公司</h3>  
            </div> -->
</body>
</html>