<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: debian-jordi
  Date: 9/03/15
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting form</title>
</head>
<body>
    <form:form method="POST" action="/greetings/${greeting.getId()}" modelAttribute="greeting" >
        <table>
            <tr>
                <td><form:label path="content">Content</form:label></td>
                <td><form:input path="content"><i><form:errors path="content"></form:errors></i></form:input></td>
            </tr>
            <tr>
                <td>
                    <form:hidden path="date"><i><form:errors path="date"></form:errors></i></form:hidden>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="send">
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>
