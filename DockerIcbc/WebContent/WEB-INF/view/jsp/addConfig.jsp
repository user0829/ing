<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="${basePath}/static/css/demo1.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/static/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/superui/superui-master/content/ui/global/layer/skin/moon/style.css">
        <link rel="stylesheet" type="text/css" href="${basePath}/superui/superui-master/content/ui/global/layer/skin/moon/style.css">
        <style type="text/css">
        .layui-layer-ico11{
        background:url(${basePath}/superui/superui-master/content/ui/global/layer/skin/moon/default.png) -224px 0 no-repeat;
        }
        .layui-layer-ico22{
        background:url(${basePath}/superui/superui-master/content/ui/global/layer/skin/moon/default.png) -192px 0 no-repeat;
        }
        </style>
</head>
<body>
<div class="container">
    <form method="post">
        <div class="new_sys">
            <p>新增子系统</p>
        </div>
        <div class="basic_con">
            <p>基本配置</p>
        </div>
        <!-- 基本配置 -->
        <div class="con_news clearfix">
            <div class="con_info">
                <!-- 业务系统 -->
                <div class="con_main clearfix">
                    <p>所属业务系统:</p>
                    <input id="system_name" type="text" name="yw_system"/>
                    <!--<select>-->
                        <!--<option value="">请选择...</option>-->
                        <!--<option value="">全渠道批量</option>-->
                        <!--<option value="">转接系统</option>-->
                    <!--</select>-->
                </div>
                <div class="con_main clearfix">
                    <p>子系统名称:</p>
                    <input id="sub_system" type="text" name="name"/>
                </div>
                <!-- 灾备等级 -->
                <div class="con_main clearfix">
                     <p>灾备等级:</p>
                    <select style="background: rgb(235,235,228)" id="disaster_level" name="hageo_sel" readonly disabled="true">
                        <option value="">请选择...</option>
                        <option value="5++/5+级">5++/5+级</option>
                        <option value="5级">5级</option>
                        <option value="4级">4级</option>
                        <option value="3级">3级</option>
                        <option value="2级以下(含2级)">2级以下(含2级)</option>
                    </select>
                </div>
                <!-- 性能套餐 -->
                <div class="con_main clearfix">
                    <p>性能套餐:</p>
                    <select id="performance_need" name="per_sel">
                        <option value="">请选择...</option>
                        <c:forEach items="${indexList}" var="item">
                        <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <!-- MySQL版本 -->
                <div class="con_main clearfix">
                    <p>MySQL版本:</p>
                    <select id="mysql_version" name="mysql_sel">
                        <option value="">请选择...</option>
                        <c:forEach items="${mysqlList}" var="item">
                        <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- 字符集 -->
                <div class="con_main clearfix">
                    <p>字符集:</p>
                    <select id="character_set" name="char_sel">
                    <option value="" selected>请选择...</option>
                    <c:forEach items="${charSet}" var="item">
                        <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <!-- 操作系统版本 -->
                <div class="con_main clearfix">
                    <p>操作系统版本:</p>
                    <select id="os_version" name="linux_sel">
                        <option value="">请选择...</option>
                        <c:forEach items="${osList}" var="item">
                        <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="con_info">
                 <!-- 主库站点 -->
                <div class="con_main clearfix">
                    <p>主库站点:</p>
                    <select id="site" name="site_sel">
                        <option value="">请选择...</option>
                        <c:forEach items="${listSite}" var="item">
                        <option value="${item.site}">${item.site}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="con_main clearfix">
                     <p>英文简称:</p>
                    <input id="sub_system_code" type="text" placeholder="例如:xx_xxx"/>
                </div>
                <!-- 部署架构 -->
                <div class="con_main clearfix">
                     <p>部署架构:</p>
                    <select style="background: rgb(235,235,228)" id="deployment" name="de_art_sel" readonly disabled="true">
                        <option value="">请选择...</option>
                        <option value="一主一异步">一主一异步</option>
                        <option value="一主多从">一主多从</option>
                        <!-- <option value="单实例">单实例</option> -->
                    </select>
                </div>
                <div class="con_main clearfix">
                   <p>实例个数:</p>
                    <input style="background: rgb(235,235,228)" type="text" value="1" readonly disabled="true" name="">
                </div>
                <!-- 端口 -->
                <div class="con_main clearfix">
                    <p>端口:</p>
                    <input id="port" type="text" name="port" value="3306"/>
                </div>
                <!-- 网络区段 -->
                <div class="con_main clearfix" style="width:430px">
                   <p>网络区段:</p>
                   <span>
                   		<input id="segment1"  type="text" name="segmentLeft"/>
                    -
                    <input id="segment2" type="text" name="segmentRight"/>
                   </span>
                    
                </div>
                <!-- 备份时间 -->
                <div class="con_main clearfix">
                    <p>备份时间:</p>
                    <input type="text" name="date">
                </div>
            </div>
        </div>
        <div class="stor_info">
            <p>存储信息</p>
        </div>
        <div class="stor_news clearfix">
            <div class="stor_new_info">
                <div class="stor_main clearfix">
                    <!-- 高端存储 -->
                    <p>数据容量(G):</p>
                    <input id="data_volume" type="text" name="data_cap" placeholder="范围20-1000"/>
                    <i id="hint_data" class="fa fa-question-circle-o" aria-hidden="true"></i>
                    <p class="hint hint_data">取值请填写整数，单位为G，填写建议至少预留20G</p>
                </div>
                <div class="stor_main clearfix">
                    <!-- 高端存储 -->
                    <p>临时容量(G):</p>
                    <input id="temp_volume" type="text" name="tem_cap" placeholder="范围30-1000"/>
                    <i id="hint_tem" class="fa fa-question-circle-o" aria-hidden="true"></i>
                    <p class="hint hint_tem">取值请填写整数，单位为G，对于生产或性能测试环境，建议50G以上。对于功能测试环境，可预留1G</p>
                </div>
            </div>
            <div class="stor_new_info">
                <div class="stor_main clearfix">
                    <!-- 高端存储 -->
                    <p>日志容量(G):</p>
                    <input id="log_volume" type="text" name="log_cap" placeholder="范围50-1000"/>
                    <i id="hint_log" class="fa fa-question-circle-o" aria-hidden="true"></i>
                    <p class="hint hint_log">取值请填写整数，单位为G，建议至少预留30G，其他主要用于存放binlog。按大基线，binlog保留1周，因此要求至少可以存放1周的binlog数据。</p>
                </div>
                <div class="stor_main clearfix">
                    <!-- 低端存储 -->
                    <p>备份容量(G):</p>
                    <input id="backup_volume" type="text" name="backup_cap" placeholder="范围50-1000"/>
                    <i id="hint_backup" class="fa fa-question-circle-o" aria-hidden="true"></i>
                    <p class="hint hint_backup">取值请填写整数，单位为G，每一次全量备份的数据量，计算公式如下：MySQL数据$MYSQL_DATADIR占用空间*1.5+$MYSQL_LOGDIR/innodb_log占用空间*2。</p>
                </div>
            </div>
        </div>
        <div class="db_urlname">
            <p>数据库信息</p>
        </div>
        <div class="db_urlname_news clearfix">
            <div class="db_urlname_info">
                <div class="db_urlname_main clearfix">
                    <p>数据库域名</p>
                    <input id="database_domain_name" type="text" name="db_real" />
                </div>
            </div>
        </div>
        <div class="submit">
            <div class="sub_left">
                <input id="pre" type="button" onclick="submitData()" value="保存" />
            </div>
            <div class="sub_right">
                <input id="cancel" type="reset" value="取消"/>
            </div>
        </div>

    </form>

</div>


<div id="creationSuccess" class="layer-ext-moon clearfix">
    <div class="layui-layer-ico layui-layer-ico11 myico"></div>
    创建成功
</div>
<div id="creationError" class="layer-ext-moon clearfix">
    <div class="layui-layer-ico layui-layer-ico22 myico"></div>
    创建失败
</div>

</body>
<script type="text/javascript" src="${basePath}/static/js/jquery-1.11.3.min.js"></script>
<script src="${basePath}/static/js/jquery.serializeJSON.js"></script>
<script src="${basePath}/static/js/new.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
</script>
</html>


