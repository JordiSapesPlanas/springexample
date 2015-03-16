<%--
  Created by IntelliJ IDEA.
  User: debian-jordi
  Date: 2/03/15
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>greeting list</h2>
        <ul>
            <c:if test="${not empty greetings}">
                <c:forEach var="greeting" items="${greetings}">
                    <li>
                        <a href="/greetings/${greeting.getId()}"> ${greeting.getId()}</a>:${fn:escapeXML(greeting.getContent())}
                    </li>
                -</c:forEach>
            </c:if>
        </ul>
</body>
</html>
