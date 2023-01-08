function deleteUser(uid){
    if (confirm('是否删除?')){
        window.location.href = 'user.do?uid='+uid+"&operate=delete";
    }
}

function page(pageNo){
    // 这里不用带上operate user.do里面拿不到operate字段会默认设置为index
    window.location.href = 'user.do?pageNo='+pageNo;
}

function toRegister(){
    window.location.href = 'pages/register.html'
}