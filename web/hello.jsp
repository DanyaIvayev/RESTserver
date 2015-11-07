<%--
  Created by IntelliJ IDEA.
  User: Дамир
  Date: 06.11.2015
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=UTF-8">
    <title>MEETING APP</title>
</head>
<body>
  <h1 >Главная страница"</h1>
  <table class="insert">
    <tbody>
    <tr>
      <td class="insert">Фамилия</td>
      <td><input type="text" id="surname" required placeholder="Введите фамилию" name="surname" size="50"/></td>
    </tr>
    <tr>
      <td class="insert">Имя</td>
      <td><input type="text" id="firstname" required placeholder="Введите Имя" name="firstname" size="50"/></td>
    </tr>
    <tr>
      <td class="insert">Отчество</td>
      <td><input type="text" id="date" required placeholder="Введите отчество"  name="patronymic" size="50"/></td>
    </tr>
    <tr>
      <td class="insert">Должность</td>
      <td><input type="text" id="country" required placeholder="Введите должность" name="post" size="50"/></td>
    </tr>
    </tbody>
  </table>

<input class="button" type="reset" value="Очистить" name="clear"/>
&nbsp;&nbsp;
<input class="button" type="submit" value="Сохранить" name="submit"/>
&nbsp;&nbsp;
</body>
</html>