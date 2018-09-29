<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>成绩单</title>
</head>
<body>
<% String name=(String)session.getAttribute("name"); %>
<%=name %>同学的成绩单如下:

    <table>
        <tr>
            <th>科目</th>
            <th>得分</th>
            <th>删除</th>
            <th>修改</th>
        </tr>
        <tr>
            <td>Java</td>
            <td>10</td>
            <td><a href="delStudent">删除</a></td>
            <td><a href="updateStudent">修改</a></td></td>
        </tr>
    </table>
</body>
</html>
