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
                        url:"AddAuctionServlet",
                        dataType:"json",
                        type:"post",
                        success:function (result) {
                            alert(result.msg);
                            if(result.status==1){
                                location.href = "IndexServlet";
                            }else {
                                location.href = "addAuction.jsp";
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
        <dl>
            <dd >
                <label>名称：</label>
                <input type="text" class="inputh lf" name="auctionName" />
            </dd>
            <dd>
                <label>起拍价：</label>
                <input type="text" class="inputh lf" name="auctionStartPrice" />
            </dd>
            <dd>
                <label>底价：</label>
                <input type="text" class="inputh lf" name="auctionUpset" />
            </dd>
            <dd>
                <label>开始时间：</label>
                <input type="text" class="inputh lf" name="auctionStartTime" />
            </dd>
            <dd>
                <label>结束时间：</label>
                <input type="text" class="inputh lf" name="auctionEndTime" />
            </dd>
            <dd class="dds">
                <label>拍卖品图片：</label>
                <div class="lf salebd"><a href="#"><img src="images/ad20.jpg" width="100" height="100" /></a></div>
                <input name="auctionPicType" type="file" class="offset10 lf" />
            </dd>
            <dd class="dds">
                <label>描述：</label>
                <textarea name="auctionDesc" cols="" rows="" class="textarea"></textarea>
            </dd>
            <dd class="hegas">
                <input id="btn" type="button" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input onclick="location.href='index.jsp'" type="button" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf" />
            </dd>
        </dl>
        </form>
    </div>
</div>
</div>
</body>
</html>
