<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                var name = $("#name").val();
                var pwd = $("#password").val();
                var code = $("#passwords").val();
                if (code!="7chh") {
                    alert("验证码错误！");
                }else {
                    if (name=="" || name==null) {
                        alert("用户名不能为空！");
                    }else if(pwd=="" || pwd==null){
                        alert("密码不能为空！");
                    }else{
                        $.post("LoginServlet",{"username":name,"password":pwd},function (result) {
                            if (result.isexist==0){
                                alert(result.msg);
                            } else {
                                location.href = "IndexServlet";
                            }
                        },"json");
                    }
                }
            });
        });
    </script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="main">
        <div class="sidebar">
            <p><img src="images/img1.jpg" width="443" height="314" alt="" /></p>
        </div>
        <div class="sidebarg">
            <form action="" method="post" target='_blank'>
                <div class="login">
                    <dl>
                        <dt class="blues">用户登陆</dt>
                        <dd><label for="name">用户名：</label><input type="text" class="inputh" placeholder="用户名" id="name"/></dd>
                        <dd><label for="password">密 码：</label><input type="text" class="inputh" placeholder="密码" id="password"/></dd>
                        <dd>
                            <label class="lf" for="passwords">验证码：</label>
                            <input type="text" class="inputh inputs lf" placeholder="验证码" id="passwords"/>
                            <span class="wordp lf"><img src="images/img2.jpg" width="96" height="27" alt="" /></span>
                            <span class="blues lf"><a href="" title="">看不清</a></span>
                        </dd>
                        <dd>
                            <input name=""  type="checkbox" id="rem_u"  />
                            <span for="rem_u">下次自动登录</span>
                        </dd>
                        <dd class="buttom">
                            <input id="btn" type="button" value="登 录" class="spbg buttombg f14 lf" />
                            <input name="" type="button" value="注 册" class="spbg buttombg f14 lf" onclick="location.href='addUser.jsp'"/>
                            <span class="blues  lf"><a href="" title="">忘记密码?</a></span>
                            <div class="cl"></div>
                        </dd>
                    </dl>
                </div>
            </form>
        </div>
        <div class="cl"></div>
    </div>
    <!-- main end-->

    <!-- footer begin-->
</div>
<!--footer end-->

</div>
</body>
</html>
