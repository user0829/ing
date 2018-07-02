<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${basePath}/static/css/url.css"/>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="mynav">
    <ul class="clearfix">
        <li>首页</li>
        <!--<li>-->
            <!--<span class="glyphicon glyphicon-blackboard"></span>-->
            <!--主机管理-->
            <!--<span class="glyphicon glyphicon-remove-sign"></span>-->
        <!--</li>-->
        <!--<li>-->
            <!--<span class="glyphicon glyphicon-envelope"></span>-->
            <!--事件监控-->
            <!--<span class="glyphicon glyphicon-remove-sign"></span>-->
        <!--</li>-->
        <!--<li>-->
            <!--<span class="glyphicon glyphicon-edit"></span>-->
            <!--存储管理-->
            <!--<span class="glyphicon glyphicon-remove-sign"></span>-->
        <!--</li>-->
        <!--<li>-->
            <!--<span class="glyphicon glyphicon-cog"></span>-->
            <!--系统管理-->
            <!--<span class="glyphicon glyphicon-remove-sign"></span>-->
        <!--</li>-->
        <!--<li>-->
            <!--<span class="glyphicon glyphicon-time"></span>-->
            <!--子系统管理-->
            <!--<span class="glyphicon glyphicon-remove-sign"></span>-->
        <!--</li>-->
        <li id="btn" class="active">
            <span class="glyphicon glyphicon-book"></span>
            实例管理
            <span class="glyphicon glyphicon-remove-sign"></span>
        </li>
    </ul>
</div>
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
        <!--<li>-->
            <!--<span class="glyphicon glyphicon-folder-open"></span>-->
            <!--<span>变更</span>-->
        <!--</li>-->
        <li>
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

<!--<div id="info"></div>-->
<div id="podsList">
    <table id="mytable" border="1" style="border-collapse:collapse;border-color: rgb(160,168,176)">
        <tr id="con">
            <th></th>
            <th>英文简称</th>
            <th>应用名称</th>
            <th>数据库用途</th>
            <th>应用节点描述</th>
            <th>应用等级</th>
            <th>灾备等级</th>
            <th>高可用</th>
            <th>主备类型</th>
            <th>IP地址</th>
            <th>VIP地址</th>
            <th>端口号</th>
            <th>域名</th>
            <th>操作系统</th>
            <th>用户名/密码</th>
            <th>MySQL版本</th>
            <th>全备时间</th>
            <th>备份目录</th>
            <th>物理虚拟</th>
            <th>搭建时间</th>
            <th>物理位置</th>
            <th>cpu</th>
            <th>内存</th>
            <!-- <th>租户</th>
            <th>站点</th>
            <th>业务系统</th>
            <th>子系统</th>
            <th>实例名称</th>
            <th>部署架构</th>
            <th>MySQL版本号</th>
            <th>灾备等级</th>
            <th>性能套餐</th>
            <th>网络区段</th>
            <th>端口</th>
            <th>操作系统版本</th>
            <th>管理状态</th>
            <th>运行状态</th>
            <th>服务状态</th>
            <th>访问URL</th>
            <th>管理</th>
            <th>监控</th> -->
        </tr>
        <!--<tr id="con">-->

        <!--</tr>-->
    </table>
</div>
</body>
<script src="js/jquery.js"></script>
<!-- <script type="text/javascript">
    $(function(){
        $.ajax({
            url:"new_do.php",
            type:"post",
            async:true,
            dataType:"json",
            success:function(data){
                var con="";
                con=data.yw;
                console.log(con);
            }
        })
    })
</script> -->
<script type="text/javascript">
    $(function(){
        $.ajax({
            type:'post',
//            url:'http://192.168.234.130:8080/api/v1/pods',
            url:'pods.json',
            async:true,
//            jsonp:'jsoncallback',
            params:{"contentType": "application/json;charset=utf-8"},
            //data:{name:name},
            dataType:'json',
            success:function(data){
                var con="";
//                $("#info").html(data);
                console.log(data.items.length);
                for(i=0;i<=data.items.length;i++){
                    con="<td>"+data.items[i].metadata.name+"</td>";
                    con1="<td>"+data.items[i].metadata.namespace+"</td>";
                    con2="<td>"+data.items[i].metadata.resourceVersion+"</td>";
                    con3="<td>"+data.items[i].metadata.uid+"</td>";
                    con4="<td>"+data.items[i].metadata.selfLink+"</td>";
                    con5="<td>"+data.items[i].metadata.creationTimestamp+"</td>";
                    con6="<td>"+data.items[i].status.podIP+"</td>";
                    con7="<td>"+data.items[i].status.startTime+"</td>";
                    $("#mytable").append("<tr>"+"<td><input type='radio' name='radio'/></td>"+con+con1+con2+con3+con4+con5+con6+con7+"<td>已启动</td>"+"</tr>");
                }
            }
        });
    });
</script>
</html>


