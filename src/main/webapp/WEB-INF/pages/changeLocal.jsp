
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:spring="http://www.springframework.org/tags" xmlns:form="http://www.springframework.org/tags/form">
<head>
    <title>Registration Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        span.error {
            color: red;
            display: inline-block;
        }
    </style>

</head>
<body>
<div class="container">
    <form:form modelAttribute="localeSelect" method="post">
        <div class="from-row md-4">
         <form:select name="choice"  path="choice">
             <form:option value = "en_US">en_US</form:option>
              <form:option value = "ar_EG">ar_EG</form:option>

           </form:select>
        </div>
        <br>
          <input type="submit" value="changeLocale" />
    </form:form>

</div>
</body>
</html>
