<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>학기별 이수 학점</title>
</head>
<body>
<h2>학기별 이수 학점</h2>
<table border="1">
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>총 학점</th>
        <th>상세보기</th>
    </tr>
    <c:forEach var="row" items="${summary}">
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
            <td>
                <a href="credits/detail?year=${row[0]}&semester=${row[1]}">보기</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/helloSpringMVC/school">홈으로</a>
</body>
</html>
