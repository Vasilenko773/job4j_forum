<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save?id=${post.id}'/>" method='POST'>
  <table>
    <tr>
      <td>Название:</td>
      <td><input type='text' name='name' value="${post.name}"></td>
      <td>Описание:</td>
      <td><input type='text' name='description' value="${post.description}"></td>
      </td>
    </tr>

    <tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
    </tr>
  </table>
</form>
</body>
</html>