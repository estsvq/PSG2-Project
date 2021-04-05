<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">

    <h2><spring:message code="vet_info" /></h2>


    <table class="table table-striped">
        <tr>
            <th><spring:message code="name" /></th>
            <td><b><c:out value="${vet.firstName} ${vet.lastName}"/></b></td>
        </tr>
        <tr>
            <th><spring:message code="specialties" /></th>
            <td><c:forEach var="specialty" items="${vet.specialties}">
                <spring:message code="${specialty.name}" />&nbsp;
            </c:forEach>
            <c:if test="${vet.nrOfSpecialties == 0}"><spring:message code="none" /></c:if></td>
        </tr>
    </table>

    <spring:url value="{vetId}/edit" var="editUrl">
        <spring:param name="vetId" value="${vet.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default"><spring:message code="update_vet" /></a>

</petclinic:layout>
