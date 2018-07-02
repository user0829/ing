$(function(){
	
	
	  $("#addMySQLport").click(function(){
	        $("#MySQLportForm").show();
	    });
	    $("#addCharacter_set").click(function(){
	        $("#character_setForm").show();
	    });
	    $("#addDBA").click(function(){
	        $("#DBApersonForm").show();
	    });
	    $("#addDep").click(function(){
	        $("#depManagerForm").show();
	    });
	    $("#addColony").click(function(){
	        $("#colonyForm").show();
	    });
	    $("#addSite").click(function(){
	        $("#siteForm").show();
	    });
	
	
	
	$(".myshow").show();
    $("#dbaNav li").off("click").on("click",function(){
        var index = $(this).index();
        $(this).addClass("myactive").siblings().removeClass("myactive");
        $(".mybody .mytab").eq(index).show().siblings().hide();
    });
	
	
    $("#subPort").click(function(){
        var mysqlPort=$("#mysqlPort").val();
        if(mysqlPort==''){
            /*alert('不能为空');*/
        	$("#formHintWarning").show();
            setTimeout(function(){
                $("#formHintWarning").hide();
                //window.location.reload();
            },2000);
            return false;
        }
        /*$(".mysqlTab").append("<tr><td style='width: 150px;'>"+mysqlPort+"</td><td style='width: 150px;'><a href='#'>删除</a></td></tr>");
        $("#mysqlPort").val("");*/
        var data='{"mysqlVersion":"'+mysqlPort+'"}';
        	data=encodeURI(data);
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/addMysqlVersion.do?data='+data,
            dataType:'json',
            async:true,
            success:function(data){
                if(data.errCode==1){
//                	alert("新增成功！");
                	$("#formHintSuccess").show();
                	setTimeout(function(){
                        $("#formHintSuccess").hide();
                        $("#mysqlTab").append("<tr><td style='padding: 5px 70px;'>"+mysqlPort+"</td><td style='padding: 5px 70px;'><a href='###' onclick='deleteMysqlPort(this)'>删除</a></td></tr>");
                        $("#mysqlPort").val("");
                    },2000);
                    
                }
            }
        });
    });
    $("#subcharacter_set").click(function(){
        var character_set=$("#character_set").val();
        if(character_set==''){
//            alert('不能为空');
        	$("#formHintWarning").show();
            setTimeout(function(){
                $("#formHintWarning").hide();
                //window.location.reload();
            },2000);
            return false;
        }
        var data='{"characterSet":"'+character_set+'"}';
    	data=encodeURI(data);
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/addCharSet.do?data='+data,
            dataType:'json',
            success:function(data){
                if(data.errCode==1){
//                	alert("新增成功！");
                	$("#formHintSuccess").show();
                	setTimeout(function(){
                		$("#formHintSuccess").hide();
                		$("#charTab").append("<tr><td style='padding: 5px 70px;'>"+character_set+"</td><td style='padding: 5px 70px;'><a href='###' onclick='deleteCharacter(this)'>删除</a></td></tr>");
                		$("#character_set").val("");
                	},2000);
                    
                }
            }
        });
    });
    $("#subDBAperson").click(function(){
    	var DBANum=$("#DBANum").val();
        var DBAperson=$("#DBAperson").val();
        if(DBANum=='' || DBAperson==''){
//            alert('不能为空');
        	$("#formHintWarning").show();
            setTimeout(function(){
                $("#formHintWarning").hide();
                //window.location.reload();
            },2000);
            return false;
        }
        var data='{"dbaName":"'+DBAperson+'","dbaId":"'+DBANum+'"}';
    	data=encodeURI(data);
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/addDbaManager.do?data='+data,
            dataType:'json',
            success:function(data){
                if(data.errCode==1){
//                	alert("新增成功！");
                	$("#formHintSuccess").show();
                	setTimeout(function(){
                		$("#formHintSuccess").hide();
                		$("#DBAtab").append("<tr><td style='padding: 5px 70px;' class='dbaNum' valueNum='"+DBANum+"'>"+DBANum+"</td><td style='padding: 5px 70px;'>"+DBAperson+"</td><td style='padding: 5px 70px;'><a href='###' onclick='deleteDBAperson(this)'>删除</a></td></tr>");
                        $("#DBANum").val("");
                        $("#DBAperson").val("");
                	},2000);
                    
                }
            }
        });
    });
    $("#subdepManager").click(function(){
    	var depNum=$("#depNum").val();
        var dep=$("#dep").val();
        var depManager=$("#depManager").val();
        if(depNum=='' || depManager=='' || dep==''){
//            alert('不能为空');
        	$("#formHintWarning").show();
            setTimeout(function(){
                $("#formHintWarning").hide();
                //window.location.reload();
            },2000);
            return false;
        }
        var data='{"departName":"'+dep+'","managerName":"'+depManager+'","managerId":"'+depNum+'"}';
    	data=encodeURI(data);
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/addPartManager.do?data='+data,
            dataType:'json',
            success:function(data){
                if(data.errCode==1){
//                	alert("新增成功！");
                	$("#formHintSuccess").show();
                	setTimeout(function(){
                		$("#formHintSuccess").hide();
                		$("#depTab").append( "<tr><td style='padding: 5px 70px;' class='dep' valueNum='"+depNum+"'>"+depNum+"</td><td style='padding: 5px 70px;'>"+dep+"</td><td style='padding: 5px 70px;'>"+depManager+"</td><td style='padding: 5px 70px;'><a href='###' onclick='deleteDepManager(this)'>删除</a></td></tr>");
                        $("#depNum").val("");
                        $("#dep").val("");
                        $("#depManager").val("");
                	},2000);
                    
                }
            }
        });
    });
    
    $("#subSite").click(function(){
    	 var siteInfo=$("#siteInfo").val();
         var masterIP=$("#masterIP").val();
         var port=$("#port").val();
         var remark=$("#remark").val();
         if(siteInfo=='' || masterIP=='' || port=='' || remark==''){
//             alert('不能为空');
        	 $("#formHintWarning").show();
             setTimeout(function(){
                 $("#formHintWarning").hide();
                 //window.location.reload();
             },2000);
             return false;
         }
         var data='{"site":"'+siteInfo+'","apiServerIp":"'+masterIP+'","port":"'+port+'","remark":"'+remark+'"}';
         data=encodeURI(data);
        
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/addSiteInfo.do?data='+data,
            dataType:'json',
            success:function(data){
                if(data.errCode==1){
//                	alert("新增成功！");
                	$("#formHintSuccess").show();
                	setTimeout(function(){
                		$("#formHintSuccess").hide();
                		$("#siteTab").append("<tr><td style='padding: 5px 70px;'>"+siteInfo+"</td><td style='padding: 5px 70px;' class='dbaNum' valueNum='"+masterIP+"'>"+masterIP+"</td><td style='padding: 5px 70px;'>"+port+"</td><td style='padding: 5px 70px;'>"+remark+"</td><td style='padding: 5px 70px;'><a href='###' onclick='deleteSite(this)'>删除</a></td></tr>");
                        $("#siteInfo").val("");
                        $("#masterIP").val("");
                        $("#port").val("");
                        $("#remark").val("");
                	},2000);
                	 
                }
            }
        });
        
        
        
        
    });
    
    

    $("#subColony").click(function(){
        var siteName=$("#siteName").val();
        var startIP=$("#startIP").val();
        var endIP=$("#endIP").val();
        var gateway=$("#gateway").val();
        var mask=$("#mask").val();
        var vlan=$("#vlan").val();
        if(siteName=='' || startIP=='' || endIP=='' || gateway=='' || mask=='' || vlan==''){
//            alert('不能为空');
        	$("#formHintWarning").show();
            setTimeout(function(){
                $("#formHintWarning").hide();
                //window.location.reload();
            },2000);
            return false;
        }
        var data='{"site":"'+siteName+'","startIp":"'+startIP+'","endIp":"'+endIP+'","route":"'+gateway+'","mask":"'+mask+'","vlan":"'+vlan+'"}';
    	data=encodeURI(data);
        
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/addColony.do?data='+data,
            dataType:'json',
            success:function(data){
                if(data.errCode==1){
//                	alert("新增成功！");
                	$("#formHintSuccess").show();
                	setTimeout(function(){
                		$("#formHintSuccess").hide();
                		$("#colonyTab").append("<tr><td style='padding: 5px 45px;'>"+siteName+"</td><td style='padding: 5px 45px;' class='nodeIP' valueNum='"+startIP+"'>"+startIP+"</td><td style='padding: 5px 45px;'>"+endIP+"</td><td style='padding: 5px 45px;'>"+gateway+"</td><td style='padding: 5px 45px;' >"+mask+"</td><td style='padding: 5px 45px;'>"+vlan+"</td><td style='padding: 5px 45px;'><a href='###' onclick='deleteColony(this)'>删除</a></td></tr>");
                        $("#siteName").val("");
                        $("#startIP").val("");
                        $("#endIP").val("");
                        $("#gateway").val("");
                        $("#mask").val("");
                        $("#vlan").val("");
                	},2000);
                    
                }
            }
        });
    });
    
    
    
/*//  mysql版本
    $(".deleteMysqlPort").live("click",function(){
        var MysqlPortText=$(this).parents('td').siblings().html();
        var currentObject=$(this).parents('td').parents("tr");
        
        console.log(MysqlPortText);
        var data='{"mysqlVersion":"'+MysqlPortText+'"}';
        data=encodeURI(data);
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=1",
            dataType:'json',
            success:function(data){
            	if(data.errCode==1){
            		alert("删除成功！");
            		currentObject.remove();
            	}else{
            		alert("删除失败！");
            	}
            }
        })
    });
//    字符集
    $(".deleteCharacter_set").click(function(){
        var Character_setText=$(this).parents('td').siblings().html();
        var currentObject=$(this).parents('td').parents("tr");
        var data='{"characterSet":"'+Character_setText+'"}';
        data=encodeURI(data);
        $.ajax({
            type:'post',
            url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=2",
            dataType:'json',
            success:function(data){
            	if(data.errCode==1){
            		alert("删除成功！");
            		currentObject.remove();
            	}else{
            		alert("删除失败！");
            	}
            }
        })
    });
//    DBA管理人员
    $(".deleteDBAperson").click(function(){
        var DBApersonText=$(this).parents('td').parents('tr').children('.dbaNum').attr('valueNum');
        var currentObject=$(this).parents('td').parents("tr");
        var data='{"dbaId":"'+DBApersonText+'"}';
        data=encodeURI(data);
        $.ajax({
        	type:'post',
            url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=3",
            dataType:'json',
            success:function(data){
            	if(data.errCode==1){
            		alert("删除成功！");
            		currentObject.remove();
            	}else{
            		alert("删除失败！");
            	}
            }
        })
    });
//    部门管理员
    $(".deleteDepManager").click(function(){
        var DepManagerText=$(this).parents('td').parents('tr').children('.dep').attr('valueNum');
        var currentObject=$(this).parents('td').parents("tr");
        var data='{"managerId":"'+DepManagerText+'"}';
        data=encodeURI(data);
        $.ajax({
        	type:'post',
            url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=4",
            dataType:'json',
            success:function(data){
            	if(data.errCode==1){
            		alert("删除成功！");
            		currentObject.remove();
            	}else{
            		alert("删除失败！");
            	}
            }
        })
    });
//    集群
    $(".deleteColony").click(function(){
        var ColonyText=$(this).parents('td').parents('tr').children('.nodeIP').attr('valueNum');
        var currentObject=$(this).parents('td').parents("tr");
        var data='{"managerId":"'+ColonyText+'"}';
        $.ajax({
        	type:'post',
            url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=5",
            dataType:'json',
            success:function(data){

            }
        })
    });*/
    
    
    
    
    
});


//mysql版本
function deleteMysqlPort(_this){
    var MysqlPortText=$(_this).parents('td').siblings().html();
    var currentObject=$(_this).parents('td').parents("tr");
    
   /* console.log(MysqlPortText);*/
    var data='{"mysqlVersion":"'+MysqlPortText+'"}';
    data=encodeURI(data);
    $.ajax({
        type:'post',
        url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=1",
        dataType:'json',
        success:function(data){
        	if(data.errCode==1){
//        		alert("删除成功！");
        		$("#deleteSuccess").show();
                setTimeout(function(){
                    $("#deleteSuccess").hide();
                },2000);
        		currentObject.remove();
        	}else{
//        		alert("删除失败！");
        		$("#deleteError").show();
                setTimeout(function(){
                    $("#deleteError").hide();
                },2000);
        	}
        }
    })
}

//字符集
function deleteCharacter(_this){
    var Character_setText=$(_this).parents('td').siblings().html();
    var currentObject=$(_this).parents('td').parents("tr");
    var data='{"characterSet":"'+Character_setText+'"}';
    data=encodeURI(data);
    $.ajax({
        type:'post',
        url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=2",
        dataType:'json',
        success:function(data){
        	if(data.errCode==1){
//        		alert("删除成功！");
        		$("#deleteSuccess").show();
                setTimeout(function(){
                    $("#deleteSuccess").hide();
                },2000);
        		currentObject.remove();
        	}else{
//        		alert("删除失败！");
        		$("#deleteError").show();
                setTimeout(function(){
                    $("#deleteError").hide();
                },2000);
        	}
        }
    })
}

//DBA管理人员
function deleteDBAperson(_this){
    var DBApersonText=$(_this).parents('td').parents('tr').children('.dbaNum').attr('valueNum');
    var currentObject=$(_this).parents('td').parents("tr");
    var data='{"dbaId":"'+DBApersonText+'"}';
    data=encodeURI(data);
    $.ajax({
    	type:'post',
        url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=3",
        dataType:'json',
        success:function(data){
        	if(data.errCode==1){
//        		alert("删除成功！");
        		$("#deleteSuccess").show();
                setTimeout(function(){
                    $("#deleteSuccess").hide();
                },2000);
        		currentObject.remove();
        	}else{
//        		alert("删除失败！");
        		$("#deleteError").show();
                setTimeout(function(){
                    $("#deleteError").hide();
                },2000);
        	}
        }
    })
}

//部门管理员
function deleteDepManager(_this){
    var DepManagerText=$(_this).parents('td').parents("tr").children('.dep').attr('valueNum');
    var currentObject=$(_this).parents('td').parents("tr");
    var data='{"managerId":"'+DepManagerText+'"}';
    data=encodeURI(data);
    $.ajax({
    	type:'post',
        url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=4",
        dataType:'json',
        success:function(data){
        	if(data.errCode==1){
//        		alert("删除成功！");
        		$("#deleteSuccess").show();
                setTimeout(function(){
                    $("#deleteSuccess").hide();
                },2000);
        		currentObject.remove();
        	}else{
//        		alert("删除失败！");
        		$("#deleteError").show();
                setTimeout(function(){
                    $("#deleteError").hide();
                },2000);
        	}
        }
    })
}

//集群
function deleteSite(_this){
    var ColonyText=$(_this).parents('td').parents('tr').children('.dbaNum').attr('valueNum');
    var currentObject=$(_this).parents('td').parents("tr");
    var data='{"apiServerIp":"'+ColonyText+'"}';
    data=encodeURI(data);
    $.ajax({
    	type:'post',
        url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=5",
        dataType:'json',
        success:function(data){
        	if(data.errCode==1){
//        		alert("删除成功！");
        		$("#deleteSuccess").show();
                setTimeout(function(){
                    $("#deleteSuccess").hide();
                },2000);
        		currentObject.remove();
        	}else{
//        		alert("删除失败！");
        		$("#deleteError").show();
                setTimeout(function(){
                    $("#deleteError").hide();
                },2000);
        	}
        }
    })
}

//站点-网络
function deleteColony(_this){
    var ColonyText=$(_this).parents('td').parents('tr').children('.nodeIP').attr('valueNum');
    var networkSite=$(_this).parents('td').parents('tr').children('.nodeSite').attr('valueNum');
    var currentObject=$(_this).parents('td').parents("tr");
    var data='{"startIp":"'+ColonyText+'","site":"'+networkSite+'"}';
    data=encodeURI(data);
    $.ajax({
    	type:'post',
        url:basePath+'/managerInfo/deleteInfo.do?data='+data+"&flag=6",
        dataType:'json',
        success:function(data){
        	if(data.errCode==1){
//        		alert("删除成功！");
        		$("#deleteSuccess").show();
                setTimeout(function(){
                    $("#deleteSuccess").hide();
                },2000);
        		currentObject.remove();
        	}else{
//        		alert("删除失败！");
        		$("#deleteError").show();
                setTimeout(function(){
                    $("#deleteError").hide();
                },2000);
        	}
        }
    })
}