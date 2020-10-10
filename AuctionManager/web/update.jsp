<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/jquery.form-4.3.js"></script>
    <script>
        $(function () {
            $.validator.addMethod("date",function (value,element) {
                var regdate = /^[1-2]\d{3}\-[0-1]{1}\d{1}\-[0-3]{1}\d{1}$/;
                return this.optional(element) || regdate.test(value);
            },"格式如：2010-05-05");
            $.validator.addMethod("price",function (value,element) {
                var regprice = /^[1-9]{1}\d*$/;
                return this.optional(element) || regprice.test(value);
            },"必须为数字");
            $("#myform").validate({
                rules:{
                    "auctionStartPrice":{required:true,price:true},
                    "auctionUpset":{required:true,price:true},
                    "auctionStartTime":{required:true,date:true},
                    "auctionEndTime":{required:true,date:true}
                },
                messages:{
                    "auctionStartPrice":{required:"起拍价不能为空"},
                    "auctionUpset":{required:"底价不能为空"},
                    "auctionStartTime":{required:"开始时间不能为空"},
                    "auctionEndTime":{required:"结束时间不能为空"}
                }
            });
            $("#btn").click(function () {
                if ($("#myform").valid()){
                    $("#myform").ajaxSubmit({
                        url:"UpdateServlet",
                        dataType:"json",
                        type:"post",
                        success:function (result) {
                            alert(result.msg);
                            if(result.status==1){
                                location.href = "IndexServlet";
                            }else {
                                location.href = "update.jsp";
                            }
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
<div class="wrap">
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form enctype="multipart/form-data" method="post" id="myform">
            <input type="hidden" name="auctionId" value="${auction.auctionId}">
            <input type="hidden" name="auctionPic" value="${auction.auctionPic}">
        <dl>
            <dd >
                <label>名称：</label>
                <input type="text" class="inputh lf" value="${auction.auctionName}" name="auctionName"/>
            </dd>
            <dd>
                <label>起拍价：</label>
                <input type="text" class="inputh lf" value="${auction.auctionStartPrice}" name="auctionStartPrice" />
            </dd>
            <dd>
                <label>底价：</label>
                <input type="text" class="inputh lf" value="${auction.auctionUpset}" name="auctionUpset"/>
            </dd>
            <dd>
                <label>开始时间：</label>
                <input type="text" class="inputh lf" value="${auction.auctionStartTime}" name="auctionStartTime"/>
            </dd>
            <dd>
                <label>结束时间：</label>
                <input type="text" class="inputh lf" value="${auction.auctionEndTime}" name="auctionEndTime"/>
            </dd>
            <dd class="dds">
                <label>描述：</label>
                <textarea name="auctionDesc" cols="" rows="" class="textarea">${auction.auctionDesc}</textarea>
            </dd>
            <dd>
                <label>修改图片：</label>
                <div class="lf salebd"><a href="#"><img src="images/${auction.auctionPicType}" width="100" height="100" /></a></div>
                <input name="auctionPicType" type="file" class="marg10" />
            </dd>
            <dd class="hegas">
                <input id="btn" type="button" value="保 存" class="spbg buttombg buttombgs f14 lf buttomb" />
                <input type="button" value="取 消" class="spbg buttombg buttombgs f14 lf buttomb" onclick="location.href='index.jsp'"/>
            </dd>
        </dl>
        </form>
    </div>
</div>
</div>
</body>
</html>
