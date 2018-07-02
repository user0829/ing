function addNewTab(tabname, url) {  
    //创建一个新的窗口，在mainlayout上    
    if(!$("#mainTabs").tabs('getTab', tabname)) {  
        $("#mainTabs").tabs('add', {  
            title: tabname,  
            selected: true,  
            closable: true,  
            content: "<iframe src='"  + url + "' style='width:88%;height:100%'  frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='yes' />"  
        });  
    } else {  
        $('#mainTabs').tabs('select', tabname);  
    }  
}  
