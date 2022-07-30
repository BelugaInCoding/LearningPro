function testClic(i, j){
    all1 = sum(i, j)
    alert(i+"*+"+j+"="+all1)
}

// 第二种函数定义方式
// var 函数名 = function(形参1，形参2...){函数体}
// 函数的形参只是一个符号，可以代表多个参数，即arguments[]列表 可以用下标依次访问参数
var sum = function (a, b){
    var s = 0
    for (var i = 0; i < arguments.length-1; i++) {
        if (typeof(arguments[i])== "number"){
            s += arguments[i]
        }
    }
    return s
}

// Js自定义对象
var myObj = new Object()
myObj.name = 'Beluga'
myObj.age = 8
myObj.gender = "man"
myObj.eat = function (){
    alert("挖掘机吃东西")
}

// JS自定义对象方式2 在空对象中添加kv对
var IObj = {
    name : 'Beluga分身',
    age : 88,
    gender : 'man',
    eatt : function (){
        alert("暴风吸入")
    },
    sleep : function (a, b){
        alert("每天睡觉时间："+a+"点——"+b+"点")
    }
}

// 用于静态注册onload
function onloadFun(){
    alert("函数调用实现静态注册onload的方法")
}

// 用于动态注册onchange
function onchangeFun(){
    alert("选择框内容已改变 ")
}

// 用于静态注册onsubmit
function onsubmitFun(){
    alert("有问题")
    // 如果点击提交 审查数据有问题 返回值false阻止表单提交
    return false
}