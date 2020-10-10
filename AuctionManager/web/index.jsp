<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>$Title$</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
      $(function () {
          $("ul:gt(0):even").addClass("rows");
          $("ul:gt(0):odd").addClass("rows even");
          $("#select").click(function () {
              var name = $("#name").val();
              var desc = $("#names").val();
              location.href = "IndexServlet?name="+name+"&desc="+desc;
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
    <div class="forms">
      <label for="name">名称</label>
      <input name="" type="text" class="nwinput" id="name"/>
      <label for="names">描述</label>
      <input name="" type="text" id="names" class="nwinput"/>
      <input id="select" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
      <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb" onclick="location.href='addAuction.jsp'"/>
    </div>
    <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      <script>
          function del(id){
              if(confirm("你确定要删除吗？")){
                  $.post("DelServlet",{"id":id},function (result) {
                      alert(result.msg);
                      location.href = "IndexServlet";
                  },"json");
              }
          }
      </script>
      <c:forEach var="auction" items="${list}">
        <ul>
          <li>${auction.auctionName}</li>
          <li class="list-wd">${auction.auctionDesc}</li>
          <li>${auction.auctionStartTime}</li>
          <li>${auction.auctionEndTime}</li>
          <li>${auction.auctionStartPrice}</li>
          <li class="borderno red">
            <a href="ToUpdateServlet?id=${auction.auctionId}" title="竞拍">修改</a>
            <a href="javascript:del(${auction.auctionId})" title="竞拍">删除</a>
          </li>
        </ul>
      </c:forEach>
      <div class="page">
        <c:if test="${pageIndex==1}">
          首页
          上一页
        </c:if>
        <script>
            function jump(name,desc,index,size){
                location.href = "IndexServlet?name="+name+"&desc="+desc+"&pageIndex="+index+"&pageSize="+size;
            }
        </script>
        <c:if test="${pageIndex!=1}">
          <a href="javascript:jump('${name}','${desc}',1,5)" title="">首页</a>
          <a href="javascript:jump('${name}','${desc}','${pageIndex-1}',5)" title="">上一页</a>
        </c:if>
        <c:if test="${totalPage!=0}">
          <c:forEach var="i" begin="1" end="${total}" step="1">
            <a href="javascript:jump('${name}','${desc}','${i}',5)" title="">${i}</a>
          </c:forEach>
        </c:if>
        <c:if test="${pageIndex==total}">
          首页
          上一页
        </c:if>
        <c:if test="${pageIndex!=total}">
          <a href="javascript:jump('${name}','${desc}','${pageIndex+1}',5)" title="">下一页</a>
          <a href="javascript:jump('${name}','${desc}','${total}',5)" title="">尾页</a>
        </c:if>
      </div>
    </div>
  </div>
  </body>
</html>
