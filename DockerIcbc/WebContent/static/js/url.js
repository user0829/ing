/**
 * Created by Administrator on 2018/5/23 0023.
 */
$(function(){
    $.ajax({
        type:'get',
        //url:'http://192.168.234.130:8080/api/v1/pods',
        url:'./pods.json',
        //async:true,
        //jsonp:'jsoncallback',
        //params:{"contentType": "application/json;charset=utf-8"},
        //data:{name:name},
        dataType:'json',
        success:function(data){
            //var con="";
            //$("#info").html(data);
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

            //$.each(data,function(index,item){
            //    //console.log(arr[0]);
            //
            //
            //});


        }
    });
});
