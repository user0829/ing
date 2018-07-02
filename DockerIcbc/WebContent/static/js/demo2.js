/**
 * Created by Administrator on 2018/5/8 0008.
 */
//ajax
function a() {
    $.ajax({
        url: "url.html",  //要请求的页面
        global: false,
        type: "get",
        dataType: "html",  //请求类型
        async: false,   //是否为异步请求
        success: function (msg) {  //msg得到的数据(这里得到的是整个html代码)
            // alert(msg);
            $('.page-content').html(msg);
        }
    })
}

//左侧导航
$('.nav>li>a').bind('click', function () {
    if ($(this).next('ul').hasClass('dplay')) {
        $(this).parent('li').removeClass('hideli');
        $(this).next('ul').slideToggle("slow");
    }else{
        $(this).parent('li').siblings().children(":last-child").removeClass('dplay').addClass('hide');
        $(this).parent('li').addClass('hideli');
        $(this).parent('li').siblings().removeClass('hideli');
        $(this).next('ul').removeClass('hide').addClass('dplay').slideToggle('slow');
    }
});

$('.menu>li').bind('mouseenter',function () {
    if($(this).hasClass('active')){
    }else{
        $(this).addClass('active');
        $(this).siblings('li').removeClass('active');
    }
});