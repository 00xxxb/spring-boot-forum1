
//管理员禁言用户
function banned(s_id) {
   // alert("你是好人还是坏人啊？"+s_id+"个");
    window.location.href="/banned?s_id="+s_id;

}
//管理员解除禁言
function belease(s_id) {
    window.location.href="/belease?s_id="+s_id;
}