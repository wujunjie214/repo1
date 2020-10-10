<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script>
        $(function () {

            $.validator.addMethod("checkname",function (value,element) {
                var regname = /^\w{6,}$/;
                return this.optional(element) || regname.test(value);
            },"用户名不低于6个字符");
            $.validator.addMethod("pwd",function (value,element) {
                var regpwd = /^\w{6,}$/;
                return this.optional(element) || regpwd.test(value);
            },"密码不低于6个字符");
            $("#myform").validate({
                rules:{
                    "userName":{required:true,checkname:true},
                    "userPassword":{required:true,pwd:true},
                    "userCardNo":{required:true},
                    "userTel":{required:true}
                },
                messages:{
                    "userName":{required:"用户名不能为空"},
                    "userPassword":{required:"密码不能为空"},
                    "userCardNo":{required:"身份证号不能为空"},
                    "userTel":{required:"电话不能为空"}
                }
            });
            $("#btn").click(function () {
                if (!document.getElementById("rem_u").checked) {
                    alert("请勾选同意服务条款");
                }else {
                    if ($("#checkcode").val()=="" || $("#checkcode").val()!="7chh"){
                        alert("验证码错误");
                    } else {
                        if($("#myform").valid()){
                            var data = $("#myform").serialize();
                            $.post("AddUserServlet",data,function (result) {
                                alert(result.msg);
                                if(result.status==1){
                                    location.href = "login.jsp";
                                }else {
                                    location.href = "addUser.jsp";
                                }
                            },"json");
                        }
                    }
                }
            });
        });
    </script>
</head>
<body>
<div class="wrap">
    <!-- main begin-->
    <div class="zclf login logns">
        <h1 class="blue">用户注册</h1>
        <form id="myform">
        <dl>
            <dd>
                <label> <small>*</small>用户名</label>
                <input type="text" class="inputh lf" name="userName" />
            </dd>
            <dd>
                <label> <small>*</small>密码</label>
                <input type="text" class="inputh lf" name="userPassword" />
            </dd>
            <dd>
                <label> <small>*</small>身份证号</label>
                <input type="text" class="inputh lf" name="userCardNo" />
            </dd>
            <dd>
                <label> <small>*</small>电话</label>
                <input type="text" class="inputh lf" name="userTel" />

            </dd>
            <dd>
                <label> <small>*</small>住址</label>
                <input type="text" class="inputh lf" name="userAddress" />
            </dd>
            <dd>
                <label> <small>*</small>邮政编码</label>
                <input type="text" class="inputh lf" name="userPostNumber" />
            </dd>
            <dd class="hegas">
                <label> <small>*</small>验证码</label>
                <input type="text" class="inputh inputs lf" id="checkcode" />
                <span class="wordp lf"><img src="images/img2.jpg" width="96" height="27" alt="" /></span>
                <span class="blues lf"><a href="" title="">看不清</a></span>
            </dd>
            <dd class="hegas">
                <label>&nbsp;</label>
                <input type="checkbox" id="rem_u" value="1"/>
                <label for="rem_u" class="labels">我同意<span class="blues">《服务条款》</span></label>
            </dd>
            <dd class="hegas">
                <label>&nbsp;</label>
                <input id="btn" type="button" value="立即注册" class="spbg buttombg buttombgs f14 lf" />
            </dd>
        </dl>
        </form>
    </div>
</div>
</div>
</body>
</html>
