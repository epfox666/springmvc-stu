<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>
      $(function () {
        $("#btn").click(function () {
            <%--$.post("${pageContext.request.contextPath}/a2",function (data) {--%>
            <%--  console.log(data);--%>
            <%--  var html="";--%>
            <%--  for(var i=0;i<data.length;i++){--%>
            <%--    html+="<tr>"+--%>
            <%--            "<td>" + data[i].name +"</td>" +--%>
            <%--            "<td>" + data[i].age +"</td>" +--%>
            <%--            "<td>" + data[i].sex +"</td>" +--%>
            <%--          "</tr>"--%>
            <%--  }--%>
            <%--  $("#body").html(html)--%>
            <%--})--%>
          $.post({
            url:"${pageContext.request.contextPath}/a2",
            success:function (data) {
                console.log(data);
                var html="";
                for(var i=0;i<data.length;i++){
                  html+="<tr>"+
                          "<td>" + data[i].name +"</td>" +
                          "<td>" + data[i].age +"</td>" +
                          "<td>" + data[i].sex +"</td>" +
                        "</tr>"
                }
                $("#body").html(html)
            }
          });
        })

      })
    </script>
  </head>
  <body>
    <input type="button" id="btn" value="获取数据"/>
  <table>
    <tr>
      <td>姓名</td>
      <td>年龄</td>
      <td>性别</td>
    </tr>
    <tbody id="body">

    </tbody>
  </table>
  </body>
</html>
