
//管理员禁言用户
function banned(s_id) {
    // alert("你是好人还是坏人啊？"+s_id+"个");
    // alert(s_id);
    // window.location.href="/banned?s_id="+s_id;

    $.ajax({
        url:"/banned?s_id="+s_id,
        type:"post",
        async:false,
        data:{},
        success:function(data){
            if(data=="true") {
                // window.location.href="/loging?uname="+uname+"&cpassword="+cpassword;
                document.getElementById("zhuantai1").innerHTML = "禁言";
                location.reload(true);
            }
        }
    })
}
//管理员解除禁言
function release(s_id) {
    // alert("我是坏人！");
    // window.location.href="/belease?s_id="+s_id;

    // $.ajax({
    //     url:"/belease?s_id="+s_id,
    //     type: "post",
    //     async:false,
    //
    // })
    $.ajax({
        url:"/belease?s_id="+s_id,
        type:"post",
        async:false,
        data:{},
        success:function (data){
            if(data=="false") {
                // window.location.href="/loging?uname="+uname+"&cpassword="+cpassword;
                document.getElementById("zhuantai2").innerHTML = "解除";
                location.reload(true);
            }
        }
    })
}