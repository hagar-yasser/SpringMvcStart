<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%    request.setCharacterEncoding("UTF8");   %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html xmlns:spring="http://www.springframework.org/tags" xmlns:form="http://www.springframework.org/tags/form">

<head>
    <title>LocaleHello</title>
</head>
<body>
<h1><spring:message code="hello"/>${locale}</h1>
</body>
</html>