<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Greetings</title>
    </head>
    <body>
        <h3>Greeting:</h3>
        <c:if test = "${not empty greeting}">
            <p> Hello, ${greeting.getId()}</p>
            <p >${fn:escapeXML(greeting.getContent())}</p>
        </c:if>
        <c:if test="${empty greeting}">
            <p> greeting not exists </p>
        </c:if>

    </body>
</html>