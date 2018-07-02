/**
 * Created by Administrator on 2018/7/1 0001.
 */
$(function(){
    $("#deleteExample").click(function(){
        //var sub_system_codeText=$("#mytable0 tr").find('.sub_system_code').attr('valueNum');
    	 var sub_system_codeText=$("[name='example']:checked").parents("tr").find('.sub_system_code').attr('valueNum');
        //var str=$("[name='example']:checked").val();
        var deleteThis=$("[name='example']:checked").parents("tr");
//            console.log(str);
     /*   var data='{"dbaId":"'+sub_system_codeText+'"}';
        data=encodeURI(data);*/
        $.ajax({
            type:'post',
            url:basePath+'/sendInfo/deletePod.do?subSystemCode='+sub_system_codeText,
            dataType:'json',
            success:function(data){
                if(data.errCode==1){
                   /* $("#myexampleSuccess").show();
                    setTimeout(function(){
                        $("#myexampleSuccess").hide();
                    },2000);*/
                	deleteThis.remove();
                }else{
                    $("#myexampleWarning").show();
                    setTimeout(function(){
                        $("#myexampleWarning").hide();
                    },2000);
                    return false;
                }
            }
        });
        //if(str==undefined){
        //    //alert('123214');
        //    $("#myexampleWarning").show();
        //    setTimeout(function(){
        //        $("#myexampleWarning").hide();
        //    },2000);
        //    return false;
        //}else{
        //    $("#myexampleSuccess").show();
        //    setTimeout(function(){
        //        $("#myexampleSuccess").hide();
        //    },2000);
        //
        //    //console.log(sub_system_code);
        //}
    });
});