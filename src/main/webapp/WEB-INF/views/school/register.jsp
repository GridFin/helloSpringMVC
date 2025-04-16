<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>수강 신청하기</title>
  <style>
    .formtable {
      border-collapse: collapse;
    }
    .formtable td {
      padding: 8px;
    }
    .label {
      font-weight: bold;
    }
    .error {
      color: red;
      font-size: 0.9em;
    }
  </style>
</head>
<body>

<h2>수강 신청하기</h2>

<sf:form method="post" action="${pageContext.request.contextPath}/school/register" modelAttribute="course">
  <table class="formtable">
    <tr>
      <td class="label">수강년도:</td>
      <td>
        <sf:input path="year" type="number" />
        <sf:errors path="year" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td class="label">학기:</td>
      <td>
        <sf:input path="semester" type="number" />
        <sf:errors path="semester" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td class="label">교과코드:</td>
      <td>
        <sf:input path="course_code" />
        <sf:errors path="course_code" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td class="label">교과목명:</td>
      <td>
        <sf:input path="course_name" />
        <sf:errors path="course_name" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td class="label">교과구분:</td>
      <td>
        <sf:input path="course_option" />
        <sf:errors path="course_option" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td class="label">담당교수:</td>
      <td>
        <sf:input path="prof" />
        <sf:errors path="prof" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td class="label">학점:</td>
      <td>
        <sf:input path="score" type="number" />
        <sf:errors path="score" cssClass="error" />
      </td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="신청" /></td>
    </tr>
  </table>
</sf:form>

<br>
<a href="${pageContext.request.contextPath}/school">← 홈으로</a>

</body>
</html>
