/**
 * Created by Administrator on 2018/5/8 0008.
 */
//ajax
function a() {
    $.ajax({
        url: "url.html",  //Ҫ�����ҳ��
        global: false,
        type: "get",
        dataType: "html",  //��������
        async: false,   //�Ƿ�Ϊ�첽����
        success: function (msg) {  //msg�õ�������(����õ���������html����)
            // alert(msg);
            $('.page-content').html(msg);
        }
    })
}

//��ർ��
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