<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>수강 신청 조회</title></head>
<body>
<h2>${year}년도 ${semester}학기 수강 신청 내역</h2>
<table border="1">
  <tr>
    <th>교과목명</th>
    <th>교과코드</th>
    <th>교과구분</th>
    <th>담당교수</th>
    <th>학점</th>
  </tr>
  <c:forEach var="course" items="${courses}">
    <tr>
      <td>${course.course_name}</td>
      <td>${course.course_code}</td>
      <td>${course.course_option}</td>
      <td>${course.prof}</td>
      <td>${course.score}</td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="/helloSpringMVC/school">홈으로</a>
</body>
</html>
