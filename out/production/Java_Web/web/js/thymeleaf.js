function deleteUser(uid){
    if (confirm('是否删除?')){
        window.location.href = 'delete.do?uid='+uid;
    }
}

function page(pageNo){
    window.location.href = 'indexer?pageNo='+pageNo;
}