<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>학사 정보 시스템</title></head>
<body>
<h2>학사 정보 시스템 메뉴</h2>

<ul>
    <li><a href="${pageContext.request.contextPath}/school/credits">① 학년별 이수 학점 조회</a></li>
    <li><a href="${pageContext.request.contextPath}/school/register">② 수강 신청하기</a></li>
    <li><a href="${pageContext.request.contextPath}/school/courses?year=2025&semester=1">③ 수강 신청 조회</a></li>
</ul>

<br>
<a href="${pageContext.request.contextPath}/">← 메인 홈으로</a>
</body>
</html>
