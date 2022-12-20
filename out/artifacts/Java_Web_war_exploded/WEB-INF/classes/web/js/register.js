$(function (){
    let usernamef = false;
    let pwdf = false;
    let repwdf = false;
    let emailf = false;
    let codef = false;

    /*change事件正则验证用户名*/
    $("#username").change(function(){
        let username = $("#username");
        let patt = /^\w{3,12}$/;
        if(!patt.test(username.val())){
            $("#unspan").css("color", "#ff0000").text("×");
            usernamef = false;
        }else {
            $("#unspan").css("color","#ADFF2FFF").text("√");
            usernamef = true;
        }
    });
    /*change事件正则验证密码*/
    $("#pwd").change(function (){
        let pwd = $("#pwd");
        let patt = /^\w{6,15}$/;
        if (!patt.test(pwd.val())){
            $("#pwdspan").css("color", "#ff0000").text("×");
            pwdf = false;
        }else {
            $("#pwdspan").css("color","#ADFF2FFF").text("√");
            pwdf = true;
        }
    });
    /*点击方块显示密码*/
    $("#pwdshow").click(function (){
        let pwd = $("#pwd");
        if(pwd.attr("type")=="password"){
            pwd.attr("type","text");
        }else {
            pwd.attr("type","password");
        }
    });

    /*change事件验证密码是否相同*/
    $("#repwd").change(function (){
        let pwd = $("#pwd");
        let repwd = $("#repwd");
        if(pwd.val() != repwd.val()){
            $("#repwdspan").css("color", "#ff0000").text("×");
            repwdf = false;
        }else {
            $("#repwdspan").css("color","#ADFF2FFF").text("√");
            repwdf = true;
        }
    });
    /*点击方块显示二次密码*/
    $("#repwdshow").click(function (){
        if(pwdf){   //密码输入正确才需要二次输入验证密码
            let repwd = $("#repwd");
            if(repwd.attr("type")=="password"){
                repwd.attr("type","text");
            }else {
                repwd.attr("type","password");
            }
        }
    });
    /*change事件验证email 是否有@符号*/
    $("#email").change(function (){
        let emaile = $("#email");
        //邮箱正则表达式
        let patt = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        if (!patt.test(emaile.val())){
            $("#emailspan").css("color", "#ff0000").text("×");
            emailf = false;
        }else {
            $("#emailspan").css("color","#ADFF2FFF").text("√");
            emailf = true;
        }
    });

    /*change验证码*/
    $("#code").change(function (){
        //TODO 后面来做验证码
        let code = $("#code");
        code = $.trim(code.val());//去掉左右的空格
        if (code == "" || code == null){
            $("#codespan").css("color", "#ff0000").text("×");
            codef = false;
        }else{
            $("#codespan").css("color","#ADFF2FFF").text("√");
            codef = true;
        }
    });

    /* submit提交的点击事件 所有的flage为true */
    $("#submit").click(function (){
        if(usernamef && pwdf && repwdf && emailf && codef){
            return true
        }else{
            return false;
        }
    });
});