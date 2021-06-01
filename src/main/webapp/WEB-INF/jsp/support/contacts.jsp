<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<petclinic:layout pageName="contacts">
    <h2><spring:message code="contact_info" /></h2>

    <c:forEach items="${contacts}" var="contact">


        <table class="table table-striped">
            <thead>
            <tr>
                <th colspan="2" scope="rowgroup"><c:out value="${contact.name}"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style="width: 20%"><spring:message code="email" /></td>
                <td style="width: 80%"><c:out value="${contact.email}"/></td>
            </tr>
            <tr>
                <td style="width: 20%"><spring:message code="telephone" /></td>
                <td style="width: 80%"><c:out value="${contact.phone}"/></td>
            </tr>
            <tr>
                <td style="width: 20%"><spring:message code="role" /></td>
                <td style="width: 80%"><c:out value="${contact.role}"/></td>
            </tr>

            </tbody>
        </table>
    </c:forEach>


</petclinic:layout>