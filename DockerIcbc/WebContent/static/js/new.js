$(function(){
        $("#hint_data").hover(function(){
            $(this).next('p').show();
        },function(){
            $(this).next('p').hide();
        });
        $("#hint_tem").hover(function(){
            $(this).next('p').show();
        },function(){
            $(this).next('p').hide();
        });
        $("#hint_log").hover(function(){
            $(this).next('p').show();
        },function(){
            $(this).next('p').hide();
        });
        $("#hint_backup").hover(function(){
            $(this).next('p').show();
        },function(){
            $(this).next('p').hide();
        });
        $("#pre").on("click",function(){
            console.log($('form').serializeJSON());
        });
        
        $("#site").click(function(){
            var mysite=$("#site").find('option:selected').val();
            if(mysite==""){
            	return false;
            }
            /*console.log(mysite);*/
            var data='{"site":"'+mysite+'"}';
        	data=encodeURI(data);
        	var content="";
            $.ajax({
                type:'post',
                url:basePath+'/sendInfo/selectSegment.do?data='+data,
                dataType:'json',
                success:function(data){
                	var list=data.list;
                	var size=list.length;
                	if(data.errCode==1){
                		if(size>0){
                			var returnValue1=list[0].start_ip;
                			var returnValue2=list[0].end_ip;
                			$("#segment1").val(returnValue1);
                			$("#segment2").val(returnValue2);
                		}
                		
                	}else{
                		alert("查询失败！");
                	}
                   
                }
            })
        });
        
        
    
        
    });
    
    
    
  function submitData(){
    var systemName=$("#system_name").val();
    var site=$("#site").val();
    var subSystem=$("#sub_system").val();
    var subSystemCode=$("#sub_system_code").val();
    var disasterLevel=$("#disaster_level option:selected").val();
    var deployment=$("#deployment option:selected").val();
    var performanceNeed=$("#performance_need option:selected").val();
    var mysqlVersion=$("#mysql_version option:selected").val();
    var portNum=$("#port").val();
    var characterSet=$("#character_set option:selected").val();
    var osVersion=$("#os_version option:selected").val();
    var dataVolume=$("#data_volume").val();
    var logVolume=$("#log_volume").val();
    var tempVolume=$("#temp_volume").val();
    var backupVolume=$("#backup_volume").val();
    var databaseDomainName=$("#database_domain_name").val();
    
    
    
    
  /* var data= '{"systemName":"'+systemName+'","site":"'+site+'","subSystem":"'+subSystem+'","subSystemCode":"'+subSystemCode+'"' +
   		',"disasterLevel":"'+disasterLevel+'","deployment":"'+deployment+'","performanceNeed":"'+performanceNeed+'",' +
   				'"mysqlVersion":"'+mysqlVersion+'","portNum":"'+portNum+'","characterSet":"'+characterSet+'","osVersion":"'+osVersion+'",' +
   						'"dataVolume":"'+dataVolume+'","logVolume":"'+logVolume+'","tempVolume":"'+tempVolume+'","backupVolume":"'+backupVolume+'",' +
   								'"databaseDomainName":"'+databaseDomainName+'"}';*/
   
   var data='{"systemName":"'+systemName+'","site":"'+site+'","subSystem":"'+subSystem+'","subSystemCode":"'+subSystemCode+'","disasterLevel":"'+disasterLevel+'","deployment":"'+deployment+'"'
	+ ',"performanceNeed":"'+performanceNeed+'","instances":123,"mysqlVersion":"'+mysqlVersion+'","portNum":"'+portNum+'","characterSet":"'+characterSet+'","networkSection":"dahetao","osVersion":"'+osVersion+'","dataVolume":"'+dataVolume+'"'
	+ ',"logVolume":"'+logVolume+'","tempVolume":"'+tempVolume+'","backupVolume":"'+backupVolume+'","databaseDomainName":"'+databaseDomainName+'","createrId":"dahetao","createTime":"dahetao","mysqlVersion":"dahetao","backupTiming":"dahetao"}';
   
  /* 
   var data='{"systemName":"'+backupVolume+'","site":dahetao,"subSystem":dahetao,"subSystemCode":dahetao,"disasterLevel":dahetao,"deployment":dahetao'
		+ ',"performanceNeed":dahetao,"instances":123,"mysqlVersion":dahetao,"portNum":123,"characterSet":dahetao,"networkSection":dahetao,"osVersion":dahetao,"dataVolume":123'
		+ ',"logVolume":123,"tempVolume":123,"backupVolume":123,"databaseDomainName":dahetao,"createrId":dahetao,"createTime":dahetao,"mysqlVersion":dahetao,"backupTiming":dahetao}';
   
   */
   data=encodeURI(data);

    $("input[type='button']").on("click",function(){
       /* if($("#system_name").val()=="" || $("#site").val()=="" || $("#sub_system").val()=="" || $("#disaster_level option:selected").val()=="" || $("#deployment option:selected").val()=="" || $("#performance_need option:selected").val()==""){
            alert('000');
            return false;
        }*/
        $.ajax({
            type:'post',
            url:basePath+'/sendInfo/getInfo.do?data='+data,
            dataType:"json",
            success:function(data){
            	var data1=data.errCode;
            	if(data1==1){
            		/*alert("保存成功！");
            		window.location.href=basePath+'/sendInfo/contentList.do';
            		window.event.returnValue=false; */
            		 $("#creationSuccess").show();
         	        setTimeout(function(){
         	            $("#creationSuccess").hide();
         	           window.location.href=basePath+'/sendInfo/contentList.do';
         	          window.event.returnValue=false;
         	        },2000);
         	       
           		window.event.returnValue=false;
            	}else{
            		 $("#creationError").show();
         	        setTimeout(function(){
         	            $("#creationError").hide();
         	        },2000);
            	}
            }
        })
    })
}
  
  function createSystem(){
	    var site=$("#site option:selected").val();
	    var sub_system_code=$("#sub_system_code").val();
	    var performance_need=$("#performance_need").val();
	    if(site=='' || sub_system_code=='' || performance_need==''){
	        $("#creationError").show();
	        setTimeout(function(){
	            $("#creationError").hide();
	        },2000);
	    }else{
	        $("#creationSuccess").show();
	        setTimeout(function(){
	            $("#creationSuccess").hide();

	        },2000);
	    }
	}
    
