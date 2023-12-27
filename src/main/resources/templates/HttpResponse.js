
function b(id,name,url) {
    $.ajax({
        url: url,
        type: "POST",
        data: JSON.stringify({
            "school_id": id,
            "school_name":name
        }),
        contentType: 'application/json',
        dataType: 'text',
        success: function (result) {
            alert(result);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('AJAX请求失败：', textStatus, errorThrown);
            alert("ajax请求失败！");
        }
    });
}

function a(){
    var school_id=document.getElementById("school_id").value;
    var school_name=document.getElementById("school_name").value;
    var url="http://192.168.0.3:8080/school/insert"
    if(school_id==="" ||school_name===""){
        alert("编号和名称不能为空");
    }
    else{
        b(school_id,school_name,url);
    }
}

function c(){
   var window_id=document.getElementById("window_id").value;
   var window_name=document.getElementById("window_name").value;
   var school_id=document.getElementById("school_id1").value;
   var merchant=document.getElementById("merchant_id").value;
   var window_img=document.getElementById("file").files[0].name;
   var url="http://192.168.0.3:8080/window/insert";
   if(window_id===""||window_name===""||school_id===""||merchant===""){
       alert("数据填写不完整");
   }else {
       $.ajax({
           url: url,
           type: "POST",
           data: JSON.stringify({
               "window_id": window_id,
               "window_name": window_name,
               "school_id": school_id,
               "merchant": merchant,
               "window_img":"http://192.168.0.3:8080/Image/"+window_img,
               "window_status":"关闭"
           }),
           contentType: 'application/json',
           dataType: 'text',
           success: function (result) {
               if(result==="success") {
                   uploadFile();
                   alert(result);
               }else{
                   alert(result);
               }
           },
           error: function (jqXHR, textStatus, errorThrown) {
               console.log('AJAX请求失败：', textStatus, errorThrown);
               alert("ajax请求失败！");
           }
       });
   }
}
function uploadFile() {
    var formData = new FormData();
    formData.append("file", document.getElementById("file").files[0]);

    // 使用Ajax异步上传
    $.ajax({
        type: 'POST',
        url: 'http://192.168.0.3:8080/upload', // 后端处理上传的URL
        data: formData,
        processData: false,
        contentType: false,
        success: function (data) {

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('AJAX请求失败：', textStatus, errorThrown);
            alert("ajax请求失败！");
        }
    });
}