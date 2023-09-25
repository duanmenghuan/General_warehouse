<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort()	+ path + "/";
%>
<%@page import="java.sql.*" %>
<!DOCTYPE>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>岗位信息展示</title>
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" href="./assets/css/index.css"/>
    <!-- 使用单文件引入的方式使用ECharts.JS -->
    <script src="./assets/js/jquery.min.js"></script>
    <script src="./assets/js/echarts.min.js"></script>
    <script src="./assets/js/index.js"></script>
    <script src="./assets/js/map/shandong.js"></script>
<%--    分页插件的引入--%>
    <script type="text/javascript" src="./assets/js/jqPaginator.js"></script>

    <script type="text/javascript">

        $(function() {
            var $this = $("#scroll_table");
            var scrollTimer;
            $this.hover(function() {
                clearInterval(scrollTimer);
            }, function() {
                scrollTimer = setInterval(function() {
                    scrollNews($this);
                }, 200);
            }).trigger("mouseleave");

            function scrollNews(obj) {
                var $self = obj.find("tbody");
                var lineHeight = $self.find("tr:first").height();
                $self.animate({
                    "marginTop": -lineHeight + "px"
                }, 600, function() {
                    $self.css({
                        marginTop: 0
                    }).find("tr:first").appendTo($self);
                })
            }
        })
        $(document).ready(function() {
            $("#type1").click(function() {
                var searchValue = document.getElementById("site-search").value;
                $.ajax({
                    url: "select_v_name",
                    method: "POST",
                    data: { "v_name": searchValue },
                    success: function(response) {
                        console.log("Success:", response);
                    },
                    error: function(xhr, status, error) {
                        console.log("Error:", error);
                    }
                });
            });
        });


    </script>

</head>
<body>
<!--头部-->
<div class="header">
    岗位信息展示
    <a href="javascript:;" class="a-access">
        <label for="site-search"> </label>
        <input class="button type1" type="search" id="site-search" name="q">
        <button class="button type1" id="type1">
            查询
        </button>
    </a>
</div>
<!--主体-->
<div class="main clearfix">
    <div class="main-left">
        <div class="border-container">
            <div class="name-title">学历偏向(暂时静态)</div>
            <div id="radar"></div>
            <span class="top-left border-span"></span>
            <span class="top-right border-span"></span>
            <span class="bottom-left border-span"></span>
            <span class="bottom-right border-span"></span>
        </div>
        <div class="border-container">
            <div class="name-title">学历需求与岗位数量(实现中)</div>
            <div id="graduateyear"></div>
            <ul class="three-pie clearfix">
                <li>
                    <div id="sexrate"></div>
                </li>
                <li>
                    <div id="householdrate"></div>
                </li>
            </ul>
            <span class="top-left border-span"></span>
            <span class="top-right border-span"></span>
            <span class="bottom-left border-span"></span>
            <span class="bottom-right border-span"></span>
        </div>
    </div>
    <div class="main-middle">
        <div class="border-container" id="scroll_table">
            <%  //Java语句
                try {
                    Class.forName("com.mysql.jdbc.Driver");  // 加载驱动
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/job51",
                            "root", "root");  ////获取Connection对象

                    if(con != null){
                        Statement stmt = null;
                        ResultSet rs = null;
                        String sql = "SELECT *FROM jobs;";  //查询语句
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(sql);
            %>
            <table class="table table-kingdargen">
                <thead>
                <tr>
                    <th><%out.print("序号");%></th>
                    <th><%out.print("岗位");%></th>
                    <th><%out.print("公司名称");%></th>
                    <th><%out.print("工作地点");%></th>
                    <th><%out.print("薪资");%></th>
                </tr>
                </thead>
                <tbody id="kbTable">
                <%--                //这是一个循环，读取数据库中的数据--%>
                <% while (rs.next()) {%>
                <tr>
                    <td><%out.print(rs.getInt("job_id"));%></td>
                    <td><%out.print(rs.getString("job_name"));%></td>
                    <td><%out.print(rs.getString("company_name"));%></td>
                    <td><%out.print(rs.getString("work_addr"));%></td>
                    <td><%out.print(rs.getString("salary"));%></td>
                </tr>
                <%--                    //循环结束--%>
                <%}%>
                </tbody>
            </table>
            <%
                    }else{
                        out.print("Connection fail！");
                    }
                }catch (Exception e) {
                    //e.printStackTrace();
                    out.print("Connection Exception！");
                }
            %>
<%--            添加分页导航层--%>
<%--            <div class="col-md-6"  style="text-align: center;margin-top: 20px;">--%>
<%--                <ul id="pagination">11111111111111</ul>--%>
<%--            </div>--%>

            <span class="top-left border-span"></span>
            <span class="top-right border-span"></span>
            <span class="bottom-left border-span"></span>
            <span class="bottom-right border-span"></span>
        </div>

    </div>
    <div class="main-right">
        <div class="border-container">
            <div class="name-title">学历要求(暂时静态)</div>
            <div id="courserate"></div>

            <span class="top-left border-span"></span>
            <span class="top-right border-span"></span>
            <span class="bottom-left border-span"></span>
            <span class="bottom-right border-span"></span>
        </div>
        <div class="border-container">
            <div class="name-title">岗位发布数量</div>
            <div id="changedetail"></div>
            <span class="top-left border-span"></span>
            <span class="top-right border-span"></span>
            <span class="bottom-left border-span"></span>
            <span class="bottom-right border-span"></span>
        </div>
        <div class="border-container">

            <ul>
                <div class="name-title">发布时间</div>
                <div id="professionrate"></div>
            </ul>

            <span class="top-left border-span"></span>
            <span class="top-right border-span"></span>
            <span class="bottom-left border-span"></span>
            <span class="bottom-right border-span"></span>
        </div>
    </div>
</div>

</body>