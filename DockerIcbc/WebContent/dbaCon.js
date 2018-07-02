$(function(){
    $("#subPort").click(function(){
        var mysqlPort=$("#mysqlPort").val();
        if(mysqlPort==''){
            alert('不能为空');
            return false;
        }
        $(".mysqlTab").append("<tr><td style='width: 150px;'>"+mysqlPort+"</td><td style='width: 150px;'><a href='#' class='deleteMysqlPort'>删除</a></td></tr>");
        $("#mysqlPort").val("");
        $.ajax({
            type:'post',
            url:'',
            dataType:'json',
            success:function(data){
                if(data.status=='1'){
                    $(".mysqlTab").append("<tr><td style='width: 150px;'>"+mysqlPort+"</td><td style='width: 150px;'><a href='#' class='deleteMysqlPort'>删除</a></td></tr>");
                }
            }
        });
    });
    $("#subcharacter_set").click(function(){
        var character_set=$("#character_set").val();
        if(character_set==''){
            alert('不能为空');
            return false;
        }
        $("#character_set").val("");
        $.ajax({
            type:'post',
            url:'',
            dataType:'json',
            success:function(data){
                if(data.status=='1'){
                    $(".charTab").append("<tr><td style='width: 150px;'>"+character_set+"</td><td style='width: 150px;'><a href='#' class='deleteCharacter_set'>删除</a></td></tr>");
                }
            }
        });
    });
    $("#subDBAperson").click(function(){
        var DBANum=$("#DBANum").val();
        var DBAperson=$("#DBAperson").val();
        if(DBANum=='' || DBAperson==''){
            alert('不能为空');
            return false;
        }
        $(".DBAtab").append("<tr><td style='width: 150px;' class='dbaNum' valueNum='"+DBANum+"'>"+DBANum+"</td><td style='width: 150px;'>"+DBAperson+"</td><td style='width: 150px;'><a href='#' class='deleteDBAperson'>删除</a></td></tr>");
        $("#DBANum").val("");
        $("#DBAperson").val("");
        $.ajax({
            type:'post',
            url:'',
            dataType:'json',
            success:function(data){
                if(data.status=='1'){
                    $(".DBAtab").append("<tr><td style='width: 150px;' class='dbaNum' valueNum='"+DBANum+"'>"+DBANum+"</td><td style='width: 150px;'>"+DBAperson+"</td><td style='width: 150px;'><a href='#' class='deleteDBAperson'>删除</a></td></tr>");
                }
            }
        });
    });
    $("#subdepManager").click(function(){
        var depNum=$("#depNum").val();
        var dep=$("#dep").val();
        var depManager=$("#depManager").val();
        if(depNum=='' || depManager=='' || dep==''){
            alert('不能为空');
            return false;
        }
        $("#depNum").val("");
        $("#dep").val("");
        $("#depManager").val("");
        $.ajax({
            type:'post',
            url:'',
            dataType:'json',
            success:function(data){
                if(data.status=='1'){
                    $(".depTab").append("<tr><td style='width: 150px;'>"+depNum+"</td><td style='width: 150px;'>"+dep+"</td><td style='width: 150px;'>"+depManager+"</td><td style='width: 150px;'><a href='#'>删除</a></td></tr>");
                }
            }
        });
    });

    $("#subColony").click(function(){
        var siteName=$("#siteName").val();
        var colonyName=$("#colonyName").val();
        var segment=$("#segment").val();
        var nodeIP=$("#nodeIP").val();
        var AdapterWatch=$("#AdapterWatch").val();
        if(siteName=='' || colonyName=='' || segment=='' || nodeIP=='' || AdapterWatch==''){
            alert('不能为空');
            return false;
        }
        $("#siteName").val("");
        $("#colonyName").val("");
        $("#segment").val("");
        $("#nodeIP").val("");
        $("#AdapterWatch").val("");
        $.ajax({
            type:'post',
            url:'',
            dataType:'json',
            success:function(data){
                if(data.status=='1'){
                    $(".depTab").append("<tr><td style='width: 150px;'>"+siteName+"</td><td style='width: 150px;'>"+colonyName+"</td><td style='width: 150px;'>"+segment+"</td><td style='width: 150px;'>"+nodeIP+"</td><td style='width: 150px;'>"+AdapterWatch+"</td><td style='width: 150px;'><a href='#'>删除</a></td></tr>");
                }
            }
        });
    });

//    mysql版本
    $(".deleteMysqlPort").click(function(){
        var MysqlPortText=$(this).parents('td').siblings().html();
        console.log(MysqlPortText);
        var data="{'MysqlPort':"+MysqlPortText+"}";
        $.ajax({
            type:'get',
            url:'',
            dataType:'json',
            success:function(data){

            }
        })
    });
//    字符集
    $(".deleteCharacter_set").click(function(){
        var Character_setText=$(this).parents('td').siblings().html();
        console.log(Character_setText);
        var data="{'Character_set':"+Character_setText+"}";
        $.ajax({
            type:'get',
            url:'',
            dataType:'json',
            success:function(data){

            }
        })
    });
//    DBA管理人员
    $(".deleteDBAperson").click(function(){
        var DBApersonText=$(this).parents('td').parents('tr').children('.dbaNum').attr('valueNum');
        console.log(DBApersonText);
        var data="{'DBAperson':"+DBApersonText+"}";
        $.ajax({
            type:'get',
            url:'',
            dataType:'json',
            success:function(data){

            }
        })
    });
//    部门管理员
    $(".deleteDepManager").click(function(){
        var DepManagerText=$(this).parents('td').parents('tr').children('.dep').attr('valueNum');
        console.log(DepManagerText);
        var data="{'Dep':"+DepManagerText+"}";
        $.ajax({
            type:'get',
            url:'',
            dataType:'json',
            success:function(data){

            }
        })
    });
//    集群
    $(".deleteColony").click(function(){
        var ColonyText=$(this).parents('td').parents('tr').children('.nodeIP').attr('valueNum');
        console.log(ColonyText);
        //ColonyText.each(function(){
        //    ColonyNo+= $(this).html()+",";
        //    console.log(ColonyNo);
        //
        //});
        var data="{'siteName':+"+ColonyText+"}";
        //console.log(data);

        $.ajax({
            type:'get',
            url:'',
            dataType:'json',
            success:function(data){

            }
        })
    });
});
